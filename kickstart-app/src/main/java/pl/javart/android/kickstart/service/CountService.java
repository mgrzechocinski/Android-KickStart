package pl.javart.android.kickstart.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author: mgrzechocinski@javart.eu
 * @since: 20/04/2011
 */
public class CountService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }
}
