package com.example.modelpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ProfileManagement extends AppCompatActivity {

    Button updateProfileBtn;
    String gender;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText DateOfBirthEditText;
    DBHelper madDB;
    UserProfile user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        updateProfileBtn = findViewById(R.id.buttonUpdateProfile);
        usernameEditText = findViewById(R.id.userNameEditTextProfile);
        passwordEditText = findViewById(R.id.passwordEditTextProfile);
        DateOfBirthEditText = findViewById(R.id.dobEditText);
        madDB = new DBHelper(this);
        user =  new UserProfile();


        final Intent intent =  new Intent(this,EditProfile.class);

        updateProfileBtn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if(usernameEditText.getText()!=null&&passwordEditText.getText()!=null&&DateOfBirthEditText.getText()!=null&&gender!=null){
                            user.setUserName(usernameEditText.getText().toString());
                            user.setGender(gender);
                            user.setDob(DateOfBirthEditText.getText().toString());
                            user.setPassword(passwordEditText.getText().toString());

                            if(madDB.addInfo(user)){
                                Toast.makeText(ProfileManagement.this, "Successfully Created", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(ProfileManagement.this,"Unsuccessful",Toast.LENGTH_SHORT).show();
                            }


                        }

                    }
                }
        );
    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radioButtonMaleEdit:
                if(checked)
                    gender = "Male";
                break;

            case R.id.radioButtonFemaleEdit:
                if(checked)
                    gender = "Female";
                break;
        }
    }

}
