package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.util.EncryptUtil;
import com.bw.mvplibrary.base.BaseActivity;
import com.bw.mvplibrary.utils.Logger;
import com.bw.mvplibrary.utils.PwdAndEmail;
import com.bw.mvplibrary.utils.ToastUtils;

import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.internal.Utils;

public class RegisterActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "RegisterActivity";
    @BindView(R.id.et_name_register)
    EditText etNameRegister;
    @BindView(R.id.et_email_register)
    EditText etEmailRegister;
    @BindView(R.id.et_pwd_register)
    EditText etPwdRegister;
    @BindView(R.id.et_code_register)
    EditText etCodeRegister;

    @Override
    public void onSuccess(Object obj) {
        RegisterBean registerBean = (RegisterBean) obj;
        if ("0000".equals(registerBean.getStatus())) {
            Logger.e(TAG,registerBean.getMessage());
            ToastUtils.init(this);
            ToastUtils.show(registerBean.getMessage());
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {
            ToastUtils.init(this);
            ToastUtils.show(registerBean.getMessage());
        }
    }

    @Override
    public void onSuccessFul(Object object) {
        CodeBean codeBean = (CodeBean) object;
        ToastUtils.init(this);
        ToastUtils.show(codeBean.getMessage());
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
        return R.layout.activity_register;
    }

    @OnClick({R.id.btn_code_register, R.id.tv_return_register, R.id.btn_register})
    public void onClick(View view) {
        String name = etNameRegister.getText().toString();
        String pwd = etPwdRegister.getText().toString();
        String email = etEmailRegister.getText().toString();
        String code = etCodeRegister.getText().toString();
        String encrypt = EncryptUtil.encrypt(pwd);
        switch (view.getId()) {
            case R.id.btn_code_register:
                presenter.doCode(email);
                break;
            case R.id.tv_return_register:
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_register:
                if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(pwd)&&!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(code)) {
                    presenter.doRegister(name,encrypt,email,code);
                }else {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
