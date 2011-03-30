package pl.javart.android.kickstart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author: mgrzechocinski@javart.eu
 * @since: 30/03/2011
 */
public class StartActivity extends Activity {

    public static final String NAME_INTENT_KEY = "name";
    private EditText input;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        input = (EditText) findViewById(R.id.name_input);

        Button nameButton = (Button) findViewById(R.id.name_submit_button);
        nameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openNameDetailsActivity();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    private void openNameDetailsActivity() {
        Intent nameDetailsIntent = new Intent(this, NameDetailsActivity.class);
        nameDetailsIntent.putExtra(NAME_INTENT_KEY, input.getText().toString());
        startActivity(nameDetailsIntent);
    }
}