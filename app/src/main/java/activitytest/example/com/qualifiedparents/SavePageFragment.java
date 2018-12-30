package activitytest.example.com.qualifiedparents;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.litepal.crud.DataSupport;

import activitytest.example.com.qualifiedparents.db.Note;

import static android.content.Context.MODE_PRIVATE;

public class SavePageFragment extends Fragment {

    int id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.savepage, container, false);

        SharedPreferences pref = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        id = pref.getInt("id", -1);

        Button save_button = (Button) view.findViewById(R.id.save_button);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = DataSupport.find(Note.class, id);
                if(note != null) {
                    note.setTime();
                    note.save();
                }
                AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                //    设置Title的内容
                builder2.setTitle("保存记录");
                //    设置Content来显示一个信息
                builder2.setMessage("将不会保存没有时间和事件的记录");
                //    设置一个PositiveButton
                builder2.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                        getActivity().overridePendingTransition(0, 0);

                    }
                });
                builder2.show();

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}