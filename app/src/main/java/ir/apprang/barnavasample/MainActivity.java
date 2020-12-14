package ir.apprang.barnavasample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ir.apprang.barnava.Barnava;

public class MainActivity extends AppCompatActivity {

    int statusbar = 0;
    int navigationbar = 0;
    boolean light_mode = false;

    Barnava barnava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barnava = new Barnava(this);


        if (getIntent().hasExtra("statusbar")) {
            statusbar = getIntent().getIntExtra("statusbar", 0);
            navigationbar = getIntent().getIntExtra("navigationbar", 0);
            light_mode = getIntent().getBooleanExtra("light_mode", false);

            barnava.change(statusbar, navigationbar, light_mode);
        }


        Button btn_statusbar_do_no_thing = findViewById(R.id.doNoThing);
        btn_statusbar_do_no_thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusbar = 0;

                reset();
            }
        });

        Button btn_statusbar_set_color = findViewById(R.id.colored);
        btn_statusbar_set_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusbar = R.color.yellow;
                reset();
            }
        });

        Button btn_statusbar_transparent = findViewById(R.id.transparent);
        btn_statusbar_transparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusbar = -1;
                reset();
            }
        });

        Button btn_statusbar_light = findViewById(R.id.light);
        btn_statusbar_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                light_mode = true;
                reset();
            }
        });

        Button btn_statusbar_dark = findViewById(R.id.dark);
        btn_statusbar_dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                light_mode = false;
                reset();
            }
        });

        Button btn_navigation_do_no_thing = findViewById(R.id.NdoNoThing);
        btn_navigation_do_no_thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationbar = 0;
                reset();
            }
        });

        Button btn_navigation_set_color = findViewById(R.id.Ncolored);
        btn_navigation_set_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationbar = R.color.purple_200;
                reset();
            }
        });

        Button btn_navigation_transparent = findViewById(R.id.Ntransparent);
        btn_navigation_transparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationbar = -1;
                reset();

            }
        });

    }

    public void reset() {

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.putExtra("statusbar", statusbar);
        intent.putExtra("navigationbar", navigationbar);
        intent.putExtra("light_mode", light_mode);
        startActivity(intent);
        finish();

    }

}