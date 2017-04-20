package a8a.wwl.com.a8a_android.api.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by devmac on 21/04/17.
 */

public class TokenResponse {
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
