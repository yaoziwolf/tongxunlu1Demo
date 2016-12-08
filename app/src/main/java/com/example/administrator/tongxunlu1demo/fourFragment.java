package com.example.administrator.tongxunlu1demo;

/**
 * Created by Administrator on 2016/11/14.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kkkkk on 2016/8/23.
 */
public class fourFragment extends Fragment {
    private TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_four,container,false);
        tv = (TextView) view.findViewById(R.id.textView4);
        String title = getArguments().getString("title");
        tv.setText(title);
        return view;
    }
}
