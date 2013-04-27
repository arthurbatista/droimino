package br.com.nwhere.droimino;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import br.com.nwhere.droimino.component.CrossArena;

public class DroiminoActivity extends Activity {
	
	private Context context;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.context = this;
        
        setContentView(R.layout.main);
        
        Button btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	setContentView(R.layout.arena);
            	
            	CrossArena c1 = new CrossArena(context);
            	c1.setBackgroundColor(Color.GREEN);
            	CrossArena c2 = new CrossArena(context);
            	c2.setBackgroundColor(Color.BLUE);
            	
            	((LinearLayout) findViewById(R.id.cntArena)).addView(c1);
            	((LinearLayout) findViewById(R.id.cntArena)).addView(c2);
            }
        });
    }
}