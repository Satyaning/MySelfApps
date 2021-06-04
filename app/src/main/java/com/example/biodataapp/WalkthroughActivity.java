package com.example.biodataapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.biodataapp.Adapter.WalkthroughAdapter;
import com.example.biodataapp.Model.WalkthroughItem;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
/**
 * Walkthrough Activity (Halaman Walkthrough)
 *
 * Dikerjakan Pada: 15 Mei 2021
 * Deskripsi Pekerjaan: Membuat activity walkthrough dengan contraint serta linear layout ditambah dengan
 *                      layout tambahan yang bernama item_container_walkthrough
 *                      didalamnya terdapat textview dan imageView, untuk menampilkan
 *                      textView dan ImageView menggunakan class adapter serta class Walkthroughitem pada
 *                      package model.
 * NIM: 10118058
 * Nama: Satyaning Andaru Bawalaksana
 * Kelas: IF-2
 */

public class WalkthroughActivity extends AppCompatActivity {

    private WalkthroughAdapter walkthroughAdapter;
    private LinearLayout layoutWalkthroughIndicator;
    private MaterialButton buttonWalkthroughAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        layoutWalkthroughIndicator = findViewById(R.id.layoutWalkthroughIndicator);
        buttonWalkthroughAction =findViewById(R.id.buttonWalkthroughAction);
        setupWalkthroughItems();

        ViewPager2 walkthroughViewPager = findViewById(R.id.walkthroughViewPager);
        walkthroughViewPager.setAdapter(walkthroughAdapter);

        setupWalkthroughIndicator();
        setCurrentWalkthroughIndicator(0);

        walkthroughViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentWalkthroughIndicator(position);
            }
        });
        buttonWalkthroughAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (walkthroughViewPager.getCurrentItem() + 1 < walkthroughAdapter.getItemCount()) {
                    walkthroughViewPager.setCurrentItem(walkthroughViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                }
            }
        });
    }
    private void setupWalkthroughItems(){

        List<WalkthroughItem> walkthroughItems = new ArrayList<>();

        WalkthroughItem introduction = new WalkthroughItem();
        introduction.setTitle("Perkenalkan");
        introduction.setDescription("Nama Saya Satyaning Andaru Bawalaksana");
        introduction.setImage(R.drawable.photo);

        WalkthroughItem campus = new WalkthroughItem();
        campus.setDescription("Saya Belajar di Universitas Komputer Indonesia, Jurusan Teknik Informatika ");
        campus.setImage(R.drawable.school);

        WalkthroughItem app = new WalkthroughItem();
        app.setTitle("Ini Merupakan Aplikasi Pertama Saya");
        app.setImage(R.drawable.thankyou);



        walkthroughItems.add(introduction);
        walkthroughItems.add(campus);
        walkthroughItems.add(app);

        walkthroughAdapter = new WalkthroughAdapter(walkthroughItems);
    }
    private void setupWalkthroughIndicator(){
        ImageView[] indicator = new ImageView[walkthroughAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i = 0; i < indicator.length; i++){
          indicator[i] = new ImageView(getApplicationContext());
          indicator[i].setImageDrawable(ContextCompat.getDrawable(
                  getApplicationContext(),
                  R.drawable.walkthrough_indicator_inactive
          ));
          indicator[i].setLayoutParams(layoutParams);
          layoutWalkthroughIndicator.addView(indicator[i]);
        }
    }
    @SuppressLint("SetTextI18n")
    private void setCurrentWalkthroughIndicator(int index){
            int childCount = layoutWalkthroughIndicator.getChildCount();
            for (int i = 0 ; i < childCount; i++) {
                ImageView imageView = (ImageView)layoutWalkthroughIndicator.getChildAt(i);
                if (i == index){
                    imageView.setImageDrawable(
                            ContextCompat.getDrawable(getApplicationContext(),R.drawable.walkthrough_indicator_active)
                    );
                }else{
                    imageView.setImageDrawable(
                            ContextCompat.getDrawable(getApplicationContext(),R.drawable.walkthrough_indicator_inactive)
                    );
                }
            }
            if (index == walkthroughAdapter.getItemCount()-1){
                buttonWalkthroughAction.setText("Start");
            } else {
                buttonWalkthroughAction.setText("Next");
            }
    }
}