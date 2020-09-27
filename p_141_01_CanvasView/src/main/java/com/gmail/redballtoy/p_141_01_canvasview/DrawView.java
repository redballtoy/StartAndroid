package com.gmail.redballtoy.p_141_01_canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/*This is first way to get access to Canvas throws extending the View class and overriding
 the method onDraw.
 The Canvas is a drawing tool, the result is saved in a Bitmap.
 The disadvantage of this method is that drawing and animation is performed on the main thread.
*/
public class DrawView extends View {


    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GREEN);
    }
}
