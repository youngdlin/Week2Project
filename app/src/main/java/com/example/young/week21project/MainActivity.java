package com.example.young.week21project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public Button textDisappearer;
    public EditText editText;
    public SharedPreferences sharedPreferences;
    public View buttonView;
    public TextView textView;
    public String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //button shiz

        buttonView = findViewById(R.id.button);
        textDisappearer = (Button) findViewById(R.id.button);

        textDisappearer.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            buttonView.setVisibility(View.INVISIBLE);
            //save the key-value pair
            //however, an alert dialog box should pop up if EditText is empty
            if (string==""){
                //from stack overflow
            new AlertDialog.Builder(getApplicationContext())
                    .setTitle("Important Notice")
                    .setMessage("This field cannot be left blank!")
                    .setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                            dialog.dismiss();
                        }
                    })
                    .show();
        }
        });

        // text shiz
        editText= (EditText) findViewById(R.id.editText);

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        textView = (TextView) findViewById(R.id.textView);
        string=editText.getText().toString();
        textView.setText(string);
        //save this value to a key value pair, did this part wrong


        Set<String> servicesSet = sp.getStringSet("typedText", null);
        if (servicesSet != null) {
            String[] servicesArray = servicesSet.toArray(new String[servicesSet.size()]);
            textView.setText(string);}
            servicesTextView.setText(Arrays.toString(servicesArray));
        }



    }
    @Override
    public void onResume(){
        super.onResume();
        //check if there is a saved key value pair
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.reset) {
            //startActivity(new Intent(MainActivity.this,USure.class));
            //no longer starting a new activity
            new AlertDialog.Builder(getApplicationContext())
                    .setTitle("Resetting everything")
                    .setMessage("Are you sure you want to reset the text")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //remove saved value

                            textView.setText("");
                            textDisappearer.setVisibility(View.VISIBLE);
                            editText.setVisibility(View.VISIBLE);}
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                            dialog.dismiss();
                        }
                    })
                    .show();
            return true;
        }
        else if id==R.id.settings) {
        //shared preferences again to store Boolean (check box) as key value pair. did this part wrong too
            //        if (sp.getBoolean(NOTIFICATIONS_KEY, false)) {
//            notificationsTextView.setText("true");
//        } else {
//            notificationsTextView.setText("false");
//        }
        }
        return super.onOptionsItemSelected(item);
    }
}
