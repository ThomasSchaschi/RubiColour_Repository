package schaschinger.rubicolour.com.rubicolour;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Thomas on 15.04.2016.
 *
 * This class was made to create the Singmaster notation of the current cube
 * in order to pass it on to the c - programm.
 *
 * Only method that can and must be called is createSingmasterNotation(...)
 */
public class Singmaster {

    private static final String LOG = "Singmaster - ";

    private static final Integer WHITE = 0;
    private static final Integer ORANGE = 1;
    private static final Integer YELLOW = 2;
    private static final Integer RED = 3;
    private static final Integer GREEN = 4;
    private static final Integer BLUE = 5;

    private static StringBuilder stringBuilder;

    /**
     * Returns the Singmaster Notation of the current cube;
     */
    public static String createSingmasterNotation(ArrayList<String> listWhite, ArrayList<String> listOrange, ArrayList<String> listYellow,
                                                  ArrayList<String> listRed, ArrayList<String> listGreen, ArrayList<String> listBlue){

        stringBuilder = new StringBuilder();

        int [] white = new int[9];
        int [] orange = new int[9];
        int [] yellow = new int[9];
        int [] red = new int[9];
        int [] green = new int[9];
        int [] blue = new int[9];

        //Parsing list values into arrays
        for(int i = 0; i < 9; i++){
            white[i] = getColorConvertToInt(listWhite.get(i));
            orange[i] = getColorConvertToInt(listOrange.get(i));
            yellow[i] = getColorConvertToInt(listYellow.get(i));
            red[i] = getColorConvertToInt(listRed.get(i));
            green[i] = getColorConvertToInt(listGreen.get(i));
            blue[i] = getColorConvertToInt(listBlue.get(i));
        }
        Log.i(LOG, "Converter colors to arrays!");

        /*
        Define default nominations
         */
        appendDependingOnColorInt(white, orange, yellow, red, green, blue);

        return stringBuilder.toString();
    }

    /**
     *
     * @param color
     * @return
     *
     * This method returns an Integer value depending on the Color String parsed in, in order
     * to make it easier later on to determine the right values for the singmaster notation.
     * This method is only called in the main - createSingmasterNotation(...) - method.
     */
    private static int getColorConvertToInt(String color){
        if(color.equalsIgnoreCase("white")){
            return WHITE;
        }else if(color.equalsIgnoreCase("orange")){
            return ORANGE;
        }else if(color.equalsIgnoreCase("yellow")){
            return YELLOW;
        }else if(color.equalsIgnoreCase("red")){
            return  RED;
        }else if(color.equalsIgnoreCase("green")){
            return GREEN;
        }else if(color.equalsIgnoreCase("blue")){
            return BLUE;
        }else{
            Log.e(LOG, "Color in SingmasterConvert not registered!");
            return -1;
        }
    }

