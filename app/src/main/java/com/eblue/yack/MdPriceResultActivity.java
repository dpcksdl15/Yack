package com.eblue.yack;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class MdPriceResultActivity extends AppCompatActivity implements Adapter.OnListItemSelectedInterface{
    ImageView bt_back_icon, bt_cancel_icon;

    EditText et_search_text;

    ImageView bt_search_icon;

    TextView tv_search_count;

    Button bt_add;

    View.OnClickListener cl;

    XmlPullParser xpp;

    String key="%2FRj6PnwSChD5W2Md24QgSzON59%2FhVEEUaGNz6Wqatzinv3ynhtlm6Wj5ltMVE3pywr3aDojSz8%2BMNCTzeKbMzg%3D%3D";

    String queryUrl2;
    String queryUrl;

    int count =0;
    int position = -1;

    URL url;

    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    ArrayList<String> list3 = new ArrayList<>();
    ArrayList<String> list4 = new ArrayList<>();

    InputMethodManager imm;
    InputMethodManager inputMethodManager;

    RecyclerView recyclerView;
    AsyncTask asyncTask;

    Adapter adapter;

    MdPriceActivity mdPriceActivity;

    int click_check =0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_price_result);

        bt_back_icon = findViewById(R.id.bt_back_icon);
        bt_cancel_icon = findViewById(R.id.bt_textcancel_icon);

        bt_search_icon = findViewById(R.id.bt_search_icon);

        et_search_text = findViewById(R.id.et_search_text);

        tv_search_count = findViewById(R.id.tv_search_count);

        bt_add = findViewById(R.id.bt_add);

        adapter = new Adapter(list,list2,list3,list4,this,this,position) ;

        dbHelper = new DBHelper(this,"MdDB",null,1);


        recyclerView = findViewById(R.id.recyclerview) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        }

        Intent intent = getIntent();
        String search_text = intent.getExtras().getString("md_name");

        et_search_text.setText(search_text);

        asyncTask = new AsyncTask();

        asyncTask.execute();

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){

                    // ????????????
                    case R.id.bt_back_icon:
                        finish();
                        break;

                    case R.id.bt_textcancel_icon:
                        et_search_text.setText("");
                        et_search_text.requestFocus();

                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                        break;

                    case R.id.bt_search_icon:
                        asyncTask.cancel(true);

                        position = -1;
                        bt_add.setBackgroundResource(R.drawable.md_price_save_button);

                        asyncTask = new AsyncTask();

                        asyncTask.execute();

                        break;

                    case R.id.bt_add :
                        //???????????? ??????, text??? ??????

                        sqLiteDatabase = dbHelper.getWritableDatabase();

                        String sql;

                        Date date = new Date();

                        if (click_check == 1) {

                            try {
                                sql = "INSERT INTO searchdata VALUES (" + "'" + list.get(position) + "'" + "," + "'" + list2.get(position) + "'" + "," + "'" + list3.get(position) + "'" + "," + "'" + list4.get(position) + "'" + "," + "'" + date + "'" + "," + "0" + "," + "0" + "," + "0" + "," + 0 + ");";

                                sqLiteDatabase.execSQL(sql);
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "?????? ????????? ????????????", Toast.LENGTH_SHORT).show();
                            }


                            finish();
                        } else {

                            Toast.makeText(getApplicationContext(), "?????? ?????? ?????? ?????? ???????????????.", Toast.LENGTH_SHORT).show();
                        }

                        break;
                }

            }
        };

        bt_back_icon.setOnClickListener(cl);
        bt_cancel_icon.setOnClickListener(cl);
        bt_search_icon.setOnClickListener(cl);
        bt_add.setOnClickListener(cl);
    }

    @Override
    public void onItemSelected(View v, int position) {
        this.position = position;

        if (this.position != -1){
            Log.d("???????????? ??????", "????????????");
            bt_add.setBackgroundResource(R.drawable.md_price_save_button2);
            click_check =1;
        }


    }

    public class AsyncTask extends android.os.AsyncTask<Void,Void,Void> {

        ProgressDialog mdialog = new ProgressDialog(MdPriceResultActivity.this);

        @Override
        protected void onPreExecute() {
            mdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mdialog.setMessage("??????????????????");

            mdialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            list.clear();
            list2.clear();
            list3.clear();
            list4.clear();

            url = null;

            getXmlData();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // ????????????????????? SimpleTextAdapter ?????? ??????.
                    recyclerView.setAdapter(adapter) ;
                    tv_search_count.setText(String.valueOf(adapter.getItemCount()));
                    Log.d("??????", "????????????");
                    adapter.notifyDataSetChanged();
                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            mdialog.dismiss();
        }

        @Override
        protected void onCancelled() {

            super.onCancelled();
            mdialog.cancel();
        }
    }



    public void getXmlData(){
        String str= et_search_text.getText().toString();//EditText??? ????????? Text????????????


        boolean urlversion = str.matches("[+-]?\\d*(\\.\\d+)?");
        Log.d("??????", String.valueOf(urlversion) + str);
        try{

            if (urlversion == true) {

                queryUrl2  = "http://apis.data.go.kr/B551182/dgamtCrtrInfoService/getDgamtList?serviceKey=" + key + "&numOfRows=10&pageNo=1&mdsCd=" + str;
                url= new URL(queryUrl2);//???????????? ??? ?????? url??? URL ????????? ??????.
                Log.d("??????", queryUrl);

            } else if (urlversion == false){

                queryUrl ="http://apis.data.go.kr/B551182/dgamtCrtrInfoService/getDgamtList?serviceKey=" + key + "&numOfRows=10&pageNo=1&itmNm=" + str;
                url= new URL(queryUrl);//???????????? ??? ?????? url??? URL ????????? ??????.
                Log.d("??????", queryUrl);
            }

            InputStream is= url.openStream(); //url????????? ??????????????? ??????

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();//xml????????? ??????
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream ???????????? xml ????????????

            String tag;

            xpp.next();

            int eventType= xpp.getEventType();

            while( eventType != XmlPullParser.END_DOCUMENT ){

                switch( eventType ){

                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();


                        if(tag.equals("item")) ;
                        else if(tag.equals("adtStaDd")){

                            xpp.next();
                            list3.add(xpp.getText());

                        }
                        else if(tag.equals("itmNm")){

                            xpp.next();
                            list.add(xpp.getText());

                        }
                        else if(tag.equals("mdsCd")){

                            xpp.next();
                            list2.add(xpp.getText());

                        }

                        // ????????? ?????? ?????? (?????? ?????? ????????? ??????)
//                        else if(tag.equals("mnfEntpNm")){
//
//                            xpp.next();
//
//                        }
                        else if(tag.equals("mxCprc")){

                            xpp.next();
                            Log.d("??????",xpp.getText());
                            Log.d("??????2", String.valueOf(count));
                            list4.add(xpp.getText());

                        }
                        else if(tag.equals("payTpNm")){

                            xpp.next();
                            if (xpp.getText().equals("??????")){
                                Log.d("???????????? ??????","??????");
                                try {
                                    list.remove(count);
                                    list2.remove(count);
                                    list3.remove(count);
                                    list4.remove(count);
                                }catch (Exception e){

                                }

                            } else {
                                ++count;
                            }


                        }
                        else if(tag.equals("spcGnlTpNm")){

                            xpp.next();

                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName();

                }

                eventType= xpp.next();
            }

            count =0;

        } catch (Exception e){



            e.printStackTrace();
        }


    }
}