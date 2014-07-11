package com.pangff.textview_inline_drawable;

import android.content.Context;

public class Util {
	  // dip转像素
	  public static int DipToPixels(Context context,int dip) {
	    final float SCALE = context.getResources().getDisplayMetrics().density;
	    float valueDips = dip;
	    int valuePixels = (int) (valueDips * SCALE + 0.5f);
	    return valuePixels;
	  }
}
