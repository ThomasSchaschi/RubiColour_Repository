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
                        Log.i(TAG, "WhiteList entries: " + mPreview.getListWhite().size());
                        Log.i(TAG, "OrangeList entries: " + mPreview.getListOrange().size());
                        Log.i(TAG, "YellowList entries: " + mPreview.getListYellow().size());
                        Log.i(TAG, "RedList entries: " + mPreview.getListRed().size());
                        Log.i(TAG, "GreenList entries: " + mPreview.getListGreen().size());
                        Log.i(TAG, "BlueList entries: " + mPreview.getListBlue().size());
                        Log.i(TAG, "=================================================================================");
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
}
