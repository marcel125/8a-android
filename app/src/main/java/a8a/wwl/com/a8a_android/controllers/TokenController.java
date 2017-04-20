package a8a.wwl.com.a8a_android.controllers;

import com.snappydb.DB;
import com.snappydb.SnappydbException;

import a8a.wwl.com.a8a_android.App;
import timber.log.Timber;

/**
 * Created by devmac on 21/04/17.
 */

public class TokenController {

    public static final String TAG = TokenController.class.getSimpleName();
    private static final TokenController instance = new TokenController();

    public static TokenController getInstance() {
        return instance;
    }

    private static final String CURRENT_TOKEN = "logged_in_user_token";
    private String token;

    private TokenController() {
    }

    public void saveToken(String token) {
        this.token = token;

        DB db = App.getInstance().getDb();
        try {
            db.put(CURRENT_TOKEN, token);
        } catch (SnappydbException e) {
            Timber.e(e, "Unable to save data");
        }
    }

    public boolean isExistToken() {
        DB db = App.getInstance().getDb();
        try {
            return db.exists(CURRENT_TOKEN);
        } catch (SnappydbException e) {
            Timber.e(e, "Failed on find data");
            return false;
        }
    }

    public String getToken() {
        if (token == null) {
            if (isExistToken()) {
                DB db = App.getInstance().getDb();
                try {
                    token = db.get(CURRENT_TOKEN);
                } catch (SnappydbException e) {
                    Timber.e(e, "Failed on get token");
                }
            }
        }
        return token;
    }

    public boolean removeString() {
        token = null;
        if (isExistToken()) {
            DB db = App.getInstance().getDb();
            try {
                db.del(CURRENT_TOKEN);
                return true;
            } catch (SnappydbException e) {
                Timber.e(e, "Failed on remove token");
                return false;
            }
        }else
            return true;
    }
}
