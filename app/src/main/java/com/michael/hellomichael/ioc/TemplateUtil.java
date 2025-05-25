package com.michael.hellomichael.ioc;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.michael.hellomichael.auto.ContentCover;
import com.michael.hellomichael.data.PicData;
import com.michael.hellomichael.tag.Tag;
import com.michael.hellomichael.view.ReuseImageView;

import java.lang.reflect.Field;

public class TemplateUtil {


    public static void fillContentAnnotation(Object bean, View layout) {
//        @TemplateBean(fields = {"coverImage", "coverTitle"})
//        ContentCover cover = new ContentCover();
//        @TemplateLayout(tags = {"MyCoverImage", "MyCoverTitle"})
//        View layout = findViewById(R.id.cover_layout);

        // find value by field
        // find layout with tag
        // fill value by type

        // find value
        // find layout
        // fill value

        Log.d(Tag.BEAN_LAYOUT, "======================== fillContentAnnotation bean = " + bean);

        Class<?> beanClass = bean.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        Log.d(Tag.BEAN_LAYOUT, "======================== fillContentAnnotation fields.length = " + fields.length);
        for (Field field : fields) {
            // find value
            // find view
            // fill value
            field.setAccessible(true);
            Object value = getBeanValue(field, bean);
            // get layout tag from field annotation
            TemplateLayout layoutAnnotation = field.getDeclaredAnnotation(TemplateLayout.class);
            String tag = layoutAnnotation.layoutTag();
            Log.d(Tag.BEAN_LAYOUT, "======================== fillContentAnnotation value = " + value);
            Log.d(Tag.BEAN_LAYOUT, "======================== fillContentAnnotation tag = " + tag);
            View view = layout.findViewWithTag(tag);
            fillValue(view, value);

        }


    }


    /**
     * fill content by id
     * @param cover
     * @param layout
     * @param ids
     */
    public static void fillContentId(ContentCover cover, View layout, int[] ids) {



    }

    /**
     * fill content by tag
     * @param cover
     * @param layout
     */
    public static void fillContentTag(ContentCover cover, View layout) {



    }

    /**
     * fill content by value id
     * @param values
     * @param layout
     * @param ids
     */
    public static void fillContentValue(Object[] values, View layout, int[] ids) {

    }

    /**
     * fill content by refection
     * @param layout
     * @param bean
     */
    public static void fillContent(View layout, Object bean) {
        // TODO
//        private String coverImage;
//        private String coverTitle;



        // annotation
        // reflect

        // get layout
        // get annotation bean
        // layout bean

        // findViewWithTag
        // findField
        // set bean field

        // instance of

        // find tag findView
        // find field value
        // set field value to view
        // no author, then author

        Log.d(Tag.BEAN_LAYOUT, "================ fillContent cover = " + bean);
        Class<?> beanClass = bean.getClass();
        Field[] beanFields = beanClass.getDeclaredFields();
        for (Field beanField : beanFields) {
            // find field
            String fieldName = beanField.getName();
            Log.d(Tag.BEAN_LAYOUT, "================ fieldName = " + fieldName);
            // find value
            Object value = getBeanValue(beanField, bean);
            Log.d(Tag.BEAN_LAYOUT, "================ value = " + value);
            // find view
            View view = layout.findViewWithTag(fieldName);
            Log.d(Tag.BEAN_LAYOUT, "================ view = " + view);
            // fill value
            fillValue(view, value);
        }


    }

    private static void fillValue(View view, Object value) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setText(value.toString());
            return;
        }
        if (view instanceof ReuseImageView) {
            ReuseImageView imageView = (ReuseImageView) view;
            String imagePath = (String) value;
            imageView.setParams(imagePath, PicData.WIDTH, PicData.HEIGHT);
            imageView.displayImage();
            return;
        }
        if (view instanceof IBeanLayout) {
            IBeanLayout beanLayout = (IBeanLayout) view;
            beanLayout.setBean(value);
            return;
        }
    }

    private static Object getBeanValue(Field field, Object bean) {
        try {
            field.setAccessible(true);
            return field.get(bean);
        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
            return null;
        }
    }


}
