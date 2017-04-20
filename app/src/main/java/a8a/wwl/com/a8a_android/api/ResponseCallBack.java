package a8a.wwl.com.a8a_android.api;

public interface ResponseCallBack<T> {
    void onSuccess(T data);
    void onFailure(String errorResponse);
}
