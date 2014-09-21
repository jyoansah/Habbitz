package com.habbitz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListActivity extends ActionBarActivity {

    dbSource dataSource;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dataSource = new dbSource(this);
        dataSource.open();

        ListView habitListView = (ListView) findViewById(R.id.listView);

        ArrayList<String>  StringList = new ArrayList<String>();
        ArrayList<Task> TaskList = getUserActiveTasks();

        for(int i=0; i<TaskList.size(); i++)
        {
            StringList.add(TaskList.get(i).getName());
        }

        ArrayAdapter listAdapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.list_item_textview,StringList);

        habitListView.setAdapter(listAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Task> getUserActiveTasks()
    {

        return dataSource.getUserTasks(pref.getLong("user_id", 0));

    }

}
