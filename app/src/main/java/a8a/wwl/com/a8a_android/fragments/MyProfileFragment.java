package a8a.wwl.com.a8a_android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import a8a.wwl.com.a8a_android.R;
import butterknife.ButterKnife;

/**
 * Created by devmac on 21/04/17.
 */

public class MyProfileFragment extends BaseFragment {

    private View view;

    public static MyProfileFragment newInstance() {
        MyProfileFragment fragment = new MyProfileFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_profile, container, false);
            ButterKnife.bind(this, view);
        }

        return view;
    }
}
