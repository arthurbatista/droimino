package br.com.nwhere.droimino.component;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import br.com.nwhere.droimino.R;

public class CrossBase extends TableLayout{
	
	private Cross currentCross;
	
	private final Context context;
	
	private MediaPlayer mediaPlayer;
	
	private TableRow currentRow;
	
	private ArrayList<View> crossLog;
	
	public CrossBase(Context context) {
		super(context);
		
		this.context = context;
		
		this.mediaPlayer = MediaPlayer.create(context, R.raw.galo);
		
		crossLog = new ArrayList<View>();
		
		initRow();
	}
	
	private void addViewInTableRow(View cross) {
		
		if(currentRow.getChildCount() > 2)
			initRow();
		
		this.currentRow.addView(cross);
	}
	
	private void initRow() {
		this.currentRow = new TableRow(this.context);
		this.addView(currentRow);
	}
	
	public void addPoint(int value) {
		
		if(currentCross == null) {
			currentCross = new Cross(context);
			addViewInTableRow(currentCross);
		}
		
		int i = value / 5;
		
		for(int j=0; j < i; j++) {
			
			if(currentCross.isClosed()) {
				currentCross = new Cross(context);
				currentCross.setBackgroundColor(Color.WHITE);
				addViewInTableRow(currentCross);
			}
		
			currentCross.drawPoint();
			
			crossLog.add(currentCross);
		}
	}
	
	public void deletePoint() {
		
		int index = crossLog.size() - 1;
		
		if(index > 0) {
		
			View lastView = crossLog.get(index);
			
			TableRow tRow = (TableRow)lastView.getParent();
			
			if(lastView instanceof Cross) {
				
				Cross cross = (Cross)lastView;
				
				if(this.currentCross.getPoints() > 5)
					cross.deletePoint();
				else {
					tRow.removeView(lastView);
					currentCross = findLastCrossUpdated();
				}
			} else
				tRow.removeView(lastView);
			
			//If the current row has no more child, remove it and the last but one will be the current row
			if(tRow.getChildCount() <= 0 && this.getChildCount() > 1) {
				this.currentRow = (TableRow) this.getChildAt(this.getChildCount() - 2);
				this.removeView(tRow);
			}
		}
		
		crossLog.remove(index);
	}
	
	private Cross findLastCrossUpdated() {
		
		Cross lastCross = null;
		
		int i = crossLog.size() - 1;
		while(lastCross == null && i > 0) {
			
			View view = crossLog.get(i);
			
			if(view instanceof Cross)
				lastCross = (Cross)view;
			
			i--;
		}
		
		return lastCross;
	}
	
	public void doRooster() {
		
		this.mediaPlayer.start();
		 
		ImageView i = new ImageView(super.getContext());
        i.setImageResource(R.drawable.rooster);
        i.setAdjustViewBounds(true);
        i.setMaxWidth(100);
        i.setMaxHeight(100);
        
//        lastView = i;
        
        addViewInTableRow(i);
        
        crossLog.add(i);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		 int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
		 int parentHeight = MeasureSpec.getSize(heightMeasureSpec);

		this.setMeasuredDimension(parentWidth - 100, parentHeight);
	}
}
