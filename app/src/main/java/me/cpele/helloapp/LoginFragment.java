package me.cpele.helloapp;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText loginEditText = view.findViewById(R.id.login_et);
        Button okButton = view.findViewById(R.id.login_bt_ok);

        IdentificationViewModel viewModel = ViewModelProviders.of(getActivity()).get(IdentificationViewModel.class);

        okButton.setOnClickListener(
                v -> {
                    viewModel.setLogin(String.valueOf(loginEditText.getText()));
                    viewModel.goToPassword();
                });

        return view;
    }
}
