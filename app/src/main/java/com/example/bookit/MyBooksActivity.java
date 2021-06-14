package com.example.bookit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyBooksActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mybooks);

    BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.homeNavBar);
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
          case R.id.home:
            Intent homeIntent = new Intent(MyBooksActivity.this, HomeActivity.class);
            startActivity(homeIntent);

          case R.id.search:
            Intent searchIntent = new Intent(MyBooksActivity.this, SearchActivity.class);
            startActivity(searchIntent);

          case R.id.user:
            Intent userIntent = new Intent(MyBooksActivity.this, UserActivity.class);
            startActivity(userIntent);
        }
        return true;
      }
    });
  }
}