package com.example.android_oreo.splashhomeanimation;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ivLogo , ivSubtitle , ivBtn;
    ImageView ivSplash;
    Animation smallToBig , fromLeftToRight , fleft , fhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        smallToBig = AnimationUtils.loadAnimation(this , R.anim.smalltobig);
        fromLeftToRight = AnimationUtils.loadAnimation(this , R.anim.fromlefttoright);
        fleft = AnimationUtils.loadAnimation(this , R.anim.fleft);
        fhelper = AnimationUtils.loadAnimation(this , R.anim.fhelper);


        Typeface logox = Typeface.createFromAsset(getAssets() , "fonts/Fredoka.ttf");
        Typeface mlight = Typeface.createFromAsset(getAssets() , "fonts/MontserratLight.ttf");
        Typeface mmeDium = Typeface.createFromAsset(getAssets() , "fonts/MontserratMedium.ttf");
        Typeface mregular = Typeface.createFromAsset(getAssets() , "fonts/MontserratRegular.ttf");

        ivLogo = (TextView) findViewById(R.id.ivLogo);
        ivSubtitle = (TextView) findViewById(R.id.ivSubtitle);
        ivBtn = (TextView) findViewById(R.id.ivBtn);
        ivSplash = (ImageView) findViewById(R.id.ivSplash);

        ivLogo.setTypeface(logox);
        ivSubtitle.setTypeface(mlight);
        ivBtn.setTypeface(mmeDium);


        // set animation

        ivSplash.startAnimation(smallToBig);
        //ivSubtitle.startAnimation(fromLeftToRight);
        //ivBtn.startAnimation(fromLeftToRight);

        ivLogo.setTranslationX(400);
        ivSubtitle.setTranslationX(400);
        ivBtn.setTranslationX(400);


        ivLogo.animate().translationX(0).setDuration(800).setStartDelay(500).start();
        ivSubtitle.animate().translationX(0).setDuration(800).setStartDelay(700).start();
        ivBtn.animate().translationX(0).setDuration(800).setStartDelay(900).start();

        ivBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fleft , R.anim.fhelper);
            }
        });

    }
}
