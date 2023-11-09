package com.ricardo.threescreen;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class leftViewHolder extends BaseViewHolder<String> {

    @BindView(R.id.textView)
    TextView textView;


    public leftViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    protected void initItemView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void loadItemData(Context context, String data, int position) {

        textView.setText(String.valueOf("标题1-" + (position + 1)));

    }
}
