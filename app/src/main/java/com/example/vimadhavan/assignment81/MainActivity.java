package com.example.vimadhavan.assignment81;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateUI();
    }

    private void updateUI(){
        TextView txt=(TextView) findViewById(R.id.txt);
        String  settings = "";
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        settings=settings+"Password: " + sp.getString("pref_Password", "My Password");

        settings=settings+"\nIs Screen Locked:"+ sp.getBoolean("pref_LockScreen", false);


        settings=settings+"\nUpdate Frequency: "+ sp.getString("pref_UpdateFrequency", "Weekly");



        txt.setText(settings);
    }

    @Override
    public void onClick(View v) {
        Intent settingsAct=new Intent(this,SettingsActivity.class);
        startActivity(settingsAct);
    }


}
