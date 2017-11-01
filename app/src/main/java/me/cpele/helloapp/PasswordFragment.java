package me.cpele.helloapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class PasswordFragment extends Fragment {

    private Listener mListener;

    public static PasswordFragment newInstance() {
        return new PasswordFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (getActivity() instanceof Listener) mListener = (Listener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password, container, false);
        EditText passwordEdit = view.findViewById(R.id.password_et);
        View okButton = view.findViewById(R.id.password_bt_ok);
        okButton.setOnClickListener(view1 -> {
            mListener = Assert.notNull(mListener);
            mListener.onSubmitPassword(String.valueOf(passwordEdit.getText()));
        });
        return view;
    }

    interface Listener {
        void onSubmitPassword(String text);
    }
}
