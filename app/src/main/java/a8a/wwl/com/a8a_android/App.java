package a8a.wwl.com.a8a_android;
import android.app.Application;
import android.util.Log;

import com.snappydb.DB;
import com.snappydb.SnappyDB;
import com.snappydb.SnappydbException;

import timber.log.Timber;


public class App extends Application {

    private static App instance;
    private DB db;

    public App() {
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
        configureDatabase();
    }

    private void configureDatabase() {
        try {
            db = new SnappyDB.Builder(this)
                    .name("a8a_db")
                    .build();
        } catch (SnappydbException e) {
            Log.e("DB", "Unable to create database");
        }
    }

    public DB getDb() {
        return db;
    }

}
