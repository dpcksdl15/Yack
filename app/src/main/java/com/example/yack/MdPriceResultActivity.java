package com.example.yack;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.yack.R;

public class MdPriceResultActivity extends AppCompatActivity {

    ImageView bt_back_icon, bt_cancel_icon;

    EditText et_search_text;

    View.OnClickListener cl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.md_price_result_activity);

        bt_back_icon = findViewById(R.id.bt_back_icon);
        bt_cancel_icon = findViewById(R.id.bt_textcancel_icon);

        et_search_text = findViewById(R.id.et_search_text);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){

                    // 검색부분
                    case R.id.bt_back_icon:
                        finish();
                        break;

                    case R.id.bt_textcancel_icon:
                        et_search_text.setText("");
                        et_search_text.requestFocus();
                        InputMethodManager imm = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                            imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        }
                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                        break;




                }

            }
        };

        bt_back_icon.setOnClickListener(cl);
        bt_cancel_icon.setOnClickListener(cl);


    }
}
