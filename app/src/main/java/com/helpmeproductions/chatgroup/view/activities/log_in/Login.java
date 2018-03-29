package com.helpmeproductions.chatgroup.view.activities.log_in;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.helpmeproductions.chatgroup.R;
import com.helpmeproductions.chatgroup.view.injection.log_in.DaggerLoginComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements View.OnClickListener,LoginContract.View {

    @Inject
    LoginPresenter presenter;

    private static final String TAG = "Credentials";

    //TextView and EditView bindings/inits
    @BindView(R.id.et_user) EditText etUser;
    @BindView(R.id.et_password) EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        DaggerLoginComponent.create().inject(this);
        presenter.addView(this);

        //butterknife instantiation
        ButterKnife.bind(this);



        //setting buttons --- creating user registration
        findViewById(R.id.signIn).setOnClickListener(this);
        findViewById(R.id.register).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.register) {
            presenter.createUserId(etUser.getText().toString(), etPassword.getText().toString(),this);
        } else if (i == R.id.signIn) {
            presenter.signIn(etUser.getText().toString(), etPassword.getText().toString(),this);
        }
    }


    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
