package a8a.wwl.com.a8a_android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import a8a.wwl.com.a8a_android.R;
import a8a.wwl.com.a8a_android.controllers.TokenController;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by devmac on 21/04/17.
 */

public class SelectNewsFragment extends BaseFragment {

    private View view;

    public static SelectNewsFragment newInstance() {
        SelectNewsFragment fragment = new SelectNewsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_select_news, container, false);
            ButterKnife.bind(this, view);
        }

        return view;
    }

    @OnClick(R.id.btn_report_news)
    public void onClickReportNews(){
        if (TokenController.getInstance().isExistToken()) {
            startFragment(R.id.fl_container, MyProfileFragment.newInstance());
        }else {
            startFragment(R.id.fl_container, EnterPhoneNumberFragment.newInstance());
        }
    }

    @OnClick(R.id.btn_watch_news)
    public void onClickWatchNews(){

    }
}
