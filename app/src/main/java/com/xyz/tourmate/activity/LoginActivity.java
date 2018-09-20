package com.xyz.tourmate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
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

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText emailEt,passEt;
    private TextView text1,title;
    private Button logBtn,signBtn;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        emailEt=findViewById(R.id.emailET);
        passEt=findViewById(R.id.passwordET);
        title=findViewById(R.id.titleTV);
        text1=findViewById(R.id.text1);
        logBtn=findViewById(R.id.loginBtn);
        signBtn=findViewById(R.id.signUpBtn);
        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();
        if (user!=null){
            startActivity(new Intent(LoginActivity.this, AllEventActivity.class));

        }

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=emailEt.getText().toString();
                String password=passEt.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    user=firebaseAuth.getCurrentUser();
                                    startActivity(new Intent(LoginActivity.this, AllEventActivity.class));
                                }

                            }
                        }).addOnFailureListener(LoginActivity.this, new OnFailureListener() {
                             @Override
                              public void onFailure(@NonNull Exception e) {

                               Toast.makeText(LoginActivity.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                             }
                         });



            }
        });



    }

}
