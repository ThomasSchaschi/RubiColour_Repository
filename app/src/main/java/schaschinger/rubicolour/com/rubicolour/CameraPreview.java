package schaschinger.rubicolour.com.rubicolour;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by thoma on 03/04/2016.
 */
/** A basic Camera preview class */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder mHolder;
    private Camera mCamera;


    private final String TAG = "CameraPreview - ";




    public CameraPreview(Context context, Camera camera) {
        super(context);
        mCamera = camera;

        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        mHolder = getHolder();
        mHolder.addCallback(this);
        // deprecated setting, but required on Android versions prior to 3.0
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);


        try {
            // image naming and path  to include sd card  appending name you choose for file
            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";


            mCamera.takePicture(null, null, myPictureCallback_JPG);



        } catch (Throwable e) {
            // Several error may come out with file handling or OOM
            e.printStackTrace();
        }
    }


    Bitmap takenBitmap;
    Camera.PictureCallback myPictureCallback_JPG = new Camera.PictureCallback(){

    public void onPictureTaken(byte[] arg0, Camera arg1) {
        // TODO Auto-generated method stub

        takenBitmap = BitmapFactory.decodeByteArray(arg0, 0, arg0.length);
        Log.i(TAG, "Bitmap obtained!");


        int pixelCenter= takenBitmap.getPixel(takenBitmap.getWidth() / 2 + 8, takenBitmap.getHeight() / 2);
        int pixelLeft = takenBitmap.getPixel(takenBitmap.getWidth() / 2 - 8, takenBitmap.getHeight() / 2);
        int pixelRight = takenBitmap.getPixel(takenBitmap.getWidth() / 2 + 33, takenBitmap.getHeight() / 2);

        int pixelTopCenter = takenBitmap.getPixel(takenBitmap.getWidth() / 2 + 8, takenBitmap.getHeight() / 2 - 25);
        int pixelTopLeft = takenBitmap.getPixel(takenBitmap.getWidth() / 2 - 8, takenBitmap.getHeight() / 2 - 25);
        int pixelTopRight = takenBitmap.getPixel(takenBitmap.getWidth() / 2 + 33, takenBitmap.getHeight() / 2 - 25);

        int pixelBottomCenter = takenBitmap.getPixel(takenBitmap.getWidth() / 2 + 8, takenBitmap.getHeight() / 2 + 25);
        int pixelBottomLeft = takenBitmap.getPixel(takenBitmap.getWidth() / 2 - 8, takenBitmap.getHeight() / 2 + 25);
        int pixelBottomRight = takenBitmap.getPixel(takenBitmap.getWidth() / 2 + 33, takenBitmap.getHeight() / 2 + 25);

        Log.i(TAG, "Obtained pixelCenter from coordinate : " + takenBitmap.getWidth() / 2 + " " + takenBitmap.getHeight() / 2);
        Log.i(TAG, "+" + pixelCenter);


        /*
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        // image naming and path  to include sd card  appending name you choose for file
        String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";


        File imageFile = new File(mPath);

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            takenBitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();
            Log.i(TAG, "SAVE!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        //Color center
        String hexColor = String.format("#%06X", (0xFFFFFF & pixelCenter));
        Log.i(TAG, "Probably : " + hexColor);
        ColorUtils colorUtils = new ColorUtils();
        String colorName = colorUtils.getColorNameFromHex(pixelCenter);
        Log.i(TAG, "Center : " + colorName);

        //Color left
        hexColor = String.format("#%06X", (0xFFFFFF & pixelLeft));
        Log.i(TAG, "Probably : " + hexColor);
        colorName = colorUtils.getColorNameFromHex(pixelLeft);
        Log.i(TAG, "Left : " + colorName);

        //Color right
        hexColor = String.format("#%06X", (0xFFFFFF & pixelRight));
        Log.i(TAG, "Probably : " + hexColor);
        colorName = colorUtils.getColorNameFromHex(pixelRight);
        Log.i(TAG, "Right : " + colorName);

        //Top center
        hexColor = String.format("#%06X", (0xFFFFFF & pixelTopCenter));
        Log.i(TAG, "Probably : " + hexColor);
        colorName = colorUtils.getColorNameFromHex(pixelTopCenter);
        Log.i(TAG, "Top center : " + colorName);

        //Top left
        hexColor = String.format("#%06X", (0xFFFFFF & pixelTopLeft));
        Log.i(TAG, "Probably : " + hexColor);
        colorName = colorUtils.getColorNameFromHex(pixelTopLeft);
        Log.i(TAG, "Top left : " + colorName);

        //Top right
        hexColor = String.format("#%06X", (0xFFFFFF & pixelTopRight));
        Log.i(TAG, "Probably : " + hexColor);
        colorName = colorUtils.getColorNameFromHex(pixelTopRight);
        Log.i(TAG, "Top right : " + colorName);

        //Bttom center
        hexColor = String.format("#%06X", (0xFFFFFF & pixelBottomCenter));
        Log.i(TAG, "Probably : " + hexColor);
        colorName = colorUtils.getColorNameFromHex(pixelBottomCenter);
        Log.i(TAG, "Bottom center : " + colorName);

        //Bottom left
        hexColor = String.format("#%06X", (0xFFFFFF & pixelBottomLeft));
        Log.i(TAG, "Probably : " + hexColor);
        colorName = colorUtils.getColorNameFromHex(pixelBottomLeft);
        Log.i(TAG, "Bottom left : " + colorName);

        //Bottom right
        hexColor = String.format("#%06X", (0xFFFFFF & pixelBottomRight));
        Log.i(TAG, "Probably : " + hexColor);
        colorName = colorUtils.getColorNameFromHex(pixelBottomRight);
        Log.i(TAG, "Bottom right : " + colorName);

        mCamera.stopPreview();
        //Restart camera to take another picture
        try {
            mCamera.setPreviewDisplay(mHolder);
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }};




    public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, now tell the camera where to draw the preview.
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (IOException e) {
            Log.d(TAG, "Error setting camera preview: " + e.getMessage());
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // empty. Take care of releasing the Camera preview in your activity.
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        // If your preview can change or rotate, take care of those events here.
        // Make sure to stop the preview before resizing or reformatting it.

        if (mHolder.getSurface() == null){
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
        try {
            mCamera.stopPreview();
        } catch (Exception e){
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        try {
            mCamera.setPreviewDisplay(mHolder);
            mCamera.startPreview();

        } catch (Exception e){
            Log.d(TAG, "Error starting camera preview: " + e.getMessage());
        }
    }


}
