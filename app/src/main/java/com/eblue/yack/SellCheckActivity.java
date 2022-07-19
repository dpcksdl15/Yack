package com.eblue.yack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SellCheckActivity extends AppCompatActivity {

    TextView tv_searchDate, tv_dateReplace, tv_visit, tv_moneyPrice, tv_cardPrice, tv_totalPrice, tv_etcPrice;
    ImageView img_backIcon;
    BarChart barChart;
    PieChart pieChart, pieChart2;

    View.OnClickListener cl;

    Calendar calendar;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
    String date, value = "0";

    static String pID;
    static String result;

    NumberFormat format = new DecimalFormat("#,###");

    String visit;
    int money, card, etc, total;

    ArrayList<String> SEQ_NO_LIST = new ArrayList<>();
    ArrayList<String> PAY_GB_LIST = new ArrayList<>();
    ArrayList<String> CASH_LIST = new ArrayList<>();
    ArrayList<String> CARD_LIST = new ArrayList<>();
    ArrayList<String> CANCEL_GB_LIST = new ArrayList<>();
    ArrayList<String> BAR_LABEL_LIST = new ArrayList<>();
    ArrayList<String> BAR_VALUE_DATA_LIST = new ArrayList<>();
    ArrayList<String> PIE_LABEL_LIST = new ArrayList<>();
    ArrayList<Float> PIE_VALUE_DATA_LIST = new ArrayList<>();
    ArrayList<String> PIE2_LABEL_LIST = new ArrayList<>();
    ArrayList<Float> PIE2_VALUE_DATA_LIST = new ArrayList<>();

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_check);

        tv_searchDate = findViewById(R.id.tv_searchDate);
        tv_dateReplace = findViewById(R.id.tv_dateReplace);
        tv_visit = findViewById(R.id.tv_visit);
        tv_moneyPrice = findViewById(R.id.tv_moneyPirce);
        tv_cardPrice = findViewById(R.id.tv_cardPrice);
        tv_totalPrice = findViewById(R.id.tv_totalPrice);
        tv_etcPrice = findViewById(R.id.tv_etcPrice);

        img_backIcon = findViewById(R.id.bt_back_icon);

        barChart = findViewById(R.id.barchart);
        pieChart = findViewById(R.id.piechart);
        pieChart2 = findViewById(R.id.piechart2);

        calendar = Calendar.getInstance();

        BAR_LABEL_LIST.add("09시");
        BAR_LABEL_LIST.add("10시");
        BAR_LABEL_LIST.add("11시");
        BAR_LABEL_LIST.add("12시");
        BAR_LABEL_LIST.add("13시");
        BAR_LABEL_LIST.add("14시");
        BAR_LABEL_LIST.add("15시");
        BAR_LABEL_LIST.add("16시");
        BAR_LABEL_LIST.add("17시");
        BAR_LABEL_LIST.add("18시");
        BAR_LABEL_LIST.add("19시");
        BAR_LABEL_LIST.add("20시");
        BAR_LABEL_LIST.add("21시");

        PIE_LABEL_LIST.add("현금");
        PIE_LABEL_LIST.add("카드");
        PIE_LABEL_LIST.add("임의저장");

        PIE2_LABEL_LIST.add("전문의약품");
        PIE2_LABEL_LIST.add("일반의약품");

        date = dateFormat.format(calendar.getTime());
        tv_searchDate.setText(date);

        barChart.setTouchEnabled(false);
        barChart.setDescription("");

        sharedPreferences = getSharedPreferences("LoginUserinfo", MODE_PRIVATE);

        pID = sharedPreferences.getString("pid", "");

        dataSetting(date);
        barChartgraphSetting();
        payPercentgraphSetting();
        goodspercent();

        //각 클릭 구현 (뒤로가기, 날짜, 변경버튼)
        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){

                    case R.id.bt_back_icon:
                        finish();
                        break;

                    case R.id.tv_searchDate:
                        dateChange();
                        break;

                    case R.id.tv_dateReplace:
                        dataSetting(date);
                        barChartgraphSetting();
                        payPercentgraphSetting();
                        goodspercent();
                        break;

                }


            }
        };
        img_backIcon.setOnClickListener(cl);
        tv_searchDate.setOnClickListener(cl);
        tv_dateReplace.setOnClickListener(cl);

    }

    public void dataSetting(String date){

        String searchDataDate = date;
        ServerRegisterActivity serverRegisterActivity = new ServerRegisterActivity();
        value = "3";
        try {
            Log.d("데이터 셋팅", "실행");
            result = serverRegisterActivity.execute(value,pID,searchDataDate).get();

            datalist();
        } catch (Exception e){

        }

    }


    public void dateChange(){
        DatePickerDialog.OnDateSetListener mdatePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DATE, day);

                date = dateFormat.format(calendar.getTime());

                tv_searchDate.setText(date);

            }
        };
        new DatePickerDialog(SellCheckActivity.this, mdatePicker, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)).show();

    }

    public void datalist(){
        SEQ_NO_LIST.clear();
        PAY_GB_LIST.clear();
        CASH_LIST.clear();
        CARD_LIST.clear();
        CANCEL_GB_LIST.clear();

        try {
            JSONArray jsonArray = new JSONObject(result).getJSONArray(pID);

            if (jsonArray != null){

                for (int i =0; i < jsonArray.length() ; i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    SEQ_NO_LIST.add(jsonObject.getString("SEQ_NO"));
                    PAY_GB_LIST.add(jsonObject.getString("PAY_GB"));
                    CASH_LIST.add(jsonObject.getString("CASH"));
                    CARD_LIST.add(jsonObject.getString("CARD"));
                    CANCEL_GB_LIST.add(jsonObject.getString("CANCEL_GB"));

                }

            }

        visit = format.format(SEQ_NO_LIST.size());

        tv_visit.setText(visit + "명");

            money =0; card =0; total =0; etc =0;

        for (int i =0 ; i < CASH_LIST.size() ; i++) {

            if (CANCEL_GB_LIST.get(i) != null) {

                if (PAY_GB_LIST.get(i).equals("현금")) {
                    money = money + Integer.parseInt(CASH_LIST.get(i));
                } else if (PAY_GB_LIST.get(i).equals("카드")) {
                    card = card + Integer.parseInt(CARD_LIST.get(i));
                } else if (PAY_GB_LIST.get(i).equals("임의저장")) {
                    etc = etc + Integer.parseInt(CARD_LIST.get(i));
                } else {
                    money = money + Integer.parseInt(CASH_LIST.get(i));
                    card = card + Integer.parseInt(CARD_LIST.get(i));
                }

            }

        }

        total = money + card + etc ;

        tv_moneyPrice.setText(format.format(money) + "원");
        tv_cardPrice.setText(format.format(card) + "원");
        tv_etcPrice.setText(format.format(etc) + "원");
        tv_totalPrice.setText(format.format(total) + "원");

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void barChartgraphSetting(){
        ServerRegisterActivity serverRegisterActivity = new ServerRegisterActivity();
        value = "4";
        BAR_VALUE_DATA_LIST.clear();
        try {

            result = serverRegisterActivity.execute(value,pID,date).get();
            Log.d("dd", pID);
            Log.d("dd", date);

            JSONArray jsonArray = new JSONObject(result).getJSONArray(pID);

            if (jsonArray.length() != 0){

                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH09"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH10"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH11"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH12"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH13"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH14"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH15"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH16"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH17"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH18"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH19"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH20"))/1000));
                BAR_VALUE_DATA_LIST.add(String.valueOf(Integer.parseInt(jsonArray.getJSONObject(0).getString("HH21"))/1000));


                Log.d("dd", jsonArray.getJSONObject(0).getString("HH10"));
            }

            ArrayList<BarEntry> entries = new ArrayList<>();
            ArrayList<String> label = new ArrayList<String>();

            for (int i =0; i < BAR_VALUE_DATA_LIST.size() ; i++){
                entries.add(new BarEntry(Float.parseFloat(BAR_VALUE_DATA_LIST.get(i)), i));
            }
            for (int i =0; i < BAR_LABEL_LIST.size() ; i++){
                label.add(BAR_LABEL_LIST.get(i));
            }

            BarDataSet barDataSet = new BarDataSet(entries, "단위(천 원)");
            barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            YAxis RightYAxis = barChart.getAxisRight();
            YAxis LeftYAxis = barChart.getAxisLeft();
            RightYAxis.setDrawLabels(false);
            LeftYAxis.setDrawLabels(false);

            XAxis xAxis = barChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

            //MPChart v3.x.x 오류
            BarData barData = new BarData(label,barDataSet);
            barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            barData.setValueTextSize(11);

            barChart.setData(barData);

            //애니메이션 효과 속도
            barChart.animateXY(1000,1000 );
            barChart.invalidate();

        } catch (Exception e){

        }


    }

    //결제 비율
    public void payPercentgraphSetting(){
        ServerRegisterActivity serverRegisterActivity = new ServerRegisterActivity();
        value = "5";

        try {
            result = serverRegisterActivity.execute(value,pID,date).get();
            JSONArray jsonArray = new JSONObject(result).getJSONArray(pID);
            ArrayList<Entry> entry = new ArrayList<>();

            Log.d("확인2", String.valueOf(jsonArray.length()));

            if (jsonArray.length() != 0){
                PIE_VALUE_DATA_LIST.clear();

                int m = Integer.parseInt(jsonArray.getJSONObject(0).getString("money"));
                int c = Integer.parseInt(jsonArray.getJSONObject(0).getString("card"));
                int e = Integer.parseInt(jsonArray.getJSONObject(0).getString("etc"));

                //pm = PercentMoney
                float pm =(float) m/(m+c+e)*100;
                float pc =(float) c/(m+c+e)*100;
                float pe =(float) e/(m+c+e)*100;

                PIE_VALUE_DATA_LIST.add(pm);
                PIE_VALUE_DATA_LIST.add(pc);
                PIE_VALUE_DATA_LIST.add(pe);

                for (int i =0; i < PIE_VALUE_DATA_LIST.size() ; i++) {
                    if (PIE_VALUE_DATA_LIST.get(i) != null){

                            entry.add(new Entry(PIE_VALUE_DATA_LIST.get(i),i));
                    }
                }
            }

            PieDataSet pieDataSet = new PieDataSet(entry, "결제비율");
            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

            PieData pieData = new PieData(PIE_LABEL_LIST,pieDataSet);
            pieData.setValueTextSize(9);
            pieData.setValueTextColor(Color.BLACK);
            pieChart.setDescription("");
            pieChart.animateXY(1000,1000);

            pieChart.setData(pieData);
            pieChart.invalidate();

        } catch (Exception e){

        }

    }

    //판매비율
    public void goodspercent(){
        ServerRegisterActivity serverRegisterActivity = new ServerRegisterActivity();
        ArrayList<Entry> entry = new ArrayList<>();
        value = "6";

        try {
            result = serverRegisterActivity.execute(value,pID,date).get();

            Log.d("확인",result.trim());

            String rs[] = result.trim().split("/");

            float proMed = Float.parseFloat(rs[0]);
            float genMed = Float.parseFloat(rs[1]);


            PIE2_VALUE_DATA_LIST.add(proMed/(proMed+genMed)*100);
            PIE2_VALUE_DATA_LIST.add(genMed/(proMed+genMed)*100);

            for (int i =0; i < PIE2_VALUE_DATA_LIST.size() ; i++) {
                if (PIE2_VALUE_DATA_LIST.get(i) != null){

                    entry.add(new Entry(PIE2_VALUE_DATA_LIST.get(i),i));
                }
            }

            PieDataSet pieDataSet = new PieDataSet(entry, "판매비율");
            pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

            PieData pieData = new PieData(PIE2_LABEL_LIST,pieDataSet);
            pieData.setValueTextSize(9);
            pieData.setValueTextColor(Color.BLACK);
            pieChart2.setDescription("");
            pieChart2.animateXY(1000,1000);

            pieChart2.setData(pieData);
            pieChart2.invalidate();

        } catch (Exception e){

        }




    }

}