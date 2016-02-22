package com.example.front;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class Bit extends View {

	public Bit(Context context) {
		super(context);
		
	}

	public Bit(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}

	@SuppressLint("NewApi") public Bit(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setBackground(context.getResources().getDrawable(R.drawable.bit_01));
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(1, 1);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// �����ش����κ�����
		return false;
	}

}
