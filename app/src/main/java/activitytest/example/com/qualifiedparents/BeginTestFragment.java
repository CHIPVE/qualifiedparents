package activitytest.example.com.qualifiedparents;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BeginTestFragment extends Fragment {

    Button beginTest;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.begintest, container, false);
        beginTest = (Button) view.findViewById(R.id.begintestbutton);
        beginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPagerSlide mtvp = (ViewPagerSlide) getActivity().findViewById(R.id.monthlytest_viewpager);
                mtvp.setCurrentItem(1);
            }
        });

        return view;
    }


}
