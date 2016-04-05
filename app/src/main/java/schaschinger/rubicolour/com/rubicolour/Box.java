package schaschinger.rubicolour.com.rubicolour;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by thoma on 03/04/2016.
 */
public class Box extends View {

    private Paint paint = new Paint();
    Box(Context context) {
        super(context);
    }

    public int toplefth, topleftw;


    @Override
    protected void onDraw(Canvas canvas) { // Override the onDraw() Method
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);


        //center

        int x0 = canvas.getWidth()/2;
        int y0 = canvas.getHeight()/2;


        int dx = canvas.getHeight()/3;
        int dy = canvas.getHeight()/3;

        //top left
        int newx = x0-dx+canvas.getWidth()/9;
        canvas.drawRect(x0-dx, y0-dy, newx,y0-dy+canvas.getHeight()*2/9, paint);

        toplefth = canvas.getHeight();
        topleftw = canvas.getWidth();
        //top middle
        canvas.drawRect(newx, y0-dy, newx + canvas.getWidth()/9, y0-dy+canvas.getHeight()*2/9, paint);
        //top right
        canvas.drawRect(x0-dx + canvas.getWidth()/9*2, y0-dy, newx + canvas.getWidth()/9*2,y0-dy+canvas.getHeight()*2/9, paint);

        //middle left
        canvas.drawRect(x0-dx, y0-dy+canvas.getHeight()*2/9, x0-dx+canvas.getWidth()*1/9, y0-dy+canvas.getHeight()*2/9*2, paint);
        //middle middle
        canvas.drawRect(x0-dx+canvas.getWidth()*1/9, y0-dy+canvas.getHeight()*2/9,x0-dx+canvas.getWidth()*1/9*2, y0-dy+canvas.getHeight()*2/9*2, paint);
        //middle right
        canvas.drawRect(x0-dx+canvas.getWidth()*1/9*2, y0-dy+canvas.getHeight()*2/9,x0-dx+canvas.getWidth()*1/9*3, y0-dy+canvas.getHeight()*2/9*2, paint);

        //bottom left
        canvas.drawRect(x0-dx, y0-dy+canvas.getHeight()*2/9*2,x0-dx+canvas.getWidth()*1/9, y0-dy+canvas.getHeight()*2/9*3, paint);
        //bottom middle
        canvas.drawRect(x0-dx+canvas.getWidth()*1/9, y0-dy+canvas.getHeight()*2/9*2,x0-dx+canvas.getWidth()*1/9*2, y0-dy+canvas.getHeight()*2/9*3, paint);
        //bottom right
        canvas.drawRect(x0-dx+canvas.getWidth()*1/9*2, y0-dy+canvas.getHeight()*2/9*2,x0-dx+canvas.getWidth()*1/9*3, y0-dy+canvas.getHeight()*2/9*3, paint);
    }


}
