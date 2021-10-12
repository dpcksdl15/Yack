package com.example.yack.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FragmentMdPrice extends Fragment {

    MainActivity mainActivity;
    Bundle bundle;

    private RecyclerView recyclerView;

    private PriceAdapter priceAdapter;

    private RecyclerView.LayoutManager mlayoutManager;

    Menu menu;

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

        BottomNavigationView bottomNavigationView = mainActivity.findViewById(R.id.bottom_bar);

        menu = bottomNavigationView.getMenu();
        menu.findItem(R.id.md_search).setIcon(R.drawable.nv_bt_1_b);
        menu.findItem(R.id.md_search).setChecked(true);
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
        TextView rerset = view.findViewById(R.id.reset);

        Button bt_sum = view.findViewById(R.id.bt_sum);
        TextView tv_total = view.findViewById(R.id.tv_total);

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

        bt_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int total =0;
                int rest =0;
                int rest1 = 0;

                sqLiteDatabase = dbHelper.getReadableDatabase();


                String sql,sql2;

                sql = "SELECT * FROM searchdata;";
                Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

                while (cursor.moveToNext()) {
                    if (cursor.getString(5).equals("0") || cursor.getString(6).equals("0") || cursor.getString(7).equals("0")){
                        Toast.makeText(getActivity(), "복용관련 설정을 완료해주세요", Toast.LENGTH_SHORT).show();
                        break;
                    } else if (cursor.getString(5).equals("0") == false || cursor.getString(6).equals("0") == false || cursor.getString(7).equals("0") == false){

                        total = total + (Integer.parseInt(cursor.getString(3)) *Integer.parseInt(cursor.getString(5)) * Integer.parseInt(cursor.getString(6)) * Integer.parseInt(cursor.getString(7)));
                    }
                }

                sql2 = "SELECT * FROM searchdata order by count_day desc limit 1";

                Cursor cursor1 = sqLiteDatabase.rawQuery(sql2,null);

                while (cursor1.moveToNext()) {

                    switch (cursor1.getString(5)){

                        case "1" :
                            total = total+5290;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));
                            break;

                        case "2":
                            total = total+5490;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));
                            break;

                        case "3":
                            total = total+6040;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "4":
                            total = total+6340;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "5":
                            total = total+6710;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "6":
                            total = total+7010;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "7":
                            total = total+7450;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "8":
                            total = total+7650;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "9":
                            total = total+7880;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "10":
                            total = total+8220;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "11":
                            total = total+8490;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "12":
                            total = total+8750;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "13":
                            total = total+9010;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "14":
                            total = total+9860;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "15":
                            total = total+9980;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "16":
                            total = total+10700;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "17":
                            total = total+11050;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "18":
                            total = total+12430;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "19":
                            total = total+13460;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "20":
                            total = total+14270;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "21":
                            total = total+16400;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "22":
                            total = total+16850;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "23":
                            total = total+17240;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "24":
                            total = total+17620;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;

                        case "25":
                            total = total+18080;

                            rest = total%10;

                            total = total - rest;

                            total = (int) (total*0.3);

                            rest1 = total%100;

                            total = total - rest1;

                            tv_total.setText(String.valueOf(total));

                            break;
                    }
                }



            }
        });


        rerset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    sqLiteDatabase = dbHelper.getWritableDatabase();

                    String resetsql = "DELETE FROM searchdata;";

                    sqLiteDatabase.execSQL(resetsql);

                    list.clear();
                    list2.clear();
                    list3.clear();
                    list4.clear();
                    list5.clear();
                    list6.clear();
                    list7.clear();

                    count =0;
                    priceAdapter = new PriceAdapter(list, list2, list3, list4, list5, list6, list7);

                    recyclerView.setAdapter(priceAdapter);

                    priceAdapter.notifyDataSetChanged();

                } catch (Exception e){

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

            if (cursor.getCount() <= before_count){
                before_count = cursor.getCount();
            }


            if (cursor.getCount() > 0 && count == 0){

                Log.d("DataRefresh1","실행");

                before_count = cursor.getCount();

                while (cursor.moveToNext()) {
                    list.add(cursor.getString(0));
                    list2.add(cursor.getString(1));
                    list3.add(cursor.getString(2));
                    list4.add(cursor.getString(3));
                    list5.add(cursor.getString(5));
                    list6.add(cursor.getString(6));
                    list7.add(cursor.getString(7));
                }
                count = 1;

                mlayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(mlayoutManager);

                priceAdapter = new PriceAdapter(list, list2, list3, list4, list5, list6, list7);

                Log.d("DataRefresh1",String.valueOf(list.get(0)));
                Log.d("DataRefresh1",String.valueOf(before_count));

                recyclerView.setAdapter(priceAdapter);
                priceAdapter.notifyDataSetChanged();

            } else if (cursor.getCount() >= before_count && count == 1){

                Log.d("DataRefresh2","실행");

                sql2 = "SELECT * FROM searchdata ORDER BY save_time DESC LIMIT 1;";
                Cursor cursor2 = sqLiteDatabase.rawQuery(sql2,null);

                before_count = cursor.getCount();

                while (cursor2.moveToNext()) {
                    list.add(cursor2.getString(0));
                    list2.add(cursor2.getString(1));
                    list3.add(cursor2.getString(2));
                    list4.add(cursor2.getString(3));
                    list5.add(cursor2.getString(5));
                    list6.add(cursor2.getString(6));
                    list7.add(cursor2.getString(7));
                }

                mlayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(mlayoutManager);

                priceAdapter = new PriceAdapter(list, list2, list3, list4, list5, list6, list7);

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
