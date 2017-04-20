package a8a.wwl.com.a8a_android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import a8a.wwl.com.a8a_android.R;
import a8a.wwl.com.a8a_android.activities.MainActivity;
import a8a.wwl.com.a8a_android.api.ResponseCallBack;
import a8a.wwl.com.a8a_android.api.ServiceApi;
import a8a.wwl.com.a8a_android.api.responses.ProfileResponse;
import a8a.wwl.com.a8a_android.api.responses.TokenResponse;
import a8a.wwl.com.a8a_android.controllers.LoginController;
import a8a.wwl.com.a8a_android.controllers.TokenController;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by devmac on 21/04/17.
 */

public class MyProfileFragment extends BaseFragment {

    @Bind(R.id.edt_user_name)
    EditText edtUserName;

    @Bind(R.id.edt_user_bio)
    EditText edtUserBio;

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
            getProfileInfo();
        }

        return view;
    }

    private void getProfileInfo(){
        ServiceApi.newInstance().getProfile(new ResponseCallBack<ProfileResponse>() {
            @Override
            public void onSuccess(ProfileResponse data) {
                LoginController.getInstance().saveLogin(true);
                ((MainActivity)getActivity()).initControls();
                edtUserName.setText(data.getData().get(0).getValue());
                edtUserBio.setText(data.getData().get(2).getValue());

                Toast.makeText(getContext(), "Getting profile successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(String errorResponse) {
                Toast.makeText(getContext(), errorResponse, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn_cancel)
    public void onClickCancel(){
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @OnClick(R.id.btn_logout)
    public void onClickLogout(){
        LoginController.getInstance().saveLogin(false);
        ((MainActivity)getActivity()).initControls();
        getActivity().getSupportFragmentManager().popBackStack();
    }
}
