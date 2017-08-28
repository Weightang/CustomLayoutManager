package com.treey.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by tang on 2017/6/21.
 */

public class CustomLinearLayoutManager extends RecyclerView.LayoutManager {

    final CustomLinearLayoutManager seft = this;
    Context context;
    int dw;

    public CustomLinearLayoutManager(Context context) {
        this.context = context;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        this.dw = wm.getDefaultDisplay().getWidth();
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        int offsetX = 0;

        double itme = dw / getItemCount();
        for (int i = 0; i < getItemCount(); i++) {
            View scrap = recycler.getViewForPosition(i); // 根据position获取一个碎片view，可以从回收的view中获取，也可能新构造一个

            addView(scrap);
            measureChildWithMargins(scrap, 0, 0);  // 计算此碎片view包含边距的尺寸

            int width = getDecoratedMeasuredWidth(scrap);  // 获取此碎片view包含边距和装饰的宽度width
            int height = getDecoratedMeasuredHeight(scrap); // 获取此碎片view包含边距和装饰的高度height

            int offsx = (int) ((itme - width) / 2);

            layoutDecorated(scrap, offsx+offsetX, 0, offsetX + width+offsx, height); // Important！布局到RecyclerView容器中，所有的计算都是为了得出任意position的item的边界来布局

            offsetX += itme;
        }


    }
}
