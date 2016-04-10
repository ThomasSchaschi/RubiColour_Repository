package schaschinger.rubicolour.com.rubicolour;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by thoma on 09/04/2016.
 */

public class GLCube {

    private FloatBuffer mVertexBuffer;
    private FloatBuffer mColorBuffer;
    private ByteBuffer  mIndexBuffer;

    //Defining the coordiantes of the cubes corners
    private float vertices[] = {
            -1.0f, -1.0f, -1.0f, //Bottom Back Left
            1.0f, -1.0f, -1.0f,  //Bottom Back Right
            1.0f,  1.0f, -1.0f,  //Top Back Right
            -1.0f, 1.0f, -1.0f,  //Top Back Left
            -1.0f, -1.0f,  1.0f, //Bottom Front Left
            1.0f, -1.0f,  1.0f,  //Bottom Front Right
            1.0f,  1.0f,  1.0f,  //Top Front Right
            -1.0f,  1.0f,  1.0f  //Top Front Left
    };

    private float colors[] = {
            0.0f,  1.0f,  0.0f,  1.0f,
            0.0f,  1.0f,  0.0f,  1.0f,
            1.0f,  0.5f,  0.0f,  1.0f,
            1.0f,  0.5f,  0.0f,  1.0f,
            1.0f,  0.0f,  0.0f,  1.0f,
            1.0f,  0.0f,  0.0f,  1.0f,
            0.0f,  0.0f,  1.0f,  1.0f,
            1.0f,  0.0f,  1.0f,  1.0f
    };

    //Describe which points to connect
    //EG; 0 , 4, 5 means the plain the is encolsed by bottom back left, bottom front left, and bottom front right
    private byte indices[] = {
            0, 4, 5, 0, 5, 1,
            1, 5, 6, 1, 6, 2,
            2, 6, 7, 2, 7, 3,
            3, 7, 4, 3, 4, 0,
            4, 7, 6, 4, 6, 5,
            3, 0, 1, 3, 1, 2
    };

    /**
     * Constructor only parses the array values which define the cube into various FloatBuffers which are
     * lateron used for rendering purposes;
     */
    public GLCube() {
        //Create a bitbuffer with the size of verticles times 4 since float takes up 4 bytes of space
        ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);
        //The byte order is used when reading or writing multibyte values, and when creating buffers that are views of this byte buffer.
        //The order of a newly-created byte buffer is always BIG_ENDIAN.
        byteBuf.order(ByteOrder.nativeOrder());
        //Cast the Bytebuffer to a floatbuffer
        mVertexBuffer = byteBuf.asFloatBuffer();
        //Insert the values of the corner points into the buffer;
        mVertexBuffer.put(vertices);
        //Where the buffer should start off using its values
        mVertexBuffer.position(0);

        byteBuf = ByteBuffer.allocateDirect(colors.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        mColorBuffer = byteBuf.asFloatBuffer();
        mColorBuffer.put(colors);
        mColorBuffer.position(0);

        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);
    }


    public void draw(GL10 gl) {


        gl.glFrontFace(GL10.GL_CW);

        //Now for drawing the surface - triangles
        //Parameters(always thak 3 figures since triangle three corners, Indicate that Floatvalues should be expected, don't skip any value
        // , the actual values in form of a buffer(Floatbuffer))
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);

        //same with the colors
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColorBuffer);

        //Enable the use of client defined input variables such as defined color and verticles values
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        //draw actal cube 36 because 36 points in total, type of point value, positions of the corners;
        gl.glDrawElements(GL10.GL_TRIANGLES, 36, GL10.GL_UNSIGNED_BYTE,
                mIndexBuffer);

        //Disable the use of client defined input so that cube can be drawn without doubts or stress
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }

}
