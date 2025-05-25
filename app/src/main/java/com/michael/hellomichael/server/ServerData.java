package com.michael.hellomichael.server;

import com.michael.hellomichael.data.PicData;
import com.michael.hellomichael.template.bean.BaseBean;
import com.michael.hellomichael.template.bean.Bean1;
import com.michael.hellomichael.template.bean.Bean2;
import com.michael.hellomichael.template.bean.Bean3;
import com.michael.hellomichael.template.bean.Bean4;
import com.michael.hellomichael.template.bean.Bean5;

import java.util.ArrayList;
import java.util.List;

public class ServerData {
    public static final String PATH = PicData.NETWORK_PATH;
    public static final int WIDTH = PicData.WIDTH;
    public static final int HEIGHT = PicData.HEIGHT;










    public static List getFirstData() {
        ArrayList<BaseBean> beanList = new ArrayList<BaseBean>();
        beanList.add(new Bean1("content1"));
        beanList.add(new Bean2("content2"));
        beanList.add(new Bean3("content3"));
        beanList.add(new Bean4("content4"));
        beanList.add(new Bean5("content5"));
        return beanList;
    }

    public static List getMoreData() {
        ArrayList<BaseBean> beanList = new ArrayList<BaseBean>();
        beanList.add(new Bean1("content6"));
        beanList.add(new Bean5("content7"));
        beanList.add(new Bean2("content8"));
        beanList.add(new Bean4("content9"));
        beanList.add(new Bean3("content10"));
        return beanList;
    }

}
