package com.dulce.benidict.android_mvpsqlite.presentation.login;

import android.widget.EditText;

import com.dulce.benidict.android_mvpsqlite.bases.BasePresenter;
import com.dulce.benidict.android_mvpsqlite.bases.BaseView;

/**
 * Created by benidict on 02/09/2017.
 */

@SuppressWarnings("WeakerAccess")
public interface LoginContract {

    interface View extends BaseView<Presenter>{
            void showSuccessfulMessage(String message);
            void showFailedMessage(String message);
            void navigateTo(String email);
    }

    interface Presenter extends BasePresenter{
            boolean validateLoginFields(EditText[] fields);
    }

}
