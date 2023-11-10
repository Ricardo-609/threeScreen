package com.ricardo.threescreen.BaseRecyclerView;

//长按事件监听
public interface OnItemLongClickListener<D> {

    boolean onItemLongClick(D data, int position);

}
