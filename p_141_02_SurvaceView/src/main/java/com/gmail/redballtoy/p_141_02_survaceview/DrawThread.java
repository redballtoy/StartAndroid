package com.example.redballtoy.p_141_02_survaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

//this is drawing thread in which drawing will be take place
public class DrawThread extends Thread {
    private boolean running = false;
    private SurfaceHolder surfaceHolder;

    //передается интерфейс SurfaceHolder что бы использовать Canvas
    public DrawThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        Canvas canvas;
        //выполняется пока позволяет метка работы (running)
        while (running) {
            canvas = null;
            try {
                //от SurfaceHolder получаем канву методом lockCanvas
                canvas = surfaceHolder.lockCanvas(null);
                if (canvas == null) {
                    continue;
                } else {
                    canvas.drawColor(Color.BLUE);
                }
            } finally {
                if (canvas != null) {
                    //возвращаем канву объекту SurfaceHolder методом unlockCanvasAndPost в секции
                    //finally (обязательной для выполнения)
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
