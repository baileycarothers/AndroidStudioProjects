package com.example.loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class AppMenu extends AppCompatActivity {

    private Button Math, Login, Clicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_menu);

        Login = (Button)findViewById(R.id.loginButton);
        Math = (Button) findViewById(R.id.mathButton);
        Clicker = (Button) findViewById(R.id.clickerButton);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(AppMenu.this, MainActivity.class);
                startActivity(login);
            }
        });
        Math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent math = new Intent(AppMenu.this, SecondActivity.class);
                startActivity(math);
            }
        });
        Clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clicker = new Intent(AppMenu.this, ClickerGame.class);
                startActivity(clicker);
            }
        });
    }
}
