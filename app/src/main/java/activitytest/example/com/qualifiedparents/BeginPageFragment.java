package activitytest.example.com.qualifiedparents;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BeginPageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.beginpagefragment, container, false);
        Button begin_button = (Button) view.findViewById(R.id.begin_button);


        begin_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ViewPager qavp = getActivity().findViewById(R.id.main_viewpager);
                qavp.setCurrentItem(1);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
