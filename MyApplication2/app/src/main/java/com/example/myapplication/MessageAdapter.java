package com.example.myapplication;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.R.attr.start;

/**
 * Created by 宇宙真理天下第一 on 2020/1/14.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{
    private List<Message> list;
    public interface OnItemClickListener{
        void onItemLongClick(View view,int position);
    }
    private View.OnLongClickListener mOnLongClickListener;
    public void setOnItemLongClickListener(View.OnLongClickListener onItemClickListener){
        this.mOnLongClickListener=onItemClickListener;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView message;
        public ViewHolder(View view){
            super(view);
            message=(TextView)view.findViewById(R.id.messages);

        }
    }
    public MessageAdapter(List<Message> list1){
        list=list1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false);
        final ViewHolder Holder = new ViewHolder(view);
        Holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public  boolean onLongClick(View view){
                    int position=Holder.getLayoutPosition();
                    String name = list.get(position).GetName();
                    String message = list.get(position).GetMessage();
                    Intent intent = new Intent(MyApplication.getContext(),DetailsActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("message",message);
                    MyApplication.getContext().startActivity(intent);
                    return true;
                }
            });
        return Holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Message msg = list.get(position);
        holder.message.setText(msg.GetMessage());

    }

    @Override
    public int getItemCount(){
        return list.size();
    }
}
