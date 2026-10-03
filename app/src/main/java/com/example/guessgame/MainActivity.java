package com.example.guessgame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {

    private int treasureChest;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);

        Button chest1 = findViewById(R.id.chest1);
        Button chest2 = findViewById(R.id.chest2);
        Button chest3 = findViewById(R.id.chest3);
        Button restartButton = findViewById(R.id.restartButton);

        startGame();

        chest1.setOnClickListener(v -> checkChest(1));
        chest2.setOnClickListener(v -> checkChest(2));
        chest3.setOnClickListener(v -> checkChest(3));

        restartButton.setOnClickListener(v -> startGame());
    }

    private void startGame() {
        treasureChest = new Random().nextInt(3) + 1;

        resultText.setText("🏆 اختر صندوقًا وابحث عن الكنز!");

        enableChests(true);
    }

    private void checkChest(int selectedChest) {

        if (selectedChest == treasureChest) {
            resultText.setText("🎉 مبروك! وجدت الكنز! 🏆");
        } else {
            resultText.setText("😢 لا يوجد كنز هنا! حاول مرة أخرى.");
        }
    }

    private void enableChests(boolean enabled) {
        findViewById(R.id.chest1).setEnabled(enabled);
        findViewById(R.id.chest2).setEnabled(enabled);
        findViewById(R.id.chest3).setEnabled(enabled);
    }
}
