package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button butLogin;
    EditText user,pass;
    String userName, password;
    private Boolean checkAccountValid(ArrayList<User> users, String userName, String password) {
        for(User u : users) {
            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("user", "12345"));
        users.add(new User("abc", "12345"));
        butLogin=findViewById(R.id.butLogin);
        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=findViewById(R.id.txtUserName);
                pass=findViewById(R.id.txtPassword);
                userName=user.getText().toString();
                password=pass.getText().toString();
                if (checkAccountValid(users, userName, password)) {
                    Toast.makeText(MainActivity.this,  "Loading", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Wrong Information!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}