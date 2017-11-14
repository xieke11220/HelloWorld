package com.example.xieke.helloworld;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

//    @Bind(R.id.user_name)  //用户名
    AutoCompleteTextView userNameText;

//    @Bind(R.id.password)  //密码
    EditText passwordEditText;

//    @Bind(R.id.phone_number)  //手机号码
    EditText phoneEditText;

//    @Bind(R.id.text_verification_code)  //图片验证码
    EditText verificationCodeEditText;

//    @Bind(R.id.image_verification_code) //验证码图片
    ImageView verificationCodeImageView;

//    @Bind(R.id.text_sms_code)  //短信验证码
    EditText smsCodeEditText;

//    @Bind(R.id.button_sms_code)  //获取短信验证码按钮
    Button smsCodeButton;

//    @Bind(R.id.viewpager_login) //viewpager不能用bindview，要报错
    ViewPager loginViewPager;
//    ViewPager loginViewPager = (ViewPager) findViewById(R.id.viewpager_login);

//    @Bind(R.id.login_tab)
    TabLayout tabLayout;

    private List<View> viewList = new ArrayList<View>();

    private LoginPagerAdapter loginPagerAdapter;

    private String[] tabTitle = {"登录", "快捷登录"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ViewPager loginViewPager = (ViewPager) findViewById(R.id.viewpager_login);
        initView();

        viewList.add(getLayoutInflater().inflate(R.layout.normal_login, null));
        viewList.add(getLayoutInflater().inflate(R.layout.quick_login, null));

        loginPagerAdapter = new LoginPagerAdapter(viewList, tabTitle);
        loginViewPager.setAdapter(loginPagerAdapter);
        tabLayout.setupWithViewPager(loginViewPager);
    }

    private void initView() {
        userNameText = (AutoCompleteTextView) findViewById(R.id.user_name);
        passwordEditText = (EditText) findViewById(R.id.password);
        phoneEditText = (EditText) findViewById(R.id.phone_number);
        verificationCodeEditText = (EditText) findViewById(R.id.text_verification_code);
        verificationCodeImageView = (ImageView) findViewById(R.id.image_verification_code);
        smsCodeEditText = (EditText) findViewById(R.id.text_sms_code);
        smsCodeButton = (Button) findViewById(R.id.button_sms_code);
        loginViewPager = (ViewPager) findViewById(R.id.viewpager_login);
        tabLayout = (TabLayout) findViewById(R.id.login_tab);

        tabLayout.setTabMode(TabLayout.MODE_FIXED); //tab多的时候不能滑动
        tabLayout.addTab(tabLayout.newTab().setText(tabTitle[0]));
        tabLayout.addTab(tabLayout.newTab().setText(tabTitle[1]));
    }
}
