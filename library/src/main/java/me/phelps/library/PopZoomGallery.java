package me.phelps.library;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.PopupWindow;

import java.util.ArrayList;

/**
 * Created by phelps on 2015/3/9.
 */
public class PopZoomGallery extends PopupWindow {

    private Context mContext;
    private ZoomGallery mGallery;

    private ArrayList<ZoomImageModel> mZoomImageList;
    private boolean animated = true;//flag to show animation
    private GridView mGridView;

    public PopZoomGallery(Context context, GridView gridView, ArrayList<String> mImageList) {
        super(context);
        mContext = context;
        mZoomImageList = new ArrayList<>();
        mGridView = gridView;
        updateImages(mImageList);

        setupPop();
    }

    public void updateImages(ArrayList<String> mImageList) {
        for (int i = 0; i < mGridView.getCount(); i++) {
            View child = mGridView.getChildAt(i);

            ZoomImageModel imageScale = new ZoomImageModel();
            //得到小图大小矩阵
            if (child != null) {
                int[] xy = new int[2];
                child.getLocationInWindow(xy);
                imageScale.rect = new Rect(xy[0], xy[1], xy[0] + child.getWidth(), xy[1] + child.getHeight());
            } else {
                imageScale.rect = new Rect();
            }

            imageScale.smallImagePath = mImageList.get(i);
            imageScale.bigImagePath = mImageList.get(i);
            mZoomImageList.add(imageScale);
        }
    }

    private void setupPop() {
        mGallery = new ZoomGallery(mContext, this);
        setContentView(mGallery);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// 给popupWindow设置背景
        setAnimationStyle(0);
    }

    //显示
    public void showPop(int position) {
        showAtLocation(mGridView, Gravity.BOTTOM, 0, 0);
        mGallery.open(mZoomImageList, position);
    }

    @Override
    public void dismiss() {
        if (animated) {
            animated = false;
            mGallery.close();
        } else
            super.dismiss();

    }


}
