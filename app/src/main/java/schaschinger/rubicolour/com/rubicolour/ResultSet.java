package schaschinger.rubicolour.com.rubicolour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by thoma on 03/06/2016.
 */
public class ResultSet extends Activity {

    private String masterString = "";

    private static final String TAG = "ResultSet - ";

    private Button btnSure, btnNope, btnCalibration;
    private TextView masterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultlayout);

        this.masterString = getIntent().getStringExtra("SingmasterExtra");
        Log.i(TAG, "Received StringmasterExtra : " + this.masterString);

        initialize();

    }

    private void initialize() {
        this.btnNope = (Button) findViewById(R.id.btnNope);
        this.btnSure = (Button) findViewById(R.id.btnSure);
        this.btnCalibration = (Button)findViewById(R.id.btnCalibration);
        this.masterView = (TextView) findViewById(R.id.tvSingmaster);

        if (this.masterString != null && !this.masterString.equals("")) {
            this.masterView.setText(this.masterString);
        }else{
            this.masterView.setText("ERROR OCCURED FOR SINGMASTER NOTATION! (PROBABLY WRONG COLOUR)");
        }

        this.btnNope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRajawali();
            }
        });

        this.btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });

        this.btnCalibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void startRajawali() {
        Intent i = new Intent(this, RajawaliMainActivity.class);
        startActivity(i);
        finish();
    }

    private void startMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