    private static void appendDependingOnColorInt(int[] white, int[] orange, int [] yellow, int [] red, int [] green, int [] blue){
        //Append Front
        stringBuilder.append(getShortFromInt(white[7]));
        stringBuilder.append(getShortFromInt(red[1]));
        stringBuilder.append(" ");

        //Append Right
        stringBuilder.append(getShortFromInt(white[5]));
        stringBuilder.append(getShortFromInt(blue[1]));
        stringBuilder.append(" ");

        //Append Back
        stringBuilder.append(getShortFromInt(white[1]));
        stringBuilder.append(getShortFromInt(orange[1]));
        stringBuilder.append(" ");

        //Append Left
        stringBuilder.append(getShortFromInt(white[3]));
        stringBuilder.append(getShortFromInt(green[1]));
        stringBuilder.append(" ");

        //----------------------------------------------------------------------------------------------------------------

        //Append Bottom Front
        stringBuilder.append(getShortFromInt(yellow[1]));
        stringBuilder.append(getShortFromInt(red[7]));
        stringBuilder.append(" ");

        //Append Bottom Right
        stringBuilder.append(getShortFromInt(yellow[5]));
        stringBuilder.append(getShortFromInt(blue[7]));
        stringBuilder.append(" ");

        //Append Bottom Back
        stringBuilder.append(getShortFromInt(yellow[7]));
        stringBuilder.append(getShortFromInt(orange[7]));
        stringBuilder.append(" ");

        //Append Bottom Left
        stringBuilder.append(getShortFromInt(yellow[3]));
        stringBuilder.append(getShortFromInt(green[7]));
        stringBuilder.append(" ");

        //----------------------------------------------------------------------------------------------------------------

        //Center
        //Front Right
        stringBuilder.append(getShortFromInt(red[5]));
        stringBuilder.append(getShortFromInt(blue[3]));
        stringBuilder.append(" ");

        //Front Left
        stringBuilder.append(getShortFromInt(red[3]));
        stringBuilder.append(getShortFromInt(green[5]));
        stringBuilder.append(" ");

        //Back Right
        stringBuilder.append(getShortFromInt(orange[3]));
        stringBuilder.append(getShortFromInt(blue[5]));
        stringBuilder.append(" ");

        //Back Left
        stringBuilder.append(getShortFromInt(orange[5]));
        stringBuilder.append(getShortFromInt(green[3]));
        stringBuilder.append(" ");

        //----------------------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------------------

        //Corners
        //UFR
        stringBuilder.append(getShortFromInt(white[8]));
        stringBuilder.append(getShortFromInt(red[2]));
        stringBuilder.append(getShortFromInt(blue[0]));
        stringBuilder.append(" ");

        //URB
        stringBuilder.append(getShortFromInt(white[2]));
        stringBuilder.append(getShortFromInt(blue[2]));
        stringBuilder.append(getShortFromInt(orange[0]));
        stringBuilder.append(" ");

        //UBL
        stringBuilder.append(getShortFromInt(white[0]));
        stringBuilder.append(getShortFromInt(orange[2]));
        stringBuilder.append(getShortFromInt(green[0]));
        stringBuilder.append(" ");

        //ULF
        stringBuilder.append(getShortFromInt(white[6]));
        stringBuilder.append(getShortFromInt(green[2]));
        stringBuilder.append(getShortFromInt(red[0]));
        stringBuilder.append(" ");


        //----------------------------------------------------------------------------------------------------------------
        //DRF
        stringBuilder.append(getShortFromInt(yellow[2]));
        stringBuilder.append(getShortFromInt(blue[6]));
        stringBuilder.append(getShortFromInt(red[8]));
        stringBuilder.append(" ");

        //DFL
        stringBuilder.append(getShortFromInt(yellow[0]));
        stringBuilder.append(getShortFromInt(red[6]));
        stringBuilder.append(getShortFromInt(green[8]));
        stringBuilder.append(" ");

        //DLB
        stringBuilder.append(getShortFromInt(yellow[6]));
        stringBuilder.append(getShortFromInt(green[6]));
        stringBuilder.append(getShortFromInt(orange[8]));
        stringBuilder.append(" ");

        //DBR
        stringBuilder.append(getShortFromInt(yellow[8]));
        stringBuilder.append(getShortFromInt(orange[6]));
        stringBuilder.append(getShortFromInt(blue[8]));
        stringBuilder.append(" ");


        //----------------------------------------------------------------------------------------------------------------

    }

    /*
    UP - White
    FRONT - Red
    RIGHT - Blue
    Back - Orange
    LEFT - Green
    DOWN - Yellow
     */
    private static String getShortFromInt(int id){
        switch (id){
            case 0:
                return "U";
            case 1:
                return "B";
            case 2:
                return "D";
            case 3:
                return "F";
            case 4:
                return "L";
            case 5:
                return "R";
        }
        return null;
    }

    @Override
    public String toString() {
        return "Singmaster{}";
    }
}