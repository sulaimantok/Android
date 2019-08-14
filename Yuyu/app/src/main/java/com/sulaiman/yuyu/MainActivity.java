package com.sulaiman.yuyu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvSultan;
    private ArrayList<Sultan> list = new ArrayList<>();
    private String title = "Mode List";


    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSultan = findViewById(R.id.rv_sultan);
        rvSultan.setHasFixedSize(true);

        list.addAll(SultanData.getListData());
        showRecyclerList();
    }

    private void showSelected(Sultan sultan) {
        //Toast.makeText(this, sultan.getName(), Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(MainActivity.this,Details.class);
        intent.putExtra("name",sultan.getName());
        intent.putExtra("from",sultan.getFrom());
        intent.putExtra("istri",sultan.getPasangan());
        intent.putExtra("hidup",sultan.getHidup());
        intent.putExtra("url_img",sultan.getPhoto());
        startActivity(intent);

    }


    private void showRecyclerList(){
        rvSultan.setLayoutManager(new LinearLayoutManager(this));
        ListSultanAdapter listSultanAdapter = new ListSultanAdapter(list);
        rvSultan.setAdapter(listSultanAdapter);

        listSultanAdapter.setOnItemClickCallback(new ListSultanAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Sultan data) {
                showSelected(data);
            }
        });

    }

    private void showAbout(){
        Intent about = new Intent(MainActivity.this, About.class);
        startActivity(about);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_about:
                title = "About";
                showAbout();
                break;
        }
    }
}
