package example.healthapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;

public class Register extends AppCompatActivity {
    private static final String TAG = "Register";
    private static final int CHOOSE_IMAGE = 101;
    private TextView datepicker, dateis;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private EditText fullname, edtemail, edtpassword;
    private RadioGroup rdGroup;
    private RadioButton rdBtnMale, rdBtnFemale;
    private Button joinBtn;
    private ProgressBar progressBar;
    ImageView imageView;


    Uri uriProfileImage;
    Bitmap bitmap;
    Uri resultUri;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_MONTH);
    String date;
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        datepicker = (TextView) findViewById(R.id.selectDate);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        fullname = (EditText) findViewById(R.id.fullName);
        edtemail = (EditText) findViewById(R.id.edtEmail);
        rdGroup = (RadioGroup) findViewById(R.id.rdGroup);
        rdBtnMale = (RadioButton) findViewById(R.id.rdBtnMale);
        rdBtnFemale = (RadioButton) findViewById(R.id.rdBtnFemale);
        edtpassword = (EditText) findViewById(R.id.edtSetPass);
        imageView = (ImageView) findViewById(R.id.RegisterIV);
        joinBtn = (Button) findViewById(R.id.btnJoin);
        dateis = (TextView) findViewById(R.id.dateis);

        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        firebaseAuth = FirebaseAuth.getInstance();


        //Image Chooser Method Call

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageChooser();
            }
        });

        //Date Picker Code


        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatePickerDialog dialog = new DatePickerDialog(Register.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener,
                        year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                date = month + "/" + day + "/" + year;
                dateis.setText(date);
            }
        };

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }


    //Image Chooser Method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_IMAGE && resultCode == RESULT_OK && data != null) {
            uriProfileImage = data.getData();
            CropImage.activity(uriProfileImage).setAspectRatio(1, 1).start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            resultUri = result.getUri();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), resultUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //Image Chooser Intent
    private void showImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Profile Image"), CHOOSE_IMAGE);
    }


    //Register User Method
    private void registerUser() {
        final String name = fullname.getText().toString().trim();
        final String email = edtemail.getText().toString();
        final String password = edtpassword.getText().toString();
        final String dob = dateis.getText().toString();

        if (name.isEmpty()) {
            fullname.setError("Name Required");
            fullname.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            edtemail.setError("Email Required");
            edtemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtemail.setError("Enter A Valid Email");
            edtemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            edtpassword.setError("Password Required");
            edtpassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            edtpassword.setError("Password Should Be Atleast 6 Characters Long");
            edtpassword.requestFocus();
            return;
        }

        if (rdBtnMale.isChecked()) {
            gender = "Male";
        }

        if (rdBtnFemale.isChecked()) {
            gender = "Female";
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.VISIBLE);
                    joinBtn.setVisibility(View.INVISIBLE);
                    firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                progressBar.setVisibility(View.VISIBLE);
								
								
                                //upload image to firebase
                                final StorageReference profileImageRef = FirebaseStorage.getInstance().getReference("profilepics/" + System.currentTimeMillis() + ".jpg").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                if (bitmap != null) {
                                    profileImageRef.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull final Task<UploadTask.TaskSnapshot> task) {
                                            task.getResult().getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                @Override
                                                public void onSuccess(Uri uri) {
                                                    progressBar.setVisibility(View.VISIBLE);
                                                    final String url = uri.toString();

                                                    //pojo
                                                    User information = new User(name, email, gender, dob, password, url);

                                                    FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information)
                                                            .addOnCompleteListener(new OnCompleteListener<Void>() {

                                                                @Override
                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                    if (task.isSuccessful()) {
                                                                        progressBar.setVisibility(View.GONE);
                                                                        Intent intent=new Intent(Register.this,MainActivity.class);
                                                                        startActivity(intent);
                                                                        Toast.makeText(Register.this, "User Registered Successfully , Please Verify Your Email", Toast.LENGTH_LONG).show();
                                                                    } else {
                                                                        Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                    }
                                                                }
                                                            });
                                                }
                                            });
                                        }
                                    });
                                }

                                progressBar.setVisibility(View.GONE);
                                joinBtn.setVisibility(View.VISIBLE);
                            } else {
                                Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
