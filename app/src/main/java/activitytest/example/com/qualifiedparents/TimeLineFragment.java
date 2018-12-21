package activitytest.example.com.qualifiedparents;

import android.app.Application;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class  TimeLineFragment extends Fragment {

    private RecyclerView Rv;
    private ArrayList<HashMap<String,Object>> listItem;
    private TimeLineAdapter myAdapter;
    private SwipeRefreshLayout swipeRefresh;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timeline_fragment, container, false);

        // 初始化显示的数据
        initData();

        // 绑定数据到RecyclerView
        initView(view);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApplication.getContext(), "FAB clicked", Toast.LENGTH_SHORT).show();
            }
        });

        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshTimeLine(inflater,container);
            }
        });


        return view;
    }

    public void initData(){
        listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/

        HashMap<String, Object> map1 = new HashMap<String, Object>();
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        HashMap<String, Object> map3 = new HashMap<String, Object>();
        HashMap<String, Object> map4 = new HashMap<String, Object>();
        HashMap<String, Object> map5 = new HashMap<String, Object>();
        HashMap<String, Object> map6 = new HashMap<String, Object>();
        HashMap<String, Object> map7 = new HashMap<String, Object>();
        HashMap<String, Object> map8 = new HashMap<String, Object>();
        HashMap<String, Object> map9 = new HashMap<String, Object>();

        map1.put("ItemTitle", "我在大街上骑自行车带着女儿，女儿在后座睡着了，但我不希望她在路上睡觉，她会着凉的，所以我叫醒了她。");

        listItem.add(map1);

        map2.put("ItemTitle", "今天要期末考试了,昨天晚上,让她把重点复习一下,早点睡,结果进去一看,又在看什么儿童文学,我的情绪一下就上来了,");

        listItem.add(map2);

        map3.put("ItemTitle", "周末晚上孩子上网玩游戏,妈妈问她什么时候睡,孩子说要等到“杀死”一个怪物,大概需要十分钟。平时女儿都要和妈妈");

        listItem.add(map3);

        map4.put("ItemTitle", "本来约定周末一起去看电影,结果刮台风,下暴雨,根本无法出门,儿子就大声哭了起来,并且说一些气人的话:坏爸爸,说好了");

        listItem.add(map4);

        map5.put("ItemTitle", "本来约定周末一起去看电影,结果刮台风,下暴雨,根本无法出门,儿子就大声哭了起来,并且说一些气人的话:坏爸爸,说好了");

        listItem.add(map5);

        map6.put("ItemTitle", "本来约定周末一起去看电影,结果刮台风,下暴雨,根本无法出门,儿子就大声哭了起来,并且说一些气人的话:坏爸爸,说好了");

        listItem.add(map6);
        map7.put("ItemTitle", "本来约定周末一起去看电影,结果刮台风,下暴雨,根本无法出门,儿子就大声哭了起来,并且说一些气人的话:坏爸爸,说好了");

        listItem.add(map7);
        map8.put("ItemTitle", "本来约定周末一起去看电影,结果刮台风,下暴雨,根本无法出门,儿子就大声哭了起来,并且说一些气人的话:坏爸爸,说好了");

        listItem.add(map8);
        map9.put("ItemTitle", "本来约定周末一起去看电影,结果刮台风,下暴雨,根本无法出门,儿子就大声哭了起来,并且说一些气人的话:坏爸爸,说好了");

        listItem.add(map9);

    }

    // 绑定数据到RecyclerView
    public void initView(View view){

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int widths = size.x;
        int height = size.y;



        Rv = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        //使用线性布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext()){
            @Override
            public boolean canScrollVertically() {
                // 直接禁止垂直滑动
                return false;
            }
        };
        Rv.setLayoutManager(layoutManager);
        Rv.setHasFixedSize(true);
        Rv.setNestedScrollingEnabled(false);
        //用自定义分割线类设置分割线
        Rv.addItemDecoration(new TimeLineItemDecoration(MyApplication.getContext(),size));

        //为ListView绑定适配器
        myAdapter = new TimeLineAdapter(MyApplication.getContext(),listItem);
        Rv.setAdapter(myAdapter);
    }

    private void refreshTimeLine(final LayoutInflater inflater, final ViewGroup container) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        View view = inflater.inflate(R.layout.timeline_fragment, container, false);
                        // 初始化显示的数据
                        initData();
                        // 绑定数据到RecyclerView
                        initView(view);
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

}