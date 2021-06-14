package com.example.bookit;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyBooksArrayAdapter extends ArrayAdapter {
  private Context mContext;
  private String[] mBooks;

  public MyBooksArrayAdapter (Context mContext, int resource, String[] mBooks) {
    super(mContext, resource);
    this.mContext = mContext;
    this.mBooks =mBooks;
  }

  @Override
  public Object getItem(int position) {
    String books = mBooks[position];
    return String.format(books);
  }

  @Override
  public int getCount() {
    return mBooks.length;
  }
}
