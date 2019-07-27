package com.brocode.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        final String num1 = intent.getStringExtra(FirstActivity.NUM1);
        final String num2 = intent.getStringExtra(FirstActivity.NUM2);

        //final int num1 = intent.getIntExtra(FirstActivity.NUM1, 0 );
        //final int num2 = intent.getIntExtra(FirstActivity.NUM2,0);

        TextView text1 = (TextView) findViewById(R.id.editText5);
        text1.setText(num1);
        //text1.setText(Integer.toString(num1));
        text1.setEnabled(false);


        TextView text2 = (TextView) findViewById(R.id.editText6);
        text2.setText(num2);
        //text2.setText(Integer.toString(num2));
        text2.setEnabled(false);

        final Button add = (Button) findViewById(R.id.button2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView ans = (TextView) findViewById(R.id.textView7);
                ans.setText(num1+" + "+num2+" = "+ (Integer.parseInt(num1)+Integer.parseInt(num2)));
                //ans.setText(Integer.toString(num1+num2));
            }
        });

        final Button sub = (Button) findViewById(R.id.button3);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView ans = (TextView) findViewById(R.id.textView7);
                ans.setText(num1+" - "+num2+" = "+ (Integer.parseInt(num1)-Integer.parseInt(num2)));
                //ans.setText(Integer.toString(num1-num2));
            }
        });

        final Button mul = (Button) findViewById(R.id.button4);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView ans = (TextView) findViewById(R.id.textView7);
                ans.setText(num1+" * "+num2+" = "+ (Integer.parseInt(num1)*Integer.parseInt(num2)));
                //ans.setText(Integer.toString(num1*num2));
            }
        });

        final Button div = (Button) findViewById(R.id.button5);

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView ans = (TextView) findViewById(R.id.textView7);
                ans.setText(num1+" / "+num2+" = "+ (Integer.parseInt(num1)/Integer.parseInt(num2)));
                //ans.setText(Integer.toString(num1/num2));
            }
        });
    }
}
