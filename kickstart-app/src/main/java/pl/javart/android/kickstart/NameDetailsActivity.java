package pl.javart.android.kickstart;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author: mgrzechocinski@javart.eu
 * @since: 30/03/2011
 */
public class NameDetailsActivity extends Activity {

    protected final String LOG_TAG = this.getClass().getSimpleName();
    private TextView nameOutput;
    private Button viewById;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_details);

        Intent sourceIntent = getIntent();
        String name = sourceIntent.getStringExtra(StartActivity.NAME_INTENT_KEY);
        Log.d(LOG_TAG, "Got name " + name);

        nameOutput = (TextView) findViewById(R.id.name_output);
        nameOutput.setText(name);

        viewById = (Button) findViewById(R.id.show_dialog_button);
        viewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showMyDialog();
            }


        });
        Log.d(LOG_TAG, "onCreate");
    }

    private void showMyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_msg)
                .setTitle(android.R.string.dialog_alert_title)
                .setNegativeButton(android.R.string.cancel, null);
        builder.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}