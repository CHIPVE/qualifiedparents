package activitytest.example.com.qualifiedparents;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserInfoFragment extends Fragment {

    private TextView titleText1;
    private TextView titleText2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.userinfo_fragment, container, false);
        titleText1 = (TextView) view.findViewById(R.id.id);
        titleText2 = (TextView) view.findViewById(R.id.username);

        return view;
    }


}




