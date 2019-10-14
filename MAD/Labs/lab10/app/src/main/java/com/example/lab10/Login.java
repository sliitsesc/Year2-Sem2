package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText userNameEditText;
    EditText passwordEditText;
    Button loginButton;
    Button registerButton;
    DBHelper Lab10DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEditText = findViewById(R.id.userNameEditTextLog);
        passwordEditText = findViewById(R.id.passwordEditTextLog);
        loginButton = findViewById(R.id.buttonLogin);
        registerButton = findViewById(R.id.buttonRegisterLog);
        Lab10DB = new DBHelper(this);

        loginButton.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        String username = userNameEditText.getText().toString();
                        String password = passwordEditText.getText().toString();

                        if(username!=null && password!=null){
                            User user = Lab10DB.login(username,password);
                            if(user!=null){
                                switch(user.getType()){
                                    case "Student" : {
                                        Intent intent = new Intent(Login.this,Student.class);
                                        intent.putExtra("id",user.getId());
                                        intent.putExtra("name",user.getName());
                                        startActivity(intent);
                                    }
                                        break;
                                    case "Teacher" :{
                                        Intent intent = new Intent(Login.this,Teacher.class);
                                        intent.putExtra("id",user.getId());
                                        intent.putExtra("name",user.getName());
                                        startActivity(intent);
                                    }
                                        break;
                                    default:
                                        Toast.makeText(getBaseContext(),"Something Is Not Right",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(getBaseContext(),"Invalid Username Or Password",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getBaseContext(),"Fields Cannot Be Empty",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        registerButton.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getBaseContext(),Register.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
