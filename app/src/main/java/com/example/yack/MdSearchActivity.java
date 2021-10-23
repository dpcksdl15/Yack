package com.example.yack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MdSearchActivity extends AppCompatActivity {

    EditText et_search_char;

    LinearLayout ll_cycler, ll_cycler2, ll_cycler3, ll_triangle, ll_rectangle, ll_rectangle2, ll_rectangle3, ll_polygon, ll_polygon2, ll_polygon3, ll_dubleovelr;
    LinearLayout ll_white, ll_yellow, ll_orenge, ll_magenta, ll_red, ll_brown, ll_green1, ll_green2, ll_blue1, ll_blue2, ll_blue3, ll_puple1, ll_puple2;
    LinearLayout ll_gray, ll_black, ll_trans, ll_type1, ll_type2, ll_type3, ll_non, ll_miner, ll_plus, ll_etc;

    Button bt_search;

    View.OnClickListener cl;

    private ArrayList<String> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_search);


        et_search_char = findViewById(R.id.et_search_char);

        ll_cycler = findViewById(R.id.ll_cycler);
        ll_cycler2 = findViewById(R.id.ll_cycler2);
        ll_cycler3 = findViewById(R.id.ll_cycler3);
        ll_triangle = findViewById(R.id.ll_triangle);
        ll_rectangle = findViewById(R.id.ll_rectangle);
        ll_rectangle2 = findViewById(R.id.ll_rectangle2);
        ll_rectangle3 = findViewById(R.id.ll_rectangle3);
        ll_polygon = findViewById(R.id.ll_polygon);
        ll_polygon2 = findViewById(R.id.ll_polygon2);
        ll_polygon3 = findViewById(R.id.ll_polygon3);
        ll_dubleovelr = findViewById(R.id.ll_dubleovelr);
        ll_white = findViewById(R.id.ll_white);
        ll_yellow = findViewById(R.id.ll_yellow);
        ll_orenge = findViewById(R.id.ll_orenge);
        ll_magenta = findViewById(R.id.ll_magenta);
        ll_red = findViewById(R.id.ll_red);
        ll_brown = findViewById(R.id.ll_brown);
        ll_green1 = findViewById(R.id.ll_green1);
        ll_green2 = findViewById(R.id.ll_green2);
        ll_blue1 = findViewById(R.id.ll_blue1);
        ll_blue2 = findViewById(R.id.ll_blue2);
        ll_blue3 = findViewById(R.id.ll_blue3);
        ll_puple1 = findViewById(R.id.ll_puple1);
        ll_puple2 = findViewById(R.id.ll_puple2);
        ll_gray = findViewById(R.id.ll_gray);
        ll_black = findViewById(R.id.ll_black);
        ll_trans = findViewById(R.id.ll_trans);
        ll_type1 = findViewById(R.id.ll_type1);
        ll_type2 = findViewById(R.id.ll_type2);
        ll_type3 = findViewById(R.id.ll_type3);
        ll_non = findViewById(R.id.ll_non);
        ll_miner = findViewById(R.id.ll_miner);
        ll_plus = findViewById(R.id.ll_plus);
        ll_etc = findViewById(R.id.ll_etc);

        bt_search = findViewById(R.id.bt_search);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){

                    case R.id.ll_cycler :
                        ll_cycler.setBackgroundResource(R.drawable.ll_type2);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type);

                        list.add(1,"원형");
                        break;
                    case R.id.ll_cycler2:
                        ll_cycler.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type2);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type);

                        list.add(1,"타원형");

                        break;
                    case R.id.ll_cycler3:
                        ll_cycler.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type2);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type);

                        list.add(1,"반원형");

                        break;
                    case R.id.ll_triangle:
                        ll_cycler.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type2);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type);

                        list.add(1,"삼각형");

                        break;
                    case R.id.ll_rectangle:
                        ll_cycler.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type2);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type);

                        list.add(1,"사각형");

                        break;
                    case R.id.ll_rectangle2:
                        ll_cycler.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type2);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type);

                        list.add(1,"마름모형");

                        break;
                    case R.id.ll_rectangle3:
                        ll_cycler.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type2);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type);

                        list.add(1,"장방형");

                        break;
                    case R.id.ll_polygon:
                        ll_cycler.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type2);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type);

                        list.add(1,"오각형");

                        break;
                    case R.id.ll_polygon2:
                        ll_cycler.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type2);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type);

                        list.add(1,"육각형");

                        break;
                    case R.id.ll_polygon3:
                        ll_cycler.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type2);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type);

                        list.add(1,"팔각형");

                        break;
                    case R.id.ll_dubleovelr:
                        ll_cycler.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler2.setBackgroundResource(R.drawable.ll_type);
                        ll_cycler3.setBackgroundResource(R.drawable.ll_type);
                        ll_triangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle2.setBackgroundResource(R.drawable.ll_type);
                        ll_rectangle3.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon2.setBackgroundResource(R.drawable.ll_type);
                        ll_polygon3.setBackgroundResource(R.drawable.ll_type);
                        ll_dubleovelr.setBackgroundResource(R.drawable.ll_type2);

                        list.add(1,"기타");

                        break;
                    case R.id.ll_white:
                        ll_white.setBackgroundResource(R.drawable.ll_type2);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"하양");

                        break;
                    case R.id.ll_yellow:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type2);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"노랑");

                        break;
                    case R.id.ll_orenge:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type2);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"주황");

                        break;
                    case R.id.ll_magenta:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type2);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"분홍");

                        break;
                    case R.id.ll_red:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type2);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"빨강");

                        break;
                    case R.id.ll_brown:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type2);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"갈색");

                        break;
                    case R.id.ll_green1:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type2);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"연두");

                        break;
                    case R.id.ll_green2:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type2);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"초록");

                        break;
                    case R.id.ll_blue1:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type2);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"청록");

                        break;
                    case R.id.ll_blue2:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type2);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"파랑");

                        break;
                    case R.id.ll_blue3:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type2);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"남색");

                        break;
                    case R.id.ll_puple1:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type2);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"자주");

                        break;
                    case R.id.ll_puple2:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type2);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"보라");

                        break;
                    case R.id.ll_gray:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type2);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"회색");

                        break;
                    case R.id.ll_black:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type2);
                        ll_trans.setBackgroundResource(R.drawable.ll_type);

                        list.add(2,"검정");

                        break;
                    case R.id.ll_trans:
                        ll_white.setBackgroundResource(R.drawable.ll_type);
                        ll_yellow.setBackgroundResource(R.drawable.ll_type);
                        ll_orenge.setBackgroundResource(R.drawable.ll_type);
                        ll_magenta.setBackgroundResource(R.drawable.ll_type);
                        ll_red.setBackgroundResource(R.drawable.ll_type);
                        ll_brown.setBackgroundResource(R.drawable.ll_type);
                        ll_green1.setBackgroundResource(R.drawable.ll_type);
                        ll_green2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue1.setBackgroundResource(R.drawable.ll_type);
                        ll_blue2.setBackgroundResource(R.drawable.ll_type);
                        ll_blue3.setBackgroundResource(R.drawable.ll_type);
                        ll_puple1.setBackgroundResource(R.drawable.ll_type);
                        ll_puple2.setBackgroundResource(R.drawable.ll_type);
                        ll_gray.setBackgroundResource(R.drawable.ll_type);
                        ll_black.setBackgroundResource(R.drawable.ll_type);
                        ll_trans.setBackgroundResource(R.drawable.ll_type2);

                        list.add(2,"투명");

                        break;
                    case R.id.ll_type1:
                        ll_type1.setBackgroundResource(R.drawable.ll_type2);
                        ll_type2.setBackgroundResource(R.drawable.ll_type);
                        ll_type3.setBackgroundResource(R.drawable.ll_type);

                        list.add(3,"정제류");

                        break;
                    case R.id.ll_type2:
                        ll_type1.setBackgroundResource(R.drawable.ll_type);
                        ll_type2.setBackgroundResource(R.drawable.ll_type2);
                        ll_type3.setBackgroundResource(R.drawable.ll_type);

                        list.add(3,"경질캡슐");

                        break;
                   case R.id.ll_type3:
                        ll_type1.setBackgroundResource(R.drawable.ll_type);
                        ll_type2.setBackgroundResource(R.drawable.ll_type);
                        ll_type3.setBackgroundResource(R.drawable.ll_type2);

                        list.add(3,"연질캡슐");

                        break;
                    case R.id.ll_non:
                        ll_non.setBackgroundResource(R.drawable.ll_type2);
                        ll_miner.setBackgroundResource(R.drawable.ll_type);
                        ll_plus.setBackgroundResource(R.drawable.ll_type);
                        ll_etc.setBackgroundResource(R.drawable.ll_type);

                        list.add(4,"없음");

                        break;
                    case R.id.ll_miner:
                        ll_non.setBackgroundResource(R.drawable.ll_type2);
                        ll_miner.setBackgroundResource(R.drawable.ll_type);
                        ll_plus.setBackgroundResource(R.drawable.ll_type);
                        ll_etc.setBackgroundResource(R.drawable.ll_type);

                        list.add(4,"분할선");

                        break;
                    case R.id.ll_plus:
                        ll_non.setBackgroundResource(R.drawable.ll_type2);
                        ll_miner.setBackgroundResource(R.drawable.ll_type);
                        ll_plus.setBackgroundResource(R.drawable.ll_type);
                        ll_etc.setBackgroundResource(R.drawable.ll_type);

                        list.add(4,"없음");

                        break;
                    case R.id.ll_etc:
                        ll_non.setBackgroundResource(R.drawable.ll_type2);
                        ll_miner.setBackgroundResource(R.drawable.ll_type);
                        ll_plus.setBackgroundResource(R.drawable.ll_type);
                        ll_etc.setBackgroundResource(R.drawable.ll_type);

                        list.add(4,"없음");

                        break;

                }
            }
        };
        ll_cycler.setOnClickListener(cl);
        ll_cycler2.setOnClickListener(cl);
        ll_cycler3.setOnClickListener(cl);
        ll_triangle.setOnClickListener(cl);
        ll_rectangle.setOnClickListener(cl);
        ll_rectangle2.setOnClickListener(cl);
        ll_rectangle3.setOnClickListener(cl);
        ll_polygon.setOnClickListener(cl);
        ll_polygon2.setOnClickListener(cl);
        ll_polygon3.setOnClickListener(cl);
        ll_dubleovelr.setOnClickListener(cl);
        ll_white.setOnClickListener(cl);
        ll_yellow.setOnClickListener(cl);
        ll_orenge.setOnClickListener(cl);
        ll_magenta.setOnClickListener(cl);
        ll_red.setOnClickListener(cl);
        ll_brown.setOnClickListener(cl);
        ll_green1.setOnClickListener(cl);
        ll_green2.setOnClickListener(cl);
        ll_blue1.setOnClickListener(cl);
        ll_blue2.setOnClickListener(cl);
        ll_blue3.setOnClickListener(cl);
        ll_puple1.setOnClickListener(cl);
        ll_puple2.setOnClickListener(cl);
        ll_gray.setOnClickListener(cl);
        ll_black.setOnClickListener(cl);
        ll_trans.setOnClickListener(cl);
        ll_type1.setOnClickListener(cl);
        ll_type2.setOnClickListener(cl);
        ll_type3.setOnClickListener(cl);
        ll_non.setOnClickListener(cl);
        ll_miner.setOnClickListener(cl);
        ll_plus.setOnClickListener(cl);
        ll_etc.setOnClickListener(cl);

    }
}