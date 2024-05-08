package com.example.multipurposecalculator;

import androidx.appcompat.app.AppCompatActivity;



import android.icu.text.UnicodeSet;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private EditText Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display = findViewById(R.id.input);
        Display.setShowSoftInputOnFocus(false);

        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.Display).equals(Display.getText().toString())) {
                    Display.setText("");
                }
            }
        });

    }

    private void updateText(String strToAdd) {
        String oldstr = Display.getText().toString();
        int cursorPos = Display.getSelectionStart();
        String leftstr = oldstr.substring(0, cursorPos);
        String rightstr = oldstr.substring(cursorPos);
        if (getString(R.string.Display).equals(Display.getText().toString())){
            Display.setText(strToAdd);
            Display.setSelection(cursorPos + 1);
        }
        else {
            Display.setText(String.format("%s%s%s", leftstr, strToAdd, rightstr));
            Display.setSelection(cursorPos + 1);
        }

    }

    public void zeroBTN(View v) {
        updateText("0");

    }

    public void oneBTN(View v) {
        updateText("1");

    }

    public void twoBTN(View v) {
        updateText("2");

    }

    public void threeBTN(View v) {
        updateText("3");

    }

    public void fourBTN(View v) {
        updateText("4");
    }

    public void fiveBTN(View v) {
        updateText("5");

    }

    public void sixBTN(View v) {
        updateText("6");

    }

    public void sevenBTN(View v) {
        updateText("7");

    }

    public void eightBTN(View v) {
        updateText("8");

    }

    public void nineBTN(View v) {
        updateText("9");

    }

    public void mulitplyBTN(View v) {
        updateText("*");

    }

    public void divideBTN(View v) {
        updateText("/");

    }

    public void subtractBTN(View v) {
        updateText("-");

    }

    public void addBTN(View v) {
        updateText("+");

    }

    public void clearBTN(View v) {
        Display.setText("");

    }

    public void parBTN(View v) {
        int cursorPos = Display.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLen = Display.getText().length();

        for (int i =0; i< cursorPos; i++){

            if (Display.getText().toString().substring(i, i+1).equals("(")){
                openPar += 1;
            }
            if (Display.getText().toString().substring(i, i+1).equals(")")){
                closePar += 1;
            }
        }
        if (openPar == closePar || Display.getText().toString().substring(textLen -1, textLen).equals("(")){
            updateText("(");
        }
        else if (closePar < openPar || !Display.getText().toString().substring(textLen -1, textLen).equals("(")){
            updateText(")");

        }
        Display.setSelection(cursorPos + 1);


    }

    public void expBTN(View v) {
        updateText("^");

    }

    public void eqBTN(View v) {
        String userExp  = Display.getText().toString();

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        Display.setText(result);
        Display.setSelection(result.length());

    }

    public void pointBTN(View v) {
        updateText(".");

    }

    public void plusmiusBTN(View v) {
        updateText("-");

    }

    public void backspace(View v) {
        int cursorPos = Display.getSelectionStart();
        int textLen = Display.getText().length();

        if (cursorPos != 0 && textLen !=0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) Display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            Display.setText(selection);
            Display.setSelection(cursorPos - 1);
        }

    }

}