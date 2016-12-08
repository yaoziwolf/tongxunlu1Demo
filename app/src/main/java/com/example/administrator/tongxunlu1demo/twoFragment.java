package com.example.administrator.tongxunlu1demo;

/**
 * Created by Administrator on 2016/11/14.
 */
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kkkkk on 2016/8/23.
 */
public class twoFragment extends Fragment {
    private ListView listView;
    private List<Map<String,String>> list;
    MyAdapter adapter=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_two,container,false);
        listView = (ListView) view.findViewById(R.id.listView);
        list = new ArrayList<Map<String,String>>();
        //获取ContentResolver对象
        ContentResolver contentResolver = getActivity().getContentResolver();
        //获取数据库表中所有联系人的数据
        Cursor cursorSum = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (cursorSum.moveToNext()) {
            //用于存放查询到的数据
            Map<String,String> map = new HashMap<String,String>();
            //获取联系人的名字
            String name = cursorSum.getString(cursorSum.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            //放入名字
            map.put("name",name);
            //获取联系人的ID
            String id = cursorSum.getString(cursorSum.getColumnIndex(ContactsContract.Contacts._ID));
            System.out.println(id);
            //根据ID获取联系人的电话号码
            Cursor cursorPhones = contentResolver.query(
                    //查询电话号码表
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    //表示要查询的人的ID
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=?",
                    new String[]{id},
                    null);
            //用于拼接多个电话或email
            StringBuffer sbPhone = new StringBuffer();
            while(cursorPhones.moveToNext()){
                String phones = cursorPhones.getString(cursorPhones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                map.put("phone",sbPhone.append(phones+",").toString());
            }
            list.add(map);

        }
        adapter= new MyAdapter(getActivity(),list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();

                intent.setAction("android.intent.action.CALL");

                intent.setData(Uri.parse("tel:"+ContactsContract.CommonDataKinds.Phone.CONTENT_URI));

                startActivity(intent);
            }
        });
        return view;

    }


}
