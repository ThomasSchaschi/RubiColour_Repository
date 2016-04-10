package schaschinger.rubicolour.com.rubicolour;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by thoma on 09/04/2016.
 */
public class GLCubeExample extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Go fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Initialize new surfaceview for next activity which is about to run in fullssreen
        GLSurfaceView view = new GLSurfaceView(this);
        //Set Surface Renderer
        view.setRenderer(new GLCubeRendererEx());
        //Set view
        setContentView(view);
    }
}
