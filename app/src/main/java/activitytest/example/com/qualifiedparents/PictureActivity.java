package activitytest.example.com.qualifiedparents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity {
    int picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        ImageView im = (ImageView)findViewById(R.id.picture1);
        String sID=getIntent().getStringExtra("picture");
        picture=Integer.parseInt(sID);      //String转int
        switch (picture){

            case 1:
                im.setBackground(getResources().getDrawable(R.drawable.pic1));
                break;

            case 2:
                im.setBackground(getResources().getDrawable(R.drawable.pic2));
                break;

            case 3:
                im.setBackground(getResources().getDrawable(R.drawable.pic3));
                break;

            case 4:
                im.setBackground(getResources().getDrawable(R.drawable.pic4));
                break;

            case 5:
                im.setBackground(getResources().getDrawable(R.drawable.pic5));
                break;

            case 6:
                im.setBackground(getResources().getDrawable(R.drawable.pic6));
                break;

            case 7:
                im.setBackground(getResources().getDrawable(R.drawable.pic7));
                break;

            case 8:
                im.setBackground(getResources().getDrawable(R.drawable.pic5));
                break;

            case 9:
                im.setBackground(getResources().getDrawable(R.drawable.pic9));
                break;

            case 10:
                im.setBackground(getResources().getDrawable(R.drawable.pic10));
                break;
            case 11:
                im.setBackground(getResources().getDrawable(R.drawable.pic11));
                break;
            case 12:
                im.setBackground(getResources().getDrawable(R.drawable.pic12));
                break;
            case 13:
                im.setBackground(getResources().getDrawable(R.drawable.pic13));
                break;
            default:
                break;
        }
    }
}
