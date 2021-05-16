package com.xuhuaixin.classshoot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        WebView wv = findViewById(R.id.webview);
        wv.loadUrl("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
    }
}