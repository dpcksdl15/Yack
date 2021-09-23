package com.example.yack.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yack.DBHelper;
import com.example.yack.MainActivity;
import com.example.yack.MdPriceResultActivity;
import com.example.yack.PriceAdapter;
import com.example.yack.R;

import java.util.ArrayList;

public class FragmentMdPrice extends Fragment {

    MainActivity mainActivity;
    Bundle bundle;

    private RecyclerView recyclerView;

    private PriceAdapter priceAdapter;

    private RecyclerView.LayoutManager mlayoutManager;

    SQLiteDatabase sqLiteDatabase;

    DBHelper dbHelper;

    String name, code, stdday, price;

    TextView tv_count;

    int before_count = 0;
    int count = 0;

    //name
    private ArrayList<String> list = new ArrayList<>();
    //code
    private ArrayList<String> list2 = new ArrayList<>();
    //stdday
    private ArrayList<String> list3 = new ArrayList<>();
    //price
    private ArrayList<String> list4 = new ArrayList<>();
    //day count
    private ArrayList<String> list5 = new ArrayList<>();
    //1day time count
    private ArrayList<String> list6 = new ArrayList<>();
    //1time unit count
    private ArrayList<String> list7 = new ArrayList<>();
    //Insurance or not Insurance
    private ArrayList<String> list8 = new ArrayList<>();


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

    @Override
    public void onStart() {
        super.onStart();
    }




    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_md_price, container ,false);

        Button bt_search = view.findViewById(R.id.bt_search);
        EditText et_md_search_name = view.findViewById(R.id.et_md_search_name);
        tv_count = view.findViewById(R.id.tv_count);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview2);

        dbHelper = new DBHelper(getContext(),"MdDB",null,1);

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



    @Override
    public void onResume() {
        super.onResume();
        Log.d("다시 실행","싫행");

        DataRefresh();
    }

    public void DataRefresh(){

        Log.d("다시 실행","DB받기");

        try {
            sqLiteDatabase = dbHelper.getReadableDatabase();

            String sql, sql2;

            sql = "SELECT * FROM searchdata;";
            Cursor cursor = sqLiteDatabase.rawQuery(sql,null);



            if (cursor.getCount() > 0 && count == 0){

                Log.d("DataRefresh1","실행");

                before_count = cursor.getCount();

                while (cursor.moveToNext()) {
                    list.add(cursor.getString(0));
                    list2.add(cursor.getString(1));
                    list3.add(cursor.getString(2));
                    list4.add(cursor.getString(3));
                }
                count = 1;

                mlayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(mlayoutManager);

                priceAdapter = new PriceAdapter(list, list2, list3, list4);

                Log.d("DataRefresh1",String.valueOf(list.get(0)));
                Log.d("DataRefresh1",String.valueOf(before_count));

                recyclerView.setAdapter(priceAdapter);
                priceAdapter.notifyDataSetChanged();

            } else if (cursor.getCount() > before_count && count == 1){

                Log.d("DataRefresh2","실행");

                sql2 = "SELECT * FROM searchdata ORDER BY save_time DESC LIMIT 1;";
                Cursor cursor2 = sqLiteDatabase.rawQuery(sql2,null);

                before_count = cursor.getCount();

                while (cursor2.moveToNext()) {
                    list.add(cursor2.getString(0));
                    list2.add(cursor2.getString(1));
                    list3.add(cursor2.getString(2));
                    list4.add(cursor2.getString(3));
                }

                mlayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(mlayoutManager);

                priceAdapter = new PriceAdapter(list, list2, list3, list4);

                Log.d("DataRefresh2",String.valueOf(cursor2.getString(0)));
                Log.d("DataRefresh2",String.valueOf(before_count));

                recyclerView.setAdapter(priceAdapter);
                priceAdapter.notifyItemChanged(before_count);

            }

            tv_count.setText("총 " + before_count +"개");
            Log.d("다시 실행","싫행 종료");


        } catch (Exception e){

        }



    }


}
