package com.hugh.TotalDemo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentThree extends Fragment {


    private TextView textView;

    public FragmentThree() {
        // Required empty public constructor
    }

    //1.new 一个OkHttpClient
    private final OkHttpClient mClient = new OkHttpClient();



    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what ==1){
                textView.setText("----使用OkHttpClient----" + (String) msg.obj);
                ValueAnimator colorAnim = ObjectAnimator.ofFloat(textView, "scaleX",0.5f);
                colorAnim.setDuration(1000);
                colorAnim.start();
            }
        }
    };




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void excute() throws Exception{
        String path = "http://publicobject.com/helloworld.txt";
        //2.
        Request request = new Request.Builder().url(path).build();
        //3.
        Response response = mClient.newCall(request).execute();
        Message message = Message.obtain();
        message.obj = response.body().string();
        message.what = 1;
        mHandler.sendMessage(message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        textView = new TextView(getActivity());
        textView.setText("FragmentThree");
        return textView;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    excute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
