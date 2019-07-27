package com.brocode.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FirstActivity extends AppCompatActivity {

    public static final String NUM1 = "com.brocode.IntentsProj.NUM1";
    public static final String NUM2 = "com.brocode.IntentsProj.NUM2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


    }

    public void navigate(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        TextView text1 = (TextView)findViewById(R.id.editText);
        String num1= text1.getText().toString();
        //int num1 = Integer.parseInt(text1.getText().toString());
        TextView text2 = (TextView)findViewById(R.id.editText2);
        String num2= text2.getText().toString();
        //int num2 = Integer.parseInt(text2.getText().toString());

        intent.putExtra(NUM1,num1);
        intent.putExtra(NUM2,num2);

        //intent.putExtra(NUM1,num1);
        //intent.putExtra(NUM2,num2);

        startActivity(intent);
    }
}
