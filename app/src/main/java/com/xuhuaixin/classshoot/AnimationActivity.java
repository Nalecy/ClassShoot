package com.xuhuaixin.classshoot;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AnimationActivity extends AppCompatActivity {

    private boolean adStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        switch (getIntent().getIntExtra("type", 1)) {
            case 1:
                Picasso.get()
                        .load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4011064803,493771095&fm=26&gp=0.jpg")
                        .into((ImageView) findViewById(R.id.img_view));
                findViewById(R.id.rotate_btn).setOnClickListener(v ->
                        findViewById(R.id.img_view).startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate))
                );
                break;
            case 2:
                AnimationDrawable ad = new AnimationDrawable();
                ad.addFrame(getResources().getDrawable(R.drawable.pause), 100);
                ad.addFrame(getResources().getDrawable(R.drawable.play), 100);
                ad.setOneShot(false);
                ((ImageView) findViewById(R.id.img_view)).setImageDrawable(ad);
                findViewById(R.id.rotate_btn).setOnClickListener(v -> {
                    if (adStart) {
                        ad.stop();
                        adStart = false;
                    }else {
                        ad.start();
                        adStart = true;
                    }
                });
        }


    }
}