package com.ricardo.threescreen;

import android.view.View;

//点击事件监听
public interface OnItemClickListener<D> {

    void onItemClick(D itemData, View view, int position);

}
