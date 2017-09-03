package com.dulce.benidict.android_mvpsqlite.presentation.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;

import com.dulce.benidict.android_mvpsqlite.R;
import com.dulce.benidict.android_mvpsqlite.data.sqlite.SqliteController;

/**
 * Created by benidict on 02/09/2017.
 */

@SuppressWarnings("WeakerAccess")
public class LoginPresenter implements LoginContract.Presenter{

    @NonNull LoginContract.View mView;
    Context mContext;
    String email, pass;
    SqliteController sqliteController;

    public LoginPresenter(@NonNull LoginContract.View view, Context context){
        mView = view;
        mView.setPresenter(this);
        mContext = context;
        sqliteController = new SqliteController(context);
    }

    /**
     * This method check the if the fields are null or not and return boolean value.
     * @param fields this param carrier the EditText Object.
     * @return true/false
     **/
    @Override
    public boolean validateLoginFields(EditText[] fields) {
        for (EditText field: fields){
            if (field.getText().toString().isEmpty()){
                field.setError("Provide the required field!");
                return false;
            }
        }
        validated(fields);
        return true;
    }

    private void validated(EditText[] fields){
        email = fields[0].getText().toString();
        pass = fields[1].getText().toString();
        checkCredentials(email, pass);
    }

    /**
     * This method check if user exist or not.
     * @param email this param carrier the email value
     * @param pass this param carrier the password value
    **/
    private void checkCredentials(String email, String pass){
       if (sqliteController.checkUserCredentials(email, pass)){
           mView.showSuccessfulMessage(mContext.getString(R.string.success_valid_email_password));
           mView.navigateTo(email);
       }else{
           mView.showFailedMessage(mContext.getString(R.string.error_valid_email_password));
       }
    }

    @Override
    public void start() {}

}
