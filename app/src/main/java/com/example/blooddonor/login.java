package com.example.blooddonor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    EditText lemail,lpass;
    TextView clickhere;
    Button lsignin;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mFirebaseAuth=FirebaseAuth.getInstance();
        lemail=findViewById(R.id.a_lemail);
        lpass=findViewById(R.id.a_lpassword);
        clickhere=findViewById(R.id.a_lalreadySign);
        lsignin=findViewById(R.id.a_lsignIn);
        mAuthStateListner=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser=mFirebaseAuth.getCurrentUser();

                if(mFirebaseUser!=null ){
                    Toast.makeText(login.this,"Logged In",Toast.LENGTH_LONG).show();
                    Intent i= new Intent(login.this, MainActivity.class);
                    i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(login.this,"Please Login",Toast.LENGTH_LONG).show();

                }

            }
        };
        lsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lemail1=lemail.getText().toString();
                String lpass1=lpass.getText().toString();

                if(lemail1.isEmpty()){
                    lemail.setError("Please Enter First Name");
                    lemail.requestFocus();
                }
                if (lpass1.isEmpty()){
                    lpass.setError("Please Enter Last Name");
                    lpass.requestFocus();

                }
                else if(!(lemail1.isEmpty()&& lpass1.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(lemail1,lpass1).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(login.this,"Login Error,Please Login again",Toast.LENGTH_LONG).show();

                            }
                            else{
                                Intent i=new Intent(login.this, MainActivity.class);
                                startActivity(i);
                                finish();
                            }
                        }
                    });

                }else{
                    Toast.makeText(login.this,"Error Occured",Toast.LENGTH_LONG).show();

                }


            }
        });
        clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login.this, signup.class);
                startActivity(i);
                finish();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListner);
    }
}
