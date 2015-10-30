package com.example.niels.myfirstapplication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    // class propeerties
    private Button onCheckButtonClick, onResetButtonClick, mediumButtonClick, easyButtonClick, hardButtonClick;
    private EditText usersNumberInput;
    private int numInput;
    private int randNumber;
    public int counter;

    // initializer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onCheckButtonClick = (Button) findViewById(R.id.buttonCheck);
        onResetButtonClick = (Button) findViewById(R.id.buttonReset);
        mediumButtonClick = (Button) findViewById(R.id.mediumButton);
        easyButtonClick = (Button) findViewById(R.id.easyButton);
        hardButtonClick = (Button) findViewById(R.id.hardButton);

        usersNumberInput = (EditText) findViewById(R.id.editText);

        randNumber = randomInteger(0,100);
    }

    // check button tells if given number is higher or lower than generated number
    public void onCheckButtonClick(View view) {

        // sets user input as an integer
        numInput = Integer.parseInt(usersNumberInput.getText().toString());

        // initializes the textview so it can be changed
        final TextView higherLower = (TextView) findViewById(R.id.higherLowerTip);
        final TextView counterSet = (TextView) findViewById(R.id.counter);

        // increment counter
        counter++;

        // sets the counter number to a string and displays it
        String strCounter = String.valueOf(counter);
        counterSet.setText(strCounter);

        // gives messages and tips to guess the number
        if (numInput < randNumber) {
            higherLower.setText("Choose higher!");
        }
        if (numInput > randNumber) {
            higherLower.setText("Choose lower!");
        }
        if (numInput == randNumber) {
            higherLower.setText("You won!");
            randNumber = randomInteger(0,100);
            counter = 0;
        }

    }

    // regenerates the random number and resets the counter
    public void onResetButtonClick (View view) {
        randNumber = randomInteger(0,100);
        counter = 0;
        Toast.makeText(this, "The number has been reset to 0 - 100!", Toast.LENGTH_SHORT).show();
    }
    // returns a random number
    public int randomInteger(int min, int max) {

        Random rand = new Random();

        // nextInt excludes the top value so we have to add 1 to include the top value
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    // sets the random number range to 0 - 100
    public void easyButtonClick(View view) {
        randNumber = randomInteger(0, 100);
        counter = 0;

        // shows update message
        Toast.makeText(this, "Number has been set from 0 to 100", Toast.LENGTH_SHORT).show();

        // sets button colors
        easyButtonClick.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
        mediumButtonClick.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.MULTIPLY);
        hardButtonClick.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.MULTIPLY);
    }

    // sets the random number range to 0 - 1000
    public void mediumButtonClick(View view) {
        randNumber = randomInteger(0, 1000);
        counter = 0;

        // shows update message
        Toast.makeText(this, "Number has been set from 0 to 1000", Toast.LENGTH_SHORT).show();

        // sets button colors
        easyButtonClick.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.MULTIPLY);
        mediumButtonClick.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
        hardButtonClick.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.MULTIPLY);
    }

    // sets the random number range to 0 - 10 000
    public void hardButtonClick(View view) {
        randNumber = randomInteger(0, 10000);
        counter = 0;

        // shows update message
        Toast.makeText(this, "Number has been set from 0 to 10 000", Toast.LENGTH_SHORT).show();

        // sets button colors
        easyButtonClick.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.MULTIPLY);
        mediumButtonClick.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.MULTIPLY);
        hardButtonClick.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
    }
}
