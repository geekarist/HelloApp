package me.cpele.helloapp;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        IdentificationViewModel viewModel =
                ViewModelProviders.of(this).get(IdentificationViewModel.class);

        viewModel.getCurrentStep().observe(
                this,
                step -> {
                    step = Assert.notNull(step);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_fl_container, step.createFragment())
                            .commit();
                });
    }
}
