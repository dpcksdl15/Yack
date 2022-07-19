package com.eblue.yack;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {


    // vlaue값
    // 0:가입, 1:id확인, 2:로그인

    Button bt_login;
    EditText et_id;
//    EditText et_pw;

    String value = "2";
    String value_id = null, value_pw = null;

    //결과값 리턴
    String result, rs;

    CheckBox ckb_autologin;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_id);
//        et_pw = findViewById(R.id.et_pw);
        bt_login = findViewById(R.id.bt_login);
        ckb_autologin = findViewById(R.id.ckb_autologin);


        //입력감지
        et_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                value_id = et_id.getText().toString();
//                value_pw = et_pw.getText().toString();

                if (value_id.length() != 0){
                    bt_login.setBackgroundResource(R.drawable.background_login_button_b);
                    bt_login.setTextColor(R.color.white);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//        et_pw.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                value_id = et_id.getText().toString();
//                value_pw = et_pw.getText().toString();
//
//                if (value_id.length() != 0 && value_pw.length() != 0){
//                    bt_login.setBackgroundResource(R.drawable.background_login_button_b);
//                    bt_login.setTextColor(R.color.black);
//                } else {
//                    bt_login.setBackgroundResource(R.drawable.background_login_button);
//                    bt_login.setTextColor(R.color.black);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//
//            }
//        });

        //로그인 버튼 클릭
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    value_id = et_id.getText().toString();
//                    value_pw = et_pw.getText().toString();

                    ServerRegisterActivity task = new ServerRegisterActivity();
                    result = task.execute(value, value_id).get();
                    rs = result.trim();
                    String[] userData = rs.split("/");

                    if (rs.equals("0")){
                        Toast.makeText(getApplicationContext(),"아이디를 확인해주세요.",Toast.LENGTH_SHORT).show();

                    } else if (userData[0].equals("1")){

                        //기존 메인뷰 삭제
                        FirstMainActivity firstMainActivity = (FirstMainActivity) FirstMainActivity.firstmain;
                        firstMainActivity.finish();

                        Toast.makeText(getApplicationContext(),"로그인이 되었습니다.",Toast.LENGTH_SHORT).show();

                        if (ckb_autologin.isChecked() == true) {
                            sharedPreferences = getSharedPreferences("LoginUserinfo", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putString("login", "1");
                            editor.putString("pid", value_id);
                            editor.putString("user_nm", userData[2]);


                            editor.commit();

                        } else if (ckb_autologin.isChecked() == false){
                            sharedPreferences = getSharedPreferences("LoginUserinfo", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            Log.d("MemberInfoDBUplode2", userData[1]);

                            editor.putString("login", "0");
                            editor.putString("pid", value_id);
                            editor.putString("user_nm", userData[2]);

                            editor.commit();
                        }

                        Intent intent = new Intent(getApplicationContext(), FirstMainActivity.class);
                        intent.putExtra("loginvalue", 1);
                        startActivity(intent);
                        finish();
                    }

                } catch (Exception e){
                    Log.d("MemberInfoDBUplode", ".....ERROR.....!");
                }

            }
        });

    }
}