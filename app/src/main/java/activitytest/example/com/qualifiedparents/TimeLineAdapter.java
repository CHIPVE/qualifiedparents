package activitytest.example.com.qualifiedparents;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class  TimeLineAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private ArrayList<HashMap<String, Object>> listItem;

    private ItemClickListener mItemClickListener ;
    public interface ItemClickListener{
        public void onItemClick(int position) ;
    }
    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.mItemClickListener = itemClickListener ;

    }

    public TimeLineAdapter(Context context, ArrayList<HashMap<String, Object>> listItem) {
        inflater = LayoutInflater.from(context);
        this.listItem = listItem;
    }

    //定义Viewholder
    class Viewholder extends RecyclerView.ViewHolder  {

        private TextView Title;

        public Viewholder(View root) {
            super(root);

            Title = (TextView) root.findViewById(R.id.Itemtitle);
        }

        public TextView getTitle() {
            return Title;
        }

    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new Viewholder(inflater.inflate(R.layout.timeline_list_cell, null));
    }//在这里把ViewHolder绑定Item的布局

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Viewholder vh = (Viewholder) holder;
        // 绑定数据到ViewHolder里面
        vh.Title.setText((String) listItem.get(position).get("ItemTitle"));

        if (mItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 这里利用回调来给RecyclerView设置点击事件
                    mItemClickListener.onItemClick(position);
                }
            });
        }


    }
    //返回Item数目
    @Override
    public int getItemCount() {
        return listItem.size();
    }
}



