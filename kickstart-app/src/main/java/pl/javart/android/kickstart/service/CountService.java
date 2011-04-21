package pl.javart.android.kickstart.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

/**
 * @author: mgrzechocinski@javart.eu
 * @since: 20/04/2011
 */
public class CountService extends Service {

    public static final String INCREMENT_ACTION = "pl.javart.javart.kickstart.ACTION_VALUE_INCREMENTED";
    public static final String INTENT_KEY = "value";

    protected final String LOG_TAG = CountService.class.getSimpleName();

    public class LocalBinder extends Binder {
        public CountService getService() {
            return CountService.this;
        }
    }

    private final IBinder localServiceBinder = new LocalBinder();

    private int count;


    public IBinder onBind(Intent intent) {
        return localServiceBinder;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            count++;
            broadcastIncrementEvent();
            if(count > 10){
                stopSelf();
                return;
            }
            schedule(1000);
        }
    };

    private void broadcastIncrementEvent() {
        Intent intent = new Intent(INCREMENT_ACTION);
        intent.putExtra(INTENT_KEY, count);
        sendBroadcast(intent);
    }

    private void schedule(int delayMillis) {
        handler.sendEmptyMessageDelayed(0, delayMillis);
    }


    @Override
    public void onCreate() {
        Log.d(LOG_TAG, "onCreate()");
        schedule(0);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartCommand()");
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy(). Current value: " + count);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(LOG_TAG, "onUnbind()");
        return super.onUnbind(intent);
    }
}
