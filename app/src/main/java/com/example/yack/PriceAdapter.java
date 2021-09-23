package com.example.yack;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


    public PriceAdapter(ArrayList<String> list, ArrayList<String> list2, ArrayList<String> list3, ArrayList<String> list4){
        mlist = list;
        mlist2 = list2;
        mlist3 = list3;
        mlist4 = list4;

        Log.d("받은부분", String.valueOf(mlist));
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name_code, tv_stdday, tv_price, tv_lis, tv_notlis;
        Spinner sp_md_days, sp_md_day_count, sp_md_count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name_code = itemView.findViewById(R.id.tv_name_code);
            tv_stdday = itemView.findViewById(R.id.tv_stdday);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_lis = itemView.findViewById(R.id.tv_lis);
            tv_notlis = itemView.findViewById(R.id.tv_notlis);
            sp_md_days = itemView.findViewById(R.id.sp_md_days);
            sp_md_day_count = itemView.findViewById(R.id.sp_md_day_count);
            sp_md_count = itemView.findViewById(R.id.sp_md_count);

        }
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

        String text = mlist.get(position) + mlist2.get(position);
        String text2 = mlist3.get(position);
        String text3 = mlist4.get(position);


        holder.tv_name_code.setText(text);
        holder.tv_stdday.setText(text2);
        holder.tv_price.setText(text3);


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
