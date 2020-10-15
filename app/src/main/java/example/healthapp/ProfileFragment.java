package example.healthapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {
    TextView profileFullname, profileGender, profileDOB, profileEmail;
    ImageView profileiv;
    ProgressDialog p;

    View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_profile, container, false);

        profileFullname = (TextView) mView.findViewById(R.id.profileFullname);
        profileGender = (TextView) mView.findViewById(R.id.profileGender);
        profileDOB = (TextView) mView.findViewById(R.id.profileDOB);
        profileEmail = (TextView) mView.findViewById(R.id.profileEmail);
        profileiv = (ImageView) mView.findViewById(R.id.ProfileIV);

        AsyncTaskExample asyncTask=new AsyncTaskExample();
        asyncTask.execute();

        return mView;
    }

    private class AsyncTaskExample extends AsyncTask<String, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p = new ProgressDialog(getContext());
            p.setMessage("Please wait...Information is downloading");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                fetch();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }

    private void fetch() {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference uidRef = rootRef.child("User").child(uid);
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String fullname = dataSnapshot.child("fullname").getValue(String.class);
                String email = dataSnapshot.child("email").getValue(String.class);
                String dob = dataSnapshot.child("dateis").getValue(String.class);
                String gender = dataSnapshot.child("gender").getValue(String.class);
                String url = dataSnapshot.child("url").getValue(String.class);

                Glide.with(ProfileFragment.this)
                        .load(url)
                        .into(profileiv);

                profileFullname.setText(fullname);
                profileEmail.setText(email);
                profileDOB.setText(dob);
                profileGender.setText(gender);
                p.hide();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Please Try Again", Toast.LENGTH_SHORT).show();
            }
        };
        uidRef.addListenerForSingleValueEvent(valueEventListener);
    }
}
