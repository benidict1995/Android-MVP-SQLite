package com.dulce.benidict.android_mvpsqlite.presentation.register;

import android.widget.EditText;

import com.dulce.benidict.android_mvpsqlite.bases.BasePresenter;
import com.dulce.benidict.android_mvpsqlite.bases.BaseView;

/**
 * Created by benidict on 02/09/2017.
 */

@SuppressWarnings("WeakerAccess")
public interface RegisterContract {

    interface View extends BaseView<Presenter> {
        void showSuccessfulRegister(String message);
        void showErrorRegister(String message);
        void navigateTo();
    }

    interface Presenter extends BasePresenter {
        boolean validateRegisterFields(EditText[] fields);
    }

}
