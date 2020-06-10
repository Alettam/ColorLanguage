package com.example.colorlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spinner, spinnerColor;
    Button okBtn, colorChangeBtn;
    Locale locale;
    Configuration config;

    private static int currentThemeRes = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (currentThemeRes != -1) {
            setTheme(currentThemeRes);
        }
        setContentView(R.layout.activity_main);


        initViews();
    }

    private void initViews() {
        spinner = findViewById(R.id.spinner);
        spinnerColor = findViewById(R.id.spinnerColor);
        okBtn = findViewById(R.id.okBtn);
        colorChangeBtn = findViewById(R.id.chageColor);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config = new Configuration();
                if (spinner.getSelectedItem().toString().equals("English")) {
                    locale = new Locale("en");
                    config.setLocale(locale);
                    getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }else {
                    locale = new Locale("ru");
                    config.setLocale(locale);
                    getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }

            }
        });

        colorChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinnerColor.getSelectedItem().toString().equals("Черный")) {
                    currentThemeRes = R.style.ThemeBlack;
                    recreate();
                }else if(spinnerColor.getSelectedItem().toString().equals("Зеленый")){
                    currentThemeRes = R.style.ThemeGreen;
                    recreate();
                }else if (spinnerColor.getSelectedItem().toString().equals("Синий")){
                    currentThemeRes = R.style.ThemeBlue;
                    recreate();
                }
           }
        });
    }
}
