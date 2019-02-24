package com.example.loginscreen;

import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickerGame extends AppCompatActivity {

    private Button Generate, UpgradeButton;
    private TextView tvFunds, tvTotalFunds;
    private int currentFunds = 0, totalFunds = 0, clickValue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker_game);

        UpgradeButton = (Button) findViewById(R.id.upgradeButton);
        Generate = (Button) findViewById(R.id.moneyButton);
        tvFunds = (TextView) findViewById(R.id.tvFunds);
        tvTotalFunds = (TextView) findViewById(R.id.tvTotalFunds);

        Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFunds = currentFunds + clickValue;
                totalFunds = totalFunds + clickValue;
                tvFunds.setText("Funds: " + String.valueOf(currentFunds));
                tvTotalFunds.setText(("Total Funds Generated: " + String.valueOf(totalFunds)));
            }
        });

        UpgradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFunds = currentFunds - 10;
                clickValue = clickValue + 1;
                tvFunds.setText("Funds: " + String.valueOf(currentFunds));
            }
        });
    }
}
