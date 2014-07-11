package com.pangff.textview_inline_drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class TextDrawable extends Drawable {

    private final String text;
    private final Paint paint;
    private int height ;
    int padding = 10;
    int innerPaddingH = 10;
    int textWidth = 0;
    int rectWidth = 0;
    int innerTextHeight = 0;
    int linsSpaceExtra = 0;
    public TextDrawable(String text,int height,int linsSpaceExtra,int textSize) {
    		this.linsSpaceExtra = linsSpaceExtra;
        this.text = text;
        this.height = height;
        this.paint = new Paint();
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        textWidth =  (int) paint.measureText(text);
        rectWidth = 2*innerPaddingH+textWidth;
        innerTextHeight = (int) Math.ceil(paint.getFontMetrics().descent - paint.getFontMetrics().ascent)+2;
    }

    RectF rectF = new RectF();
    @Override
    public void draw(Canvas canvas) {
    		paint.setColor(Color.RED);
    		rectF.set(padding,  -height-linsSpaceExtra, padding+rectWidth, -linsSpaceExtra);
    		canvas.drawRoundRect(rectF, height/2, height/2, paint);
    		//canvas.drawRect(padding,  -height-linsSpaceExtra, padding+rectWidth, -linsSpaceExtra, paint);
    		int baseline = (int) (rectF.top + (rectF.bottom - rectF.top - paint.getFontMetrics().bottom + paint.getFontMetrics().top) / 2 - paint.getFontMetrics().top)-2;
    		paint.setColor(Color.WHITE);
        canvas.drawText(text, rectF.centerX(),  baseline, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
