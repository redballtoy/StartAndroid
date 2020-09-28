package com.gmail.redballtoy.p_142_01_paintingsimpleshapestext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class DrawView extends View {
    Paint paint;
    Rect rect;

    public DrawView(Context context) {
        super(context);
        paint=new Paint();
        rect=new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //заливка канвы цветом
        canvas.drawARGB(80, 102, 204, 255);
    }
}
