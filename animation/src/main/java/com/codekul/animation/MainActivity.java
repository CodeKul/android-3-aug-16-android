package com.codekul.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnMixed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appyAnimation(R.anim.bounce);
            }
        });
    }

    public void appyAnimation(int animation){

        findViewById(R.id.imageView)
                .startAnimation(AnimationUtils
                        .loadAnimation(this,animation));

    }
}
