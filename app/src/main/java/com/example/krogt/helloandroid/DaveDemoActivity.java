package com.example.krogt.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class DaveDemoActivity extends BaseActivity {

    String resultStr = "";
    EditText edtResultFrom;
    EditText edtConversionResult;

    TextView txtFromUnits;
    TextView txtToUnits;

    String[] items = {
            "Inches to Centimeters",
            "Centimeters to Inches",
            "Miles to Kilometers",
            "Kilometers to Miles",
            "Gallons to Cups",
            "Cups to Gallons",
            "Meters to Feet",
            "Feet to Meters",
            "Meters to Inches",
            "Inches to Meters",
            "Millimeter to Inches",
            "Inches to Millimeters",
            "Square meters to Square feet",
            "Square feet to Square meters",
            "Square meters to Square inches",
            "Square inches to Square feet",

            "Cubic meter to Cubic feet",
            "Cubic feet to Cubic Meter",
            "Cubic meter to Gallons",
            "Gallons to Cubic meters",
            "Liters to Cubic feet",
            "Cubic feet to Liters",
            "Liters to Cubic inches",
            "Cubic Inches to Liters",
            "Liters to Gallons",
            "Gallons to Liters",

            "Kilograms to Pounds",
            "Pounds to Kilograms",
            "Newtons to Pounds of Force",
            "Pounds of force to Newtons",

            "Pints to Quarts",
            "Quarts to Pints",
            "Quarts to Gallons",
            "Gallons to Quarts",
            "Ounces to Pounds",
            "Pounds to Ounces",
            "Pounds to Tons",
            "Tons to Pounds",

            "Rods to Furlongs",
            "Furlongs to Rods"
    };

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dave_demo);

        txtToUnits = findViewById(R.id.txtToUnits);
        txtFromUnits = findViewById(R.id.txtFromUnits);
        edtConversionResult = findViewById(R.id.edtResultTo);
        edtResultFrom = findViewById(R.id.edtResultFrom);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, items);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                performCalculation(position);
            }
        });
    }

    Double[] conversionRates = {
            2.54,
            0.393701,
            1.60934,
            0.6213727366,
            16.0,
            0.0625,
            3.281,
            0.3047851264858275,
            39.37,
            0.0254000508001016,
            0.03937,
            25.4000508001016,
            10.76,
            0.0929368029739777,
            1550.0,
            0.000645161290,
            35.31,
            0.028320589,
            264.2,
            0.003785,
            0.03531,
            28.320589,
            61.02,
            0.016388,
            0.2642,
            3.785011,
            2.205,
            0.4535147,
            0.2248,
            4.44839857,
            0.5,
            2.0,
            0.25,
            4.0,
            0.0625,
            16.0,
            0.0005,
            2000.0,
            0.025,
            40.0
    };


    private void performCalculation(int position) {
        Double fromNumber;
        Double toNumber;

        fromNumber = Double.parseDouble(edtResultFrom.getText().toString());

        if (fromNumber != null) { // || (fromNumber != 0){

            toNumber = conversionRates[position] * fromNumber;
            edtConversionResult.setText(Double.toString(toNumber));
            String[] parts = items[position].split(" to ");
            String part1 = parts[0];
            String part2 = parts[1];
            txtFromUnits.setText(part1);
            txtToUnits.setText(part2);
        }
    }


    public void calcButtonOnClick(View v) {

        //Intent AKA intention
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
