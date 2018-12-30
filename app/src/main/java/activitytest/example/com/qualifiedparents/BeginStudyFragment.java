package activitytest.example.com.qualifiedparents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import activitytest.example.com.qualifiedparents.db.Note;

public class BeginStudyFragment extends Fragment {

    Button beginstudy;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.beginstudy, container, false);
        beginstudy = (Button) view.findViewById(R.id.beginstudybutton);
        beginstudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Note note = new Note();
                note.setSolve(false);
                note.setTime();
                note.save();
                Intent intent = new Intent(getActivity(), QuestionActivity.class);
                intent.putExtra("id",  note.getId()+"");      // id+"" 这样是把int转成String类型, 否则会报错
                startActivity(intent);

                getActivity().finish();
            }
        });
        return view;
    }


}
