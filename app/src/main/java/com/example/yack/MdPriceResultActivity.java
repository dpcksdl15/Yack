package com.example.yack;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yack.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class MdPriceResultActivity extends AppCompatActivity {

    ImageView bt_back_icon, bt_cancel_icon;

    EditText et_search_text;

    ImageView bt_search_icon;

    TextView tv_search_count;

    View.OnClickListener cl;

    XmlPullParser xpp;

    String key="%2FRj6PnwSChD5W2Md24QgSzON59%2FhVEEUaGNz6Wqatzinv3ynhtlm6Wj5ltMVE3pywr3aDojSz8%2BMNCTzeKbMzg%3D%3D";

    String queryUrl2;
    String queryUrl;



    URL url;

    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    ArrayList<String> list3 = new ArrayList<>();
    ArrayList<String> list4 = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.md_price_result_activity);

        bt_back_icon = findViewById(R.id.bt_back_icon);
        bt_cancel_icon = findViewById(R.id.bt_textcancel_icon);

        bt_search_icon = findViewById(R.id.bt_search_icon);

        et_search_text = findViewById(R.id.et_search_text);

        tv_search_count = findViewById(R.id.tv_search_count);

        RecyclerView recyclerView = findViewById(R.id.recyclerview) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;


        Intent intent = getIntent();
        String search_text = intent.getExtras().getString("md_name");

        et_search_text.setText(search_text);


        //검색어 넘어왔을 경우
        new Thread(new Runnable() {
            @Override
            public void run() {

                list.clear();
                list2.clear();
                list3.clear();
                list4.clear();

                url = null;


                getXmlData();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
                        Adapter adapter = new Adapter(list,list2,list3,list4) ;
                        recyclerView.setAdapter(adapter) ;
                        tv_search_count.setText(String.valueOf(adapter.getItemCount()));
                        Log.d("확인", "확인시간");
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){

                    // 검색부분
                    case R.id.bt_back_icon:
                        finish();
                        break;

                    case R.id.bt_textcancel_icon:
                        et_search_text.setText("");
                        et_search_text.requestFocus();
                        InputMethodManager imm = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                            imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        }
                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                        break;

                    case R.id.bt_search_icon:
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                list.clear();
                                list2.clear();
                                list3.clear();
                                list4.clear();

                                url = null;


                                getXmlData();


                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // 리사이클러뷰에 adapter 객체 지정.


                                        Adapter adapter = new Adapter(list,list2,list3,list4) ;
                                        recyclerView.setAdapter(adapter) ;
                                        tv_search_count.setText(String.valueOf(adapter.getItemCount()));
                                        Log.d("확인", "확인시간");
                                        adapter.notifyDataSetChanged();


                                    }
                                });


                            }
                        }).start();


                }

            }
        };

        bt_back_icon.setOnClickListener(cl);
        bt_cancel_icon.setOnClickListener(cl);
        bt_search_icon.setOnClickListener(cl);
    }

    public void getXmlData(){
        String str= et_search_text.getText().toString();//EditText에 작성된 Text얻어오기


        boolean urlversion = str.matches("[+-]?\\d*(\\.\\d+)?");
        Log.d("확인", String.valueOf(urlversion) + str);
        try{

            if (urlversion == true) {

                queryUrl2  = "http://apis.data.go.kr/B551182/dgamtCrtrInfoService/getDgamtList?serviceKey=" + key + "&numOfRows=10&pageNo=1&mdsCd=" + str;
                url= new URL(queryUrl2);//숫자열로 된 요청 url을 URL 객체로 생성.
                Log.d("확인", queryUrl);

            } else if (urlversion == false){

                queryUrl ="http://apis.data.go.kr/B551182/dgamtCrtrInfoService/getDgamtList?serviceKey=" + key + "&numOfRows=10&pageNo=1&itmNm=" + str;
                url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
                Log.d("확인", queryUrl);
            }

            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();//xml파싱을 위한
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

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

                        // 제조사 부분 주석 (추후 개발 가능성 여부)
//                        else if(tag.equals("mnfEntpNm")){
//
//                            xpp.next();
//
//                        }
                        else if(tag.equals("mxCprc")){

                            xpp.next();
                            Log.d("확인",xpp.getText());
                            list4.add(xpp.getText());

                        }
                        else if(tag.equals("payTpNm")){

                            xpp.next();
                            if (xpp.getText().equals("삭제")){
                                Log.d("삭제목록 확인","확인");
                                list4.add("0");
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

        } catch (Exception e){



            e.printStackTrace();
        }


    }
}
