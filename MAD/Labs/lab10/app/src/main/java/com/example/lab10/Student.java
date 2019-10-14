package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Student extends AppCompatActivity {

    TextView username;
    ListView messageList;
    List<MessageModel> messages;
    DBHelper Lab10DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        username = findViewById(R.id.usernameS);
        Intent intent = getIntent();
        username.setText(intent.getStringExtra("name"));
        messageList = findViewById(R.id.messagesList);
        Lab10DB = new DBHelper(this);
        messages = Lab10DB.retrieveMessages();
        CustomAdapter customAdapter = new CustomAdapter();
        messageList.setAdapter(customAdapter);

        messageList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(Student.this,Message.class);
                        intent.putExtra("messageId",messages.get(position).getId());
                        startActivity(intent);
                    }
                }
        );

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return messages.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.listitem,null);
            TextView textViewUser = convertView.findViewById(R.id.textViewUser);
            TextView textViewSubject = convertView.findViewById(R.id.textViewSubject);


            textViewUser.setText(messages.get(position).getUser());
            textViewSubject.setText(messages.get(position).getSubject());

            return convertView;
        }
    }
}
