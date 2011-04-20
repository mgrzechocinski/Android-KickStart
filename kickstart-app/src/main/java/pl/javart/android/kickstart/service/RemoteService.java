package pl.javart.android.kickstart.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author: mgrzechocinski@javart.eu
 * @since: 20/04/2011
 */
public class RemoteService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Return the interface
        return mBinder;
    }

    private final MyRemoteService.Stub mBinder = new MyRemoteService.Stub() {
        public int getPid(){
            return 0;
        }
        public void basicTypes(int anInt, long aLong, boolean aBoolean,
            float aFloat, double aDouble, String aString) {
            // Does nothing
        }
    };
}
