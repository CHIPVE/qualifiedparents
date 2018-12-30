package activitytest.example.com.qualifiedparents;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;

import activitytest.example.com.qualifiedparents.db.Note;

public class QuestionActivity extends AppCompatActivity {

    ViewPager questionActivityViewPager;
    QuestionActivityViewPaperAdapter adapter;
    int id;
    int rewrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Button answer_button = (Button) findViewById(R.id.answer_button);
        answer_button.setVisibility(View.GONE);

        Button back_button = (Button) findViewById(R.id.back_button);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
                AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivity.this);
                //    设置Title的内容
                builder.setTitle("退出记录");
                //    设置Content来显示一个信息
                builder.setMessage("您是否要退出本次记录的内容？");
                //    设置一个PositiveButton
                builder.setPositiveButton("继续记录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                //    设置一个NegativeButton
                builder.setNegativeButton("退出记录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        AlertDialog.Builder builder2 = new AlertDialog.Builder(QuestionActivity.this);
                        //    设置Title的内容
                        builder2.setTitle("保存记录");
                        //    设置Content来显示一个信息
                        builder2.setMessage("将不会保存没有时间和事件的记录，您是否要放弃本次记录的内容？");
                        //    设置一个PositiveButton
                        builder2.setPositiveButton("保存本次记录", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                overridePendingTransition(0, 0);

                            }
                        });
                        //    设置一个NegativeButton
                        builder2.setNegativeButton("放弃本次记录", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DataSupport.delete(Note.class, id);
                                Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                overridePendingTransition(0, 0);
                            }
                        });
                        builder2.show();

                    }
                });
                builder.show();
        }
        });

        String sID=getIntent().getStringExtra("id");
        id=Integer.parseInt(sID);      //String转int

        String sID2=getIntent().getStringExtra("rewrite");
        rewrite=Integer.parseInt(sID2);      //String转int

        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putInt("id", id);
        editor.putInt("rewrite", rewrite);
        editor.putInt("doublepage", 0);
        editor.apply();

        questionActivityViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        adapter = new QuestionActivityViewPaperAdapter(getSupportFragmentManager());

        adapter.addFragment(new BeginPageFragment());
        adapter.addFragment(new InfomationPageFragment1());
        adapter.addFragment(new SinglePageFragment1());
        adapter.addFragment(new SinglePageFragment2());
        adapter.addFragment(new InfomationPageFragment0());
        adapter.addFragment(new InfomationPageFragment2());
        adapter.addFragment(new DoublePageFragment());
        adapter.addFragment(new InfomationPageFragment3());
        adapter.addFragment(new AnswerPageFragment());
        adapter.addFragment(new CardPageFragment());
        adapter.addFragment(new CommunicationPageFragment());
        adapter.addFragment(new ResultPageFragment());
        adapter.addFragment(new SavePageFragment());

        questionActivityViewPager.setAdapter(adapter);

        questionActivityViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                Note note = new Note();
                note.updateAll("Tag_id = ?", id+"");
                Button back_button = (Button) findViewById(R.id.back_button);
                Button answer_button = (Button) findViewById(R.id.answer_button);
                if(position == 0) {
                    answer_button.setVisibility(View.GONE);
                }else
                    answer_button.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        if(rewrite == 1)
            questionActivityViewPager.setCurrentItem(9);

        answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionActivityViewPager.setCurrentItem(9);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
            AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivity.this);
            //    设置Title的内容
            builder.setTitle("退出记录");
            //    设置Content来显示一个信息
            builder.setMessage("您是否要退出本次记录的内容？");
            //    设置一个PositiveButton
            builder.setPositiveButton("继续记录", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {

                }
            });
            //    设置一个NegativeButton
            builder.setNegativeButton("退出记录", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {

                    AlertDialog.Builder builder2 = new AlertDialog.Builder(QuestionActivity.this);
                    //    设置Title的内容
                    builder2.setTitle("保存记录");
                    //    设置Content来显示一个信息
                    builder2.setMessage("将不会保存没有时间和事件的记录，您是否要放弃本次记录的内容？");
                    //    设置一个PositiveButton
                    builder2.setPositiveButton("保存本次记录", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            overridePendingTransition(0, 0);

                        }
                    });
                    //    设置一个NegativeButton
                    builder2.setNegativeButton("放弃本次记录", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            DataSupport.delete(Note.class, id);
                            Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            overridePendingTransition(0, 0);
                        }
                    });
                    builder2.show();

                }
            });
            builder.show();

        }

        return false;

    }

}
