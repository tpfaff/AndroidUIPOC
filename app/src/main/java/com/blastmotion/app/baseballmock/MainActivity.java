package com.blastmotion.app.baseballmock;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements ActionBar.TabListener {


    ViewPager tabBar;
    //MyAdapter adapter;
    HistoryFragment historyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        historyFragment=new HistoryFragment();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        ActionBar actionBar=getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("HISTORY").setTabListener(this));
       // actionBar.addTab(actionBar.newTab().setText("CAMERA").setTabListener(this));
     //   actionBar.addTab(actionBar.newTab().setText("METRICS").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("EQUIPMENT").setTabListener(this));
        //actionBar.addTab(actionBar.newTab().setText("SETTINGS").setTabListener(this));
        actionBar.setTitle("");

//        actionBar.getTabAt(0).getCustomView().
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            this.historyFragment.useFat=!this.historyFragment.useFat;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        final int HISTORY=0;
//        final int CAMERA=1;
        final int METRICS=1;
        final int EQUIPMENT=2;
//        final int SETTINGS=4;

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        switch (tab.getPosition()){
            case HISTORY:
                ft.replace(R.id.frame,historyFragment);
                break;

//            case CAMERA:
//                //ft.replace()
//                break;

            case METRICS:
              //  ft.replace(R.id.frame,new MetricsFragment());
                break;

            case EQUIPMENT:
                ft.replace(R.id.frame,new EquipmentFragment());
                break;

//            case SETTINGS:
//                ft.replace(R.id.frame,new SettingsFragment());
//                break;
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){

    }

//    public static class MyAdapter extends FragmentPagerAdapter {
//        public MyAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public int getCount() {
//            return 5;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return ArrayListFragment.newInstance(position);
//        }
//    }
//
//
//    public static class History extends Fragment{
//
//    }
}
