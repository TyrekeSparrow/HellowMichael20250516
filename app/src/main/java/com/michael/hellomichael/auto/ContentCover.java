package com.michael.hellomichael.auto;

import com.michael.hellomichael.R;
import com.michael.hellomichael.data.PicData;
import com.michael.hellomichael.ioc.TemplateLayout;

public class ContentCover {

    @TemplateLayout(layoutTag = "MyCoverImage")
    private String coverImage = PicData.IMAGE1_PATH;
    @TemplateLayout(layoutTag = "MyCoverTitle")
    private String coverTitle = "咸蛋黄鸡翅吃过吗？外焦肉嫩，沙沙的好好吃";
//    private ContentAuthor author;


//    private String authorName;
//    private ContentOptions options;


}
