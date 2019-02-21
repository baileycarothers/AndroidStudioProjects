package com.example.loginscreen;

import android.support.v7.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView Info;
    private int Counter = 0;
    private Button Submit;
    private TextView MathProblem;
    private EditText Answer;
    private TextView ShowAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000) + 1;
        int rand_int2 = rand.nextInt(1000) + 1;
        final int randAnswer = rand_int1 + rand_int2;

        ShowAnswer = (TextView) findViewById(R.id.showAnswer);
        MathProblem = (TextView) findViewById(R.id.mathProblem);
        Answer = (EditText) findViewById(R.id.etAnswer);
        Submit = (Button) findViewById(R.id.btnSubmit);
        Info = (TextView) findViewById(R.id.incorrectAttempts);

        ShowAnswer.setText("Answer: " + randAnswer);
        Info.setText("Number of Incorrect Answers: " + String.valueOf(Counter));
        MathProblem.setText(rand_int1 + " + " + rand_int2);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Answer.getText().toString(), randAnswer);
            }
        });
    }

    private void validate(String userAnswer, int randAnswer) {
        int userNum = Integer.parseInt(userAnswer);
        if (userNum == randAnswer)
        {
            Info.setText("Congrats you can do math!");
        }
        else {
            Counter++;
            Info.setText("Number of Incorrect Answers: " + String.valueOf(Counter));
            if (Counter == 2) {
                Info.setText("You suck at math");
                Submit.setEnabled(false);
            }
        }
    }
}