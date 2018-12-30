package activitytest.example.com.qualifiedparents;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import org.litepal.crud.DataSupport;

import activitytest.example.com.qualifiedparents.db.Note;

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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
              Intent intent = new Intent(MonthlyTestActivity.this, MainActivity.class);
              startActivity(intent);
               finish();
               overridePendingTransition(0, 0);
        }

        return false;

    }

}
