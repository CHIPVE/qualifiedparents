package activitytest.example.com.qualifiedparents;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

public class TimeLineItemDecoration extends RecyclerView.ItemDecoration {
    // 写右边字的画笔(具体信息)
    private Paint mPaint;

    private Paint mPaintLine;

    private Paint mPaintTag;

    // 写左边日期字的画笔( 时间 + 日期)
    private Paint mPaint1;
    private Paint mPaint2;

    private Paint mPaintSolve;

    // 左 上偏移长度
    private int itemView_leftinterval;
    private int itemView_topinterval;

    // 轴点半径
    private int circle_radius;

    // 图标
    private Bitmap mIcon;

    // 在构造函数里进行绘制的初始化，如画笔属性设置等
    public TimeLineItemDecoration(Context context, Point size) {

        int screenWidth = size.x;
        int screenHeight = size.y;

        // 轴点画笔(红色)
        mPaint = new Paint();
        mPaint.setColor(Color.argb(255, 166, 142, 118));

        mPaintLine = new Paint();
        mPaintLine.setColor(Color.argb(255, 127, 127, 127));
        mPaintLine.setStrokeWidth(1f);

        mPaintTag =  new Paint();
        mPaintTag.setColor(Color.argb(255, 166, 142, 118));

        // 左边时间文本画笔(蓝色)
        // 此处设置了两只分别设置 时分 & 年月
        mPaint1 = new Paint();
        mPaint1.setColor(Color.argb(255, 108, 108, 108));
        mPaint1.setTextSize(35);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.argb(255, 108, 108, 108));
        mPaint2.setTextSize(80);

        mPaintSolve = new Paint();
        mPaintSolve.setColor(Color.argb(255, 255, 255, 255));
        mPaintSolve.setTextSize(37);

        // 赋值ItemView的左偏移长度为200
        itemView_leftinterval = screenWidth/4;

        // 赋值ItemView的上偏移长度为50
        itemView_topinterval = screenHeight/15;

        // 赋值轴点圆的半径为10
        circle_radius = 18;

        // 获取图标资源
        // mIcon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.logo);

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        // 设置ItemView的左 & 上偏移长度分别为200 px & 50px,即此为onDraw()可绘制的区域
        outRect.set(itemView_leftinterval, itemView_topinterval, 0, 0);

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            float centerx = child.getLeft() - itemView_leftinterval / 5;
            float centery = child.getTop() - (child.getHeight())/4;

            c.drawCircle(centerx, centery, circle_radius, mPaint);
            c.drawRoundRect(centerx+36,centery-36,centerx+216,centery+36,15,15,mPaintTag);
            c.drawText("已解决", centerx+70, centery+13, mPaintSolve);

            int index = parent.getChildAdapterPosition(child);

            float upLine_up_x = centerx;
            float upLine_up_y = child.getTop() - itemView_topinterval;

            float upLine_bottom_x = centerx;
            float upLine_bottom_y = centery - circle_radius;

            if(index !=0) {
                c.drawLine(upLine_up_x, upLine_up_y, upLine_bottom_x, upLine_bottom_y, mPaintLine);
            }
            float bottomLine_up_x = centerx;
            float bottom_up_y = centery + circle_radius;

            float bottomLine_bottom_x = centerx;
            float bottomLine_bottom_y = child.getBottom();

            c.drawLine(bottomLine_up_x, bottom_up_y, bottomLine_bottom_x, bottomLine_bottom_y, mPaintLine);



            float Text_x = centerx - 180;
            float Text_y = centery + 10;

            switch (index) {
                case (0):
                    // 设置日期绘制位置
                    c.drawText("Dec.2018", Text_x, Text_y, mPaint1);
                    c.drawText("11", Text_x + 30, Text_y + 120, mPaint2);
                    break;
                case (1):
                    // 设置日期绘制位置
                    c.drawText("Dec.2018", Text_x, Text_y, mPaint1);
                    c.drawText("02", Text_x + 30, Text_y + 120, mPaint2);
                    break;
                case (2):
                    // 设置日期绘制位置
                    c.drawText("Nov.2018", Text_x, Text_y, mPaint1);
                    c.drawText("21", Text_x + 30, Text_y + 120, mPaint2);
                    break;
                default:
                    c.drawText("Nov.2018", Text_x, Text_y, mPaint1);
                    c.drawText("01", Text_x + 30, Text_y + 120, mPaint2);
            }
        }
    }

}

