package com.dulce.benidict.android_mvpsqlite.presentation.register;

import android.content.Intent;
import android.widget.EditText;

import com.dulce.benidict.android_mvpsqlite.NavigationUtils;
import com.dulce.benidict.android_mvpsqlite.R;
import com.dulce.benidict.android_mvpsqlite.bases.BaseActivity;
import com.dulce.benidict.android_mvpsqlite.presentation.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benidict on 02/09/2017.
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.View{

    @BindView(R.id.reg_first_name) EditText reg_first_name;
    @BindView(R.id.reg_last_name) EditText reg_last_name;
    @BindView(R.id.reg_address) EditText reg_address;
    @BindView(R.id.reg_phone_num) EditText reg_phone_num;
    @BindView(R.id.reg_email_address) EditText reg_email_address;
    @BindView(R.id.reg_password) EditText reg_password;
    RegisterContract.Presenter mPresenter;
    RegisterPresenter registerPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @OnClick(R.id.btn_submit)
    public void submitClicked(){
        mPresenter.validateRegisterFields(new EditText[]{reg_first_name, reg_last_name, reg_address, reg_phone_num,
                reg_email_address, reg_password});
    }


    @Override
    public void showSuccessfulRegister(String message) {
        showMessageToast(message);
        navigateTo();
    }

    @Override
    public void showErrorRegister(String message) {
        showMessageToast(message);
    }

    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }


    @Override
    public void navigateTo() {
        NavigationUtils.startActivity(this, LoginActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerPresenter = new RegisterPresenter(this, this);
        mPresenter.start();
    }
}
