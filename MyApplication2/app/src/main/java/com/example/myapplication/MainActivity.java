package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Message> msg = new ArrayList<>();
    MessageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initmessage();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MessageAdapter(msg);
        recyclerView.setAdapter(adapter);
    }
    private void initmessage(){
        for(int i = 0;i < 1;i++)
        {
            Message a = new Message("马云","下次一起去爬珠穆朗玛峰吧。");
            msg.add(a);
            Message b = new Message("马化腾","下次一起去爬乔戈里峰吧。");
            msg.add(b);
            Message c = new Message("王健林","下次一起去爬干城章嘉峰吧。");
            msg.add(c);
            Message d = new Message("王思聪","下次一起去爬洛子峰吧。");
            msg.add(d);
            Message e = new Message("常石磊","下次一起去爬马卡鲁峰吧。");
            msg.add(e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.send_item:
                Intent intent = new Intent(MainActivity.this,SendActivity.class);
                startActivityForResult(intent,1);
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("send_name");
                String message = data.getStringExtra("send_message");
                msg.add(new Message(name, message));
                adapter.notifyDataSetChanged();
            }
        }
    }
}



