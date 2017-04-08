package com.dawang.androidexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dawang.androidexample.animation.AnimationActivity;
import com.dawang.androidexample.http.HttpsActivity;
import com.dawang.androidexample.mvp.view.MvpActivity;
import com.dawang.androidexample.window.WindowActivity;

public class MainActivity extends AppCompatActivity {
    Context mContext;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initViews();
        loadViews();
    }

    void initData(){
        mContext = this.getApplicationContext();
    }

    void initViews(){
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview);
    }

    void loadViews(){
        mListView.setAdapter(new ExampleBaseAdapter(mContext));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent  intentHttp = new Intent();
                        intentHttp.setClass(mContext, HttpsActivity.class);
                        mContext.startActivity(intentHttp);
                        break;
                    case 1:
                        Intent  intentWindow = new Intent();
                        intentWindow.setClass(mContext, WindowActivity.class);
                        mContext.startActivity(intentWindow);
                    case 2:
                        Intent  intentAnimation = new Intent();
                        intentAnimation.setClass(mContext, AnimationActivity.class);
                        mContext.startActivity(intentAnimation);
                        break;
                    case 3:
                        Intent  intentAidl = new Intent();
                        intentAidl.setClassName("com.example.louiewh.aidlapplication", "com.example.louiewh.aidlapplication.MainActivity");
                        mContext.startActivity(intentAidl);
                        break;
                    case 4:
                        Intent  intentMvp = new Intent();
                        intentMvp.setClass(mContext, MvpActivity.class);
                        mContext.startActivity(intentMvp);
                    default:
                        break;
                }
            }
        });
    }
}
