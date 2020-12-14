package ir.apprang.barnavasample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import ir.apprang.barnava.Barnava;

public class MainActivity extends AppCompatActivity {


    Button btn_statusbar_do_no_thing;
    Button btn_statusbar_set_color;
    Button btn_statusbar_transparent;
    Button btn_statusbar_light;
    Button btn_statusbar_dark;
    Button btn_navigation_do_no_thing;
    Button btn_navigation_set_color;
    Button btn_navigation_transparent;

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


        btn_statusbar_do_no_thing = findViewById(R.id.doNoThing);
        btn_statusbar_do_no_thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusbar = 0;

                reset();
            }
        });

        btn_statusbar_set_color = findViewById(R.id.colored);
        btn_statusbar_set_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusbar = R.color.yellow;
                reset();
            }
        });

        btn_statusbar_transparent = findViewById(R.id.transparent);
        btn_statusbar_transparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusbar = -1;
                reset();
            }
        });

        btn_statusbar_light = findViewById(R.id.light);
        btn_statusbar_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                light_mode = true;
                reset();
            }
        });

        btn_statusbar_dark = findViewById(R.id.dark);
        btn_statusbar_dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                light_mode = false;
                reset();
            }
        });

        btn_navigation_do_no_thing = findViewById(R.id.NdoNoThing);
        btn_navigation_do_no_thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationbar = 0;
                reset();
            }
        });

        btn_navigation_set_color = findViewById(R.id.Ncolored);
        btn_navigation_set_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationbar = R.color.purple_200;
                reset();
            }
        });

        btn_navigation_transparent = findViewById(R.id.Ntransparent);
        btn_navigation_transparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationbar = -1;
                reset();

            }
        });

        changeBtnColor();

    }

    public void reset() {

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.putExtra("statusbar", statusbar);
        intent.putExtra("navigationbar", navigationbar);
        intent.putExtra("light_mode", light_mode);
        startActivity(intent);
        finish();

    }


    public void changeBtnColor() {

        if (statusbar > 0) {
            btn_statusbar_do_no_thing.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            btn_statusbar_set_color.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
            btn_statusbar_transparent.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
        } else if (statusbar < 0) {
            btn_statusbar_do_no_thing.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            btn_statusbar_set_color.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            btn_statusbar_transparent.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
        } else if (statusbar == 0) {
            btn_statusbar_do_no_thing.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
            btn_statusbar_set_color.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            btn_statusbar_transparent.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
        }


        if (light_mode) {
            btn_statusbar_light.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
            btn_statusbar_dark.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
        } else {
            btn_statusbar_light.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            btn_statusbar_dark.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
        }


        if (navigationbar > 0) {
            btn_navigation_do_no_thing.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            btn_navigation_set_color.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
            btn_navigation_transparent.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
        } else if (navigationbar < 0) {
            btn_navigation_do_no_thing.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            btn_navigation_set_color.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            btn_navigation_transparent.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
        } else if (navigationbar == 0) {
            btn_navigation_do_no_thing.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
            btn_navigation_set_color.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            btn_navigation_transparent.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
        }


    }

}