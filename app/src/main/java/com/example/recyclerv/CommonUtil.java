package com.example.recyclerv;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by Faza Akbar on 21/03/19.
 * faza.akbar.tif17@polban.ac.id
 */
public class CommonUtil {

    private static  Drawable[] drawables =new Drawable[4];

    public static Drawable makeLightsType(Resources resources, int index) {

        if (drawables[index]==null){
            TypedArray images = resources.obtainTypedArray(R.array.gambar);
            Drawable drawable = images.getDrawable(index);
            drawables[index]=drawable;
            Log.d("new Drawable", drawable.toString());
        }
        return  drawables[index];

    }

}