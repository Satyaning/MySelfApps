package com.example.biodataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Splash Activity (Halaman Splash)
 *
 * Dikerjakan Pada: 12 Mei 2021
 * Deskripsi Pekerjaan: Membuat activity splash dengan contraint serta linear layout ditambah dengan
 *                      textview dan imageView selain itu animasi splash activity dibuat pada
 *                      directory anim.
 * NIM: 10118058
 * Nama: Satyaning Andaru Bawalaksana
 * Kelas: IF-2
 */

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    //animation
    Animation topAnim,bottomAnim;
    ImageView image;
    TextView txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //Animations

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks

        image =findViewById(R.id.logo);
        txt1 = findViewById(R.id.text);
        txt2 = findViewById(R.id.text2);

        image.setAnimation(topAnim);
        txt1.setAnimation(bottomAnim);
        txt2.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, WalkthroughActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}