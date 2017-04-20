package a8a.wwl.com.a8a_android.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import a8a.wwl.com.a8a_android.activities.BaseActivity;

/**
 * Created by devmac on 21/04/17.
 */

public class BaseFragment extends Fragment{

    protected static String TAG = BaseFragment.class.getSimpleName();

    private boolean isNeedRegister = false;
    protected int userId;
    protected int eventId;

    public void setTitle(){

    }

    public void setTitle(String title) {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            activity.setTitle(title);
    }

    public void setSubtitle(String subTitle) {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            activity.setSubtitle(subTitle);
    }

    public void showProgressBar() {

        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            activity.showProgressBar();
    }

    public void hideProgressBar() {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            activity.hideProgressBar();
    }

    public boolean isProgressBarVisible(){
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            return activity.isProgressBarVisible();
        else
            return false;
    }

    public void showSuccessNotificationBar(String message) {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            activity.showSuccessNotificationBar(message);
    }

    public void showErrorNotificationBar(String message) {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null)
            activity.showErrorNotificationBar(message);
    }

    public void showActionNotificationBar(String message, String action, View.OnClickListener listener) {
        BaseActivity activity = (BaseActivity) getActivity();
        activity.showActionNotificationBar(message, action, listener);
    }

    public boolean onBackPressed(){
        return true;
    }

    protected void  startFragment(int frameLayoutId, Fragment f) {
        startFragment(frameLayoutId, f, true, null);
    }

    protected void startFragmentWithTag(int frameLayoutId, Fragment f, String tag) {
        startFragment(frameLayoutId, f, true, tag);
    }

    protected void startFragment(int frameLayoutId, Fragment f, boolean addToBackStack, String tag) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayoutId, f);
        if(addToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }
}
