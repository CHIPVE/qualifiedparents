package activitytest.example.com.qualifiedparents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import activitytest.example.com.qualifiedparents.db.Note;

import static android.content.Context.MODE_PRIVATE;

public class AnswerPageFragment extends Fragment {

    int id;
    String answer = new String();

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


    CheckBox cb1;

    CheckBox cb2;

    CheckBox cb3;

    CheckBox cb4;

    CheckBox cb5;

    CheckBox cb6;

    CheckBox cb7;

    CheckBox cb8;

    CheckBox cb9;

    CheckBox cb10;

    Button sub_button;

    int rewrite;

    public final String TAG = "LeftFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.answerpage, container, false);

        TextView question_index = (TextView) view.findViewById(R.id.question_index);
        question_index.setText("15");

        sub_button = (Button) view.findViewById(R.id.sub_button);

        sub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cb1.isChecked())
                    answer += cb1.getText().toString();

                if(cb2.isChecked())
                    answer += cb2.getText().toString();

                if(cb3.isChecked())
                    answer += cb3.getText().toString();

                if(cb4.isChecked())
                    answer += cb4.getText().toString();

                if(cb5.isChecked())
                    answer += cb5.getText().toString();

                if(cb6.isChecked())
                    answer += cb6.getText().toString();

                if(cb7.isChecked())
                    answer += cb7.getText().toString();

                if(cb8.isChecked())
                    answer += cb8.getText().toString();

                if(cb9.isChecked())
                    answer += cb9.getText().toString();

                if(cb10.isChecked())
                    answer += cb10.getText().toString();

                Note note = DataSupport.find(Note.class, id);
                if(note != null) {
                    note.setItem15(answer);
                    note.update(id);
                    note.save();
                }

                ViewPager qavp = getActivity().findViewById(R.id.main_viewpager);
                qavp.setCurrentItem(9);
            }
        });
        tx1 = (TextView) view.findViewById(R.id.text_1);

        tx2 = (TextView) view.findViewById(R.id.text_2);

        tx3 = (TextView) view.findViewById(R.id.text_3);

        tx4 = (TextView) view.findViewById(R.id.text_4);

        tx5 = (TextView) view.findViewById(R.id.text_5);

        tx6 = (TextView) view.findViewById(R.id.text_6);

        tx7 = (TextView) view.findViewById(R.id.text_7);

        tx8 = (TextView) view.findViewById(R.id.text_8);

        tx9 = (TextView) view.findViewById(R.id.text_9);

        tx10 = (TextView) view.findViewById(R.id.text_10);


        cb1 = (CheckBox) view.findViewById(R.id.rb_1);

        cb2 = (CheckBox) view.findViewById(R.id.rb_2);

        cb3 = (CheckBox) view.findViewById(R.id.rb_3);

        cb4 = (CheckBox) view.findViewById(R.id.rb_4);

        cb5 = (CheckBox) view.findViewById(R.id.rb_5);

        cb6 = (CheckBox) view.findViewById(R.id.rb_6);

        cb7 = (CheckBox) view.findViewById(R.id.rb_7);

        cb8 = (CheckBox) view.findViewById(R.id.rb_8);

        cb9 = (CheckBox) view.findViewById(R.id.rb_9);

        cb10 = (CheckBox) view.findViewById(R.id.rb_10);

        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PictureActivity.class);
                intent.putExtra("picture",  "1");
                startActivity(intent);
            }
        });

        tx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PictureActivity.class);
                intent.putExtra("picture",  "2");
                startActivity(intent);
            }
        });

        tx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PictureActivity.class);
                intent.putExtra("picture",  "3");
                startActivity(intent);
            }
        });

        tx4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PictureActivity.class);
                intent.putExtra("picture",  "4");
                startActivity(intent);
            }
        });

        tx5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PictureActivity.class);
                intent.putExtra("picture",  "5");
                startActivity(intent);
            }
        });

        tx6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PictureActivity.class);
                intent.putExtra("picture",  "6");
                startActivity(intent);
            }
        });

        tx7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PictureActivity.class);
                intent.putExtra("picture",  "7");
                startActivity(intent);
            }
        });

        tx8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PictureActivity.class);
                intent.putExtra("picture",  "8");
                startActivity(intent);
            }
        });

        tx9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PictureActivity.class);
                intent.putExtra("picture",  "9");
                startActivity(intent);
            }
        });

        tx10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PictureActivity.class);
                intent.putExtra("picture",  "10");
                startActivity(intent);
            }
        });


        SharedPreferences pref = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        id = pref.getInt("id", -1);
        rewrite = pref.getInt("rewrite", 0);
        if(rewrite == 1) {
            Note note = DataSupport.find(Note.class, id);
            if (note.getItem15() != null)
                if (note.getItem15().length() > 0) {
                    if (note.getItem15().indexOf("A") != -1)
                        cb1.setChecked(true);
                    if (note.getItem15().indexOf("B") != -1)
                        cb2.setChecked(true);
                    if (note.getItem15().indexOf("C") != -1)
                        cb3.setChecked(true);

                    if (note.getItem15().indexOf("D") != -1)
                        cb4.setChecked(true);

                    if (note.getItem15().indexOf("E") != -1)
                        cb5.setChecked(true);

                    if (note.getItem15().indexOf("F") != -1)
                        cb6.setChecked(true);

                    if (note.getItem15().indexOf("G") != -1)
                        cb7.setChecked(true);

                    if (note.getItem15().indexOf("H") != -1)
                        cb8.setChecked(true);

                    if (note.getItem15().indexOf("I") != -1)
                        cb9.setChecked(true);

                    if (note.getItem15().indexOf("J") != -1)
                        cb10.setChecked(true);

                }
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }
    @Override
    public void onPause() {
        super.onPause();
        sub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cb1.isChecked())
                    answer += cb1.getText().toString();

                if (cb2.isChecked())
                    answer += cb2.getText().toString();

                if (cb3.isChecked())
                    answer += cb3.getText().toString();

                if (cb4.isChecked())
                    answer += cb4.getText().toString();

                if (cb5.isChecked())
                    answer += cb5.getText().toString();

                if (cb6.isChecked())
                    answer += cb6.getText().toString();

                if (cb7.isChecked())
                    answer += cb7.getText().toString();

                if (cb8.isChecked())
                    answer += cb8.getText().toString();

                if (cb9.isChecked())
                    answer += cb9.getText().toString();

                if (cb10.isChecked())
                    answer += cb10.getText().toString();

                Note note = DataSupport.find(Note.class, id);
                if (note != null) {
                    note.setItem15(answer);
                    note.update(id);
                    note.save();
                }
            }
        });
    }
}



