package pl.javart.android.kickstart;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import pl.javart.android.kickstart.service.CountService;

/**
 * @author: mgrzechocinski@javart.eu
 * @since: 20/04/2011
 */
public class CountActivity extends Activity implements ValueIncrementedListener {

    protected final String LOG_TAG = CountActivity.class.getSimpleName();

    private TextView viewById;

    private MyReceiver myReceiver = new MyReceiver();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count);

        Intent service = new Intent(getApplicationContext(), CountService.class);

        startService(service);
        viewById = (TextView) findViewById(R.id.counter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(myReceiver, myReceiver.specifyIntentFilter());
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }


    @Override
    public void onValueIncremented(int newValue) {
        viewById.setText(Integer.toString(newValue));
    }

    private class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int newValue = intent.getIntExtra(CountService.INTENT_KEY, 0);
            onValueIncremented(newValue);
        }

        public IntentFilter specifyIntentFilter(){
            return new IntentFilter(CountService.INCREMENT_ACTION);
        }
    }
}