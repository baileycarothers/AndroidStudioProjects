package com.example.loginscreen;

import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ClickerGame extends AppCompatActivity {

    private Button Generate, UpgradeButton, UpgradeAutoClicker;
    private TextView tvFunds, tvTotalFunds;
    private double upgradeCost = 10, clickValue = 1, totalFunds = 0, currentFunds = 0, autoClicker = 0, autoClickerUpgrade = 10, fundsToBeAdded;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker_game);

        UpgradeButton = (Button) findViewById(R.id.upgradeButton);
        Generate = (Button) findViewById(R.id.moneyButton);
        tvFunds = (TextView) findViewById(R.id.tvFunds);
        tvTotalFunds = (TextView) findViewById(R.id.tvTotalFunds);
        UpgradeAutoClicker = (Button) findViewById(R.id.autoclickerButton) ;

        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (currentFunds - autoClickerUpgrade >= 0)
                        {
                            UpgradeAutoClicker.setEnabled(true);
                        }
                        else
                            UpgradeAutoClicker.setEnabled(false);
                        if (currentFunds - upgradeCost >= 0)
                        {
                            UpgradeButton.setEnabled(true);
                        }
                        else
                            UpgradeButton.setEnabled(false);
                        fundsToBeAdded = autoClicker;
                        currentFunds = currentFunds + fundsToBeAdded;
                        totalFunds = totalFunds + fundsToBeAdded;
                        //BigDecimal bdTotal = new BigDecimal(totalFunds);
                        //bdTotal = bdTotal.setScale(0, RoundingMode.HALF_UP);
                        //totalFunds = bdTotal.doubleValue();
                        tvFunds = (TextView) findViewById(R.id.tvFunds);
                        tvFunds.setText("Funds: " + String.valueOf(currentFunds));
                        tvTotalFunds.setText(("Total Funds Generated: " + String.valueOf(totalFunds)));
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(task,1000,1000);

        UpgradeAutoClicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentFunds - autoClickerUpgrade >= 0) {
                    UpgradeAutoClicker.setEnabled(false);
                    currentFunds = currentFunds - autoClickerUpgrade;
                    autoClicker = autoClicker + 1;
                    autoClickerUpgrade = autoClickerUpgrade * 2;
                    /*
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    UpgradeAutoClicker.setEnabled(true);
                                }
                            });
                        }
                    }, 3000);
                    */
                }
            }
        });

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
                if(currentFunds - upgradeCost >= 0)
                {
                    UpgradeButton.setEnabled(false);
                    currentFunds = currentFunds - upgradeCost;
                    upgradeCost = upgradeCost * 2.5;
                    clickValue = clickValue + 1;
                    tvFunds.setText("Funds: " + String.valueOf(currentFunds));
                }
            }
        });
    }
}
