package com.example.krogt.helloandroid;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends BaseActivity {

    Button btn1;
    EditText edtResult;
    boolean usedDecimalPoint = false;
    Button btnPlus, btnMinus, btnMult, btnDiv, btnBackspace, btnSquared, btnSqRt, btnPie, btnPercent, btnNegative;
    Button btnEquals;
    int pendingOperation;  // button id
    double lastNumber, currentValue, nextValue;
    int btnEqualsID;
    double runningTotal;
    boolean portrait = true;

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btn1 = (Button) findViewById(R.id.btn1);
        edtResult = (EditText) findViewById(R.id.edtResult);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnEquals = (Button) findViewById(R.id.btnEquals);

        // Add Unicode characters for the buttons
//        if(!portrait) {
        btnBackspace = (Button) findViewById(R.id.btnBackspace);
        btnBackspace.setText("\u232b");
        btnSquared = (Button) findViewById(R.id.btnSquared);
        btnSquared.setText("X\u00b2");
        btnSqRt = (Button) findViewById(R.id.btnSqRt);
        btnSqRt.setText("\u221A");
        btnPie = (Button) findViewById(R.id.btnPie);
        btnPie.setText("\u03C0");
        btnPercent = (Button) findViewById(R.id.btnPercent);
        btnPercent.setText("\u0025");
        btnNegative = (Button) findViewById(R.id.btnNegative);
        btnNegative.setText("\u00B1");
//        }
        // Disallow soft keyboard

        edtResult.setShowSoftInputOnFocus(false);
        edtResult.setInputType(InputType.TYPE_NULL);
        edtResult.setFocusable(false);
        edtResult.setText("");

        // Get screen orientation

//        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
//        int orientation = display.getRotation();
//        portrait = (orientation == Surface.ROTATION_0 || orientation == Surface.ROTATION_180); // ? true : false;


    }




