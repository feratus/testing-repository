package com.example.testing_project.mainApp;

import com.example.testing_project.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
	
	Button mStartButton, mCancelButton;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// load the view
		setContentView(R.layout.main_activity);
		// find the buttons
		mStartButton = (Button) findViewById(R.id.button_start_app);
		mStartButton.setOnClickListener(this);
		mCancelButton = (Button) findViewById(R.id.button_cancel_app);
		mCancelButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_start_app:
			startIndexActivity();
			break;
		case R.id.button_cancel_app:
			finish();
			break;
		}
	}

	private void startIndexActivity() {
		Intent i = new Intent(this, IndexActivity.class);        
        startActivity(i);
	}
	

}
