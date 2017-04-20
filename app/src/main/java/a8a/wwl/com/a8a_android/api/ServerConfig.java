package a8a.wwl.com.a8a_android.api;

public class ServerConfig {

    public static final int SERVER_RESPONSE_SUCCESS_CODE                = 200;
    public static final int SERVER_RESPONSE_ERROR_CODE                  = 400;
    public static final int SERVER_RESPONSE_ERROR_CODE_TOKEN            = 401;
    public static final int SERVER_RESPONSE_ERROR_CODE_FORBIDDEN        = 403;
    public static final int SERVER_RESPONSE_ERROR_CODE_NOT_FOUND        = 404;
    public static final int SERVER_RESPONSE_ERROR_CODE_INTERNAL_ERROR   = 500;

    public static final String AUTH_HEADER = "Authorization";

    public static final String MSG_NETWORK_ERROR = "Unable to reach to server, please try again";
    public static final String MSG_SERVER_ERROR = "Unknown response from server";
    public static final String MSG_LOGIN_FAILED = "Failed to login, Please try again";
    public static final String MSG_ADD_DEVICE_FAILED = "Adding device token failed";
    public static final String MSG_REGISTER_FAILED = "The invitation code you entered is invalid";
    public static final String MSG_REGISTER_INVITE_INVALID = "The invitation code you entered is invalid";
    public static final String MSG_REGISTER_PHONE_INVALID = "The phone number you entered is invalid";
    public static final String MSG_VERIFY_FAILED = "Failed to verify, Please try again";
    public static final String MSG_PARSING_ERROR = "Parsing error";

    public static final String SERVER_ADDRESS = "http://dev-api.wwl.tv/";
    public static final String END_POINT = "api/v1/";

    public static final String GET_SMS_CODE = END_POINT + "login/request-code";
    public static final String USER_LOG_IN = END_POINT + "login";
    public static final String USER_GET_PROFILE = END_POINT + "users/profile-fields";

}
