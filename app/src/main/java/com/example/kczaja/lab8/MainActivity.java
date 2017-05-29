package com.example.kczaja.lab8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.main_list);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

        switch ((int)id)
        {
            case 0:{
                Intent intent = new Intent(getApplication(), TouchActvity.class);
                startActivity(intent);

            }
            case 1:
            {
                Intent intent = new Intent(getApplication(), GestureActvity.class);
                startActivity(intent);
            }
            case 2:
            {
                    Intent intent = new Intent(getApplication(), PainterActivity.class);
                startActivity(intent);
            }
        }

    }
}
