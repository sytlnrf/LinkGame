package com.sytlnrf.shengyitao.linkgame.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.sytlnrf.shengyitao.linkgame.R;
import com.sytlnrf.shengyitao.linkgame.view.PieceImage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by shengyitao on 15/7/6.
 */
public class ImageUtil {
    private static List<Integer> imageValues = getImageValues();

    public static List<Integer> getImageValues(){
        try {
            Field[] drawableFields = R.drawable.class.getFields();
            List<Integer> resourcesValues = new ArrayList<Integer>();
            for (Field field:drawableFields){
                if (field.getName().contains("p_p")){
                    resourcesValues.add(field.getInt(R.drawable.class));
                    Log.d("imageName",field.getName());
                }
            }
            return resourcesValues;
        }catch (Exception e){
            Log.e("ImageUtil",e.getStackTrace().toString());
            return null;
        }
    }

    public static List<Integer> getRandomValues(
            List<Integer> sourceValues, int size){
        Random random = new Random();
        List<Integer> result = new ArrayList<Integer>();
        for (int i=0;i<size;i++){
            try {
                int index = random.nextInt(sourceValues.size());
                Integer image = sourceValues.get(index);
                result.add(image);
            }catch (IndexOutOfBoundsException e){
                Log.e("ImageUtil",e.getStackTrace().toString());
                return result;
            }
        }
        return result;
    }

    public static List<Integer> getPlayValues(int size){
        if (size % 2 != 0){
            size +=1;
        }
        List<Integer> playImageValues = getRandomValues(imageValues,size / 2);
        Log.d("playImageValues",playImageValues.toString());
        playImageValues.addAll(playImageValues);
        Collections.shuffle(playImageValues);
        Log.e("size", String.valueOf(playImageValues.size()));
        return playImageValues;
    }

    public static List<PieceImage> getPlayImages(Context context, int size){
        List<Integer> resourceValues = getPlayValues(size);
        List<PieceImage> result = new ArrayList<PieceImage>();
        for (Integer value:resourceValues){
            Bitmap bm = BitmapFactory.decodeResource(
                    context.getResources(),value);
            PieceImage pieceImage = new PieceImage(bm,value);
            result.add(pieceImage);
            Log.e("ImageUtil",value.toString());
        }

        return result;
    }

    public static Bitmap getSelectImage(Context context){
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.selected);
        return bm;
    }
}
