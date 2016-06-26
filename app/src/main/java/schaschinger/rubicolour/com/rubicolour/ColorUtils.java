package schaschinger.rubicolour.com.rubicolour;

/**
 * Created by thoma on 03/04/2016.
 */


import java.util.ArrayList;
import android.graphics.Color;
import android.util.Log;

public class ColorUtils {

    /**
     * Initialize the color list that we have.
     */
    private ArrayList<ColorName> initColorList() {
        ArrayList<ColorName> colorList = new ArrayList<ColorName>();

        /*
        colorList.add(new ColorName("White", 0xF0, 0xF8, 0xFF));
        colorList.add(new ColorName("White", 0xFA, 0xEB, 0xD7));
        colorList.add(new ColorName("White", 0x00, 0xFF, 0xFF));
        colorList.add(new ColorName("White", 0x7F, 0xFF, 0xD4));
        colorList.add(new ColorName("White", 0xF0, 0xFF, 0xFF));
        colorList.add(new ColorName("White", 0xF5, 0xF5, 0xDC));
        colorList.add(new ColorName("White", 0xFF, 0xE4, 0xC4));
        colorList.add(new ColorName("White", 0xFF, 0xEB, 0xCD));
        colorList.add(new ColorName("Blue", 0x00, 0x00, 0xFF));
        colorList.add(new ColorName("Blue", 0x8A, 0x2B, 0xE2));
        colorList.add(new ColorName("Red", 0xA5, 0x2A, 0x2A));
        colorList.add(new ColorName("White", 0xDE, 0xB8, 0x87));
        colorList.add(new ColorName("Yellow", 0x7F, 0xFF, 0x00));
        colorList.add(new ColorName("Orange", 0xD2, 0x69, 0x1E));
        colorList.add(new ColorName("Orange", 0xFF, 0x7F, 0x50));
        colorList.add(new ColorName("Blue", 0x64, 0x95, 0xED));
        colorList.add(new ColorName("White", 0xFF, 0xF8, 0xDC));
        colorList.add(new ColorName("Red", 0xDC, 0x14, 0x3C));
        colorList.add(new ColorName("Blue", 0x00, 0xFF, 0xFF));
        colorList.add(new ColorName("Blue", 0x00, 0x00, 0x8B));
        colorList.add(new ColorName("White", 0xA9, 0xA9, 0xA9));
        colorList.add(new ColorName("Green", 0x00, 0x64, 0x00));
        colorList.add(new ColorName("White", 0xBD, 0xB7, 0x6B));
        colorList.add(new ColorName("Red", 0x8B, 0x00, 0x8B));
        colorList.add(new ColorName("Orange", 0xFF, 0x8C, 0x00));
        colorList.add(new ColorName("Red", 0x99, 0x32, 0xCC));
        colorList.add(new ColorName("Red", 0x8B, 0x00, 0x00));
        colorList.add(new ColorName("Orange", 0xE9, 0x96, 0x7A));
        colorList.add(new ColorName("Green", 0x8F, 0xBC, 0x8F));
        colorList.add(new ColorName("Blue", 0x48, 0x3D, 0x8B));
        colorList.add(new ColorName("Blue", 0x00, 0xCE, 0xD1));
        colorList.add(new ColorName("Red", 0x94, 0x00, 0xD3));
        colorList.add(new ColorName("Blue", 0x00, 0xBF, 0xFF));
        colorList.add(new ColorName("Blue", 0x1E, 0x90, 0xFF));
        colorList.add(new ColorName("Red", 0xB2, 0x22, 0x22));
        colorList.add(new ColorName("White", 0xFF, 0xFA, 0xF0));
        colorList.add(new ColorName("Green", 0x22, 0x8B, 0x22));
        colorList.add(new ColorName("White", 0xF8, 0xF8, 0xFF));
        colorList.add(new ColorName("Yellow", 0xFF, 0xD7, 0x00));
        colorList.add(new ColorName("Green", 0x00, 0x80, 0x00));
        colorList.add(new ColorName("Yellow", 0xAD, 0xFF, 0x2F));
        colorList.add(new ColorName("White", 0xF0, 0xFF, 0xF0));
        colorList.add(new ColorName("Red", 0xFF, 0x69, 0xB4));
        colorList.add(new ColorName("Yellow", 0xCD, 0x5C, 0x5C));
        colorList.add(new ColorName("White", 0xFF, 0xFF, 0xF0));
        colorList.add(new ColorName("White", 0xF0, 0xE6, 0x8C));
        colorList.add(new ColorName("White", 0xE6, 0xE6, 0xFA));
        colorList.add(new ColorName("White", 0xFF, 0xF0, 0xF5));
        colorList.add(new ColorName("Green", 0x7C, 0xFC, 0x00));
        colorList.add(new ColorName("White", 0xFF, 0xFA, 0xCD));
        colorList.add(new ColorName("White", 0xAD, 0xD8, 0xE6));
        colorList.add(new ColorName("White", 0xE0, 0xFF, 0xFF));
        colorList.add(new ColorName("White", 0xFA, 0xFA, 0xD2));
        colorList.add(new ColorName("White", 0xD3, 0xD3, 0xD3));
        colorList.add(new ColorName("Green", 0x90, 0xEE, 0x90));
        colorList.add(new ColorName("Orange", 0xFF, 0xA0, 0x7A));
        colorList.add(new ColorName("Blue", 0x20, 0xB2, 0xAA));
        colorList.add(new ColorName("Blue", 0x87, 0xCE, 0xFA));
        colorList.add(new ColorName("White", 0x77, 0x88, 0x99));
        colorList.add(new ColorName("White", 0xB0, 0xC4, 0xDE));
        colorList.add(new ColorName("White", 0xFF, 0xFF, 0xE0));
        colorList.add(new ColorName("Green", 0x00, 0xFF, 0x00));
        colorList.add(new ColorName("Green", 0x32, 0xCD, 0x32));
        colorList.add(new ColorName("White", 0xFA, 0xF0, 0xE6));
        colorList.add(new ColorName("Red", 0xFF, 0x00, 0xFF));
        colorList.add(new ColorName("Red", 0x80, 0x00, 0x00));
        colorList.add(new ColorName("Green", 0x66, 0xCD, 0xAA));
        colorList.add(new ColorName("Blue", 0x00, 0x00, 0xCD));
        colorList.add(new ColorName("Blue", 0x93, 0x70, 0xDB));
        colorList.add(new ColorName("Green", 0x3C, 0xB3, 0x71));
        colorList.add(new ColorName("Blue", 0x7B, 0x68, 0xEE));
        colorList.add(new ColorName("Green", 0x00, 0xFA, 0x9A));
        colorList.add(new ColorName("Blue", 0x48, 0xD1, 0xCC));
        colorList.add(new ColorName("Red", 0xC7, 0x15, 0x85));
        colorList.add(new ColorName("Blue", 0x19, 0x19, 0x70));
        colorList.add(new ColorName("White", 0xF5, 0xFF, 0xFA));
        colorList.add(new ColorName("White", 0xFF, 0xE4, 0xE1));
        colorList.add(new ColorName("White", 0xFF, 0xE4, 0xB5));
        colorList.add(new ColorName("White", 0xFF, 0xDE, 0xAD));
        colorList.add(new ColorName("Blue", 0x00, 0x00, 0x80));
        colorList.add(new ColorName("White", 0xFD, 0xF5, 0xE6));
        colorList.add(new ColorName("Green", 0x80, 0x80, 0x00));
        colorList.add(new ColorName("Green", 0x6B, 0x8E, 0x23));
        colorList.add(new ColorName("Orange", 0xFF, 0xA5, 0x00));
        colorList.add(new ColorName("Orange", 0xFF, 0x45, 0x00));
        colorList.add(new ColorName("White", 0xEE, 0xE8, 0xAA));
        colorList.add(new ColorName("Green", 0x98, 0xFB, 0x98));
        colorList.add(new ColorName("White", 0xAF, 0xEE, 0xEE));
        colorList.add(new ColorName("White", 0xFF, 0xEF, 0xD5));
        colorList.add(new ColorName("White", 0xFF, 0xDA, 0xB9));
        colorList.add(new ColorName("Yellow", 0xCD, 0x85, 0x3F));
        colorList.add(new ColorName("White", 0xFF, 0xC0, 0xCB));
        colorList.add(new ColorName("White", 0xB0, 0xE0, 0xE6));
        colorList.add(new ColorName("Red", 0x80, 0x00, 0x80));
        colorList.add(new ColorName("Red", 0xFF, 0x00, 0x00));
        colorList.add(new ColorName("White", 0xBC, 0x8F, 0x8F));
        colorList.add(new ColorName("Blue", 0x41, 0x69, 0xE1));
        colorList.add(new ColorName("Orange", 0xFA, 0x80, 0x72));
        colorList.add(new ColorName("Orange", 0xF4, 0xA4, 0x60));
        colorList.add(new ColorName("Green", 0x2E, 0x8B, 0x57));
        colorList.add(new ColorName("White", 0xFF, 0xF5, 0xEE));
        colorList.add(new ColorName("White", 0xC0, 0xC0, 0xC0));
        colorList.add(new ColorName("Blue", 0x87, 0xCE, 0xEB));
        colorList.add(new ColorName("Blue", 0x6A, 0x5A, 0xCD));
        colorList.add(new ColorName("White", 0xFF, 0xFA, 0xFA));
        colorList.add(new ColorName("Green", 0x00, 0xFF, 0x7F));
        colorList.add(new ColorName("Blue", 0x46, 0x82, 0xB4));
        colorList.add(new ColorName("Blue", 0x00, 0x80, 0x80));
        colorList.add(new ColorName("White", 0xD8, 0xBF, 0xD8));
        colorList.add(new ColorName("Orange", 0xFF, 0x63, 0x47));
        colorList.add(new ColorName("Blue", 0x40, 0xE0, 0xD0));
        colorList.add(new ColorName("White", 0xF5, 0xDE, 0xB3));
        colorList.add(new ColorName("White", 0xFF, 0xFF, 0xFF));
        colorList.add(new ColorName("White", 0xF5, 0xF5, 0xF5));
        colorList.add(new ColorName("Yellow", 0xFF, 0xFF, 0x00));
        colorList.add(new ColorName("Orange", 0xDA, 0x7D, 0x5B));
        colorList.add(new ColorName("Orange", 0xE7, 0x85, 0x60));
        colorList.add(new ColorName("Yellow", 0xE8, 0x77, 0x3B));
        colorList.add(new ColorName("Orange", 0xE1, 0x69, 0x2D));
        colorList.add(new ColorName("Orange", 0xE7, 0x6E, 0x35));
        colorList.add(new ColorName("Orange", 0xD0, 0x6E, 0x3F));
        colorList.add(new ColorName("Orange", 0xDD, 0x63, 0x34));
        colorList.add(new ColorName("Yellow", 0xD7, 0xBC, 0x13));
        colorList.add(new ColorName("Orange", 0xF0, 0x7C, 0x31));

        colorList.add(new ColorName("White",0xff,0xff,0xff));
        colorList.add(new ColorName("White",0xdd,0xe6,0xac));

        colorList.add(new ColorName("White",0xdd,0xe6,0xad));
        colorList.add(new ColorName("Yellow",0xff,0xc8,0x14));

        colorList.add(new ColorName("Green",0x6c,0x80,0x00));
        colorList.add(new ColorName("Green",0x00,0xff,0x7b));

        colorList.add(new ColorName("Blue",0x00,0x80,0xff));
        colorList.add(new ColorName("Blue",0x00,0x26,0x4d));

        colorList.add(new ColorName("Yellow", 0xBB, 0xE7, 0x78));
        colorList.add(new ColorName("White", 0xE5, 0x71, 0x40));

        colorList.add(new ColorName("Orange", 0xD3, 0x64, 0x50));
        */


        colorList.add(new ColorName("White", 0xCC, 0xDF, 0xE5));
        colorList.add(new ColorName("Red", 0x7E, 0x1F, 0x19));
        colorList.add(new ColorName("Yellow", 0xC0, 0xF6, 0x6D));
        colorList.add(new ColorName("Blue", 0x02, 0x5A, 0xA4));
        colorList.add(new ColorName("Orange", 0xEB, 0x92, 0x68));
        colorList.add(new ColorName("Green", 0x00, 0xB8, 0x48));



        return colorList;
    }

