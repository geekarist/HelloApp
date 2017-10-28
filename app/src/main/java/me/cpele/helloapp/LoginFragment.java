package me.cpele.helloapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment {

    private Listener mListener;

    public static Fragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Listener) mListener = (Listener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText loginEditText = view.findViewById(R.id.login_et);
        Button okButton = view.findViewById(R.id.login_bt_ok);
        okButton.setOnClickListener(v -> {
            mListener = Assert.notNull(mListener);
            mListener.onLoginSubmitted(loginEditText.getText());
        });
        return view;
    }

    interface Listener {
        void onLoginSubmitted(CharSequence text);
    }
}
