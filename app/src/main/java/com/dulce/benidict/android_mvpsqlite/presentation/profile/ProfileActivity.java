package com.dulce.benidict.android_mvpsqlite.presentation.profile;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dulce.benidict.android_mvpsqlite.NavigationUtils;
import com.dulce.benidict.android_mvpsqlite.R;
import com.dulce.benidict.android_mvpsqlite.bases.BaseActivity;
import com.dulce.benidict.android_mvpsqlite.data.model.User;
import com.dulce.benidict.android_mvpsqlite.presentation.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benidict on 03/09/2017.
 */

public class ProfileActivity extends BaseActivity implements ProfileContract.View{


    @BindView(R.id.et_edit_fname) EditText et_edit_fname;
    @BindView(R.id.et_edit_lname) EditText et_edit_lname;
    @BindView(R.id.et_edit_address) EditText et_edit_address;
    @BindView(R.id.et_edit_email) EditText et_edit_email;
    @BindView(R.id.et_edit_phone) EditText et_edit_phone;
    @BindView(R.id.et_edit_password) EditText et_edit_password;
    @BindView(R.id.tv_fname) TextView tv_fname;
    ProfileContract.Presenter mPresenter;
    ProfilePresenter profilePresenter;
    String de_fname, de_lname, de_address, de_phone, de_email, de_password, email;
    int de_id;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @OnClick({R.id.btn_edit, R.id.btn_delete, R.id.btn_logout})
    public void buttonClicked(View v){
        switch (v.getId()){
            case R.id.btn_edit:
                profilePresenter.validateUpdateFields(new EditText[]{et_edit_fname, et_edit_lname, et_edit_address,
                        et_edit_phone, et_edit_email, et_edit_password});
                break;
            case R.id.btn_delete:
                profilePresenter.deleteAccountPermanent(de_email);
                break;
            case R.id.btn_logout:
                profilePresenter.logOut(email);
                break;
        }
    }

    @Override
    public void loadUserDetail(User user) {
        de_id = user.getUser_id();
        de_fname = user.getUser_fname();
        de_lname = user.getUser_lname();
        de_address = user.getUser_address();
        de_phone = user.getUser_phone();
        de_email = user.getUser_email();
        de_password = user.getUser_password();

        if (de_fname!=null){
            setData();
        }
    }

    private void setData(){
        et_edit_fname.setText(de_fname);
        et_edit_lname.setText(de_lname);
        et_edit_address.setText(de_address);
        et_edit_phone.setText(de_phone);
        et_edit_email.setText(de_email);
        et_edit_password.setText(de_password);

        tv_fname.setText(de_fname);
    }

    @Override
    public void showSuccess(String message) {
        showMessageToast(message);
    }

    @Override
    public void showFailed(String message) {
        showMessageToast(message);
    }

    @Override
    public void navigateToNextPage() {
        NavigationUtils.startActivity(this,
                LoginActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    public void refreshPage(String email) {
        profilePresenter = new ProfilePresenter(this, this);
        profilePresenter.getUserEmail(email);
    }

    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }

    @Override
    public void logOut() {
        NavigationUtils.startActivity(this,
                LoginActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        email = getIntent().getStringExtra("detailWrapper");
        profilePresenter = new ProfilePresenter(this, this);
        profilePresenter.getUserEmail(email);
    }
}
