package com.example.cerradura;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logOut(View view)
    {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Se ha cerrado sesión", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), LogInActivity.class);
        startActivity(i);
    }

    public void chat(View view)
    {
        Intent i = new Intent(getApplicationContext(), ChatActivity.class);
        startActivity(i);
    }

}