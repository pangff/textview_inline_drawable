package com.pangff.textview_inline_drawable;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView;
	TextView textView2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView2 = (TextView) findViewById(R.id.text2);
		textView = (TextView) findViewById(R.id.text);
		ImageGetter imageGetter = new ImageGetter() {
			@Override
			public Drawable getDrawable(String source) {
				int height = (int) Math.ceil(textView.getPaint().getFontMetrics().descent - textView.getPaint().getFontMetrics().top) + 2;
				Drawable drawable = new TextDrawable(source,height,Util.DipToPixels(MainActivity.this,5),Util.DipToPixels(MainActivity.this,13));  
				drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
						drawable.getIntrinsicHeight());
				return drawable;
			}
		};
		textView.setText(Html.fromHtml("在上篇笔记中介绍了使用Rajawali加载外部模型的步骤以及注意事项，但是上篇中只加载了一个简单的少纹理贴图的模型，下面通过一个复杂模型的加载来说明多纹理贴图模型加载注意事项<img src=\"更多\">", imageGetter, null));
		
		
		ImageGetter imageGetter2 = new ImageGetter() {
			@Override
			public Drawable getDrawable(String source) {
				int height = (int) Math.ceil(textView2.getPaint().getFontMetrics().descent - textView2.getPaint().getFontMetrics().top) + 2;
				Drawable drawable = new TextDrawable(source,height,Util.DipToPixels(MainActivity.this,5),Util.DipToPixels(MainActivity.this,13));  
				drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
						drawable.getIntrinsicHeight());
				return drawable;
			}
		};
		textView2.setText(Html.fromHtml("在上篇笔记中<img src=\"更多\">", imageGetter2, null));
	}
	



}
