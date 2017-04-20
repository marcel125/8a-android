package a8a.wwl.com.a8a_android.api;

import a8a.wwl.com.a8a_android.api.responses.SmsCodeResponse;
import a8a.wwl.com.a8a_android.api.responses.TokenResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

import static a8a.wwl.com.a8a_android.api.ServerConfig.GET_SMS_CODE;
import static a8a.wwl.com.a8a_android.api.ServerConfig.USER_LOG_IN;


public interface WwlService {


    @POST(GET_SMS_CODE)
    @FormUrlEncoded
    Call<SmsCodeResponse>               getSmsCode(@Field("phoneNumber") String phoneNumber);

    @POST(USER_LOG_IN)
    @FormUrlEncoded
    Call<TokenResponse>               getToken(@Field("phoneNumber") String phoneNumber, @Field("confirmationCode") String confirmationCode);

}
