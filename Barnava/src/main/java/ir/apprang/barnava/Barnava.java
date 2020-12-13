package ir.apprang.barnava;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;


/**
 * Utils for status bar
 * Created by Mahdi Farzami on 12/12/2020.
 */

public class Barnava {

    Activity activity;


    public Barnava(@NonNull Activity activity) {

        this.activity = activity;
    }


    public void change(int statusBarColor, int navigationBarColor, boolean light_statusbar) {

        // رنگ استاتوس و رنگ نویگیشن بار تعویض میشود
        if (statusBarColor == 0 && navigationBarColor == 0) {

        }
        // رنگ استاتوس و رنگ نویگیشن بار تعویض میشود
        else if (statusBarColor > 0 && navigationBarColor > 0) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.setStatusBarColor(ContextCompat.getColor(activity, statusBarColor));
                window.setNavigationBarColor(ContextCompat.getColor(activity, navigationBarColor));
                if (light_statusbar)
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }

        // رنگ استاتوس تغییر میکند اما با نویگیشن کاری نداریم
        else if (statusBarColor > 0 && navigationBarColor == 0) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.setStatusBarColor(ContextCompat.getColor(activity, statusBarColor));
                if (light_statusbar)
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }

        }

        // رنگ نویگیشن بار تغییر میکند اما با استاتوس بار کاری نداریم
        else if (statusBarColor == 0 && navigationBarColor > 0) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.setNavigationBarColor(ContextCompat.getColor(activity, navigationBarColor));
                if (light_statusbar)
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }

        }

        // هم استاتوس بار و هم نریگیشن بار ترنسپرنت (شفاف) میشوند
        else if (statusBarColor < 0 && navigationBarColor < 0) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); // transparent navigationbar
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.setStatusBarColor(Color.TRANSPARENT);
                window.setNavigationBarColor(Color.TRANSPARENT);
                if (light_statusbar)
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }

        }

        // استاتوس بار ترنسپرنت (شفاش) میشود ولی با نویگیشن بار کاری نداریم.
        else if (statusBarColor < 0 && navigationBarColor == 0) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.setStatusBarColor(Color.TRANSPARENT);
                if (light_statusbar)
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }

        }
        // نویگیشن بار ترنسپرت میشود ولی با استاتوس بار کاری نداریم
        else if (statusBarColor == 0 && navigationBarColor < 0) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                if (light_statusbar)
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }

        }

        // تغییر رنگ استاتوس بار - نویگیشن بار شفاف
        else if (statusBarColor > 0 && navigationBarColor < 0) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                window.setStatusBarColor(ContextCompat.getColor(activity, statusBarColor));
                if (light_statusbar)
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }

        }


    }



}
