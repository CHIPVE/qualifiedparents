package activitytest.example.com.qualifiedparents;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import activitytest.example.com.qualifiedparents.db.Note;

public class ItemActivity extends AppCompatActivity {
    int note_id;
    TextView tx1;
    TextView tx2;
    TextView tx3;
    TextView tx4;
    TextView tx5;
    TextView tx6;
    TextView tx7;
    TextView tx8;
    TextView tx9;
    TextView tx10;
    TextView tx11;
    TextView tx12;
    TextView tx13;
    TextView tx14;
    TextView tx15;
    TextView tx16;
    Button write_button;
    Button del_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        String sID=getIntent().getStringExtra("note_id");
        note_id=Integer.parseInt(sID);      //String转int
        Note note = DataSupport.find(Note.class, note_id);

        write_button = (Button)findViewById(R.id.write_button);
        del_button = (Button)findViewById(R.id.del_button);

        write_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemActivity.this, QuestionActivity.class);
                intent.putExtra("id",note_id+"");
                intent.putExtra("rewrite",  "1");      // id+"" 这样是把int转成String类型, 否则会报错
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        });

        del_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ItemActivity.this);
                //    设置Title的内容
                builder2.setTitle("删除记录");
                //    设置Content来显示一个信息
                builder2.setMessage("您是否要删除本次记录的内容？");
                //    设置一个PositiveButton
                builder2.setPositiveButton("不删除", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {


                    }
                });
                //    设置一个NegativeButton
                builder2.setNegativeButton("删除", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        DataSupport.delete(Note.class, note_id);
                        Intent intent = new Intent(ItemActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        overridePendingTransition(0, 0);
                    }
                });
                builder2.show();
            }
        });

        tx1 = (TextView)findViewById(R.id.time);
        tx2 = (TextView)findViewById(R.id.description2);
        tx3 = (TextView)findViewById(R.id.myemotion2);

        tx4 = (TextView)findViewById(R.id.done2);

        tx5 = (TextView)findViewById(R.id.infulence2);

        tx6 = (TextView)findViewById(R.id.convey2);

        tx7 = (TextView)findViewById(R.id.origin2);

        tx8 = (TextView)findViewById(R.id.now2);

        tx9 = (TextView)findViewById(R.id.itsemotion2);

        tx10 = (TextView)findViewById(R.id.can2);

        tx11 = (TextView)findViewById(R.id.doing2);

        tx12 = (TextView)findViewById(R.id.contradiction2);


        tx13 = (TextView)findViewById(R.id.point2);

        tx14 = (TextView)findViewById(R.id.solution2);

        tx15 = (TextView)findViewById(R.id.result2);

        tx16 = (TextView)findViewById(R.id.finally1);



        if(note != null){
            if(note.getItem1() != null)
                if(note.getItem1().length()>0)
                    tx1.setText(note.getItem1());

            if(note.getItem2() != null)
                if(note.getItem2().length()>0)
                    tx2.setText(note.getItem2());

            if(note.getItem3() != null)
                if(note.getItem3().length()>0)
                    tx3.setText(note.getItem3());

            if(note.getItem4() != null)
                if(note.getItem4().length()>0)
                    tx4.setText(note.getItem4());

            if(note.getItem5()!= null)
                if(note.getItem5().length()>0){
                    if(note.getItem5().indexOf("A")!=-1)
                        tx5.setText("严重影响");
                    if(note.getItem5().indexOf("B")!=-1)
                        tx5.setText("有影响");
                    if(note.getItem5().indexOf("C")!=-1)
                        tx5.setText("没有影响");
                }

            if(note.getItem6()!= null)
                if(note.getItem6().length()>0){
                    if(note.getItem6().indexOf("A")!=-1)
                        tx6.setText("很不一致");
                    if(note.getItem6().indexOf("B")!=-1)
                        tx6.setText("有些不一致");
                    if(note.getItem6().indexOf("C")!=-1)
                        tx6.setText("完全一致");
                }

            if(note.getItem7() != null)
                if(note.getItem7().length()>0)
                    tx7.setText(note.getItem7());

            if(note.getItem8() != null)
                if(note.getItem8().length()>0)
                    tx8.setText(note.getItem8());

            if(note.getItem9() != null)
                if(note.getItem9().length()>0)
                    tx9.setText(note.getItem9());

            if(note.getItem10()!= null)
                if(note.getItem10().length()>0){
                    if(note.getItem10().indexOf("A")!=-1)
                        tx10.setText("很不一致");
                    if(note.getItem10().indexOf("B")!=-1)
                        tx10.setText("有些不一致");
                    if(note.getItem10().indexOf("C")!=-1)
                        tx10.setText("完全一致");
                }

            if(note.getItem11() != null)
                if(note.getItem11().length()>0)
                    tx11.setText(note.getItem11());

            if(note.getItem12() != null)
                if(note.getItem12().length()>0)
                    tx12.setText(note.getItem12());


            if(note.getItem13()!= null)
                if(note.getItem13().length()>0){
                    if(note.getItem13().indexOf("A")!=-1)
                        tx13.setText("大部分是您的原因");
                    if(note.getItem13().indexOf("B")!=-1)
                        tx13.setText("大部分是孩子的原因");
                    if(note.getItem13().indexOf("C")!=-1)
                        tx13.setText("双方情绪/观念/需求发生冲突");
                }


            if(note.getItem15() != null)
                if(note.getItem15().length()>0){
                String str1 = new String();
                str1 = "";
                    if(note.getItem15().indexOf("A")!=-1)
                        str1+="拥抱拉近距离";
                    if(note.getItem15().indexOf("B")!=-1)
                        str1+="共情，理解孩子";
                    if(note.getItem15().indexOf("C")!=-1)
                        str1+="积极暂停，迅速安抚情绪";
                    if(note.getItem15().indexOf("D")!=-1)
                        str1+="选择轮，关注解决方法";
                    if(note.getItem15().indexOf("E")!=-1)
                        str1+="日程表，建立成就感";
                    if(note.getItem15().indexOf("F")!=-1)
                        str1+="启发式提问，培养独立思考";
                    if(note.getItem15().indexOf("G")!=-1)
                        str1+="4个R，向孩子承认错误";
                    if(note.getItem15().indexOf("H")!=-1)
                        str1+="7个步骤，赢的孩子";
                    if(note.getItem15().indexOf("I")!=-1)
                        str1+="鼓励，培养孩子的自信";
                    if(note.getItem15().indexOf("J")!=-1)
                        str1+="自然结果，让孩子学会承担后果";

                    tx14.setText(str1);
                }


            if(note.isSolve())
                    tx15.setText("已解决");
            else
                tx15.setText("未解决");

            if(note.getItem16() != null)
                if(note.getItem16().length()>0)
                    tx16.setText(note.getItem16());

        }
        else{
            Intent intent = new Intent(ItemActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(0, 0);
        }

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            Intent intent = new Intent(ItemActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(0, 0);
        }

        return false;

    }

}
