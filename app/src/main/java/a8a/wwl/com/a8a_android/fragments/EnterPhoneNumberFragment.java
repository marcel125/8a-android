package a8a.wwl.com.a8a_android.fragments;

import android.os.Bundle;
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
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static a8a.wwl.com.a8a_android.api.ServiceApi.STATUS_SUCCESS;

/**
 * Created by devmac on 21/04/17.
 */

public class EnterPhoneNumberFragment extends BaseFragment {

    @Bind(R.id.btn_get_sms_code)
    Button btnGetCode;

    @Bind(R.id.edt_phone_number)
    EditText edtPhoneNumber;

    private View view;

    public static EnterPhoneNumberFragment newInstance() {
        EnterPhoneNumberFragment fragment = new EnterPhoneNumberFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_enter_phone_number, container, false);
            ButterKnife.bind(this, view);
        }

        return view;
    }

    @OnClick(R.id.btn_get_sms_code)
    public void onClickEditPhoneNumber(){
        final String number = edtPhoneNumber.getText().toString();

        if (number.isEmpty()){
            Toast.makeText(getContext(), "Enter phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        ServiceApi.newInstance().getSmsCode(number, new ResponseCallBack<SmsCodeResponse>() {
            @Override
            public void onSuccess(SmsCodeResponse data) {
                if (data.getSuccess().equals(STATUS_SUCCESS))
                    startFragment(R.id.fl_container, EnterSmsCodeFragment.newInstance(number));
                else
                    Toast.makeText(getContext(), data.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(String errorResponse) {
                Toast.makeText(getContext(), errorResponse, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
