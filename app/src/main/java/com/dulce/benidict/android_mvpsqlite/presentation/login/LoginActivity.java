package com.dulce.benidict.android_mvpsqlite.presentation.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dulce.benidict.android_mvpsqlite.NavigationUtils;
import com.dulce.benidict.android_mvpsqlite.R;
import com.dulce.benidict.android_mvpsqlite.bases.BaseActivity;
import com.dulce.benidict.android_mvpsqlite.presentation.custom.UnderLineText;
import com.dulce.benidict.android_mvpsqlite.presentation.profile.ProfileActivity;
import com.dulce.benidict.android_mvpsqlite.presentation.register.RegisterActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benidict on 02/09/2017.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View{

    @BindView(R.id.et_email_address) EditText et_email;
    @BindView(R.id.et_password) EditText et_pass;
    @BindView(R.id.btn_register) TextView btn_register;
    LoginContract.Presenter mPresenter;
    LoginPresenter loginPresenter;

    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setView() {
        super.setView();
        new UnderLineText(btn_register);
    }

    @OnClick({R.id.btn_register, R.id.btn_login})
    public void buttonClicked(View v){
        switch (v.getId()){
            case R.id.btn_login:
                loginPresenter.validateLoginFields(new EditText[]{et_email, et_pass});
                break;
            case R.id.btn_register:
                NavigationUtils.startActivity(this,
                        RegisterActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
        }
    }

    @Override
    public void showSuccessfulMessage(String message) {
        showMessageToast(message);
    }

    @Override
    public void showFailedMessage(String message) {
        showMessageToast(message);
    }

    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }

    @Override
    public void navigateTo(String email) {
        NavigationUtils.startActivity(this,
                ProfileActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP,
                email);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter = new LoginPresenter(this, this);
    }
}
