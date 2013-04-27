package br.com.nwhere.droimino.component;

import br.com.nwhere.droimino.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class CrossArena extends LinearLayout{

	private final Context context;
    private final CrossBase crossBase;
	private LinearLayout cntButton;
	
	//Buttons
	private Button btn5;
	private Button btn10;
	private Button btnUndo;
	private Button btnRooster;
	
	public CrossArena(Context context) {
		super(context);
		
		this.context = context;
		
		setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT,1));
		
		this.crossBase = new CrossBase(context);
		this.addView(this.crossBase);
		
		this.cntButton = new LinearLayout(context);
		this.cntButton.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		this.cntButton.setOrientation(VERTICAL);
		this.cntButton.setBackgroundColor(Color.WHITE);
		
		this.addView(this.cntButton);
		
		this.createButtons();
	}

	public void createButtons() {
		
		
		this.btn5 = new Button(this.context);
		this.btn5.setText("5");
		this.btn5.setWidth(50);
		this.btn5.setHeight(50);
		this.btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	crossBase.addPoint(5);
            }
        });
		this.btn5.setBackgroundResource(R.drawable.shape);
		this.cntButton.addView(btn5);
		
		this.btn10 = new Button(this.context);
		this.btn10.setText("10");
		this.btn10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	crossBase.addPoint(10);
            }
        });
		this.btn10.setBackgroundResource(R.drawable.shape);
		this.cntButton.addView(btn10);
		
		this.btnUndo = new Button(this.context);
		this.btnUndo.setText("<");
		this.btnUndo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	crossBase.deletePoint();
            }
        });
		this.btnUndo.setBackgroundResource(R.drawable.shape);
		this.cntButton.addView(btnUndo);
		
		this.btnRooster = new Button(this.context);
		this.btnRooster.setText("Galo");
		this.btnRooster.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	crossBase.doRooster();
            }
        });
		this.cntButton.addView(btnRooster);
	}
}
