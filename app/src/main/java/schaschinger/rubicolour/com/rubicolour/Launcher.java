package schaschinger.rubicolour.com.rubicolour;

import android.*;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by Thomas Schaschinger on 03/06/2016.
 * This class/activity pops up to the users when he runs the application first, provides a userguide
 * of how to handel the application and the output data and which restrictions are given at that time.
 */
public class Launcher extends Activity {

    private Button btnLaunch;
    private RadioButton rbShow;
    private TextView tvManual;

    private static final int REQUEST_CAMERA = 1;
    private static final String TAG = "Launcher - ";
    private SharedPreferences settings;
    private boolean skip = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        restorePrefs();
        if(this.skip){
            //Log.i(TAG, "Skipped because skip = " + this.skip);
            //startMain();
        }

        Log.i(TAG, "Attempting to load manual.");
        String manual = loadManual();

        setContentView(R.layout.launchview);

        this.btnLaunch = (Button)findViewById(R.id.btnStart);
        this.rbShow = (RadioButton)findViewById(R.id.rbShow);
        this.rbShow.setChecked(true);
        this.tvManual = (TextView)findViewById(R.id.tvManual);
        this.tvManual.setText(manual);

        btnLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commitChanges();
                startMain();
                finish();
            }
        });
        rbShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = rbShow.isChecked();
                if(checked){
                    rbShow.setChecked(false);
                    rbShow.setClickable(false);
                    skip = true;
                }
            }
        });


    }

    private String loadManual(){
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = null;
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("manual.txt")));
            stringBuilder = new StringBuilder();
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            Log.i(TAG, "File read successfully!");
            bufferedReader.close();
            return stringBuilder.toString();
        }catch(Exception e){
            Log.i(TAG, "Error attempting to read the manual - file.");
        }
        return null;
    }

    /**
     * Restore Preferences
     */
    private void restorePrefs(){
        this.settings = getPreferences(0);
        //boolean silent = settings.getBoolean("silentMode", false);
        this.skip = this.settings.getBoolean("skip", false);
    }


    public void permissionsQ(){
        //Receive Runtime Permission
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            Log.i(TAG, "Should have permission to access camera!");
        }else{
            Log.i(TAG, "Don't have permission to access camera!");

            //Putting up dialog for users to inform about camera denial
            if(shouldShowRequestPermissionRationale(android.Manifest.permission.CAMERA)){
                Toast.makeText(this, "You need to give us permission to use your camera! - we cannot operate without.", Toast.LENGTH_SHORT).show();
            }
            requestPermissions(new String[]{android.Manifest.permission.CAMERA}, REQUEST_CAMERA);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == REQUEST_CAMERA){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.i(TAG, "Should have permission by now.");
            }
        }else{
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void commitChanges(){
        this.settings = getPreferences(0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("skip", skip);
        editor.commit();
        Log.i(TAG, "Changes commited - skip now - " + this.skip);
    }

    private void startMain(){
        Intent i = new Intent(this, RajawaliMainActivity.class);
        startActivity(i);
        finish();
    }
}
