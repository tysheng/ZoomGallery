package me.phelps.zoomgallery;

import android.content.Context;

/**
 * Created by phelps on 2014/6/11.
 */
public class ScreenUtil {
    /**
     * 从 dp 转成为 px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
