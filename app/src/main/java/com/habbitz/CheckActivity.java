package com.habbitz;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class CheckActivity extends ActionBarActivity {

    dbSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        dataSource = new dbSource(this);
        dataSource.open();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.check, menu);
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


    public String getWeekData(){

        /*ArrayList<Cal> cals = dataSource.getUserActiveTasks(pref.getLong("user_id", 0),
                pref.getLong( "task_id", 0));

        for (int i =0; i < cals.size(); i++){

            Cal cal = cals.get(i);

            if(System.currentTimeMillis() - cal.getDateStarted()  > 7 * 24 * 60 * 60 * 1000 ){

            }


        }*/

        return "test";

    }
}
