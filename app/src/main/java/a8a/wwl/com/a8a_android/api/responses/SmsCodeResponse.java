package a8a.wwl.com.a8a_android.api.responses;

import com.google.gson.annotations.SerializedName;

import a8a.wwl.com.a8a_android.api.BaseResponse;

/**
 * Created by devmac on 21/04/17.
 */

public class SmsCodeResponse extends BaseResponse {

    @SerializedName("success")
    private String success;

    @SerializedName("expires_at")
    private String expiresAt;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }


    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }
}
