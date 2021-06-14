package com.example.bookit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity {
  private Button mMyBooksButton;
  private Button mFavouritesButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user);
    mMyBooksButton = (Button) findViewById(R.id.myBooksButton);
    mFavouritesButton = (Button) findViewById(R.id.favouritesButton);


    mMyBooksButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(UserActivity.this, MyBooksActivity.class);
        startActivity(intent);
      }
    });

    mFavouritesButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(UserActivity.this, FavoritesActivity.class);
        startActivity(intent);
      }
    });

    BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.homeNavBar);
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
          case R.id.home:
            Intent homeIntent = new Intent(UserActivity.this, HomeActivity.class);
            startActivity(homeIntent);

          case R.id.search:
            Intent searchIntent = new Intent(UserActivity.this, SearchActivity.class);
            startActivity(searchIntent);

          case R.id.user:
            Intent userIntent = new Intent(UserActivity.this, UserActivity.class);
            startActivity(userIntent);
        }
        return true;
      }
    });
  }
}