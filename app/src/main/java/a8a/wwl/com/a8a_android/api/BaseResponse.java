package a8a.wwl.com.a8a_android.api;

import com.google.gson.annotations.SerializedName;


public class BaseResponse {

    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
