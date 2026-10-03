package com.example.guessgame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {

    private int secretNumber;
    private EditText guessInput;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message);
        guessInput = findViewById(R.id.guessInput);
        Button guessButton = findViewById(R.id.guessButton);

        startGame();

        guessButton.setOnClickListener(v -> checkGuess());
    }

    private void startGame() {
        secretNumber = new Random().nextInt(10) + 1;
        message.setText("أنا اخترت رقمًا من 1 إلى 10");
    }

    private void checkGuess() {
        String text = guessInput.getText().toString();

        if (text.isEmpty()) {
            message.setText("اكتب رقمًا أولًا!");
            return;
        }

        int guess = Integer.parseInt(text);

        if (guess < 1 || guess > 10) {
            message.setText("اكتب رقمًا من 1 إلى 10");
        } else if (guess < secretNumber) {
            message.setText("الرقم أكبر ⬆️");
        } else if (guess > secretNumber) {
            message.setText("الرقم أصغر ⬇️");
        } else {
            message.setText("🎉 أحسنت! خمنت الرقم الصحيح!");
            startGame();
        }

        guessInput.setText("");
    }
}
