package a8a.wwl.com.a8a_android.activities;

/**
 * Created by devmac on 21/04/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {


    public abstract void setTitle(String title);

    public abstract void setSubtitle(String subTitle);

    public void showProgressBar() {
    }

    public void hideProgressBar() {

    }

    public boolean isProgressBarVisible() {
        return false;
    }

    public abstract void showSuccessNotificationBar(String message);

    public abstract void showErrorNotificationBar(String message);

    public abstract void showActionNotificationBar(String message, String action, View.OnClickListener listener);
}