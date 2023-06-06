package com.example.touch_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {
    Bitmap[] frames = new Bitmap[6];
    int i=1;
    public GraphicsView(Context context){
        super(context);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.hutao_1);
        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.hutao_2);
        frames[3] = BitmapFactory.decodeResource(getResources(), R.drawable.hutao_3);
        frames[4] = BitmapFactory.decodeResource(getResources(), R.drawable.hutao_4);
        frames[5] = BitmapFactory.decodeResource(getResources(), R.drawable.hutao_5);
        frames[6] = BitmapFactory.decodeResource(getResources(), R.drawable.hutao_6);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (i<=6){
            canvas.drawBitmap(frames[i], 40, 40, new Paint());
        }
        else {
            i=1;
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;
        return true;
    }
}
