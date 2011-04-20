package pl.javart.android.kickstart.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * @author: mgrzechocinski@javart.eu
 * @since: 20/04/2011
 */
public class CountService extends Service {

    public class LocalBinder extends Binder {
        public CountService getService() {
            return CountService.this;
        }
    }

    private final IBinder localServiceBinder = new LocalBinder();


    public IBinder onBind(Intent intent) {
        return localServiceBinder;
    }
}
