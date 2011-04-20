package pl.javart.android.kickstart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import pl.javart.android.kickstart.service.CountService;

/**
 * @author: mgrzechocinski@javart.eu
 * @since: 20/04/2011
 */
public class CountActivity extends Activity {

    protected final String LOG_TAG = CountActivity.class.getSimpleName();

    private int count;
    private TextView viewById;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            increment();
            schedule(1000);
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count);

        startService(new Intent(getApplicationContext(), CountService.class));

        viewById = (TextView) findViewById(R.id.counter);
        schedule(0);
    }

    private void schedule(int delayMillis) {
        handler.sendEmptyMessageDelayed(0, delayMillis);
    }

    private void increment() {
        viewById.setText(Integer.toString(count++));
    }


}