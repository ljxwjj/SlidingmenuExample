package com.example.slidingmenuexample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.Menu;

import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    protected ListFragment mFrag;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("test");
        setBehindContentView(R.layout.menu_frame);
        FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
        mFrag = new SampleListFragment();
        t.replace(R.id.menu_frame, mFrag);
        t.commit();
        
        SlidingMenu sm = getSlidingMenu();
        sm.setFadeDegree(0.35f);
        sm.setBehindOffset(300);
        sm.setMode(SlidingMenu.LEFT_RIGHT);
        

        sm.setSecondaryMenu(R.layout.menu_frame_two);
        getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.menu_frame_two, new SampleListFragment())
        .commit();
        
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        
        setSlidingActionBarEnabled(true);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
