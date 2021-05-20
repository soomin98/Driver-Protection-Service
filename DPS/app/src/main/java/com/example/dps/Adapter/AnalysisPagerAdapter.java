package com.example.dps.Adapter;

import android.os.Bundle;

import com.example.dps.Fragment.Co2Fragment;
import com.example.dps.Fragment.EmotionFragment;
import com.example.dps.Fragment.EyeFragment;
import com.example.dps.Fragment.TotalFragment;
import com.example.dps.RetrofitAPI;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.cert.CertificateException;
import java.util.UUID;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class AnalysisPagerAdapter extends FragmentStatePagerAdapter {

//    Json_data
    JSONArray co2;
    JSONArray eye;
    JSONArray emotion;

    private int mPageCount;
    private String user_id;
    //생성자
    public AnalysisPagerAdapter(FragmentManager fm, int pageCount, String user_id,JSONArray co2,JSONArray emotion,JSONArray eye) {
        super(fm);
        this.mPageCount = pageCount;
        this.user_id= user_id;
        this.co2 =co2;
        this.eye =eye;
        this.emotion = emotion;

        //test 출력
        System.out.println(user_id);


    }

    @Override
    public int getCount() {
        return mPageCount;
    }

    @Override
    public Fragment getItem(int position) {

        Bundle bundle = new Bundle();
        bundle.putString("user_id", user_id);

        switch (position) {
            case 0:
                TotalFragment totalFragment = new TotalFragment();
                System.out.println("케이스0" + user_id); //확인

                Bundle totalBundle = new Bundle();
                totalBundle.putString("user_id", user_id);
                totalFragment.setArguments(totalBundle); //Name 변수 값 전달. 생략시 받는 쪽에서 null 값으로 받음
                return totalFragment;

            case 1:
                Co2Fragment co2Fragment = new Co2Fragment();
                System.out.println("케이스1" + user_id); //확인
                Bundle co2Bundle = new Bundle();
                //                co2 확인
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>co2_test:"+co2);
                bundle.putString("user_id", user_id);
                co2Fragment.setArguments(co2Bundle); //Name 변수 값 전달. 생략시 받는 쪽에서 null 값으로 받음
                return co2Fragment;

            case 2:
                EmotionFragment emotionFragment = new EmotionFragment();
                System.out.println("케이스2" + user_id); //확인
                Bundle emotionBundle = new Bundle();
                bundle.putString("user_id", user_id);
                emotionFragment.setArguments(emotionBundle); //Name 변수 값 전달. 생략시 받는 쪽에서 null 값으로 받음
                return emotionFragment;

             case 3:
                EyeFragment eyeFragment = new EyeFragment();
                 System.out.println("케이스3" + user_id); //확인
                 Bundle eyeBundle = new Bundle();
                 bundle.putString("user_id", user_id);
                 eyeFragment.setArguments(eyeBundle); //Name 변수 값 전달. 생략시 받는 쪽에서 null 값으로 받음
                 return eyeFragment;

            default:
                return null;
        }
    }

}