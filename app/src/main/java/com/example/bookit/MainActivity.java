package com.example.bookit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
  public static final String TAG = MainActivity.class.getSimpleName();
  @BindView(R.id.logInConfirmButton) Button mLogInConfirmButton;
  @BindView(R.id.switchToSignUpButton) Button mSwitchToSignUpButton;
  @BindView(R.id.editTextLogInUsername) EditText mEditTextLogInUsername;
  @BindView(R.id.editTextLogInPassword) EditText mEditTextLogInPassword;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    mLogInConfirmButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String username = mEditTextLogInUsername.getText().toString();
        String password = mEditTextLogInPassword.getText().toString();
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
      }
    });

    mSwitchToSignUpButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);
      }
    });
  }
}