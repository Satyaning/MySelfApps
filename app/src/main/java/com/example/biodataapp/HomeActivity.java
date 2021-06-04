package com.example.biodataapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.biodataapp.Fragment.DailyFragment;
import com.example.biodataapp.Fragment.GalleryFragment;
import com.example.biodataapp.Fragment.HomeFragment;
import com.example.biodataapp.Fragment.MusicVideoFragment;
import com.example.biodataapp.Fragment.ProfileFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class HomeActivity extends AppCompatActivity {

    private MeowBottomNavigation bnv_Main;
    private LinearLayout layoutFriendListIndicator,layoutImageIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bnv_Main = findViewById(R.id.bnv_Main);
        bnv_Main.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        bnv_Main.add(new MeowBottomNavigation.Model(2,R.drawable.explore));
        bnv_Main.add(new MeowBottomNavigation.Model(3,R.drawable.galery));
        bnv_Main.add(new MeowBottomNavigation.Model(4,R.drawable.music_video));
        bnv_Main.add(new MeowBottomNavigation.Model(5,R.drawable.profile));

        bnv_Main.show(1,true);
        replace(new HomeFragment());
        bnv_Main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1 :
                        replace(new HomeFragment());
                        break;

                    case 2 :
                        replace(new DailyFragment());
                        break;

                    case 3 :
                        replace(new GalleryFragment());
                        break;

                    case 4 :
                        replace(new MusicVideoFragment());
                        break;

                    case 5 :
                        replace(new ProfileFragment());
                        break;
                }
                return null;
            }
        });

    }


    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }
}