//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        // Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
//            portrait = false;
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
//            portrait = true;
//        }
//    }

    // Handle the operators
    public void btnOperationOnClick(View v) {
        int operation = ((Button) v).getId();
        int btnPlusID = btnPlus.getId();
        int btnMinusID = btnMinus.getId();
        int btnDivID = btnDiv.getId();
        int btnMultID = btnMult.getId();
        int btnEqualsID = btnEquals.getId();


        lastNumber = Double.parseDouble(edtResult.getText().toString());
        //  runningTotal += lastNumber;

        Log.i("CALC", "ButtonID: " + operation);

        if (operation == btnPlusID) {
            Log.i("Calc", "Is Plus: ");
            // CALCULATIONS
            //    Toast.makeText(this, "ButtonID: " + operation, Toast.LENGTH_LONG).show();
            // lastNumber += Double.parseDouble( edtResult.getText().toString() );
            runningTotal += lastNumber;
            pendingOperation = btnPlusID;
            // Clear the results
            edtResult.setText("");
        }

        if (operation == btnMinusID) {
            Log.i("Calc", "Is Minus: ");
            // CALCULATIONS
            //    Toast.makeText(this, "ButtonID: " + operation, Toast.LENGTH_LONG).show();
//            runningTotal = Double.parseDouble( edtResult.getText().toString() ) - lastNumber;
//            runningTotal -= (runningTotal - Double.parseDouble( edtResult.getText().toString() ));
            runningTotal -= lastNumber;
            pendingOperation = btnMinusID;
            // Clear the results
            edtResult.setText("");
        }

        if (operation == btnMultID) {
            Log.i("Calc", "Is Multiply: ");
            // CALCULATIONS
            //    Toast.makeText(this, "ButtonID: " + operation, Toast.LENGTH_LONG).show();
            runningTotal = lastNumber;//runningTotal * Double.parseDouble( edtResult.getText().toString() ) ;
            pendingOperation = btnMultID;
            // Clear the results
            edtResult.setText("");
        }

        if (operation == btnDivID) {
            Log.i("Calc", "Is Division: ");
            // CALCULATIONS
            //    Toast.makeText(this, "ButtonID: " + operation, Toast.LENGTH_LONG).show();
            runningTotal = lastNumber;
            pendingOperation = btnDivID;
            // Clear the results
            edtResult.setText("");
        }

    }

    public void btnNegative(View v) {
        double value = Double.parseDouble(edtResult.getText().toString());
        edtResult.setText(Double.toString((value) - (value * 2)));
    }

    public void btnBackspace(View v) {
        int value = Integer.parseInt(edtResult.getText().toString());
        int newNumber = value / 10;
        edtResult.setText(Integer.toString(newNumber));
    }

    public void btnPercentage(View v) {
        double value = lastNumber;
        double percentage = value * Double.parseDouble(edtResult.getText().toString()) / 100;
        edtResult.setText(Double.toString(percentage));
    }

    public void btnPie(View v) {
        double value = Math.PI;
        edtResult.setText(Double.toString(value));
    }

    public void btnSqRt(View v) {
        double value = Double.parseDouble(edtResult.getText().toString());
        edtResult.setText(Double.toString(Math.sqrt(value)));
    }

    public void btnSqared(View v) {
        double value = Double.parseDouble(edtResult.getText().toString());
        edtResult.setText(Double.toString((value * value)));
    }

    public void btnMathOperation(View v) {
        double value = Math.cos(Double.parseDouble(edtResult.getText().toString()));
        edtResult.setText(Double.toString(value));
        usedDecimalPoint = true;
    }

    public void btnMathOperation2(View v) {
        double value = Math.sin(Double.parseDouble(edtResult.getText().toString()));
        edtResult.setText(Double.toString(value));
        usedDecimalPoint = true;
    }

    public void btnMathOperation3(View v) {
        double value = Math.tan(Double.parseDouble(edtResult.getText().toString()));
        edtResult.setText(Double.toString(value));
        usedDecimalPoint = true;
    }

    public void btnRandom(View v) {
        edtResult.setText(Double.toString(Math.random()));
        usedDecimalPoint = true;
    }


    // Handles all numbers and decimal
    public void btnOnClick(View v) {
        //     btn1.setText("Craig");
        String newButton = ((Button) v).getText().toString();
        String currentResult = edtResult.getText().toString();

        if (newButton.equals(".")) {
            if (!usedDecimalPoint) {
                edtResult.setText(currentResult + ".");
                usedDecimalPoint = true;
            }
        } else {

            edtResult.setText(currentResult + newButton);
        }
    }

    public void btnEqualsOnClick(View v) {
        //  Assume that I have a pending operation and 2 numbers

        if (pendingOperation != 0) {
            switch (pendingOperation) {
                case R.id.btnPlus:
                    // plus code

                    currentValue = (runningTotal + Double.parseDouble(edtResult.getText().toString()));

                    edtResult.setText(Double.toString(currentValue));
                    pendingOperation = 0;
                    lastNumber = 0;
                    currentValue = 0;
                    runningTotal = 0;
                    break;

                case R.id.btnMinus:

                    //  1 + 2 + 3 = * 4 / 1 + 2 = C 1 + 1 =

                    currentValue = (-runningTotal) - Double.parseDouble(edtResult.getText().toString());
                    edtResult.setText(Double.toString(currentValue));
                    pendingOperation = 0;
                    lastNumber = 0;
                    currentValue = 0;
                    runningTotal = 0;
                    break;


                case R.id.btnMult:
                    // multiplication code.
                    currentValue = runningTotal * Double.parseDouble(edtResult.getText().toString());

                    edtResult.setText(Double.toString(currentValue));
                    pendingOperation = 0;
                    lastNumber = 0;
                    currentValue = 0;
                    runningTotal = 0;
                    break;


                case R.id.btnDiv:
                    // division code
                    currentValue = runningTotal / Double.parseDouble(edtResult.getText().toString());

                    edtResult.setText(Double.toString(currentValue));
                    pendingOperation = 0;
                    lastNumber = 0;
                    currentValue = 0;

                    break;

                default:
                    break;
            }
        }

    }

    public void btnClearOnClick(View v) {
        edtResult.setText("");
        usedDecimalPoint = false;
    }

    public void btnDavesDemoOnClick(View v) {
        Intent intent = new Intent (this, DaveDemoActivity.class);

        // put data in the intent
        intent.putExtra("Result", edtResult.getText().toString());
        startActivity(intent);
    }

}
