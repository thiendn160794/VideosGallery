package com.example.thiendn.tempproject;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;

/**
 * Created by thiendn on 10/3/17.
 */

public class TestItemDecoration extends RecyclerView.ItemDecoration{
    private Paint paint;

    public TestItemDecoration(Paint paint) {
        this.paint = paint;
    }
}
