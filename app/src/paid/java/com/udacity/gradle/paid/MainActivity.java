package com.udacity.gradle.paid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.jokedisplay.DisplayActivity;
import com.udacity.gradle.builditbigger.GEAsync;
import com.udacity.gradle.builditbigger.R;

public class MainActivity extends AppCompatActivity implements GEAsync.Callback {
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        //Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
        pDialog.setMessage("Loading");
        showDialog();
        fetchJoke();

    }

    private void fetchJoke(){
        new GEAsync(this).execute();
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


    @Override
    public void onFinished(String result) {
        hideDialog();
        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
        intent.putExtra("Joke", result);
        String product = "Paid";
        intent.putExtra("Product", product);
        startActivity(intent);
    }
}

