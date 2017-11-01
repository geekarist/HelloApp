package me.cpele.helloapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class MainActivity
        extends AppCompatActivity
        implements LoginFragment.Listener, PasswordFragment.Listener {

    private String mLogin;
    private String mPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Fragment loginFragment = LoginFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fl_container, loginFragment)
                .commit();
    }

    @Override
    public void onSubmitLogin(String login) {

        mLogin = login;

        Fragment passwordFragment = PasswordFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fl_container, passwordFragment)
                .commit();
    }


    @Override
    public void onSubmitPassword(String password) {

        mPassword = password;

        Fragment helloFragment = HelloFragment.newInstance(mLogin, mPassword);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fl_container, helloFragment)
                .commit();
    }
}
