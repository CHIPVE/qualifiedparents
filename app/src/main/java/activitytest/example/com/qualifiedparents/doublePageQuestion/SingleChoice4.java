package activitytest.example.com.qualifiedparents.doublePageQuestion;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.litepal.crud.DataSupport;

import activitytest.example.com.qualifiedparents.R;
import activitytest.example.com.qualifiedparents.db.Note;

import static android.content.Context.MODE_PRIVATE;

public class SingleChoice4 extends Fragment {
    int id;
    String answer;
    int rewrite;
    private RadioGroup nRg1;

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;

    public final String TAG = "LeftFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.singlechoice4, container, false);


        SharedPreferences pref = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        id = pref.getInt("id", -1);
        rewrite = pref.getInt("rewrite", 0);
        rb1 = (RadioButton) view.findViewById(R.id.rb_1);
        rb2 = (RadioButton) view.findViewById(R.id.rb_2);
        rb3 = (RadioButton) view.findViewById(R.id.rb_3);
        if(rewrite == 1){
            Note note = DataSupport.find(Note.class, id);
            if(note.getItem6()!= null)
                if(note.getItem6().length()>0){
                    if(note.getItem6().indexOf("A")!=-1)
                        rb1.setChecked(true);
                    if(note.getItem6().indexOf("B")!=-1)
                        rb2.setChecked(true);
                    if(note.getItem6().indexOf("C")!=-1)
                        rb3.setChecked(true);
                }

        }


        nRg1 = view.findViewById(R.id.rg_1);
        nRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                answer = radioButton.getText().toString();
            }
        });

        Log.d(TAG, "onCreateView");

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }
    @Override
    public void onPause() {
        super.onPause();
        Note note = DataSupport.find(Note.class, id);
        if(note != null) {
            note.setItem6(answer);
            note.update(id);
        }
    }

}


