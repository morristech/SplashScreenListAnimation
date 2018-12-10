package com.example.android_oreo.splashhomeanimation;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {




    @BindView(R.id.header_text)
    TextView headerText;


    @BindView(R.id.text_1_title)
    TextView firstTextTitle;

    @BindView(R.id.text_1_sub_title)
    TextView firstTextSubtitle;


    @BindView(R.id.text_2_title)
    TextView secondTextTitle;
    @BindView(R.id.text_2_subtitle)
    TextView secondTextSubtitle;


    @BindView(R.id.text_3_title)
    TextView thirdTextTitle;
    @BindView(R.id.text_3_subtitle)
    TextView thirdTextSubtitle;



    @BindView(R.id.btnBuy)
    Button okButton;

    @BindView(R.id.ivIlls)
    ImageView displayImage;

    Animation displayAnimation;


    @BindView(R.id.layout_1)
    LinearLayout layout1;

    @BindView(R.id.layout_2)
    LinearLayout layout2;

    @BindView(R.id.layout_3)
    LinearLayout layout3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);



        Typeface logox = Typeface.createFromAsset(getAssets() , "fonts/Fredoka.ttf");
        Typeface mlight = Typeface.createFromAsset(getAssets() , "fonts/MontserratLight.ttf");
        Typeface mmeDium = Typeface.createFromAsset(getAssets() , "fonts/MontserratMedium.ttf");
        Typeface mregular = Typeface.createFromAsset(getAssets() , "fonts/MontserratRegular.ttf");

        displayAnimation = AnimationUtils.loadAnimation(this , R.anim.slib2);

        headerText.setTypeface(mlight);

        firstTextTitle.setTypeface(mregular);
        secondTextTitle.setTypeface(mregular);
        thirdTextTitle.setTypeface(mregular);

        firstTextSubtitle.setTypeface(mlight);
        secondTextSubtitle.setTypeface(mlight);
        thirdTextSubtitle.setTypeface(mlight);
        okButton.setTypeface(mmeDium);




        okButton.setTranslationY(400);
        okButton.setAlpha(0);
        okButton.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        displayImage.setAnimation(displayAnimation);




        /// layout animation

        layout1.setTranslationX(400);
        layout2.setTranslationX(400);
        layout3.setTranslationX(400);

        layout1.animate().translationX(0).setDuration(800).setStartDelay(200).start();
        layout2.animate().translationX(0).setDuration(800).setStartDelay(400).start();
        layout3.animate().translationX(0).setDuration(800).setStartDelay(600).start();


        // layout hide

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layout1.animate().translationX(-1500).setDuration(600).setStartDelay(200).start();
                layout2.animate().translationX(1500).setDuration(600).setStartDelay(400).start();
                layout3.animate().translationX(-1500).setDuration(600).setStartDelay(600).start();
            }
        });
    }

}
