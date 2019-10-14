package com.example.modelpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class EditProfile extends AppCompatActivity {

    DBHelper madDB;
    Button editButton;
    Button deleteButton;
    Button searchButton;
    EditText userNameEditText;
    EditText dobEditText;
    EditText passwordEditText;
    List<UserProfile> users;
    UserProfile user;
    String gender;
    int id;
    RadioButton maleButton;
    RadioButton femaleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        madDB = new DBHelper(this);
        userNameEditText = findViewById(R.id.userNameeditTextEdit);
        passwordEditText = findViewById(R.id.passwordeditTextEdit);
        dobEditText = findViewById(R.id.dobeditTextEdit);
        editButton =findViewById(R.id.buttonEdit);
        deleteButton = findViewById(R.id.buttonDelete);
        searchButton = findViewById(R.id.buttonSearch);
        maleButton = findViewById(R.id.radioButtonMaleEdit);
        femaleButton = findViewById(R.id.radioButtonFemaleEdit);




        searchButton.setOnClickListener(
                new View.OnClickListener(

                ) {
                    @Override
                    public void onClick(View v) {
                        String username = userNameEditText.getText().toString();
                        users = madDB.readAllInfo();
                        Iterator<UserProfile> iterator = users.iterator();
                        while(iterator.hasNext()){
                            user = iterator.next();
                            if(user.getUserName().equals(username)){
                                break;
                            }
                            else{
                                user=null;
                            }
                        }
                        if(user==null) {
                            Toast.makeText(v.getContext(), "No Such Username", Toast.LENGTH_SHORT).show();
                            passwordEditText.setText("");
                            dobEditText.setText("");
                            maleButton.setChecked(false);
                            femaleButton.setChecked(false);
                        }
                        else{
                            userNameEditText.setText(user.getUserName());
                            passwordEditText.setText(user.getPassword());
                            dobEditText.setText(user.getDob());
                            gender = user.getGender();
                            if(gender.equals("Male")){
                                maleButton.setChecked(true);

                            }
                            else{
                                femaleButton.setChecked(true);
                            }
                            id = user.getId();

                        }
                    }
                }
        );

        deleteButton.setOnClickListener(
                new View.OnClickListener(

                ) {
                    @Override
                    public void onClick(View v) {
                        boolean state = madDB.deleteInfo(id);

                        if(state == true){
                            Toast.makeText(v.getContext(),"Successfully Deleted",Toast.LENGTH_SHORT).show();
                            userNameEditText.setText("");
                            passwordEditText.setText("");
                            dobEditText.setText("");
                            maleButton.setChecked(false);
                            femaleButton.setChecked(false);
                        }
                        else{
                            Toast.makeText(v.getContext(),"Unsuccessful",Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );

        editButton.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        UserProfile updatedUser = new UserProfile();

                        updatedUser.setId(id);
                        updatedUser.setUserName(userNameEditText.getText().toString());
                        if(maleButton.isChecked()){
                            gender= "Male";
                        }
                        else if(femaleButton.isChecked()){
                            gender="Female";
                        }
                        updatedUser.setGender(gender);
                        updatedUser.setDob(dobEditText.getText().toString());
                        updatedUser.setPassword(passwordEditText.getText().toString());

                        boolean state = madDB.updateInfo(updatedUser);

                        if(state == true){
                            Toast.makeText(v.getContext(),"Successfully Updated",Toast.LENGTH_SHORT).show();
                            updatedUser = madDB.readAllInfo(id);
                            userNameEditText.setText(updatedUser.getUserName());
                            passwordEditText.setText(updatedUser.getPassword());
                            dobEditText.setText(updatedUser.getDob());
                            gender = updatedUser.getGender();
                            if(gender.equals("Male")){
                                maleButton.setChecked(true);

                            }
                            else{
                                femaleButton.setChecked(true);
                            }
                            id = updatedUser.getId();

                        }
                        else{
                            Toast.makeText(v.getContext(),"Unsuccessful",Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );


    }
}
