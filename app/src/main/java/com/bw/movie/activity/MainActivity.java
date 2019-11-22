package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.util.EncryptUtil;
import com.bw.mvplibrary.base.BaseActivity;
import com.bw.mvplibrary.utils.Logger;
import com.bw.mvplibrary.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "MainActivity";
    @BindView(R.id.et_email_login)
    EditText etEmailLogin;
    @BindView(R.id.et_pwd_login)
    EditText etPwdLogin;
    @BindView(R.id.check_box)
    CheckBox checkBox;

    @Override
    public void onSuccess(Object obj) {
        LoginBean loginBean = (LoginBean) obj;
        Logger.e(TAG, loginBean.getMessage());
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        if (checkBox.isChecked()){
            sp.edit()
                    .putInt("code", 1)
                    .putString("phone", etEmailLogin.getText().toString())
                    .putString("pwd", etPwdLogin.getText().toString())
                    .commit();
        }else{
            sp.edit()
                    .putInt("code", 0)
                    .commit();
        }
        if ("0000".equals(loginBean.getStatus())) {
            ToastUtils.init(this);
            ToastUtils.show(loginBean.getMessage());
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            startActivity(intent);
            SharedPreferences login = getSharedPreferences("login", MODE_PRIVATE);
            SharedPreferences.Editor edit = login.edit();
            edit.putString("userId",loginBean.getResult().getUserId());
            edit.putString("sessionId",loginBean.getResult().getSessionId());
            edit.commit();
        } else {
            ToastUtils.init(this);
            ToastUtils.show(loginBean.getMessage());
        }
    }

    @Override
    public void onSuccessFul(Object object) {

    }

    @Override
    public void onNowSuccess(Object now) {

    }

    @Override
    public void onAfterSuccess(Object after) {

    }

    @Override
    public void onFail(String str) {

    }

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.tv_register, R.id.btn_login,R.id.check_box})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                String email = etEmailLogin.getText().toString();
                String pwd = etPwdLogin.getText().toString();
                String encrypt = EncryptUtil.encrypt(pwd);
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pwd)) {
                    presenter.doLogin(email, encrypt);
                } else {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.check_box:

                break;
        }
    }

    @Override
    protected void initData() {
        super.initData();
        //记住邮箱与密码
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        int code = sp.getInt("code", 0);
        String phone = sp.getString("phone", null);
        String pwd = sp.getString("pwd", null);
        if (code==1){
            etEmailLogin.setText(phone);
            etPwdLogin.setText(pwd);
            checkBox.setChecked(true);
        }else if (code==0){
            etEmailLogin.setText("");
            etPwdLogin.setText("");
            checkBox.setChecked(false);
        }
        etPwdLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().contains(" ")) {
                    String[] str = s.toString().split(" ");
                    String str1 = "";
                    for (int i = 0; i < str.length; i++) {
                        str1 += str[i];
                    }
                    etPwdLogin.setText(str1);
                    etPwdLogin.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etEmailLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().contains(" ")) {
                    String[] str = s.toString().split(" ");
                    String str1 = "";
                    for (int i = 0; i < str.length; i++) {
                        str1 += str[i];
                    }
                    etEmailLogin.setText(str1);
                    etEmailLogin.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
