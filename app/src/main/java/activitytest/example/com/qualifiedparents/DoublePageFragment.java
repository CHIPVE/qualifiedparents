package activitytest.example.com.qualifiedparents;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import activitytest.example.com.qualifiedparents.db.Note;
import activitytest.example.com.qualifiedparents.doublePageQuestion.EditPage10;
import activitytest.example.com.qualifiedparents.doublePageQuestion.EditPage11;
import activitytest.example.com.qualifiedparents.doublePageQuestion.EditPage12;
import activitytest.example.com.qualifiedparents.doublePageQuestion.EditPage2;
import activitytest.example.com.qualifiedparents.doublePageQuestion.EditPage7;
import activitytest.example.com.qualifiedparents.doublePageQuestion.EditPage8;
import activitytest.example.com.qualifiedparents.doublePageQuestion.SingleChoice1;
import activitytest.example.com.qualifiedparents.doublePageQuestion.SingleChoice3;
import activitytest.example.com.qualifiedparents.doublePageQuestion.SingleChoice4;
import activitytest.example.com.qualifiedparents.doublePageQuestion.SingleChoice5;
import activitytest.example.com.qualifiedparents.doublePageQuestion.SingleChoice6;
import activitytest.example.com.qualifiedparents.doublePageQuestion.SingleChoice9;

import static android.content.Context.MODE_PRIVATE;

public class DoublePageFragment extends Fragment {

    private TextView timeText;
    private TextView eventText;
    private ViewPager doublePageFragmentViewPaper;
    private DoublePageFragmentViewPaperAdapter adapter;
    int id;

    public final String TAG = "DoublePageFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.doublepagefragment, container, false);

        final TextView question_index = (TextView) view.findViewById(R.id.question_index);
        final TextView question_info = (TextView) view.findViewById(R.id.question_info);

        doublePageFragmentViewPaper = (ViewPager) view.findViewById(R.id.doublepage_viewpager);


        adapter = new DoublePageFragmentViewPaperAdapter(getChildFragmentManager());
        adapter.addFragment(new SingleChoice1());
        adapter.addFragment(new EditPage2());
        adapter.addFragment(new SingleChoice3());
        adapter.addFragment(new SingleChoice4());
        adapter.addFragment(new EditPage10());
        adapter.addFragment(new EditPage11());
        adapter.addFragment(new SingleChoice5());
        adapter.addFragment(new SingleChoice6());
        adapter.addFragment(new EditPage7());
        adapter.addFragment(new EditPage8());
        adapter.addFragment(new SingleChoice9());
        adapter.addFragment(new EditPage12());
        doublePageFragmentViewPaper.setAdapter(adapter);

        doublePageFragmentViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                question_index.setText(doublePageFragmentViewPaper.getCurrentItem()+3+"");
                if(doublePageFragmentViewPaper.getCurrentItem()<6){
                    question_info.setText("从事件中认识您的情绪");
                }
                else if(doublePageFragmentViewPaper.getCurrentItem()<10)
                    question_info.setText("从事件中了解孩子的情绪");
                else
                    question_info.setText("分析矛盾点");
            }
            @Override
            public void onPageSelected(int position) {
//                当 ViewPager 滑动后设置BottomNavigationView 选中相应选项

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        SharedPreferences pref = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        id = pref.getInt("id", -1);

        Note note = DataSupport.find(Note.class, id);
        timeText = (TextView) view.findViewById(R.id.time_text);
        eventText = (TextView) view.findViewById(R.id.event_text);
        timeText.setText(note.getItem1());
        eventText.setText(note.getItem2());


        Log.d(TAG, "onCreateView");

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        doublePageFragmentViewPaper.setAdapter(adapter);


        Log.d(TAG, "onActivityCreated");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences pref = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        int doublepage = pref.getInt("doublepage", 0);
        doublePageFragmentViewPaper.setCurrentItem(doublepage);
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }
}
