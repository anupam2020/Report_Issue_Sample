package com.sbdev.reportissuesample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);

        bottomNavigationView=findViewById(R.id.bottomNav);


        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,new ReportFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.report);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,new HomeFragment()).commit();
                        item.setChecked(true);
                        break;
                    case R.id.report:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,new ReportFragment()).commit();
                        item.setChecked(true);
                        break;

                    case R.id.residents:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,new ResidentsFragment()).commit();
                        item.setChecked(true);
                        break;

                    case R.id.certificates:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,new CertificatesFragment()).commit();
                        item.setChecked(true);
                        break;
                }

                return false;
            }
        });

    }
}