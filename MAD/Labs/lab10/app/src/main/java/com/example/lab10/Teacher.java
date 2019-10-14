package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Teacher extends AppCompatActivity {

    TextView username;
    EditText subjectEditText;
    EditText messageEditText;
    Button sendButton;
    DBHelper Lab10db;
    MessageModel message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        username = findViewById(R.id.textViewUserNameT);
        Intent intent = getIntent();
        username.setText(intent.getStringExtra("name"));
        subjectEditText = findViewById(R.id.subjecteditText);
        messageEditText = findViewById(R.id.messageeditText);
        Lab10db = new DBHelper(this);
        message = new MessageModel();
        sendButton = findViewById(R.id.buttonSend);
        sendButton.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        if(subjectEditText.getText().toString()!=null&&messageEditText.getText().toString()!=null){
                            message.setUser(username.getText().toString());
                            message.setSubject(subjectEditText.getText().toString());
                            message.setMessage(messageEditText.getText().toString());
                            boolean state = Lab10db.addMessage(message);
                            if(state==true){
                                Toast.makeText(getBaseContext(),"Message Added Successfully",Toast.LENGTH_SHORT);
                                subjectEditText.setText("");
                                messageEditText.setText("");
                            }
                            else {
                                Toast.makeText(getBaseContext(),"Message Creation Unsuccessful",Toast.LENGTH_SHORT);

                            }
                        }
                        else{
                            Toast.makeText(getBaseContext(),"Fields Cannot Be Empty",Toast.LENGTH_SHORT);
                        }

                    }
                }
        );

    }
}
