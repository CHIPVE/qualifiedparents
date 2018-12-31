package activitytest.example.com.qualifiedparents;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.litepal.crud.DataSupport;

import activitytest.example.com.qualifiedparents.db.Note;

import static android.content.Context.MODE_PRIVATE;

public class CommunicationPageFragment extends Fragment {

    int id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.communicationpage, container, false);

        SharedPreferences pref = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        id = pref.getInt("id", -1);

        Button yes_button = (Button) view.findViewById(R.id.yes_button);
        Button no_button = (Button) view.findViewById(R.id.no_button);

        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                //    设置Title的内容
                builder.setTitle("添加标签");
                //    设置Content来显示一个信息
                builder.setMessage("您的问题解决了吗？为这次记录添上标签吧~");
                //    设置一个PositiveButton
                builder.setPositiveButton("已解决", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Note last = DataSupport.find(Note.class, id);
                        if(last != null) {
                            last.setSolve(true);
                            last.save();
                        }

                        final ViewPager qavp = getActivity().findViewById(R.id.main_viewpager);
                        qavp.setCurrentItem(11);
                    }
                });
                //    设置一个NegativeButton
                builder.setNegativeButton("未解决", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Note last = DataSupport.find(Note.class, id);
                        if(last != null) {
                            last.setSolve(false);
                            last.save();
                        }
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                        getActivity().overridePendingTransition(0, 0);

                    }
                });
                builder.show();
            }
        });

        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                //    设置Content来显示一个信息
                builder.setMessage("沟通结束后，记得回来填写沟通结果哦");
                //    设置一个PositiveButton
                builder.setPositiveButton("返回", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                        getActivity().overridePendingTransition(0, 0);

                    }
                });
                builder.show();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
