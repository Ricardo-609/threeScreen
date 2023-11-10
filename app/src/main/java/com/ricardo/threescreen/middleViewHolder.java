package com.ricardo.threescreen;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import butterknife.BindView;
import butterknife.ButterKnife;

public class middleViewHolder extends BaseViewHolder<String> {

    @BindView(R.id.textView_middle)
    TextView textView_middle;


    public middleViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    protected void initItemView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void loadItemData(Context context, String data, int position) {
//        textView_middle.setText(String.valueOf("标题2-" + (position + 1)));
        textView_middle.setText(data);
    }
}
