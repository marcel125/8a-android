package a8a.wwl.com.a8a_android.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import a8a.wwl.com.a8a_android.R;
import a8a.wwl.com.a8a_android.api.ResponseCallBack;
import a8a.wwl.com.a8a_android.api.ServiceApi;
import a8a.wwl.com.a8a_android.api.responses.SmsCodeResponse;
import a8a.wwl.com.a8a_android.api.responses.TokenResponse;
import a8a.wwl.com.a8a_android.controllers.TokenController;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static a8a.wwl.com.a8a_android.api.ServiceApi.STATUS_SUCCESS;

/**
 * Created by devmac on 21/04/17.
 */

public class EnterSmsCodeFragment extends BaseFragment {

    @Bind(R.id.edt_sms_code)
    EditText edtSmsCode;

    @Bind(R.id.btn_next)
    Button btnNext;

    @Bind(R.id.btn_did_not_receive)
    Button btnDidNotReceive;

    private View view;
    private String phoneNumber;

    public static EnterSmsCodeFragment newInstance(String phoneNumber) {
        EnterSmsCodeFragment fragment = new EnterSmsCodeFragment();
        fragment.phoneNumber = phoneNumber;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_enter_sms_code, container, false);
            ButterKnife.bind(this, view);
        }

        return view;
    }

    @OnClick(R.id.btn_next)
    public void onClickNext() {
        String code = edtSmsCode.getText().toString();

        if (code.isEmpty()){
            Toast.makeText(getContext(), "Enter code", Toast.LENGTH_SHORT).show();
            return;
        }

        ServiceApi.newInstance().getToken(phoneNumber, code, new ResponseCallBack<TokenResponse>() {
            @Override
            public void onSuccess(TokenResponse data) {

                TokenController.getInstance().saveToken(data.getToken());
                getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startFragment(R.id.fl_container, MyProfileFragment.newInstance());
                    }
                }, 100);
            }

            @Override
            public void onFailure(String errorResponse) {
                Toast.makeText(getContext(), errorResponse, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn_did_not_receive)
    public void onClickDidNotReceive() {
        getActivity().getSupportFragmentManager().popBackStack();
    }
}
