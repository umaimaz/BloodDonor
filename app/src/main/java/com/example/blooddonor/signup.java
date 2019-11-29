package com.example.blooddonor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    EditText sfirstname,slastname,semail,spassword,saddress,sgender,sbloodgroup,sphonenum,slastdon;
    Button ssignup,sback;
    ProgressBar sbar;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        mFirebaseAuth=FirebaseAuth.getInstance();
        sfirstname=findViewById(R.id.a_sfirstName);
        slastname=findViewById(R.id.a_slastName);
        semail=findViewById(R.id.a_semail);
        spassword=findViewById(R.id.a_spassword);
        saddress=findViewById(R.id.a_saddress);
        sgender=findViewById(R.id.a_sgender);
        sbloodgroup=findViewById(R.id.a_sbloodGroup);
        sphonenum=findViewById(R.id.a_sphoneNumber);
        slastdon=findViewById(R.id.a_slastDon);
        ssignup=findViewById(R.id.a_signup);
        sback=findViewById(R.id.a_sback);
        sbar=findViewById(R.id.a_sbar);
        ssignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(isEmpty()){
                        return;
                    }

                String Semail=semail.getText().toString();
                String Spass=spassword.getText().toString();
                    inProgress(true);
                    mFirebaseAuth.createUserWithEmailAndPassword(Semail,Spass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(signup.this,"User Signup Successfully",Toast.LENGTH_LONG).show();
                            FirebaseAuth.getInstance().signOut();
                            Intent i=new Intent(signup.this,login.class);
                            i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                            finish();
                            return;

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            inProgress(false);
                            Toast.makeText(signup.this,"Signup failed! "+e.getMessage(),Toast.LENGTH_LONG).show();
                            finish();

                        }
                    });
            }
        });
        sback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inProgress(false);
            }
        });


    }
    private void inProgress(boolean x){

        if(x){
            sbar.setVisibility(View.VISIBLE);
            ssignup.setEnabled(false);
            sback.setEnabled(false);
        }else{
            startActivity(new Intent(signup.this,login.class));


        }
    }
    private boolean isEmpty(){

      //  String Sfirst=sfirstname.getText().toString();
      //  String Slast=slastname.getText().toString();
        String Semail=semail.getText().toString();
        String Spass=spassword.getText().toString();
//        String Sadres=saddress.getText().toString();
//        String Sgender=sgender.getText().toString();
//        String Sblood=sbloodgroup.getText().toString();
//        String Sphone=sphonenum.getText().toString();
//        String Slastdon=slastdon.getText().toString();
//                  if(Sfirst.isEmpty()){
//                    sfirstname.setError("Please Enter First Name");
//                    return true;
//                }
//                if (Slast.isEmpty()){
//                    slastname.setError("Please Enter Last Name");
//                    return true;
//
//                }
                if (Semail.isEmpty()){
                    semail.setError("Please Enter Email ");
                    return true;

                }
                if (Spass.isEmpty()){
                    spassword.setError("Please Enter Password");
                    return true;

                }
//                if (Sadres.isEmpty()){
//                    saddress.setError("Please Enter Address");
//                    return true;
//
//                }
//                if (Sgender.isEmpty()){
//                    sgender.setError("Please Enter Gender");
//                    return true;
//
//                }if (Sblood.isEmpty()){
//                    sbloodgroup.setError("Please Enter Blood Group");
//                    return true;
//
//                }
//                if (Sphone.isEmpty()){
//                    sphonenum.setError("Please Enter Phone Number");
//                    return true;
//
//                }
//                if (Slastdon.isEmpty()){
//                    slastdon.setError("Please Enter Last Donation");
//                    return true;

//                }
                else{
                    return false;
                }

    }

}















