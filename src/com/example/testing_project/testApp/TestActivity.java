package com.example.testing_project.testApp;

import com.example.testing_project.R;

import android.app.Activity;
import android.os.Bundle;

public class TestActivity extends Activity {

	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activityapp_screen);
	}
}
