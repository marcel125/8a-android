package a8a.wwl.com.a8a_android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import a8a.wwl.com.a8a_android.R;
import a8a.wwl.com.a8a_android.controllers.TokenController;
import a8a.wwl.com.a8a_android.fragments.SelectNewsFragment;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.iv_alert)
    ImageView ivAlert;

    @Bind(R.id.iv_log_in)
    ImageView ivLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initControls();

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, SelectNewsFragment.newInstance()).commit();
    }

    private void initControls(){

        if (TokenController.getInstance().isExistToken()){
            ivAlert.setVisibility(View.VISIBLE);
            ivLogin.setImageResource(R.drawable.ic_person);
        }else {
            ivAlert.setVisibility(View.GONE);
            ivLogin.setImageResource(R.drawable.ic_log_in);
        }
    }


    @OnClick(R.id.iv_log_in)
    public void onClickLogin() {

        if (TokenController.getInstance().isExistToken()) {             //check user is login or not

        }else {

        }
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setSubtitle(String subTitle) {

    }

    @Override
    public void showSuccessNotificationBar(String message) {

    }

    @Override
    public void showErrorNotificationBar(String message) {

    }

    @Override
    public void showActionNotificationBar(String message, String action, View.OnClickListener listener) {

    }
}
