package com.michael.hellomichael.auto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.michael.hellomichael.R;
import com.michael.hellomichael.ioc.TemplateUtil;

public class Bean2LayoutActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bean_layout);
    }

    // generate a bean
    // generate layout
    // bean 2 layout

    public void displayBean(View view) {
        bean2Layout();
    }



    private void bean2Layout() {
        // get bean

        // get layout



        // h
//        @Autowired(fields = {"coverImage", "coverTitle"}, tags = {"MyCoverImage", "MyCoverTitle"})


//        layout.findViewWithTag("");

        // view field set AOP




//        ContentCover cover = new ContentCover();
//        View layout = findViewById(R.id.cover_layout);
//        TemplateUtil.fillContent(layout, cover);


        // types fields tags ids
        // bean fields too more, find view by tags? ids
        // get annotations
        // AOP

        // ids

        // bean layout aop
        // type ???

//        @TemplateBean(fields = {"coverImage", "coverTitle"})
        ContentCover cover = new ContentCover();
//        @TemplateLayout(tags = {"MyCoverImage", "MyCoverTitle"})
        View layout = findViewById(R.id.cover_layout);

        TemplateUtil.fillContentAnnotation(cover, layout);







//        int[] ids = {R.id.cover_image_view, R.id.cover_title_view};
//        TemplateUtil.fillContentId(cover, layout, ids);

        // AOP value ids
//        Object[] values = {};
//        int[] ids = {R.id.cover_image_view, R.id.cover_title_view};
//        TemplateUtil.fillContentValue(values, layout, ids);






















    }








}
