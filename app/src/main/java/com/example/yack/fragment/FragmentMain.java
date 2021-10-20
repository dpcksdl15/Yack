package com.example.yack.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yack.MainActivity;
import com.example.yack.MdSearchActivity;
import com.example.yack.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentMain extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_main, null);

        ImageButton ibt_md_price_search = view.findViewById(R.id.bt_md_price_search);
        ImageButton bt_md_search = view.findViewById(R.id.bt_md_search);
        ImageButton ph_sell_search = view.findViewById(R.id.ph_sell_search);
        ImageButton pt_ht_search = view.findViewById(R.id.pt_ht_search);
        ImageButton ph_pt_community = view.findViewById(R.id.ph_pt_community);
        ImageButton mypage = view.findViewById(R.id.mypage);

        ibt_md_price_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainActivity.onFragmentChange(1);

            }
        });

        bt_md_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MdSearchActivity.class);
                startActivity(intent);

            }
        });

        ph_sell_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "추후 오픈될 예정입니다", Toast.LENGTH_SHORT).show();
            }
        });

        pt_ht_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "추후 오픈될 예정입니다", Toast.LENGTH_SHORT).show();
            }
        });

        ph_pt_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "추후 오픈될 예정입니다", Toast.LENGTH_SHORT).show();
            }
        });

        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "추후 오픈될 예정입니다", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
