package com.example.bookit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {
  public static final String TAG = SignUpActivity.class.getSimpleName();
  @BindView(R.id.signUpConfirmButton) Button mSignUpConfirmButton;
  @BindView(R.id.switchToLogInButton) Button mSwitchToLogInButton;
  @BindView(R.id.editTextSignUpUsername) EditText mEditTextSignUpUsername;
  @BindView(R.id.editTextSignUpEmail) EditText mEditTextSignUpEmail;
  @BindView(R.id.editTextSignUpPassword) EditText mEditTextSignUpPassword;
  @BindView(R.id.editTextSignUpPassword2) EditText mEditTextSignUpPassword2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup);
    ButterKnife.bind(this);

    mSignUpConfirmButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String email = mEditTextSignUpEmail.getText().toString();
        String password = mEditTextSignUpPassword.getText().toString();
        String password2 = mEditTextSignUpPassword2.getText().toString();
        Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
        startActivity(intent);
      }
    });

    mSwitchToLogInButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
      }
    });
  }
}