package me.cpele.helloapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

class IdentificationViewModel extends ViewModel {

    private String mLogin;
    private String mPassword;
    private MutableLiveData<IdentificationStep> mCurrentStep = new MutableLiveData<>();

    public IdentificationViewModel() {
        mCurrentStep.setValue(IdentificationStep.LOGIN);
    }

    void setLogin(String login) {
        mLogin = login;
    }

    void setPassword(String password) {
        mPassword = password;
    }

    String getLogin() {
        return mLogin;
    }

    String getPassword() {
        return mPassword;
    }

    void goToHello() {
        mCurrentStep.setValue(IdentificationStep.HELLO);
    }

    void goToPassword() {
        mCurrentStep.setValue(IdentificationStep.PASSWORD);
    }

    LiveData<IdentificationStep> getCurrentStep() {
        return mCurrentStep;
    }
}
