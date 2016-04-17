package schaschinger.rubicolour.com.rubicolour;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
IMPORTANT SIDENOTES FOR ME:

A camera preview class is a SurfaceView that can display the live image data coming from a camera, so users can frame and capture a picture or video.


 */

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity - ";
    private Camera mCamera;
    private CameraPreview mPreview;
    private Button btnPrune;


    private ArrayList<String> lWhite;
    private ArrayList<String> lOrange;
    private ArrayList<String> lYellow;
    private ArrayList<String> lRed;
    private ArrayList<String> lGreen;
    private ArrayList<String> lBlue;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview);


        // Create an instance of Camera
        mCamera = getCameraInstance();


        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);

        final Box box = new Box(this);
        addContentView(box, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        //Check if camera is available
        if(checkCameraHardware(this)) {

            mPreview.initializeArraylists();
            //For screenshot
            this.btnPrune = (Button) findViewById(R.id.button_capture);
            this.btnPrune.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mPreview.getCounter() == 7){
                        Log.i(TAG, "=================================================================================");

                        lWhite = mPreview.getListWhite();
                        lOrange = mPreview.getListOrange();
                        lYellow = mPreview.getListYellow();
                        lRed = mPreview.getListRed();
                        lGreen = mPreview.getListGreen();
                        lBlue = mPreview.getListBlue();

                        Log.i(TAG, "Data of WhiteList: " + lWhite.get(0) + " , " + lWhite.get(1) + " , " + lWhite.get(2) + " , " + lWhite.get(3) + " , " + lWhite.get(4) + " , " + lWhite.get(5) + " , " + lWhite.get(6) + " , " + lWhite.get(7) + " , " + lWhite.get(8));
                        Log.i(TAG, "Data of OrangeList: " + lOrange.get(0) + " , " + lOrange.get(1) + " , " + lOrange.get(2) + " , " + lOrange.get(3) + " , " + lOrange.get(4) + " , " + lOrange.get(5) + " , " + lOrange.get(6) + " , " + lOrange.get(7) + " , " + lOrange.get(8));
                        Log.i(TAG, "Data of YellowList: " + lYellow.get(0) + " , " + lYellow.get(1) + " , " + lYellow.get(2) + " , " + lYellow.get(3) + " , " + lYellow.get(4) + " , " + lYellow.get(5) + " , " + lYellow.get(6) + " , " + lYellow.get(7) + " , " + lYellow.get(8));
                        Log.i(TAG, "Data of RedList: " + lRed.get(0) + " , " + lRed.get(1) + " , " + lRed.get(2) + " , " + lRed.get(3) + " , " + lRed.get(4) + " , " + lRed.get(5) + " , " + lRed.get(6) + " , " + lRed.get(7) + " , " + lRed.get(8));
                        Log.i(TAG, "Data of GreenList: " + lGreen.get(0) + " , " + lGreen.get(1) + " , " + lGreen.get(2) + " , " + lGreen.get(3) + " , " + lGreen.get(4) + " , " + lGreen.get(5) + " , " + lGreen.get(6) + " , " + lGreen.get(7) + " , " + lGreen.get(8));
                        Log.i(TAG, "Data of BlueList: " + lBlue.get(0) + " , " + lBlue.get(1) + " , " + lBlue.get(2) + " , " + lBlue.get(3) + " , " + lBlue.get(4) + " , " + lBlue.get(5) + " , " + lBlue.get(6) + " , " + lBlue.get(7) + " , " + lBlue.get(8));

                        Log.i(TAG, "=================================================================================");

                        //Get Permission to calculate the singmaster notation
                        if(haveGo()) {
                            String masterString = Singmaster.createSingmasterNotation(lWhite, lOrange, lYellow, lRed, lGreen, lBlue);
                            Log.i(TAG, masterString);
                        }else{
                            Log.i(TAG, "Requirements not fulfilled!");
                        }

                    }else{
                        mPreview.takeScreenshot();
                    }

                }
            });
        }

    }

    private static final int CAMERA_REQUEST = 1888; // field




    /** Check if this device has a camera */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
            Log.i(TAG, "Primary Camera CAN be accessed!");
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
            Log.e(TAG, "Primary Camera CANNOT be accessed!");
        }
        return c; // returns null if camera is unavailable
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseCamera();              // release the camera immediately on pause event
    }


    private void releaseCamera(){
        if (mCamera != null){
            mCamera.release();        // release the camera for other applications
            mCamera = null;
        }
    }

    /**
     * This method calculates if all 6 color occure 9 times - not more and not less;
     * Otherwise it doesn't match the rubiks cube criteria;
     * @return
     */
    private int counterW = 0, counterR = 0, counterB = 0, counterO = 0, counterG = 0, counterY = 0;
    private boolean haveGo(){
        for(int i = 0; i < 9; i++){
            addToCounter(lWhite.get(i));
            addToCounter(lRed.get(i));
            addToCounter(lBlue.get(i));
            addToCounter(lOrange.get(i));
            addToCounter(lGreen.get(i));
            addToCounter(lYellow.get(i));
        }

        if(counterW != 9 || counterR != 9 || counterB != 9 || counterO != 9 || counterG != 9 || counterY != 9){
            Log.e(TAG, "Counters don't check out!");
            return false;
        }else{
            return true;
        }
    }

    private void addToCounter(String color){
        if(color.equalsIgnoreCase("white")){
            this.counterW++;
        }else if(color.equalsIgnoreCase("red")){
            this.counterR++;
        }else if(color.equalsIgnoreCase("blue")){
            this.counterB++;
        }else if(color.equalsIgnoreCase("orange")){
            this.counterO++;
        }else if(color.equalsIgnoreCase("green")){
            this.counterG++;
        }else if(color.equalsIgnoreCase("yellow")){
            this.counterY++;
        }
    }

}
