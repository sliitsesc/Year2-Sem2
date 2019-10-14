package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText userNameEditText;
    EditText passwordEditText;
    CheckBox teacherCheckbox;
    CheckBox studentCheckbox;
    Button registerButton;
    DBHelper Lab10db;
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userNameEditText = findViewById(R.id.usernameEditTextReg);
        passwordEditText = findViewById(R.id.passwordEditTextReg);
        registerButton = findViewById(R.id.buttonRegisterReg);
        teacherCheckbox = findViewById(R.id.checkBoxTeacher);
        studentCheckbox = findViewById(R.id.checkBoxStudent);
        Lab10db = new DBHelper(this);

        registerButton.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        String username = userNameEditText.getText().toString();
                        String password = passwordEditText.getText().toString();

                        if(username!= null && password != null && (studentCheckbox.isChecked()||teacherCheckbox.isChecked())){
                            user.setName(username);
                            if(studentCheckbox.isChecked()){
                                user.setType("Student");
                            }
                            if(teacherCheckbox.isChecked()){
                                user.setType("Teacher");
                            }

                            Boolean state = Lab10db.register(user,password);

                            if(state==true){
                                Toast.makeText(getBaseContext(),"Successfully Registered",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getBaseContext(),Login.class));
                            }
                            else {
                                Toast.makeText(getBaseContext(),"Something Went Wrong",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getBaseContext(),"Form Fields Cannot Be Empty",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );





    }
}
