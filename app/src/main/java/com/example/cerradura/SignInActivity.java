package com.example.cerradura;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText mailSignIn;
    private EditText passSignIn;
    private EditText passConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        mailSignIn = findViewById(R.id.mailSignIn);
        passSignIn = findViewById(R.id.passSignIn);
        passConfirm = findViewById(R.id.passConfirm);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        /*if(currentUser != null){
            reload();
        }*/


    }
    public void registrarUsuario (View view) {
        if (passSignIn.getText().toString().equals(passConfirm.getText().toString()))
        {
            mAuth.createUserWithEmailAndPassword(mailSignIn.getText().toString(), passSignIn.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(TAG, "createUserWithEmail:success");

                                FirebaseUser user = mAuth.getCurrentUser();
                                user.sendEmailVerification();

                                Toast.makeText(getApplicationContext(), "Se ha enviado un correo de verificacion.", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), LogInActivity.class);
                                startActivity(i);


                            } else {
                                // If sign in fails, display a message to the user.
                                // Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "Tu contraseña debe ser mayor a 6 caracteres", Toast.LENGTH_SHORT).show();
                                //   updateUI(null);
                            }
                        }
                    });
        } else {

            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }
    }
}