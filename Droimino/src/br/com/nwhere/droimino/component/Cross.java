package br.com.nwhere.droimino.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Cross extends View {

	private Paint paint;

	private int points;

	private Bitmap bitmap;

	private Canvas canvas;
	
	public Cross(Context context) {
		super(context);
		
		this.paint = new Paint();
		this.paint.setColor(Color.BLACK);
		this.paint.setStyle(Paint.Style.STROKE);
		this.paint.setStrokeWidth(5);
		
		this.bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.RGB_565);
		this.canvas = new Canvas(bitmap);
		
		this.canvas.drawColor(Color.WHITE);
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawBitmap(bitmap, 0, 0, this.paint);
	}
	
	public boolean isClosed() {
		return points == 50;
	}
	
	public void deletePoint() {
		
		this.bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.RGB_565);
		this.canvas = new Canvas(bitmap);
		
		this.canvas.drawColor(Color.WHITE);
		
		int i = this.points / 5 - 1;
		
		this.points = 0;
		
		if(i>0) {
			for(int j=0;j<i;j++) {
				drawPoint();
			}
		}else
			invalidate();
	}
	
	public void drawPoint() {
		
		switch (points) {
		case 0:
			canvas.drawLine(0, 40, 80, 40, paint);
			break;
		case 5:
			canvas.drawLine(40, 0, 40, 80, paint);
			break;
		case 10:
			canvas.drawLine(10, 20, 30, 20, paint);
			break;
		case 15:
			canvas.drawLine(20, 10, 20, 30, paint);
			break;
		case 20:
			canvas.drawLine(50, 20, 70, 20, paint);
			break;
		case 25:
			canvas.drawLine(60, 10, 60, 30, paint);
			break;
		case 30:
			canvas.drawLine(10, 60, 30, 60, paint);
			break;
		case 35:
			canvas.drawLine(20, 50, 20, 70, paint);
			break;
		case 40:
			canvas.drawLine(50, 60, 70, 60, paint);
			break;
		case 45:
			canvas.drawLine(60, 50, 60, 70, paint);
			break;

		default:
			break;
		}
		
		this.points += 5;

		invalidate();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		// int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
		// int parentHeight = MeasureSpec.getSize(heightMeasureSpec);

		this.setMeasuredDimension(100, 100);
	}

}
