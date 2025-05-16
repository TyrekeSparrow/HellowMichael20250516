package com.michael.hellomichael.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.michael.hellomichael.R;
import com.michael.hellomichael.server.ServerData;
import com.michael.hellomichael.template.bean.BaseBean;
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

    public void refreshData(View view) {
        List<BaseBean> beanList = ServerData.getFirstData();
        dataList.clear();
        dataList.addAll(beanList);
        notifyDataChanged();
    }

    public void getMoreData(View view) {
        List<BaseBean> beanList = ServerData.getMoreData();
        dataList.addAll(beanList);
        notifyDataChanged();
    }









}
