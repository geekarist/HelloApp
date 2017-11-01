package me.cpele.helloapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HelloFragment extends Fragment {

    private static final String ARG_LOGIN = "ARG_LOGIN";
    private static final String ARG_PASSWORD = "ARG_PASSWORD";

    public static HelloFragment newInstance(String login, String password) {
        HelloFragment helloFragment = new HelloFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LOGIN, login);
        args.putString(ARG_PASSWORD, password);
        helloFragment.setArguments(args);
        return helloFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View createdView = inflater.inflate(R.layout.fragment_hello, container, false);

        TextView titleTextView = createdView.findViewById(R.id.hello_tv_title);
        String login = getArguments().getString(ARG_LOGIN);
        titleTextView.setText(getString(R.string.hello_user, login));

        String password = getArguments().getString(ARG_PASSWORD);
        TextView strengthTextView = createdView.findViewById(R.id.hello_tv_strength);
        int strength = calculatePasswordStrength(password);
        strengthTextView.setText(getString(R.string.hello_strength, strength));

        return createdView;
    }

    private static int calculatePasswordStrength(String password) {

        //total score of password
        int iPasswordScore = 0;

        if (password.length() < 8)
            return 0;
        else if (password.length() >= 10)
            iPasswordScore += 2;
        else
            iPasswordScore += 1;

        //if it contains one digit, add 2 to total score
        if (password.matches("(?=.*[0-9]).*"))
            iPasswordScore += 2;

        //if it contains one lower case letter, add 2 to total score
        if (password.matches("(?=.*[a-z]).*"))
            iPasswordScore += 2;

        //if it contains one upper case letter, add 2 to total score
        if (password.matches("(?=.*[A-Z]).*"))
            iPasswordScore += 2;

        //if it contains one special character, add 2 to total score
        if (password.matches("(?=.*[~!@#$%^&*()_-]).*"))
            iPasswordScore += 2;

        return iPasswordScore;

    }
}
