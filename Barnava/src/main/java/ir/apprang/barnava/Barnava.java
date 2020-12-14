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


    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    public void change(int statusBarColor, int navigationBarColor, boolean light_statusbar) {


        /**
         *  statusbar : do nothing
         *  navigationbar : do nothing
         *  رنگ استاتوس و رنگ نویگیشن بار تعویض نمیشود
         */
        if (statusBarColor == 0 && navigationBarColor == 0) {

        }


        /**
         * statusbar : transparent - navigationbar : colored
         استاتوس بار ترنسپرنت (شفاش) میشود ولی  نویگیشن باررنگ دارد.
         **/
        else if (statusBarColor < 0 && navigationBarColor > 0) {

            Window window = activity.getWindow();
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                int uiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                if (light_statusbar)
                    uiVisibility = uiVisibility | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                window.getDecorView().setSystemUiVisibility(uiVisibility);
            }

            if (Build.VERSION.SDK_INT >= 21) {
                setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
                window.setStatusBarColor(Color.TRANSPARENT);
                window.setNavigationBarColor(ContextCompat.getColor(activity, navigationBarColor));
            }

        }


        /**
         statusbar = transparent - navigationbar = transparent
         هم استاتوس بار و هم نریگیشن بار ترنسپرنت (شفاف) میشوند
         */
        else if (statusBarColor < 0 && navigationBarColor < 0) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Window window = activity.getWindow();
                window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                if (light_statusbar) {
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                }
            }

        }


        /**
         statusbar = transparent - navigationbar = do no thing
         استاتوس بار ترنسپرنت (شفاش) میشود ولی با نویگیشن بار کاری نداریم.
         */
        else if (statusBarColor < 0 && navigationBarColor == 0) {

            Window window = activity.getWindow();
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                int uiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                if (light_statusbar)
                    uiVisibility = uiVisibility | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                window.getDecorView().setSystemUiVisibility(uiVisibility);
            }

            if (Build.VERSION.SDK_INT >= 21) {
                setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
                window.setStatusBarColor(Color.TRANSPARENT);
            }

        }


        /**
         status bar = colored - navigationbar = colored
         رنگ استاتوس و رنگ نویگیشن بار تعویض میشود
         */
        else if (statusBarColor > 0 && navigationBarColor > 0) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                if (light_statusbar)
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                else
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.setStatusBarColor(ContextCompat.getColor(activity, statusBarColor));
                window.setNavigationBarColor(ContextCompat.getColor(activity, navigationBarColor));
            }
        }


        /**
         statusbar = colored - navigationbar = transparent
         تغییر رنگ استاتوس بار - نویگیشن بار شفاف
         */
        else if (statusBarColor > 0 && navigationBarColor < 0) {

            Window window = activity.getWindow();
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, true);
            }
            if (Build.VERSION.SDK_INT >= 19) {

                int uiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
                if (light_statusbar)
                    uiVisibility = uiVisibility | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                window.getDecorView().setSystemUiVisibility(uiVisibility);

            }

            if (Build.VERSION.SDK_INT >= 21) {
                setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
                window.setStatusBarColor(ContextCompat.getColor(activity, statusBarColor));
                window.setNavigationBarColor(Color.TRANSPARENT);

            }

        }


        /**
         statusbar = colored - navigationbar = do no thing
         رنگ استاتوس تغییر میکند اما با نویگیشن کاری نداریم
         */
        else if (statusBarColor > 0 && navigationBarColor == 0) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                if (light_statusbar)
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                else
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.setStatusBarColor(ContextCompat.getColor(activity, statusBarColor));
            }

        }

        /**
         statusbar = do nothing - navigationbar = transparent
         نویگیشن بار ترنسپرت میشود ولی با استاتوس بار کاری نداریم
         */
        else if (statusBarColor == 0 && navigationBarColor < 0) {

            Window window = activity.getWindow();
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, true);
            }
            if (Build.VERSION.SDK_INT >= 19) {

                int uiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
                if (light_statusbar)
                    uiVisibility = uiVisibility | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                window.getDecorView().setSystemUiVisibility(uiVisibility);
            }

            if (Build.VERSION.SDK_INT >= 21) {
                setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
                //window.setStatusBarColor(ContextCompat.getColor(activity, statusBarColor));
                window.setNavigationBarColor(Color.TRANSPARENT);

            }

        }

        /**
         statusbar = do no thing - navigationbar = colored
         رنگ نویگیشن بار تغییر میکند اما با استاتوس بار کاری نداریم
         */
        else if (statusBarColor == 0 && navigationBarColor > 0) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                if (light_statusbar)
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                else
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.setNavigationBarColor(ContextCompat.getColor(activity, navigationBarColor));
            }

        }


    }


}
