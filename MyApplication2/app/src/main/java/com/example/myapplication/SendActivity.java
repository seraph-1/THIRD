package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendActivity extends AppCompatActivity {
    private EditText name_send;
    private EditText message_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        name_send=(EditText)findViewById(R.id.name_send);
        message_send=(EditText)findViewById(R.id.message_send);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = name_send.getText().toString();
                String message = message_send.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("send_name",name);
                intent.putExtra("send_message",message);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
