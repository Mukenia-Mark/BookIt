package com.example.bookit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultsActivity extends AppCompatActivity {
  @BindView(R.id.booksListView) ListView mBooksListView;
  @BindView(R.id.titleSearch) TextView mTitleSearch;
  @BindView(R.id.errorTextView) TextView mErrorTextView;
  @BindView(R.id.progressBar) ProgressBar mProgressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_searchresults);
    ButterKnife.bind(this);

    BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.searchNavBar);
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
          case R.id.home:
            Intent homeIntent = new Intent(SearchResultsActivity.this, HomeActivity.class);
            startActivity(homeIntent);

          case R.id.search:
            Intent searchIntent = new Intent(SearchResultsActivity.this, SearchActivity.class);
            startActivity(searchIntent);

          case R.id.user:
            Intent userIntent = new Intent(SearchResultsActivity.this, UserActivity.class);
            startActivity(userIntent);
        }
        return true;
      }
    });

    BooksApi client = BooksClient.getClient();
    Call<BookItBookSearchResponses> call = client.getBooks("books");
    call.enqueue(new Callback<BookItBookSearchResponses>() {
      @Override
      public void onResponse(Call<BookItBookSearchResponses> call, Response<BookItBookSearchResponses> response) {
        if (response.isSuccessful()) {
          List<Item> booksList = response.body().getItems();
          String[] books = new String[booksList.size()];
          for(int i=0;i<books.length;i++) {
            books[i] = booksList.get(i).getKind();
          }
          ArrayAdapter adapter = new MyBooksArrayAdapter(SearchResultsActivity.this, android.R.layout.simple_list_item_1,books);
          mBooksListView.setAdapter(adapter);

          showBooks();
        }else{
          showUnsuccessfulMessage();
        }
      }

      @Override
      public void onFailure(Call<BookItBookSearchResponses> call, Throwable t) {
        hideProgressBar();
        showFailureMessage();
      }
    });
  }

  private void showFailureMessage() {
    mErrorTextView.setText("Something went wrong. Please check your internet connection and try again later");
    mErrorTextView.setVisibility(View.VISIBLE);
  }

  private void showUnsuccessfulMessage() {
    mErrorTextView.setText("Something went wrong. Please try again later");
    mErrorTextView.setVisibility(View.VISIBLE);
  }

  private void showBooks() {
    mBooksListView.setVisibility(View.VISIBLE);
  }

  public void hideProgressBar() {
    mProgressBar.setVisibility(View.GONE);
  }
}