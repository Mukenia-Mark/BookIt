package com.example.bookit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
  public static final String TAG = SearchActivity.class.getSimpleName();
  private Button mSearchButton;
  private EditText mSearchTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    mSearchButton = (Button) findViewById(R.id.searchButton);
    mSearchTextView = (EditText) findViewById(R.id.searchTextView);

    mSearchButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(SearchActivity.this, SearchResultsActivity.class);
        startActivity(intent);
      }
    });

    BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.searchNavBar);
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
          case R.id.home:
            Intent homeIntent = new Intent(SearchActivity.this, HomeActivity.class);
            startActivity(homeIntent);

          case R.id.search:
            Intent searchIntent = new Intent(SearchActivity.this, SearchActivity.class);
            startActivity(searchIntent);

          case R.id.user:
            Intent userIntent = new Intent(SearchActivity.this, UserActivity.class);
            startActivity(userIntent);
        }
        return true;
      }
    });
  }
}