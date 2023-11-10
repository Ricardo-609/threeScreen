# ThreeScreen
使用fragment、RecyclerView实现了将屏幕划分为三份，其中前两部分存在跳转关系，即点击第一块中的item会刷新第二块中RecyclerView的item。

## 亮点
封装了RecyclerView的Adapter和viewHolder的通用部分，可以重用
在使用时只需要编写以下代码：
```
        BaseRecycleAdapter baseRecycleAdapter = new BaseRecycleAdapter<String, leftViewHolder>(mList, R.layout.item_list, leftViewHolder.class);
        mRecycleView.setAdapter(baseRecycleAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecycleView.setLayoutManager(layoutManager);
        mRecycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        baseRecycleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Object itemData, View view, int position) {
                // 重写item被点击后要处理的事情
                Toast.makeText(MainActivity.this, "点击了标题" + (position + 1), Toast.LENGTH_SHORT).show();
        });
```

## TODO
第二块的RecyclerView的item高度会随着点击第一个RecyclerView的不同item会增高。
