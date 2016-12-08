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
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kkkkk on 2016/8/23.
 */
public class oneFragment extends Fragment {
    private TextView tv;
    private Button btn_bohao;
    private EditText  number;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_one,container,false);

        String title = getArguments().getString("title");
        tv.setText(title);
        btn_bohao= (Button) view.findViewById(R.id.button1);
         number=(EditText)view.findViewById(R.id.editText1);
        btn_bohao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String phoneString= number.getText().toString();

                Intent intent=new Intent();

                intent.setAction("android.intent.action.CALL");

                intent.setData(Uri.parse("tel:"+phoneString));

                startActivity(intent);
            }
        });

        return view;
    }
}
