package com.ricardo.threescreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView mRecycleView, mRecycleView_middle;

    List<String> mList = new ArrayList<>();
    List<String> middleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = findViewById(R.id.recyclerView);
        mRecycleView_middle = findViewById(R.id.recyclerView_middle);

        // 构造数据
        for (int i = 1; i <= 20; ++i) {
            mList.add("标题" + i);
        }


        BaseRecycleAdapter baseRecycleAdapter = new BaseRecycleAdapter<String, leftViewHolder>(mList, R.layout.item_list, leftViewHolder.class);
        mRecycleView.setAdapter(baseRecycleAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecycleView.setLayoutManager(layoutManager);
        mRecycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        baseRecycleAdapter.setOnItemClickListener(new OnItemClickListener() {
            int pre = -1;

            @Override
            public void onItemClick(Object itemData, View view, int position) {
                // 重写item被点击后要处理的事情
                Toast.makeText(MainActivity.this, "点击了标题" + (position + 1), Toast.LENGTH_SHORT).show();

                if (pre == position) {
                    return ;
                }
                pre = position;

                // 构造子项数据
                middleList.clear();
                for (int i = 1; i <= (position + 1); ++i) {
                    middleList.add("标题" + (position + 1) +"-"+i);
                }

                BaseRecycleAdapter baseRecycleAdapter_middle = new BaseRecycleAdapter<String, middleViewHolder>(middleList, R.layout.middle_item, middleViewHolder.class);
                mRecycleView_middle.setAdapter(baseRecycleAdapter_middle);
                LinearLayoutManager layoutManager_middle = new LinearLayoutManager(MainActivity.this);
                mRecycleView_middle.setLayoutManager(layoutManager_middle);
                mRecycleView_middle.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));

                baseRecycleAdapter_middle.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(Object itemData, View view, int position) {
                        // 重写item被点击后要处理的事情
                        Toast.makeText(MainActivity.this, "点击了标题" + (pre + 1) + "-" + (position + 1), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }



}