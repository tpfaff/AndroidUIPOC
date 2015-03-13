package com.blastmotion.app.baseballmock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;


public class ActionDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_action_detail);


        ColorDrawable colorDrawable=new ColorDrawable(0x2196f3);
        ColorDrawable clear=new ColorDrawable(0x80FFFFFF);
        getActionBar().setBackgroundDrawable(clear);

        FadingActionBarHelper helper = new FadingActionBarHelper()
                .actionBarBackground(R.drawable.bar_background)
                .headerLayout(R.layout.header)
                .contentLayout(R.layout.activity_action_detail);
        setContentView(helper.createView(this));
        helper.initActionBar(this);

        ImageView commonView=(ImageView)findViewById(R.id.sport_image);
        TextView commonText=(TextView)findViewById(R.id.textView_main_metric);


        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.floating_button);
        final Context thisActivity=this;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(thisActivity,VideoActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        ViewCompat.setTransitionName(commonView,"imageTransition");
        ViewCompat.setTransitionName(commonText,"textTransition");
        ViewCompat.setTransitionName(fab,"fabTransition");
        //getActionBar().setTitle("");
    }

    @Override
    public  void onStart(){
        super.onStart();
        getActionBar().setTitle("Details");
        ScrollView scrollView=(ScrollView)findViewById(R.id.scrollView);
        scrollView.scrollTo(50,300);
        //ActionBar bar=getActionBar();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_action_detail, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
       // super.onBackPressed();
        this.finishAfterTransition();
//
//        ImageView commonView=(ImageView)findViewById(R.id.sport_image);
//       // ViewCompat.setTransitionName(commonView,"sharedElementEnterTransition");
//        ViewCompat.setTransitionName(commonView,"sharedElementExitTransition");
    }

}
