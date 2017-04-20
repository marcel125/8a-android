package a8a.wwl.com.a8a_android.api;


import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import a8a.wwl.com.a8a_android.api.responses.SmsCodeResponse;
import a8a.wwl.com.a8a_android.api.responses.TokenResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static a8a.wwl.com.a8a_android.api.ServerConfig.MSG_NETWORK_ERROR;
import static a8a.wwl.com.a8a_android.api.ServerConfig.SERVER_ADDRESS;


public class ServiceApi {

    private static final String TAG = ServiceApi.class.getSimpleName();
    private static ServiceApi instance = null;
    private WwlService service;

    public static final String STATUS_SUCCESS = "OK";
    public static final String STATUS_FAIL = "fail";

    public static ServiceApi newInstance(){
        if (instance == null){
            instance = new ServiceApi();
        }

        return instance;
    }

    public ServiceApi(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(WwlService.class);

    }

    public void getSmsCode(String phoneNumber, final ResponseCallBack<SmsCodeResponse> callBack){

        Call<SmsCodeResponse> call = service.getSmsCode(phoneNumber);
        call.enqueue(new Callback<SmsCodeResponse>() {
            @Override
            public void onResponse(Call<SmsCodeResponse> call, Response<SmsCodeResponse> response) {
                try {

//                    response.
                    SmsCodeResponse body = response.body();
                    callBack.onSuccess(body);
                } catch (Exception e) {
                    e.printStackTrace();
                    callBack.onFailure(MSG_NETWORK_ERROR);
                }
            }

            @Override
            public void onFailure(Call<SmsCodeResponse> call, Throwable t) {
                callBack.onFailure(MSG_NETWORK_ERROR);
            }
        });
    }

    public void getToken(String phoneNumber, String code, final ResponseCallBack<TokenResponse> callBack){

        Call<TokenResponse> call = service.getToken(phoneNumber, code);
        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                try {

                    TokenResponse body = response.body();
                    callBack.onSuccess(body);
                } catch (Exception e) {
                    e.printStackTrace();
                    callBack.onFailure(MSG_NETWORK_ERROR);
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                callBack.onFailure(MSG_NETWORK_ERROR);
            }
        });
    }


}
