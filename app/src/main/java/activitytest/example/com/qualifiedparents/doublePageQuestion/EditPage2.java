package activitytest.example.com.qualifiedparents.doublePageQuestion;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.litepal.crud.DataSupport;


import activitytest.example.com.qualifiedparents.R;
import activitytest.example.com.qualifiedparents.db.Note;

import static android.content.Context.MODE_PRIVATE;

public class EditPage2 extends Fragment {

    int id;
    EditText editText;
    int rewrite;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edittext2, container, false);
        editText = (EditText) view.findViewById(R.id.edit_text);
        SharedPreferences pref = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        id = pref.getInt("id", -1);
        rewrite = pref.getInt("rewrite", 0);
        if(rewrite == 1){
            Note note = DataSupport.find(Note.class, id);
            if(note.getItem4() != null)
            editText.setText(note.getItem4());
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
        Note note = DataSupport.find(Note.class, id);
        if(note != null) {
            note.setItem4(editText.getText().toString());
            note.update(id);
        }
    }

}


