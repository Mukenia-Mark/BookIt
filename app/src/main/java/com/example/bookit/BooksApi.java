package com.example.bookit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksApi {
  @GET("books/search")
  Call<BookItBookSearchResponses> getBooks(
      @Query("books") String books
  );
}
