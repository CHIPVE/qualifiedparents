package activitytest.example.com.qualifiedparents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BlogFragment extends Fragment {

    private TextView titleText;
    private Button backButton;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<String>();

    private List<String> provinceList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blog_fragment, container, false);
        titleText = (TextView) view.findViewById(R.id.title_text);
        backButton = (Button) view.findViewById(R.id.back_button);
        initData();
        listView = (ListView) view.findViewById(R.id.list_view);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

    public void initData(){

        titleText.setText("光荣榜");
        String map1 = new String();
        String map2 = new String();
        String map3 = new String();
        String map4 = new String();
        String map5 = new String();
        String map6 = new String();
        String map7 = new String();



        map1=("我在大街上骑自行车带着女儿，女儿在后座睡着了，但我不希望她在路上睡觉，她会着凉的，所以我叫醒了她。");

        dataList.add(map1);

        map2=("今天要期末考试了,昨天晚上,让她把重点复习一下,早点睡,结果进去一看,又在看什么儿童文学,我的情绪一下就上来了,");

        dataList.add(map2);

        map3=("本来约定周末一起去看电影,结果刮台风,下暴雨,根本无法出门,儿子就大声哭了起来,并且说一些气人的话:坏爸爸,说好了");

        dataList.add(map3);

        map4=("我在大街上骑自行车带着女儿，女儿在后座睡着了，但我不希望她在路上睡觉，她会着凉的，所以我叫醒了她。");

        dataList.add(map4);

        map5=("本来约定周末一起去看电影,结果刮台风,下暴雨,根本无法出门,儿子就大声哭了起来,并且说一些气人的话:坏爸爸,说好了");

        dataList.add(map5);
        for(int i=0;i<5;i++){
            map6=("我在大街上骑自行车带着女儿，女儿在后座睡着了，但我不希望她在路上睡觉，她会着凉的，所以我叫醒了她。");

            dataList.add(map6);

            map7=("本来约定周末一起去看电影,结果刮台风,下暴雨,根本无法出门,儿子就大声哭了起来,并且说一些气人的话:坏爸爸,说好了");

            dataList.add(map7);

        }


    }

}
