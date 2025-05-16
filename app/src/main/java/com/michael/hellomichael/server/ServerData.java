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
        beanList.add(new Bean1());
        beanList.add(new Bean2());
        beanList.add(new Bean3());
        beanList.add(new Bean4());
        beanList.add(new Bean5());
        return beanList;
    }


    public static List getMoreData() {
        ArrayList<BaseBean> beanList = new ArrayList<BaseBean>();
        beanList.add(new Bean1());
        beanList.add(new Bean5());
        beanList.add(new Bean2());
        beanList.add(new Bean4());
        beanList.add(new Bean3());
        return beanList;
    }





}
