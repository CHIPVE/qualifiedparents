package activitytest.example.com.qualifiedparents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import org.litepal.crud.DataSupport;

import activitytest.example.com.qualifiedparents.db.Note;

import static android.content.Context.MODE_PRIVATE;

public class CardPageFragment extends Fragment {

    int id;
    public final String TAG = "info";
    Button submit_button;
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
    CheckBox cb11;
    CheckBox cb12;
    CheckBox cb13;
    CheckBox cb14;
    CheckBox cb15;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cardpage, container, false);

        editor = getActivity().getSharedPreferences("data", MODE_PRIVATE).edit();

        submit_button = (Button) view.findViewById(R.id.submit_button);
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
        cb11 = (CheckBox) view.findViewById(R.id.rb_11);
        cb12 = (CheckBox) view.findViewById(R.id.rb_12);
        cb13 = (CheckBox) view.findViewById(R.id.rb_13);
        cb14 = (CheckBox) view.findViewById(R.id.rb_14);
        cb15 = (CheckBox) view.findViewById(R.id.rb_15);

        SharedPreferences pref = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        id = pref.getInt("id", -1);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
        initdata();
    }

    public void initdata(){
        final ViewPager qavp = getActivity().findViewById(R.id.main_viewpager);

        Note last = DataSupport.find(Note.class, id);
        if(last.getItem1() != null)
            if(last.getItem1().length()>0)
                cb1.setChecked(true);

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qavp.setCurrentItem(2);
                if(cb1.isChecked()){
                    cb1.setChecked(false);
                }
                else
                    cb1.setChecked(true);
            }
        });

        if(last.getItem2() != null)
            if(last.getItem2().length()>0)
                cb2.setChecked(true);

        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qavp.setCurrentItem(3);
                if(cb2.isChecked()){
                    cb2.setChecked(false);
                }
                else
                    cb2.setChecked(true);
            }
        });


        if(last.getItem3() != null)
            if(last.getItem3().length()>0)
                cb3.setChecked(true);

        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 0);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb3.isChecked()){
                    cb3.setChecked(false);
                }
                else
                    cb3.setChecked(true);
            }
        });


        if(last.getItem4() != null)
            if(last.getItem4().length()>0)
                cb4.setChecked(true);

        cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 1);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb4.isChecked()){
                    cb4.setChecked(false);
                }
                else
                    cb4.setChecked(true);
            }
        });


        if(last.getItem5() != null)
            if(last.getItem5().length()>0)
                cb5.setChecked(true);

        cb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 2);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb5.isChecked()){
                    cb5.setChecked(false);
                }
                else
                    cb5.setChecked(true);
            }
        });


        if(last.getItem6() != null)
            if(last.getItem6().length()>0)
                cb6.setChecked(true);

        cb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 3);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb6.isChecked()){
                    cb6.setChecked(false);
                }
                else
                    cb6.setChecked(true);
            }
        });


        if(last.getItem7() != null)
            if(last.getItem7().length()>0)
                cb7.setChecked(true);

        cb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 4);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb7.isChecked()){
                    cb7.setChecked(false);
                }
                else
                    cb7.setChecked(true);
            }
        });


        if(last.getItem8() != null)
            if(last.getItem8().length()>0)
                cb8.setChecked(true);

        cb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 5);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb8.isChecked()){
                    cb8.setChecked(false);
                }
                else
                    cb8.setChecked(true);
            }
        });


        if(last.getItem9() != null)
            if(last.getItem9().length()>0)
                cb9.setChecked(true);

        cb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 6);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb9.isChecked()){
                    cb9.setChecked(false);
                }
                else
                    cb9.setChecked(true);
            }
        });


        if(last.getItem10() != null)
            if(last.getItem10().length()>0)
                cb10.setChecked(true);

        cb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 7);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb10.isChecked()){
                    cb10.setChecked(false);
                }
                else
                    cb10.setChecked(true);
            }
        });


        if(last.getItem11() != null)
            if(last.getItem11().length()>0)
                cb11.setChecked(true);

        cb11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 8);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb11.isChecked()){
                    cb11.setChecked(false);
                }
                else
                    cb11.setChecked(true);
            }
        });

        if(last.getItem12() != null)
            if(last.getItem12().length()>0)
                cb12.setChecked(true);

        cb12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 9);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb12.isChecked()){
                    cb12.setChecked(false);
                }
                else
                    cb12.setChecked(true);
            }
        });


        if(last.getItem13() != null)
            if(last.getItem13().length()>0)
                cb13.setChecked(true);

        cb13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 10);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb13.isChecked()){
                    cb13.setChecked(false);
                }
                else
                    cb13.setChecked(true);
            }
        });


        if(last.getItem14() != null)
            if(last.getItem14().length()>0)
                cb14.setChecked(true);

        cb14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("doublepage", 11);
                editor.apply();
                qavp.setCurrentItem(6);
                if(cb14.isChecked()){
                    cb14.setChecked(false);
                }
                else
                    cb14.setChecked(true);
            }
        });

        if(last.getItem15() != null)
            if(last.getItem15().length()>0)
                cb15.setChecked(true);

        cb15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qavp.setCurrentItem(8);
                if(cb15.isChecked()){
                    cb15.setChecked(false);
                }
                else
                    cb15.setChecked(true);
            }
        });



        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                qavp.setCurrentItem(10);
            }
        });
    }
}
