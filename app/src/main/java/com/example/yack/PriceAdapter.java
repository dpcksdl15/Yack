package com.example.yack;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.ViewHolder> {

    //name
    private ArrayList<String> mlist = null;
    //code
    private ArrayList<String> mlist2 = null;
    //stdday
    private ArrayList<String> mlist3 = null;
    //price
    private ArrayList<String> mlist4 = null;

    String[] days_count = {"복용일수", "1일", "2일", "3일", "4일", "5일", "6일", "7일", "8일", "9일", "10일", "11일", "12일", "13일", "14일", "15일", "16일", "17일", "18일", "19일", "20일", "21일", "22일", "23일", "24일", "25일", "26일", "27일", "28일", "29일", "30일", "30일"};
    String[] oneday_count = {"하루복용횟수","1회","2회","3회"};
    String[] onetime_count = {"1회투여량","1알","2알","3알","4알","5알","6알","7알","8알","9알","10알"};

    ArrayAdapter<String> list_adpter;
    ArrayAdapter<String> list2_adpter;
    ArrayAdapter<String> list3_adpter;

    public PriceAdapter(ArrayList<String> list, ArrayList<String> list2, ArrayList<String> list3, ArrayList<String> list4){
        mlist = list;
        mlist2 = list2;
        mlist3 = list3;
        mlist4 = list4;

        Log.d("받은부분", String.valueOf(mlist));
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name,tv_code, tv_stdday, tv_price, tv_lis, tv_notlis;
        Spinner sp_md_days, sp_md_day_count, sp_md_count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_code = itemView.findViewById(R.id.tv_code);
            tv_stdday = itemView.findViewById(R.id.tv_stdday);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_lis = itemView.findViewById(R.id.tv_lis);
            tv_notlis = itemView.findViewById(R.id.tv_notlis);
            sp_md_days = itemView.findViewById(R.id.sp_md_days);
            sp_md_day_count = itemView.findViewById(R.id.sp_md_day_count);
            sp_md_count = itemView.findViewById(R.id.sp_md_count);

            list_adpter  = new ArrayAdapter<String>(itemView.getContext(), R.layout.custom_spiner_item,days_count);
            list2_adpter  = new ArrayAdapter<String>(itemView.getContext(), R.layout.custom_spiner_item,oneday_count);
            list3_adpter  = new ArrayAdapter<String>(itemView.getContext(), R.layout.custom_spiner_item,onetime_count);

            list_adpter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            list2_adpter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            list3_adpter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);


            sp_md_days.setAdapter(list_adpter);
            sp_md_day_count.setAdapter(list2_adpter);
            sp_md_count.setAdapter(list3_adpter);


        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_md_price_recycler_list, parent,false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String text = mlist.get(position);
        String text1 = mlist2.get(position);
        String text2 = mlist3.get(position);
        String text3 = mlist4.get(position);


        holder.tv_name.setText(text);
        holder.tv_code.setText(text1);
        holder.tv_stdday.setText(text2);
        holder.tv_price.setText(text3);

        holder.sp_md_days.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                holder.sp_md_days.setSelection(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
