package com.example.loginscreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    private TextView Info, MathProblem, ShowAnswer;
    private int Counter = 0;
    private Button Submit;
    private EditText Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

        final AlertDialog.Builder NoAnswer = new AlertDialog.Builder(SecondActivity.this);
        NoAnswer.setMessage("Please enter an answer.")
                .setCancelable(false)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Commit Die", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();
                        Intent intent=new Intent(SecondActivity.this, AppMenu.class);
                        startActivity(intent);
                    }
                });
        final AlertDialog alert = NoAnswer.create();
        Info.setText("Number of Incorrect Answers: " + String.valueOf(Counter));
        MathProblem.setText(rand_int1 + " + " + rand_int2);

        Submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(Answer.getText().toString().isEmpty())
                    alert.show();
                else
                    validate(Answer.getText().toString(), randAnswer);
            }
        });
    }

    private void validate(String userAnswer, int randAnswer)
    {
        int userNum = Integer.parseInt(userAnswer);
        if (userNum == randAnswer)
        {
            Info.setText("Congrats you can do math!");
            Submit.setText("Generate New Problem");
            Intent intent=new Intent(SecondActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            Counter++;
            Info.setText("Number of Incorrect Answers: " + String.valueOf(Counter));
            if (Counter == 2)
            {
                Info.setText("You suck at math");
                Submit.setEnabled(false);
                ShowAnswer.setText("The correct answer was: " + randAnswer);
            }
        }
    }
}