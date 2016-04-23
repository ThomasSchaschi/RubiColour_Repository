package schaschinger.rubicolour.com.rubicolour;

import android.content.Context;
import android.view.MotionEvent;

import org.rajawali3d.Object3D;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.loader.LoaderOBJ;
import org.rajawali3d.loader.ParsingException;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.renderer.RajawaliRenderer;

/**
 * Created by thoma on 22/04/2016.
 */
public class Renderer extends RajawaliRenderer{

    private Context context;
    private DirectionalLight directionalLight;
    private Object3D obj;



    public Renderer(Context context) {
        super(context);
        this.context = context;

        setFrameRate(60);
    }

    @Override
    protected void initScene() {
        directionalLight = new DirectionalLight(1f, .2f, -2.0f);
        directionalLight.setColor(1.0f, 1.0f, 1.0f);
        directionalLight.setPower(1.8f);
        getCurrentScene().addLight(directionalLight);

        Material material = new Material();
        material.enableLighting(true);
        material.setDiffuseMethod(new DiffuseMethod.Lambert());
        material.setColor(0);

        /////////////////////////////////https://github.com/Rajawali/Rajawali/wiki/tutorial-17-importing-.obj-files
        LoaderOBJ parser = new LoaderOBJ(getContext().getResources(), mTextureManager, R.raw.rubikscube);
        try{
            parser.parse();
        }catch(ParsingException e){
            e.printStackTrace();
        }

        obj = parser.getParsedObject();

        obj.setMaterial(material);


        ////////////////////////////////

        /*
        Texture earthTexture = new Texture("Earth", R.drawable.earthtruecolor_nasa_big);
        try{
            material.addTexture(earthTexture);
        }catch(ATexture.TextureException error){
            Log.d("Debug", "TEXTURE ERROR");
        }

        earthSphere = new Sphere(1, 24, 24);
        earthSphere.setMaterial(material);
        */
        getCurrentScene().addChild(obj);
        getCurrentCamera().setZ(7f);
    }

    @Override
    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    @Override
    protected void onRender(long ellapsedRealtime, double deltaTime) {
        super.onRender(ellapsedRealtime, deltaTime);
        obj.rotate(Vector3.Axis.Y, 0.5);
        obj.rotate(Vector3.Axis.X, 0.5);
    }
}
