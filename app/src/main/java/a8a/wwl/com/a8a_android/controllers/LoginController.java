package a8a.wwl.com.a8a_android.controllers;

import com.snappydb.DB;
import com.snappydb.SnappydbException;

import a8a.wwl.com.a8a_android.App;
import timber.log.Timber;

/**
 * Created by devmac on 21/04/17.
 */

public class LoginController {

    public static final String TAG = LoginController.class.getSimpleName();
    private static final LoginController instance = new LoginController();

    public static LoginController getInstance() {
        return instance;
    }

    private static final String CURRENT_LOGIN = "logged_in_user_isLogin";
    private Boolean isLogin;

    private LoginController() {
    }

    public void saveLogin(Boolean isLogin) {
        this.isLogin = isLogin;

        DB db = App.getInstance().getDb();
        try {
            db.put(CURRENT_LOGIN, isLogin);
        } catch (SnappydbException e) {
            Timber.e(e, "Unable to save data");
        }
    }

    public boolean isExistLogin() {
        DB db = App.getInstance().getDb();
        try {
            return db.exists(CURRENT_LOGIN);
        } catch (SnappydbException e) {
            Timber.e(e, "Failed on find data");
            return false;
        }
    }

    public Boolean getLogin() {
        if (isLogin == null) {
            if (isExistLogin()) {
                DB db = App.getInstance().getDb();
                try {
                    isLogin = db.getBoolean(CURRENT_LOGIN);
                } catch (SnappydbException e) {
                    Timber.e(e, "Failed on get isLogin");
                }
            }
        }
        return isLogin == null ? false : isLogin;
    }

    public boolean removeString() {
        isLogin = null;
        if (isExistLogin()) {
            DB db = App.getInstance().getDb();
            try {
                db.del(CURRENT_LOGIN);
                return true;
            } catch (SnappydbException e) {
                Timber.e(e, "Failed on remove isLogin");
                return false;
            }
        }else
            return true;
    }
}
