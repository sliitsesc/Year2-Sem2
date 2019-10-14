package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Message extends AppCompatActivity {

    TextView subjectText;
    EditText messageText;
    DBHelper Lab10db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Lab10db = new DBHelper(this);
        subjectText = findViewById(R.id.subjecttextView);
        messageText = findViewById(R.id.messageText);
        Intent intent = getIntent();
        MessageModel message = Lab10db.getMessage(intent.getIntExtra("messageId",0));
        if(message==null){
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }
        else{
            subjectText.setText(message.getSubject());
            messageText.setText(message.getMessage());
        }
    }
}
