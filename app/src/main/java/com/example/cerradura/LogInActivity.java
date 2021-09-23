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

public class LogInActivity extends AppCompatActivity {

    private EditText mailLogIn;
    private EditText passLogIn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mailLogIn = findViewById(R.id.mailLogIn);
        passLogIn = findViewById(R.id.passLogIn);

// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

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

    public void Ingresar (View view)
    {
        if(validar()) {
            mAuth.signInWithEmailAndPassword(mailLogIn.getText().toString(), passLogIn.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //  Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                              /*  if (!user.isEmailVerified()) {
                                    Toast.makeText(LogInActivity.this, "Usuario no verificado", Toast.LENGTH_SHORT).show();
                                }else{*/
                                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(i);
                                //}


                                // Toast.makeText(getApplicationContext(), "Log In funciona", Toast.LENGTH_SHORT).show();
                                // updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                //  Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                //  updateUI(null);
                            }
                        }
                    });
        }
    }


    public void Registrarse (View view)
    {
        Intent i = new Intent(getApplicationContext(), SignInActivity.class);
        startActivity(i);
    }

    public boolean validar()
    {
        boolean var=true;

        String mail = mailLogIn.getText().toString();
        String pass = passLogIn.getText().toString();

        if (mail.isEmpty())
        {
            mailLogIn.setError("Por favor, ingresa un correo válido");
            var=false;
        }

        if (pass.isEmpty())
        {
            passLogIn.setError("Por favor, ingresa una contraseña válida");
            var=false;
        }

        return var;
    }
}

