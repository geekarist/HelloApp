package me.cpele.helloapp;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class PasswordFragment extends Fragment {

    public static PasswordFragment newInstance() {
        return new PasswordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password, container, false);
        EditText passwordEdit = view.findViewById(R.id.password_et);
        View okButton = view.findViewById(R.id.password_bt_ok);
        IdentificationViewModel viewModel = ViewModelProviders.of(getActivity()).get(IdentificationViewModel.class);
        okButton.setOnClickListener(
                v -> {
                    viewModel.setPassword(String.valueOf(passwordEdit.getText()));
                    viewModel.goToHello();
                });
        return view;
    }
}
