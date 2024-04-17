package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.bounceBallImage);
        btn = findViewById(R.id.bounceBallButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.clearAnimation();
                TranslateAnimation animation = new TranslateAnimation(0f, 0f, 0f, (dHeight()/2));
                animation.setStartOffset(500);
                animation.setDuration(3000);
                animation.setFillAfter(true);
                animation.setInterpolator(new BounceInterpolator());
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        img.clearAnimation();
                        int left = img.getLeft();
                        int right = img.getRight();
                        int top = img.getTop();
                        int bottom = img.getBottom();
                        img.layout(left, top,right,bottom);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            img.startAnimation(animation);

            }
        });

    }
    private int dHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}