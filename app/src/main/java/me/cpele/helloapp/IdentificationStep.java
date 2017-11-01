package me.cpele.helloapp;

import android.support.v4.app.Fragment;

enum IdentificationStep {

    PASSWORD(PasswordFragment.class),
    HELLO(HelloFragment.class),
    LOGIN(LoginFragment.class);

    private Class<? extends Fragment> mFragmentClass;


    IdentificationStep(Class<? extends Fragment> fragmentClass) {
        mFragmentClass = fragmentClass;
    }

    public Fragment createFragment() {
        try {
            return mFragmentClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
