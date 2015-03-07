package com.blastmotion.app.baseballmock;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


public class VideoActivity extends Activity implements SurfaceHolder.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
    }

    @Override
    protected  void onStart() {
        super.onStart();
        getActionBar().hide();

        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.videoSurface);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
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
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("SURFACE WAS CREATED","SURFACE WAS CREATED");
        MediaPlayer mediaPlayer;
        boolean feelingFunny=false;

        if(feelingFunny) {
            mediaPlayer=MediaPlayer.create(this,R.raw.rickroll);

        }else {
            mediaPlayer = MediaPlayer.create(this, R.raw.video);
        }
            mediaPlayer.setDisplay(holder);
            try {
                mediaPlayer.prepare();
            }catch (Exception e){
                Log.e("e",e.toString());
            }


            // Set the IMMERSIVE flag.
            // Set the content to appear under the system bars so that the content
            // doesn't resize when the system bars hide and show.
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                            | View.SYSTEM_UI_FLAG_IMMERSIVE);

            mediaPlayer.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d("SURFACE WAS CHANGED","SURFACE WAS CHANGED");

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("SURFACE WAS DESTROYED","SURFACE WAS DESTROYEDm");

    }
}
