package com.example.yack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MdSearch2Adpter extends RecyclerView.Adapter<MdSearch2Adpter.ViewHolder> {

    //일련번호
    private ArrayList<String> mlist = null;
    //품목명
    private ArrayList<String> mlist2 = null;
    //업체명
    private ArrayList<String> mlist3 = null;
    //이미지
    private ArrayList<Bitmap> mlist4 = null;

    Context mcontext;

    private int click_position = -1;

    private OnListItemSelectedInterface mListener = null;

    public interface OnListItemSelectedInterface {
        void onItemSelected(View v, int position);
    }

    public  void  setOnClickListener(OnListItemSelectedInterface listener){
        this.mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tv_md_name, tv_md_code, tv_md_comp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_md_name = itemView.findViewById(R.id.tv_md_name);
            tv_md_code= itemView.findViewById(R.id.tv_md_code);
            tv_md_comp = itemView.findViewById(R.id.tv_md_comp);
            imageView = itemView.findViewById(R.id.imgv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    click_position = getAdapterPosition();

                    mListener.onItemSelected(view,click_position);
                    Log.d("클릭", "클릭");
                }
            });
        }

    }

    MdSearch2Adpter(ArrayList<String> list, ArrayList<String> list2, ArrayList<String> list3, ArrayList<Bitmap> list4){

        mlist = list;
        mlist2 = list2;
        mlist3 = list3;
        mlist4 = list4;

        Log.d("받은부분", String.valueOf(mlist4));

    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.main_md_search_recycler_list,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String text = mlist.get(position);
        String text2 = mlist2.get(position);
        String text3 = mlist3.get(position);
        Bitmap bitmap = mlist4.get(position);

        holder.tv_md_name.setText(text2);
        holder.tv_md_code.setText(text);
        holder.tv_md_comp.setText(text3);
        holder.imageView.setImageBitmap(bitmap);

    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

}
