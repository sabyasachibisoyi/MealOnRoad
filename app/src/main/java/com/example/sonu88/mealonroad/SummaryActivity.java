package com.example.sonu88.mealonroad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView= (TextView)findViewById(R.id.textView4);
        textView.setText(message);


        ImageView img_animation = (ImageView)findViewById(R.id.imageView4);
        TranslateAnimation animation = new TranslateAnimation(0.0f, 2100.0f,
                0.0f, 0.0f);
        animation.setDuration(4955);
        animation.setRepeatCount(1);
        animation.setFillAfter(true);
        img_animation.startAnimation(animation);
    }
}
