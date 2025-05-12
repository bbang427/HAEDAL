package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class HomeActivity extends AppCompatActivity {

    TextView email;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);


        // 해당 엑티비티 넘어올 때 사용된 intent 불러오기
        Intent intent = getIntent();
        String emailText = intent.getStringExtra("email");
        String passWordText = intent.getStringExtra("password");

        Button HomeButton = findViewById(R.id.btn_home);
        Button GalleryButton = findViewById(R.id.btn_gallery);
        Button AccountButton = findViewById(R.id.btn_account);
        Button FavoriteButton = findViewById(R.id.btn_favorite);

        change_fragment(new HomeFragment());

        HomeButton.setOnClickListener(v->{
            change_fragment(new HomeFragment());
        });
        GalleryButton.setOnClickListener(v->{
            change_fragment(new GalleryFragment());
        });
        AccountButton.setOnClickListener(v->{
            change_fragment(new AccountFragment());
        });
        FavoriteButton.setOnClickListener(v->{
            change_fragment(new FavoriteFragment());
        });
    }
    private void change_fragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}