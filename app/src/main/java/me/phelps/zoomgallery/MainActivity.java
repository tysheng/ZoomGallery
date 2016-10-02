package me.phelps.zoomgallery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import me.phelps.library.PopZoomGallery;


public class MainActivity extends AppCompatActivity {

    private GridView mGridView;

    private GridViewAdapter mAdapter;

    private ArrayList<String> mImageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);


        mGridView = (GridView) findViewById(R.id.grid_view);
        mAdapter = new GridViewAdapter();
        mGridView.setAdapter(mAdapter);

        mImageList.add("http://h.hiphotos.baidu.com/image/pic/item/ac345982b2b7d0a213987e5cc9ef76094a369a99.jpg");
        mImageList.add("http://d.hiphotos.baidu.com/image/pic/item/0ff41bd5ad6eddc4aa295b333bdbb6fd53663328.jpg");
        mImageList.add("http://h.hiphotos.baidu.com/image/pic/item/ac345982b2b7d0a213987e5cc9ef76094a369a99.jpg");
        mImageList.add("http://d.hiphotos.baidu.com/image/pic/item/3c6d55fbb2fb4316365895b222a4462308f7d3b7.jpg");
        mImageList.add("http://c.hiphotos.baidu.com/image/pic/item/d1a20cf431adcbef546504c7aeaf2edda2cc9f99.jpg");
        mImageList.add("http://f.hiphotos.baidu.com/image/pic/item/caef76094b36acaf0bb1ec3d7ed98d1000e99c99.jpg");
        mImageList.add("https://bbsstaticoss.hoopchina.com.cn/aHR0cDovL2h1cHUtaTFpNS5pbWctY24taGFuZ3pob3UuYWxpeXVuY3MuY29tL3RvdWNoLzI4OS8yNTQ0MTI4OS90b3VjaF9iYnNfdGhyZWFkX2ltZ18yNTQ0MTI4OV8xNDc1MzU3NzkxLjU3NDguanBlZw");
        mImageList.add("http://b.hiphotos.baidu.com/image/pic/item/8718367adab44aed2f8e87e3b11c8701a08bfbf0.jpg");
        mImageList.add("https://bbsstaticoss.hoopchina.com.cn/aHR0cDovL2h1cHUtaTFpNS5pbWctY24taGFuZ3pob3UuYWxpeXVuY3MuY29tL3RvdWNoLzI4OS8yNTQ0MTI4OS90b3VjaF9iYnNfdGhyZWFkX2ltZ18yNTQ0MTI4OV8xNDc1MzU3NzkxLjYzNC5qcGVn");


        mAdapter.update(mImageList);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                new PopZoomGallery(MainActivity.this, mGridView,mImageList).showPop(position);
            }
        });
    }
    
}
