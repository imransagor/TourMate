package com.xyz.tourmate.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.xyz.tourmate.R;

public class SignUpActivity extends AppCompatActivity {
    private TextInputEditText nameET,phoneET,emailET,passET;
    private TextView title;
    private Button signUpBtn;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setTitle("Sign UP");

        title=findViewById(R.id.titleTV);
        nameET=findViewById(R.id.nameET);
        emailET=findViewById(R.id.emailET);
        phoneET=findViewById(R.id.phoneNoET);
        passET=findViewById(R.id.passwordET);
        signUpBtn=findViewById(R.id.registerBtn);
        firebaseAuth=FirebaseAuth.getInstance();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name=nameET.getText().toString();
                String email=emailET.getText().toString();
                String phoneNo=phoneET.getText().toString();
                String password=passET.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    user=firebaseAuth.getCurrentUser();
                                    Toast.makeText(SignUpActivity.this, "Done", Toast.LENGTH_SHORT).show();
                                    updateUI();
                                }

                            }
                        }).addOnFailureListener(SignUpActivity.this, new OnFailureListener() {
                             @Override
                              public void onFailure(@NonNull Exception e) {

                               Toast.makeText(SignUpActivity.this, "error"+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                             }
                         });



            }
        });



    }

    private void updateUI() {
       /* if (user!=null){
            String userName=user.getDisplayName();
            String userEmail=user.getEmail();
            String userPhonNo=user.getPhoneNumber();
            String userId=user.getUid();

            Bundle bundle=new Bundle();
            bundle.putString("userName",userName);
            bundle.putString("userEmail",userEmail);
            bundle.putString("userPhoneNo",userPhonNo);

            showUserInfo userInfo=new showUserInfo();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.info,userInfo);

            userInfo.setArguments(bundle);
        }
*/
        Intent intent =new Intent(SignUpActivity.this,AllEventActivity.class);
        startActivity(intent);

    }
}
