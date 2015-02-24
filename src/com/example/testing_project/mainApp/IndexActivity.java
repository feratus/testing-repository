package com.example.testing_project.mainApp;

import com.example.testing_project.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class IndexActivity extends FragmentActivity 
						implements OnClickListener, 
								   IndexFragment.OnItemSelectedListener{
	
	// Fragments
	IndexFragment mIndexFragment;
	DescriptionFragment mDescriptionFragment;
	
	// to check the availability of dual-pane
	boolean mIsDualPane = false;
	
	// the index currently being displayed
	int mActIndex, mCatIntex;
	
	// List of Activities
	private String mActivityIndexList[] = { 
			" A - OK",			// 1 
			" Dva",				// 2
			" Tri", 			// 3
			" Chetyre", 		// 4	
			" Pyat'",			// 5			
			};
	
	// -----------------------------------------------------------------------------------
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.index_layout); // searches for the alias @values/layouts
		
		// find the fragments...
		mIndexFragment = 
			(IndexFragment) getSupportFragmentManager().findFragmentById(R.id.index_fragment);
		
		// Register this activity as the listener for the IndexFragment envents.
		mIndexFragment.setOnItemSelectedListener(this);
	}
	
	// -----------------------------------------------------------------------------------
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		restoreSelection(savedInstanceState);
	}
	public void restoreSelection(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			setIndexCategory(savedInstanceState.getInt("catIndex", 0));
			if (mIsDualPane) {
				int actIndex = savedInstanceState.getInt("actIndex", 0);
				mIndexFragment.setSelection(actIndex);
				onItemSelected(actIndex);
			}
		}
	}
	// -----------------------------------------------------------------------------------
	@Override
	public void onStart() {
		super.onStart();
		setIndexCategory(0);
	}
	/**
	 * setItemsCategory sets the displayed Items for a specific subject
	 * This causes the Index Fragment to be populated with the appropriate content
	 */
	void setIndexCategory(int categoryIndex) {
		// 
		mCatIntex = categoryIndex;
		mIndexFragment.loadIndex(mActivityIndexList);
		
		// In dual pane, display the content on the right, and update that too
		if (mIsDualPane) {
			mDescriptionFragment.displayDescription();
		}
	}
	
	// -----------------------------------------------------------------------------------
	/**
	 * Called when an Activity is selected
	 * 
	 * This is called by the ActivitiesFragment (via its listener interface) to notify
	 * that an activity was selected in the Action Bar. The way this reacts depends on 
	 * whether the app is in single o dual-pane mode. In the first, a new activity is 
	 * launched to display the selected content; in dual-pane the content is displayed
	 * on the description fragment
	 * 
	 * @param index the index of the selected activity
	 */
	@Override
	public void onItemSelected(int index) { // from IndexFragment.OnItemSelectedListener
		// TODO Auto-generated method stub
		//mDescriptionIndex = index;		
		if (mIsDualPane) {
			// TODO display it on the description fragment
			// mDescriptionFragment.displayDescription(mCurrent...);
		} else {
			// use separate activity
			/*Intent i = new Intent(this, DescriptionActivity.class);
			i.putExtra("categoryIndex", 0);
			i.putExtra("descriptionIndex",index);
			startActivity(i);
			*/
			launchActivity(index);
		}
	}	
	private void launchActivity (int indexPosition) {
		
		Intent intent = new Intent(this, DescriptionActivity.class);
        //intent.putExtra("ABOUT_TEXT_TITLE", activityTitle);
        
        switch (indexPosition) {
        case 0:
            intent.putExtra("ACTIVITY_TO_LAUNCH", "mainApp.MainActivity");
            intent.putExtra("ABOUT_TEXT", "HTML/html_about.html");
            break;
        case 1:
            intent.putExtra("ACTIVITY_TO_LAUNCH", "testApp.TestActivity");
            intent.putExtra("ABOUT_TEXT", "HTML/html_about.html");
            break;
        case 2:
            intent.putExtra("ACTIVITY_TO_LAUNCH", "testApp.TestActitivy");
            intent.putExtra("ABOUT_TEXT", "HTML/html_about.html");
            break;
        case 3:
            intent.putExtra("ACTIVITY_TO_LAUNCH", "activityApp.TestActivity");
            intent.putExtra("ABOUT_TEXT", "HTML/html_about.html");
            break;
        case 4:
            intent.putExtra("ACTIVITY_TO_LAUNCH", "testApp.TestActivity");
            intent.putExtra("ABOUT_TEXT", "HTML/html_about.html");
            break;
        }
        
        startActivity(intent);
	}
	// -----------------------------------------------------------------------------------
	@Override
	public void onClick(View v) {		// from OnClickListener
		// TODO Auto-generated method stub
		
	}
	// -----------------------------------------------------------------------------------
	
}
