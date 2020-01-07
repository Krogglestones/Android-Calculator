package com.example.krogt.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class BaseActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        // Insert toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.calculator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.menuDaveDemo:
                intent = new Intent(getApplicationContext(), DaveDemoActivity.class);
                startActivity(intent);
                break;

            case R.id.menuCalc:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;

            case R.id.menuHistory:
                intent = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(intent);
                break;

            case R.id.menuAbout:
                intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);

            default:
                return true;
        }
        return true;
    }
}
