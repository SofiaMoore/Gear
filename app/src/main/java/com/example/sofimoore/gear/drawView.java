package com.example.sofimoore.gear;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;

import org.w3c.dom.Attr;

import java.util.Objects;


public class drawView extends View {

    public boolean stop = true;

    public drawView(Context context, AttributeSet as) {
        super(context, as);
        paint1 = new Paint();
        paint1.setColor(Color.BLUE);
        paint1.setStrokeWidth(4);
        paint1.setSubpixelText(true);
        paint1.setAntiAlias(true);
        MyTask mt = new MyTask();
        mt.execute();
    }
    private Paint paint1;

    int angle = 1;
    int angle2 = 180;
    int speed = 8;
    int speed2 = 1;

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(Color.MAGENTA);
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);

        int x1 = canvas.getWidth() / 2;
        int y1 = canvas.getHeight() / 2 - 150;
        canvas.drawCircle(x1,y1, 100, paint);
        canvas.drawLine(x1,y1, (float) (x1 + 100 * Math.cos(Math.toRadians(angle))), (float) (y1 + 100 * Math.sin(Math.toRadians(angle))), paint1);
        canvas.drawCircle(x1 + 50, y1 + 250, 150, paint);
        canvas.drawLine(x1 + 50, y1 + 250,(float)(x1+50 + 150 * Math.cos(Math.toRadians(angle2))), (float)(y1 + 250 + 150 * Math.sin(Math.toRadians(angle2))), paint1);
    }


    class MyTask extends AsyncTask<Object, Object, Object>{



        @Override
        protected Object doInBackground(Object... params) {
            while (stop) {
               // angle++;
                angle+=speed;
                //angle2--;
                angle2-=speed2;
                //angle++;
                publishProgress();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } return stop;
        }

        @Override
        protected void onProgressUpdate(Object... values) {
            invalidate();
        }


    }

}

