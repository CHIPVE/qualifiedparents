package activitytest.example.com.qualifiedparents;

import android.app.Application;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import activitytest.example.com.qualifiedparents.db.Note;


public class  TimeLineFragment extends Fragment {

    private RecyclerView Rv;
    private ArrayList<HashMap<String,Object>> listItem;
    private TimeLineAdapter myAdapter;
    private SwipeRefreshLayout swipeRefresh;
    private List<Note> noteList;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timeline_fragment, container, false);


        // 初始化显示的数据
        listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
        initData();
        myAdapter = new TimeLineAdapter(getActivity(),listItem);
        Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), MonthlyTestActivity.class);
                startActivity(intent);
                getActivity().finish();
                getActivity().overridePendingTransition(0, 0);
            }
        });
        // 绑定数据到RecyclerView
        initView(view);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note();
                note.setSolve(false);
                note.setTime();
                note.save();
                Intent intent = new Intent(getActivity(), QuestionActivity.class);
                intent.putExtra("id",  note.getId()+"");
                intent.putExtra("rewrite",  "0"); // id+"" 这样是把int转成String类型, 否则会报错
                startActivity(intent);
                getActivity().finish();
                getActivity().overridePendingTransition(0, 0);
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


        noteList = DataSupport.findAll(Note.class);
        listItem.clear();
        if(noteList.size()>0){
            for(int i= noteList.size()-1;i>=0;i--){
                HashMap<String, Object> map0 = new HashMap<String, Object>();
                if(noteList.get(i).getBrief() == null)
                    DataSupport.delete(Note.class,noteList.get(i).getId());
                if(noteList.get(i).getBrief().length() == 0)
                    DataSupport.delete(Note.class,noteList.get(i).getId());
                map0.put("ItemTitle",noteList.get(i).getBrief());
                listItem.add(map0);
            }
        }
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        HashMap<String, Object> map3 = new HashMap<String, Object>();


        map1.put("ItemTitle", "我在大街上骑自行车带着女儿，女儿在后座睡着了，但我不希望她在路上睡觉，她会着凉的，所以我叫醒了她。");

        listItem.add(map1);

        map2.put("ItemTitle", "新手引导2");

        listItem.add(map2);

        map3.put("ItemTitle", "新手引导1");

        listItem.add(map3);

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()){
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
        Rv.addItemDecoration(new TimeLineItemDecoration(getActivity(),size,noteList));

        //为ListView绑定适配器

        Rv.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new TimeLineAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(position<listItem.size()-3) {
                    Note note = noteList.get(noteList.size() - 1 - position);
                    Intent intent = new Intent(getActivity(), ItemActivity.class);
                    intent.putExtra("note_id", note.getId() + "");      // id+"" 这样是把int转成String类型, 否则会报错
                    startActivity(intent);
                    getActivity().finish();
                    getActivity().overridePendingTransition(0, 0);
                }
                else{
                    if(position == listItem.size()-3){
                        Intent intent = new Intent(getActivity(), PictureActivity.class);
                        intent.putExtra("picture",  "11");
                        startActivity(intent);
                    }
                    if(position == listItem.size()-2){
                        Intent intent = new Intent(getActivity(), PictureActivity.class);
                        intent.putExtra("picture",  "12");
                        startActivity(intent);
                    }
                    if(position == listItem.size()-1){
                        Intent intent = new Intent(getActivity(), PictureActivity.class);
                        intent.putExtra("picture",  "13");
                        startActivity(intent);
                    }
                }
            }
        });

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
                        initData();
                        myAdapter.notifyDataSetChanged();
                        initView(view);
                        view.requestLayout();
                        getActivity().finish();
                        startActivity(getActivity().getIntent());
                        getActivity().overridePendingTransition(0, 0);
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
    @Override
    public void onResume() {
        super.onResume();
        }
    }

