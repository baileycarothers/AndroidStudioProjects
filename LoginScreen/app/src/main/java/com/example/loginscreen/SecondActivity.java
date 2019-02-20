package com.example.loginscreen;

import android.support.v7.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView int1;
    private TextView int2;
    private TextView incorrect;
    private EditText answer;
    private Button submit;
    private int IncorrectAttempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Random rand = new Random();
        int rand_int1 = rand.nextInt(100) + 1;
        int rand_int2 = rand.nextInt(100) + 1;
        int randAnswer = rand_int1 + rand_int2;

        int1 = (TextView)findViewById(R.id.num1);
        int2 = (TextView)findViewById(R.id.num2);
        answer = (EditText)findViewById(R.id.etAnswer);
        submit = (Button)findViewById(R.id.btnSubmit);
        incorrect = (TextView)findViewById(R.id.tvIncorrect);

        incorrect.setText("Number of Incorrect Answers: " + IncorrectAttempts);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}