package com.gmail.redballtoy.p_141_02_survaceview;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

/*Second variant is more correct to implement constant drawing not in the main thread,
  but through SurfaceView in a separate tread.
  This class inherits from SurfaceView and implements the SurfaceHolder.Callback.
  SurfaceView only displays content and works with him it through the handler SurfaceHolder.
*/
public class DrawView extends SurfaceView implements SurfaceHolder.Callback {

    private DrawThread drawThread;
    private final String MY_LOG = "myLogs";

    /*In the DrawThread constructor, we get the SurfaceHolder handler and tell it that we
    * will handle its events of which there are three:
    *       surfaceCreated(@NonNull SurfaceHolder holder)
    *       surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height)
    *           -
    *       surfaceDestroyed(@NonNull SurfaceHolder holder)
    */
    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        drawThread = new DrawThread(getHolder());
        drawThread.setRunning(true);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        boolean retry = true;
        drawThread.setRunning(false);
        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
                Log.e(MY_LOG,e.toString());
            }
        }
    }
}
