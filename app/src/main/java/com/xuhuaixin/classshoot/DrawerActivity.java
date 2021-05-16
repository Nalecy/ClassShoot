package com.xuhuaixin.classshoot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class DrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
    }

    public void startDrawer(View view) {
        ((DrawerLayout)findViewById(R.id.drawer)).openDrawer(GravityCompat.START);
    }
}