package com.example.yack.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yack.MainActivity;
import com.example.yack.MdPriceResultActivity;
import com.example.yack.R;

public class FragmentMdPrice extends Fragment {

    MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //현재 소속된 액티비티를 메인 액티비티로 한다.
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_md_price,null);

        Button bt_search = view.findViewById(R.id.bt_search);
        EditText et_md_search_name = view.findViewById(R.id.et_md_search_name);

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_md_search_name.getText().toString().equals("")){

                    Toast.makeText(getActivity(), "검색어를 입력해 주세요", Toast.LENGTH_LONG).show();

                } else {

                    Intent intent = new Intent(getActivity(), MdPriceResultActivity.class);

                    intent.putExtra("md_name", et_md_search_name.getText().toString());

                    startActivity(intent);
                }
            }
        });


        return view;


    }
}
