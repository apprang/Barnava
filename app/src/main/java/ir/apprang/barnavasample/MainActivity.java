package ir.apprang.barnavasample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ir.apprang.barnava.Barnava;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Barnava.setStatusBarAndNavBarTransparent(this);
    }
}