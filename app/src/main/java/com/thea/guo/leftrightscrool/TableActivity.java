package com.thea.guo.leftrightscrool;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.thea.guo.leftrightscrool.adapter.MyLeftAdapter;
import com.thea.guo.leftrightscrool.adapter.MyRightAdapter;
import com.thea.guo.leftrightscrool.model.RightModel;
import com.thea.guo.leftrightscrool.tool.UtilTools;
import com.thea.guo.leftrightscrool.view.SyncHorizontalScrollView;

public class TableActivity extends Activity {
    private LinearLayout leftContainerView;
    private ListView leftListView;
    private List<String> leftlList;
    private LinearLayout rightContainerView;
    private ListView rightListView;
    private List<RightModel> models;
    private SyncHorizontalScrollView titleHorsv;
    private SyncHorizontalScrollView contentHorsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tab_view);

        leftContainerView = (LinearLayout) findViewById(R.id.left_container);
        leftListView = (ListView) findViewById(R.id.left_container_listview);

        rightContainerView = (LinearLayout) findViewById(R.id.right_container);
        rightListView = (ListView) findViewById(R.id.right_container_listview);
        /* 右侧标题scroll*/
        titleHorsv = (SyncHorizontalScrollView) findViewById(R.id.title_horsv);
		/*右侧内容的父容器 实现水平滚动*/
        contentHorsv = (SyncHorizontalScrollView) findViewById(R.id.content_horsv);
        // ��������ˮƽ�ؼ�������
        titleHorsv.setScrollView(contentHorsv);
        contentHorsv.setScrollView(titleHorsv);

        // ��������������
        leftContainerView.setBackgroundColor(Color.YELLOW);
        initLeftData();
        MyLeftAdapter adapter = new MyLeftAdapter(this, leftlList);
        leftListView.setAdapter(adapter);
        UtilTools.setListViewHeightBasedOnChildren(leftListView);
        // ����ұ���������
        rightContainerView.setBackgroundColor(Color.BLUE);
        initRightData();
        MyRightAdapter myRightAdapter = new MyRightAdapter(this, models);
        rightListView.setAdapter(myRightAdapter);
        UtilTools.setListViewHeightBasedOnChildren(rightListView);
    }

    private void initRightData() {
        models = new ArrayList<RightModel>();
        models.add(new RightModel("1", "222", "333", "444", "555", "666"));
        models.add(new RightModel("2", "222", "333", "444", "555", "666"));
        models.add(new RightModel("3", "222", "333", "444", "555", "666"));
        models.add(new RightModel("4", "222", "333", "444", "555", "666"));
        models.add(new RightModel("5", "222", "333", "444", "555", "666"));
        models.add(new RightModel("6", "222", "333", "444", "555", "666"));
        models.add(new RightModel("7", "222", "333", "444", "555", "666"));
        models.add(new RightModel("8", "222", "333", "444", "555", "666"));
        models.add(new RightModel("9", "222", "333", "444", "555", "666"));
        models.add(new RightModel("10", "222", "333", "444", "555", "666"));
        models.add(new RightModel("11", "222", "333", "444", "555", "666"));

    }

    private void initLeftData() {
        leftlList = new ArrayList<String>();
        leftlList.add("1");
        leftlList.add("2");
        leftlList.add("3");
        leftlList.add("4");
        leftlList.add("5");
        leftlList.add("6");
        leftlList.add("7");
        leftlList.add("8");
        leftlList.add("9");
        leftlList.add("10");
    }
}