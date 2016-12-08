package com.example.administrator.tongxunlu1demo;

/**
 * Created by Administrator on 2016/11/14.
 */
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kkkkk on 2016/8/23.
 */
public class threeFragment extends Fragment {
    private TextView tv;
    private Button btn_duanxin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_three,container,false);

        String title = getArguments().getString("title");
        tv.setText(title);

        btn_duanxin= (Button) view.findViewById(R.id.btn_duanxin);
        btn_duanxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSMS = new Intent();
                intentSMS.setAction(Intent.ACTION_SENDTO);
                intentSMS.setData(Uri.parse("smsto:13141403763"));
                intentSMS.putExtra("sms_body","");
                System.out.println("");
                startActivity(intentSMS);
            }
        });
        return view;
    }
}
