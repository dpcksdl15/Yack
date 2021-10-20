package com.example.yack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yack.fragment.FragmentMain;
import com.example.yack.fragment.FragmentMdPrice;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();

    private FragmentMain fragmentMain = new FragmentMain();
    private FragmentMdPrice fragmentMdPrice = new FragmentMdPrice();

    FragmentTransaction transaction;

    Menu menu;

    private long backbuttonpress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frag_layout, fragmentMain).commitNowAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_bar);

        menu = bottomNavigationView.getMenu();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                switch (item.getItemId()){

                    case R.id.home:

                        item.setIcon(R.drawable.nv_bt_3_b);
                        menu.findItem(R.id.md_search).setIcon(R.drawable.nv_bt_1);
                        menu.findItem(R.id.yg_sell).setIcon(R.drawable.nv_bt_2);
                        menu.findItem(R.id.md_consulting).setIcon(R.drawable.nv_bt_4);
                        menu.findItem(R.id.my_info).setIcon(R.drawable.nv_bt_5);

                        transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.frag_layout, fragmentMain).commitAllowingStateLoss();
                        return true;

                    case R.id.md_search:

                        item.setIcon(R.drawable.nv_bt_1_b);
                        menu.findItem(R.id.home).setIcon(R.drawable.nv_bt_3);
                        menu.findItem(R.id.yg_sell).setIcon(R.drawable.nv_bt_2);
                        menu.findItem(R.id.md_consulting).setIcon(R.drawable.nv_bt_4);
                        menu.findItem(R.id.my_info).setIcon(R.drawable.nv_bt_5);

                        transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.frag_layout, fragmentMdPrice).commitAllowingStateLoss();

                        return true;


                    case R.id.yg_sell:

                        item.setIcon(R.drawable.nv_bt_2_b);
                        menu.findItem(R.id.md_search).setIcon(R.drawable.nv_bt_1);
                        menu.findItem(R.id.home).setIcon(R.drawable.nv_bt_3);
                        menu.findItem(R.id.md_consulting).setIcon(R.drawable.nv_bt_4);
                        menu.findItem(R.id.my_info).setIcon(R.drawable.nv_bt_5);

                        Toast.makeText(getApplicationContext(), "추후 오픈될 예정입니다", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.md_consulting:

                        item.setIcon(R.drawable.nv_bt_4_b);
                        menu.findItem(R.id.md_search).setIcon(R.drawable.nv_bt_1);
                        menu.findItem(R.id.yg_sell).setIcon(R.drawable.nv_bt_2);
                        menu.findItem(R.id.home).setIcon(R.drawable.nv_bt_3);
                        menu.findItem(R.id.my_info).setIcon(R.drawable.nv_bt_5);

                        Toast.makeText(getApplicationContext(), "추후 오픈될 예정입니다", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.my_info:

                        item.setIcon(R.drawable.nv_bt_5_b);
                        menu.findItem(R.id.md_search).setIcon(R.drawable.nv_bt_1);
                        menu.findItem(R.id.yg_sell).setIcon(R.drawable.nv_bt_2);
                        menu.findItem(R.id.home).setIcon(R.drawable.nv_bt_1);
                        menu.findItem(R.id.home).setIcon(R.drawable.nv_bt_3);

                        Toast.makeText(getApplicationContext(), "추후 오픈될 예정입니다", Toast.LENGTH_SHORT).show();
                        return true;

                }


                return true;
            }
        });

        FragmentMdPrice fragmentMdPrice = new FragmentMdPrice();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(fragmentMdPrice.brod(),intentFilter);

    }

    public void onBackpressde(){
        onBackPressed();
    }


    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() > backbuttonpress + 2000 ){

            backbuttonpress = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 한번 더 누르시면 종료합니다", Toast.LENGTH_SHORT).show();
            return;

        } else if (System.currentTimeMillis() <= backbuttonpress + 2000){

            finish();

        }
//        super.onBackPressed();
    }

    public void onFragmentChange(int value){


        if (value == 1){
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frag_layout, fragmentMdPrice).commitAllowingStateLoss();


        }



    }

}