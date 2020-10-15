package example.healthapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_pass extends AppCompatActivity {
    EditText entermail;
    Button resetbutton;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        entermail = findViewById(R.id.passResetEdtMail);
        resetbutton = findViewById(R.id.btnResetMail);
        firebaseAuth = FirebaseAuth.getInstance();


        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.sendPasswordResetEmail(entermail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Forget_pass.this, "Please Check Your Mail Inbox", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Forget_pass.this,Login_Screen.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Forget_pass.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
