package com.michael.hellomichael.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.michael.hellomichael.tag.Tag;
import com.michael.hellomichael.template.bean.BaseBean;
import com.michael.hellomichael.template.bean.Bean1;
import com.michael.hellomichael.template.bean.Bean2;
import com.michael.hellomichael.template.bean.Bean3;
import com.michael.hellomichael.template.bean.Bean4;
import com.michael.hellomichael.template.bean.Bean5;
import com.michael.hellomichael.template.layout.Layout1;
import com.michael.hellomichael.template.layout.Layout2;
import com.michael.hellomichael.template.layout.Layout3;
import com.michael.hellomichael.template.layout.Layout4;
import com.michael.hellomichael.template.layout.Layout5;

import java.util.List;

public class TemplateListView extends ScrollView {
    public TemplateListView(Context context) {
        super(context);
        addRoot();
    }

    public TemplateListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addRoot();
    }

    public TemplateListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addRoot();
    }

    public TemplateListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        addRoot();
    }

    public LinearLayout mRoot = null;
    private void addRoot() {
        mRoot = new LinearLayout(getContext());
        mRoot.setOrientation(LinearLayout.VERTICAL);
        mRoot.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(mRoot);
    }






    private List<BaseBean> mDataList;
    private int mIndex = 0;



    public void setData(List data) {
        mDataList = data;
    }



    public void notifyDataChanged() {
        if (mDataList == null || mDataList.isEmpty()) {return;}
        // TODO
        if (mDataList.size() < mIndex + 1) {return;}

        while (mDataList.size() > mIndex) {
            BaseBean bean = mDataList.get(mIndex++);
            addBeanLayout(bean);
        }





//        // for each, add template
//        for (BaseBean bean : mDataList) {
//            addBeanLayout(bean);
//        }
    }

    private void addBeanLayout(BaseBean bean) {
        View layout = getBeanLayout(bean);
        mRoot.addView(layout);

//
//        // get last bottom
//        // get height
//        int lastBottom = layout.getBottom();
//        if (lastBottom > mVisibleBottom) {
//            int lastIndex = mRoot.getChildCount() - 1;
//            updateLastIndex(lastIndex);
//        }

    }

    private View getBeanLayout(BaseBean bean) {
        if (bean instanceof Bean1) {
            return new Layout1(getContext(), bean. conntent);
        }
        else if (bean instanceof Bean2) {
            return new Layout2(getContext(), bean. conntent);

        }
        else if (bean instanceof Bean3) {
            return new Layout3(getContext(), bean.conntent);
        }
        else if (bean instanceof Bean4) {
            return new Layout4(getContext(), bean.conntent);
        }
        else if (bean instanceof Bean5) {
            return new Layout5(getContext(), bean.conntent);
        }
        else {
            addView(new TextView(getContext()));
        }
        return new View(getContext());
    }

    private void updateFirstIndex() {
        mFirstIndex++;
        Log.d(Tag.REUSE_IMAGE_VIEW, "=========================== mFirstIndex = " + mFirstIndex);
    }

    private void updateLastIndex(int lastIndex) {
        mLastIndex = lastIndex;
        Log.d(Tag.REUSE_IMAGE_VIEW, "=========================== mLastIndex = " + mLastIndex);
    }

    // addView
    // onScroll

    private int mVisibleTop = 0;
    private int mVisibleBottom = getHeight();


    private int mFirstIndex = 0;
    private int mLastIndex = 0;




    public void onVisibleChanged(int newTop, int oldTop) {
        mVisibleTop = newTop;
        mVisibleBottom = newTop + getHeight();
        Log.d(Tag.REUSE_IMAGE_VIEW, "======================================== mVisibleTop = " + mVisibleTop);
        Log.d(Tag.REUSE_IMAGE_VIEW, "======================================== mVisibleBottom = " + mVisibleBottom);


//        // update first index
//        int firstBottom = mRoot. getChildAt(mFirstIndex). getBottom();
//        Log.d(Tag.REUSE_IMAGE_VIEW, "======================================== firstBottom = " + firstBottom);
//        if (firstBottom < mVisibleTop) {
//            updateFirstIndex();
//        }
//        // update last index




        // first visible index
        // lastVisible index;

        // new old

//        int newFirstIndex = mFirstIndex;
//        int newLastIndex = mLastIndex;
//
//        for (int i = 0; i < mRoot.getChildCount(); i++) {
////            int
//
//        }

        // TODO add view



        // TODO removeView



















    }






    @Override
    protected void onScrollChanged(int left, int top, int oldTop, int oldt) {
        super.onScrollChanged(left, top, oldTop, oldt);
//        Log.d(Tag.REUSE_IMAGE_VIEW, "==================== onScrollChanged l = " + l);
//        Log.d(Tag.REUSE_IMAGE_VIEW, "==================== onScrollChanged oldtop = " + oldt);
//        Log.d(Tag.REUSE_IMAGE_VIEW, "==================== onScrollChanged top = " + t);
//        Log.d(Tag.REUSE_IMAGE_VIEW, "==================== onScrollChanged oldl = " + oldl);



//        Log.d(Tag.REUSE_IMAGE_VIEW, "============ mRoot.getChildCount() = " + mRoot.getChildCount());

        // TODO
        // isVisible
        // removeInVisible
        // addVisible

//        Log.d(Tag.REUSE_IMAGE_VIEW, "================ mRoot.getHeight() = " + mRoot.getHeight());
//        Log.d(Tag.REUSE_IMAGE_VIEW, "================ this.getHeight() = " + this.getHeight());

//        int visibleTop = t;
//        int visibleBottom = t + getHeight();
//        Log.d(Tag.REUSE_IMAGE_VIEW, "======================================== visibleTop = " + visibleTop);
//        Log.d(Tag.REUSE_IMAGE_VIEW, "======================================== visibleBottom = " + visibleBottom);

        onVisibleChanged(top, oldTop);

        // visible child
        // onChildInVisible
        // onChildVisible



        // update first visible index
        // update last visible index







//        if (mRoot.getChildCount() > 1) {
//
//
//            View child1 = mRoot.getChildAt(0);
////            Log.d(Tag.REUSE_IMAGE_VIEW, "=================== child2.getTop() = " + child2.getTop());
//            Log.d(Tag.REUSE_IMAGE_VIEW, "====================================== child1.getBottom() = " + child1.getBottom());
//
//
//            View child5 = mRoot.getChildAt(4);
//            Log.d(Tag.REUSE_IMAGE_VIEW, "========================================== child5.getTop() = " + child5.getTop());
//
//
//
//
//
//
//
//
//
//
//
//
//        }





    }


}
