package activitytest.example.com.qualifiedparents.doublePageQuestion;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import org.litepal.crud.DataSupport;

import activitytest.example.com.qualifiedparents.R;
import activitytest.example.com.qualifiedparents.db.Note;

import static android.content.Context.MODE_PRIVATE;

public class SingleChoice5 extends Fragment {
    int id;
    String answer;
    CheckBox cb1;
    ImageView im1;
    CheckBox cb2;
    ImageView im2;
    CheckBox cb3;
    ImageView im3;
    CheckBox cb4;
    ImageView im4;
    CheckBox cb5;
    ImageView im5;
    CheckBox cb6;
    ImageView im6;
    CheckBox cb7;
    ImageView im7;
    CheckBox cb8;
    ImageView im8;
    CheckBox cb9;
    ImageView im9;
    CheckBox cb10;
    ImageView im10;
    CheckBox cb11;
    ImageView im11;
    CheckBox cb12;
    ImageView im12;
    CheckBox cb13;
    ImageView im13;
    CheckBox cb14;
    ImageView im14;
    CheckBox cb15;
    ImageView im15;
    CheckBox cb16;
    ImageView im16;
    CheckBox cb17;
    ImageView im17;
    CheckBox cb18;
    ImageView im18;
    CheckBox cb19;
    ImageView im19;
    CheckBox cb20;
    ImageView im20;
    CheckBox cb21;
    ImageView im21;
    CheckBox cb22;
    ImageView im22;
    CheckBox cb23;
    ImageView im23;
    CheckBox cb24;
    ImageView im24;
    CheckBox cb25;
    ImageView im25;
    CheckBox cb26;
    ImageView im26;
    CheckBox cb27;
    ImageView im27;
    CheckBox cb28;
    ImageView im28;
    CheckBox cb29;
    ImageView im29;
    CheckBox cb30;
    ImageView im30;
    CheckBox cb31;
    ImageView im31;
    CheckBox cb32;
    ImageView im32;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.singlechoice5, container, false);


        SharedPreferences pref = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        id = pref.getInt("id", -1);


        cb1 = (CheckBox) view.findViewById(R.id.rb_1);
        im1 = (ImageView) view.findViewById(R.id.image_view1);

        cb2 = (CheckBox) view.findViewById(R.id.rb_2);
        im2 = (ImageView) view.findViewById(R.id.image_view2);

        cb3 = (CheckBox) view.findViewById(R.id.rb_3);
        im3 = (ImageView) view.findViewById(R.id.image_view3);

        cb4 = (CheckBox) view.findViewById(R.id.rb_4);
        im4 = (ImageView) view.findViewById(R.id.image_view4);

        cb5 = (CheckBox) view.findViewById(R.id.rb_5);
        im5 = (ImageView) view.findViewById(R.id.image_view5);

        cb6 = (CheckBox) view.findViewById(R.id.rb_6);
        im6 = (ImageView) view.findViewById(R.id.image_view6);

        cb7 = (CheckBox) view.findViewById(R.id.rb_7);
        im7 = (ImageView) view.findViewById(R.id.image_view7);

        cb8 = (CheckBox) view.findViewById(R.id.rb_8);
        im8 = (ImageView) view.findViewById(R.id.image_view8);

        cb9 = (CheckBox) view.findViewById(R.id.rb_9);
        im9 = (ImageView) view.findViewById(R.id.image_view9);

        cb10 = (CheckBox) view.findViewById(R.id.rb_10);
        im10 = (ImageView) view.findViewById(R.id.image_view10);

        cb11 = (CheckBox) view.findViewById(R.id.rb_11);
        im11 = (ImageView) view.findViewById(R.id.image_view11);

        cb12 = (CheckBox) view.findViewById(R.id.rb_12);
        im12 = (ImageView) view.findViewById(R.id.image_view12);

        cb13 = (CheckBox) view.findViewById(R.id.rb_13);
        im13 = (ImageView) view.findViewById(R.id.image_view13);

        cb14 = (CheckBox) view.findViewById(R.id.rb_14);
        im14 = (ImageView) view.findViewById(R.id.image_view14);

        cb15 = (CheckBox) view.findViewById(R.id.rb_15);
        im15 = (ImageView) view.findViewById(R.id.image_view15);

        cb16 = (CheckBox) view.findViewById(R.id.rb_16);
        im16 = (ImageView) view.findViewById(R.id.image_view16);

        cb17 = (CheckBox) view.findViewById(R.id.rb_17);
        im17 = (ImageView) view.findViewById(R.id.image_view17);

        cb18 = (CheckBox) view.findViewById(R.id.rb_18);
        im18 = (ImageView) view.findViewById(R.id.image_view18);

        cb19 = (CheckBox) view.findViewById(R.id.rb_19);
        im19 = (ImageView) view.findViewById(R.id.image_view19);

        cb20 = (CheckBox) view.findViewById(R.id.rb_20);
        im20 = (ImageView) view.findViewById(R.id.image_view20);

        cb21 = (CheckBox) view.findViewById(R.id.rb_21);
        im21 = (ImageView) view.findViewById(R.id.image_view21);

        cb22 = (CheckBox) view.findViewById(R.id.rb_22);
        im22 = (ImageView) view.findViewById(R.id.image_view22);

        cb23 = (CheckBox) view.findViewById(R.id.rb_23);
        im23 = (ImageView) view.findViewById(R.id.image_view23);

        cb24 = (CheckBox) view.findViewById(R.id.rb_24);
        im24 = (ImageView) view.findViewById(R.id.image_view24);

        cb25 = (CheckBox) view.findViewById(R.id.rb_25);
        im25 = (ImageView) view.findViewById(R.id.image_view25);

        cb26 = (CheckBox) view.findViewById(R.id.rb_26);
        im26 = (ImageView) view.findViewById(R.id.image_view26);

        cb27 = (CheckBox) view.findViewById(R.id.rb_27);
        im27 = (ImageView) view.findViewById(R.id.image_view27);

        cb28 = (CheckBox) view.findViewById(R.id.rb_28);
        im28 = (ImageView) view.findViewById(R.id.image_view28);

        cb29 = (CheckBox) view.findViewById(R.id.rb_29);
        im29 = (ImageView) view.findViewById(R.id.image_view29);

        cb30 = (CheckBox) view.findViewById(R.id.rb_30);
        im30 = (ImageView) view.findViewById(R.id.image_view30);

        cb31 = (CheckBox) view.findViewById(R.id.rb_31);
        im31 = (ImageView) view.findViewById(R.id.image_view31);

        cb32 = (CheckBox) view.findViewById(R.id.rb_32);
        im32 = (ImageView) view.findViewById(R.id.image_view32);


        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked())
                    cb1.setChecked(false);
                else
                    cb1.setChecked(true);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb2.isChecked())
                    cb2.setChecked(false);
                else
                    cb2.setChecked(true);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb3.isChecked())
                    cb3.setChecked(false);
                else
                    cb3.setChecked(true);
            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb4.isChecked())
                    cb4.setChecked(false);
                else
                    cb4.setChecked(true);
            }
        });

        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb5.isChecked())
                    cb5.setChecked(false);
                else
                    cb5.setChecked(true);
            }
        });

        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb6.isChecked())
                    cb6.setChecked(false);
                else
                    cb6.setChecked(true);
            }
        });

        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb7.isChecked())
                    cb7.setChecked(false);
                else
                    cb7.setChecked(true);
            }
        });

        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb8.isChecked())
                    cb8.setChecked(false);
                else
                    cb8.setChecked(true);
            }
        });

        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb9.isChecked())
                    cb9.setChecked(false);
                else
                    cb9.setChecked(true);
            }
        });

        im10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb10.isChecked())
                    cb10.setChecked(false);
                else
                    cb10.setChecked(true);
            }
        });

        im11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb11.isChecked())
                    cb11.setChecked(false);
                else
                    cb11.setChecked(true);
            }
        });

        im12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb12.isChecked())
                    cb12.setChecked(false);
                else
                    cb12.setChecked(true);
            }
        });

        im13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb13.isChecked())
                    cb13.setChecked(false);
                else
                    cb13.setChecked(true);
            }
        });

        im14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb14.isChecked())
                    cb14.setChecked(false);
                else
                    cb14.setChecked(true);
            }
        });

        im15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb15.isChecked())
                    cb15.setChecked(false);
                else
                    cb15.setChecked(true);
            }
        });

        im16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb16.isChecked())
                    cb16.setChecked(false);
                else
                    cb16.setChecked(true);
            }
        });

        im17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb17.isChecked())
                    cb17.setChecked(false);
                else
                    cb17.setChecked(true);
            }
        });

        im18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb18.isChecked())
                    cb18.setChecked(false);
                else
                    cb18.setChecked(true);
            }
        });

        im19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb19.isChecked())
                    cb19.setChecked(false);
                else
                    cb19.setChecked(true);
            }
        });

        im20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb20.isChecked())
                    cb20.setChecked(false);
                else
                    cb20.setChecked(true);
            }
        });

        im21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb21.isChecked())
                    cb21.setChecked(false);
                else
                    cb21.setChecked(true);
            }
        });

        im22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb22.isChecked())
                    cb22.setChecked(false);
                else
                    cb22.setChecked(true);
            }
        });

        im23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb23.isChecked())
                    cb23.setChecked(false);
                else
                    cb23.setChecked(true);
            }
        });

        im24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb24.isChecked())
                    cb24.setChecked(false);
                else
                    cb24.setChecked(true);
            }
        });

        im25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb25.isChecked())
                    cb25.setChecked(false);
                else
                    cb25.setChecked(true);
            }
        });

        im26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb26.isChecked())
                    cb26.setChecked(false);
                else
                    cb26.setChecked(true);
            }
        });

        im27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb27.isChecked())
                    cb27.setChecked(false);
                else
                    cb27.setChecked(true);
            }
        });

        im28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb28.isChecked())
                    cb28.setChecked(false);
                else
                    cb28.setChecked(true);
            }
        });

        im29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb29.isChecked())
                    cb29.setChecked(false);
                else
                    cb29.setChecked(true);
            }
        });

        im30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb30.isChecked())
                    cb30.setChecked(false);
                else
                    cb30.setChecked(true);
            }
        });

        im31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb31.isChecked())
                    cb31.setChecked(false);
                else
                    cb31.setChecked(true);
            }
        });

        im32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb32.isChecked())
                    cb32.setChecked(false);
                else
                    cb32.setChecked(true);
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }
    @Override
    public void onPause() {
        super.onPause();

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

        if(cb11.isChecked())
            answer += cb11.getText().toString();

        if(cb12.isChecked())
            answer += cb12.getText().toString();

        if(cb13.isChecked())
            answer += cb13.getText().toString();

        if(cb14.isChecked())
            answer += cb14.getText().toString();

        if(cb15.isChecked())
            answer += cb15.getText().toString();

        if(cb16.isChecked())
            answer += cb16.getText().toString();

        if(cb17.isChecked())
            answer += cb17.getText().toString();

        if(cb18.isChecked())
            answer += cb18.getText().toString();

        if(cb19.isChecked())
            answer += cb19.getText().toString();

        if(cb20.isChecked())
            answer += cb20.getText().toString();

        if(cb21.isChecked())
            answer += cb21.getText().toString();

        if(cb22.isChecked())
            answer += cb22.getText().toString();

        if(cb23.isChecked())
            answer += cb23.getText().toString();

        if(cb24.isChecked())
            answer += cb24.getText().toString();

        if(cb25.isChecked())
            answer += cb25.getText().toString();

        if(cb26.isChecked())
            answer += cb26.getText().toString();

        if(cb27.isChecked())
            answer += cb27.getText().toString();

        if(cb28.isChecked())
            answer += cb28.getText().toString();

        if(cb29.isChecked())
            answer += cb29.getText().toString();

        if(cb30.isChecked())
            answer += cb30.getText().toString();

        if(cb31.isChecked())
            answer += cb31.getText().toString();

        if(cb32.isChecked())
            answer += cb32.getText().toString();

        Note note = DataSupport.find(Note.class, id);
        if(note != null) {
            note.setItem9(answer);
            note.update(id);
        }
    }

}

