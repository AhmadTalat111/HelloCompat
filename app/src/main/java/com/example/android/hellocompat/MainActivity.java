package com.example.android.hellocompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private TextView mHelloTextView;
String[] mColorArray ={"red", "pink", "purple", "deep_purple",
        "indigo", "blue", "light_blue", "cyan", "teal", "green",
        "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
        "brown", "grey", "blue_grey", "black"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTextView = (TextView) findViewById(R.id.hello_textview);
        if(savedInstanceState != null){
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];
        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        mHelloTextView.setTextColor(colorRes);
    }
}
