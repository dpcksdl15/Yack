package com.example.yack;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class MdSearch2Activity extends AppCompatActivity {


    EditText et_md_search_name;
    Button bt_search;

    RecyclerView recyclerView;

    AsyncTask asyncTask;

    MdSearch2Adpter adapter2;

    int count =0;

    //일련번호
    ArrayList<String> list = new ArrayList<>();
    //품목명
    ArrayList<String> list2 = new ArrayList<>();
    //업체명
    ArrayList<String> list3 = new ArrayList<>();
    //이미지
    ArrayList<Bitmap> list4 = new ArrayList<>();

    String key="%2FRj6PnwSChD5W2Md24QgSzON59%2FhVEEUaGNz6Wqatzinv3ynhtlm6Wj5ltMVE3pywr3aDojSz8%2BMNCTzeKbMzg%3D%3D";

    URL url;

    String queryUrl;
    String queryUrl2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_search2);


        et_md_search_name = findViewById(R.id.et_md_search_name);
        bt_search = findViewById(R.id.bt_search);

        recyclerView = findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                asyncTask = new AsyncTask();

                asyncTask.execute();

                Log.d("실행확인", String.valueOf(list));

            }
        });


    }

    public class AsyncTask extends android.os.AsyncTask<Void,Void,Void> {

        ProgressDialog mdialog = new ProgressDialog(MdSearch2Activity.this);

        @Override
        protected void onPreExecute() {
            mdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mdialog.setMessage("검색중입니다");

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
                    // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
                    adapter2 = new MdSearch2Adpter(list,list2,list3,list4);
                    recyclerView.setAdapter(adapter2) ;
                    Log.d("확인", "확인시간");
                    adapter2.notifyDataSetChanged();
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
        String str= et_md_search_name.getText().toString();//EditText에 작성된 Text얻어오기


        boolean urlversion = str.matches("[+-]?\\d*(\\.\\d+)?");
        Log.d("확인", String.valueOf(urlversion) + str);
        try{

            if (urlversion == false) {

                queryUrl  = "http://apis.data.go.kr/1470000/MdcinGrnIdntfcInfoService/getMdcinGrnIdntfcInfoList?serviceKey=" + key + "&numOfRows=10&pageNo=1&item_name=" + str;
                url= new URL(queryUrl);//숫자열로 된 요청 url을 URL 객체로 생성.
                Log.d("확인", queryUrl);

            } else if (urlversion == true){

                queryUrl2 ="http://apis.data.go.kr/1470000/MdcinGrnIdntfcInfoService/getMdcinGrnIdntfcInfoList?serviceKey=" + key + "&numOfRows=10&pageNo=1&edi_code=" + str;
                url= new URL(queryUrl2);//문자열로 된 요청 url을 URL 객체로 생성.
                Log.d("확인", queryUrl2);
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
                        else if(tag.equals("ITEM_SEQ")){

                            xpp.next();
                            Log.d("확인",xpp.getText());
                            list.add(xpp.getText());

                        }
                        else if(tag.equals("ITEM_NAME")){

                            xpp.next();
                            Log.d("확인",xpp.getText());
                            list2.add(xpp.getText());

                        }
                        else if(tag.equals("ENTP_NAME")){

                            xpp.next();
                            Log.d("확인",xpp.getText());
                            list3.add(xpp.getText());

                        }
                        else if(tag.equals("ITEM_IMAGE")){

                            xpp.next();
                            Log.d("확인",xpp.getText());

                            Bitmap bmp = null;
                            URL url = new URL(xpp.getText());
                            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                            list4.add(bmp);

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