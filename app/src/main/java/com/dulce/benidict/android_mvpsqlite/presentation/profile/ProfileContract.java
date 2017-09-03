package com.dulce.benidict.android_mvpsqlite.presentation.profile;

import android.widget.EditText;

import com.dulce.benidict.android_mvpsqlite.bases.BasePresenter;
import com.dulce.benidict.android_mvpsqlite.bases.BaseView;
import com.dulce.benidict.android_mvpsqlite.data.model.User;

/**
 * Created by benidict on 03/09/2017.
 */

public interface ProfileContract {

    interface View extends BaseView<Presenter>{
        void loadUserDetail(User user);
        void showSuccess(String message);
        void showFailed(String message);
        void navigateToNextPage();
        void refreshPage(String email);
        void logOut();
    }

    interface Presenter extends BasePresenter{
        void getUserEmail(String email);
        void logOut(String email);
        void getUserDetail(User user);
        void deleteAccountPermanent(String email);
        boolean validateUpdateFields(EditText[] fields);
    }
}
