package activitytest.example.com.qualifiedparents;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MonthlyTestActivity extends AppCompatActivity {

    ViewPagerSlide monthltTestActivityViewPager;
    MonthlyTestActivityViewPaperAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_test);
        monthltTestActivityViewPager = (ViewPagerSlide)findViewById(R.id.monthlytest_viewpager);
        monthltTestActivityViewPager.setSlide(false);
        adapter = new MonthlyTestActivityViewPaperAdapter(getSupportFragmentManager());
        adapter.addFragment(new BeginTestFragment());
        adapter.addFragment(new BeginStudyFragment());
        monthltTestActivityViewPager.setAdapter(adapter);
    }
}
