package com.example.front;

import com.example.front.service.MyService;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class MainActivity extends Activity {

	@SuppressLint({ "NewApi", "ResourceAsColor" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bit bit = new Bit(this);
		LayoutParams layoutParams = new FrameLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		/*
		 * android.view.WindowManager.LayoutParams layoutParams2 = new
		 * WindowManager.LayoutParams(1, 1,
		 * WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA,
		 * WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.RGB_888);
		 * 
		 * getWindowManager().updateViewLayout(bit, layoutParams2);
		 */

		// View peekDecorView = getWindow().peekDecorView();

		View decorView = getWindow().getDecorView();
		WindowManager m = getWindowManager();
		Display d = m.getDefaultDisplay(); // Ϊ��ȡ��Ļ����
		android.view.WindowManager.LayoutParams p = getWindow().getAttributes();
		p.height = (int) 1; // �߶�����Ϊ��Ļ��1.0
		p.width = (int) 1; // �������Ϊ��Ļ��0.8
		p.alpha = 0.6f; // ���ñ���͸����
		p.dimAmount = 0.0f; // ���úڰ���

		p.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT; // ϵͳ��ʾ����,��Ҫ
		p.format = 1;
		p.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE; // ������ռ�۽���
		p.flags = p.flags | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
		p.flags = p.flags | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS; // �Ű治������
		getWindow().setAttributes(p); // ������Ч
		getWindow().setGravity(Gravity.LEFT); // ���ÿ��Ҷ���

		// ����Ļ���Ͻ�Ϊԭ�㣬����x��y��ʼֵ
		p.x = 0;
		p.y = 0;

		// �����������ڳ�������
		p.width = 140;
		p.height = 140;

		// ��ʾmyFloatViewͼ��
		m.addView(bit, p);
		
		startService(new Intent(this.getApplicationContext(), MyService.class));
	}

	/*@Override
	public boolean onTouchEvent(MotionEvent event) {
		// �����¼�������.
		return true;
	}*/

}