    /**
     * Get the closest color name from our list
     *
     * @param r
     * @param g
     * @param b
     * @return
     */
    public String getColorNameFromRgb(int r, int g, int b) {
        ArrayList<ColorName> colorList = initColorList();
        ColorName closestMatch = null;
        int minMSE = Integer.MAX_VALUE;
        int mse;
        for (ColorName c : colorList) {
            mse = c.computeMSE(r, g, b);
            if (mse < minMSE) {
                minMSE = mse;
                closestMatch = c;
            }
        }

        if (closestMatch != null) {
            Log.i(TAG, "Octal color : " +  closestMatch.getR() + " " + closestMatch.getG() + " " + closestMatch.getB());
            return closestMatch.getName();
        } else {
            return "No matched color name.";
        }
    }

    /**
     * Convert hexColor to rgb, then call getColorNameFromRgb(r, g, b)
     *
     * @param hexColor
     * @return
     */
    private final String TAG = "ColorUtils :";
    public String getColorNameFromHex(int hexColor) {
        int r = (hexColor & 0xFF0000) >> 16;
        int g = (hexColor & 0xFF00) >> 8;
        int b = (hexColor & 0xFF);
        return getColorNameFromRgb(r, g, b);
    }

    /**
     * SubClass of ColorUtils. In order to lookup color name
     *
     */
    public class ColorName {
        public int r, g, b;
        public String name;

        public ColorName(String name, int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.name = name;
        }

        public int computeMSE(int pixR, int pixG, int pixB) {
            return (int) (((pixR - r) * (pixR - r) + (pixG - g) * (pixG - g) + (pixB - b)
                    * (pixB - b)) / 3);
        }

        public int getR() {
            return r;
        }

        public int getG() {
            return g;
        }

        public int getB() {
            return b;
        }

        public String getName() {
            return name;
        }
    }
}
