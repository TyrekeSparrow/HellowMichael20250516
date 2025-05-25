package com.michael.hellomichael.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.michael.hellomichael.R;
import com.michael.hellomichael.server.ServerData;
import com.michael.hellomichael.template.bean.BaseBean;
import com.michael.hellomichael.template.layout.Layout1;
import com.michael.hellomichael.view.TemplateListView;

import java.util.ArrayList;
import java.util.List;

public class ImageListActivity extends Activity {
    private TemplateListView listView;
    private ArrayList<BaseBean> dataList = new ArrayList<BaseBean>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_image_list);
        initListView();
    }

    private void initListView() {
        listView = (TemplateListView) findViewById(R.id.template_list);
        listView.setData(dataList);
        listView.notifyDataChanged();
    }

    private void notifyDataChanged(){
        listView.notifyDataChanged();
    }

    public void initData(View view) {
        // get data list
        List<BaseBean> beanList = ServerData.getFirstData();
        dataList.addAll(beanList);
        // template list
        notifyDataChanged();
    }

    public void addNewData(View view) {
//        List<BaseBean> beanList = ServerData.getFirstData();
//        dataList.clear();
//        dataList.addAll(beanList);
//        notifyDataChanged();

//        at content2
//        remove Layout1 content1
//        add Layout1 content6

        Layout1 layout0 = (Layout1) listView.mRoot. getChildAt(0);
        listView.mRoot.removeView(layout0);

        TextView emptyView0 = new TextView(getApplicationContext());
        emptyView0.setText("layout1----------- 111 EmptyContent");
        emptyView0.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 500));

        listView.mRoot.addView(emptyView0, 0);



        layout0.setText("layout1-----------content6");
        listView.mRoot.addView(layout0);





    }

    public void recoveryData(View view) {
        // get layout1 from content6
        Layout1 layout0 = (Layout1) listView.mRoot.getChildAt(5);

        // content 6 add emptyView
        listView.mRoot.removeViewAt(5);
        TextView emptyView5 = new TextView(getApplicationContext());
        emptyView5.setText("layout1----------- 666 EmptyContent");
        emptyView5.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 500));
        listView.mRoot.addView(emptyView5);


        // remove emptyview update content, add view
        listView.mRoot.removeViewAt(0);
        layout0.setText("layout1 ------------------ content 0 !!!!!");
        listView.mRoot.addView(layout0, 0);






    }


    public void getMoreData(View view) {
        List<BaseBean> beanList = ServerData.getMoreData();
        dataList.addAll(beanList);
        notifyDataChanged();
    }









}
