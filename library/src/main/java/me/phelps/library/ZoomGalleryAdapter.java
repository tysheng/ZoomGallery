package me.phelps.library;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


public class ZoomGalleryAdapter extends PagerAdapter {

    private ArrayList<ZoomImageModel> mZoomImageList;

    private ZoomGalleryTapListener mListener;

    public ZoomGalleryAdapter(ZoomGalleryTapListener listener) {
        mListener = listener;

    }

    public void update(ArrayList<ZoomImageModel> zoomImageList) {
        mZoomImageList = zoomImageList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mZoomImageList == null ? 0 : mZoomImageList.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, final int position) {

        PhotoView imageView = new PhotoView(container.getContext());

        imageView.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float v, float v2) {
                if (mListener != null) {
                    mListener.tap(position);
                }
            }
        });
        Glide.with(container.getContext().getApplicationContext())
                .load(mZoomImageList.get(position).bigImagePath)
                .into(imageView);

        container.addView(imageView, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public interface ZoomGalleryTapListener {
        void tap(int position);
    }



}
