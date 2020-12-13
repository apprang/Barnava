package ir.apprang.barnavasample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ir.apprang.barnava.Barnava;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Barnava(this)
                .change(0, R.color.yellow, true);

    }
}