package com.example.dps.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dps.R;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Co2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Co2Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Co2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Co2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Co2Fragment newInstance(String param1, String param2) {
        Co2Fragment fragment = new Co2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    View view;
    BarChart co2chart;
    String user_id;
    String[] time;
    int[] amount;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_co2, container, false);
        Bundle bundle = getArguments();

        if (bundle != null) {
            user_id = bundle.getString("user_id"); //Name 받기.
            time = bundle.getStringArray("time");
            amount = bundle.getIntArray("amount");
            System.out.println("Co2Fragment: "+user_id); //확인

            for(int i=0; i<time.length; i++){
                System.out.println( (i + 1) + "co2_time : "+time[i]);
                System.out.println( (i + 1) + "co2_amount" + amount[i]);
            }
        }
        initView(view);
        return view;
    }

    public void initView(View v){
        co2chart = (BarChart) v.findViewById(R.id.co2chart);
        setBarChart();


    }

    // 막대 차트 설정
    private void setBarChart() {

        co2chart.clearChart();

        for(int i=0;i<time.length;i++){
            co2chart.addBar(new BarModel(time[i].substring(11, 16), amount[i], 0xFF56B7F1));
        }
        /*
        co2chart.addBar(new BarModel("12", 10f, 0xFF56B7F1));
        co2chart.addBar(new BarModel("13", 10f, 0xFF56B7F1));
        co2chart.addBar(new BarModel("14", 10f, 0xFF56B7F1));
        co2chart.addBar(new BarModel("15", 20f, 0xFF56B7F1));
        co2chart.addBar(new BarModel("16", 10f, 0xFF56B7F1));
        co2chart.addBar(new BarModel("17", 10f, 0xFF56B7F1));
        */
        co2chart.startAnimation();

    }

}