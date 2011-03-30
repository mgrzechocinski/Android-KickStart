package pl.javart.android.kickstart;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author: mgrzechocinski@javart.eu
 * @since: 30/03/2011
 */
public class StartActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}