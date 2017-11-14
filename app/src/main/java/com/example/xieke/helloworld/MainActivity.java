package com.example.xieke.helloworld;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.user_name)  //用户名
    EditText userNameEditText;

    @BindView(R.id.password)  //密码
    EditText passwordEditText;

    @BindView(R.id.phone_number)  //手机号码
    EditText phoneEditText;

    @BindView(R.id.text_verification_code)  //图片验证码
    EditText verificationCodeEditText;

    @BindView(R.id.image_verification_code) //验证码图片
    ImageView verificationCodeImageView;

    @BindView(R.id.text_sms_code)  //短信验证码
    EditText smsCodeEditText;

    @BindView(R.id.button_sms_code)  //获取短信验证码按钮
    Button smsCodeButton;

    @BindView(R.id.viewpager_login)
    ViewPager loginViewPager;
//    ViewPager loginViewPager = (ViewPager) findViewById(R.id.viewpager_login);

    private List<View> viewList = new ArrayList<View>();

    private LoginPagerAdapter loginPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        viewList.add(getLayoutInflater().inflate(R.layout.normal_login, null));
        viewList.add(getLayoutInflater().inflate(R.layout.quick_login, null));

        loginPagerAdapter = new LoginPagerAdapter(viewList);
        loginViewPager.setAdapter(loginPagerAdapter);
    }

    private void initView() {
        ButterKnife.bind(this);
    }
}
