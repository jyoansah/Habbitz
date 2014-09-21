package com.habbitz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class CheckActivity extends Activity implements View.OnClickListener {

    dbSource dataSource;
    ImageButton yes_full;
    ImageButton no_full;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        dataSource = new dbSource(this);
        dataSource.open();

    ImageButton yesButton = (ImageButton) findViewById(R.id.imageButton);
    ImageButton noButton = (ImageButton) findViewById(R.id.imageButton2);

       yesButton.setOnClickListener(this);
       noButton.setOnClickListener(this);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.check, menu);
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


    public String getWeEEekData(){

        /*ArrayList<Cal> cals = dataSource.getUserActiveTasks(pref.getLong("user_id", 0),
                pref.getLong( "task_id", 0));

        for (int i =0; i < cals.size(); i++){

            Cal cal = cals.get(i);

            if(System.currentTimeMillis() - cal.getDateStarted()  > 7 * 24 * 60 * 60 * 1000 ){

            }


        }*/

        return "test";

    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()== R.id.imageButton)
        {
            //yesButton.setImageResource(R.drawable.yes_full);
            //view.setBackground(R.drawable.yes_full);
            yes_full= (ImageButton) view;
           yes_full.setImageResource(R.drawable.yes_full);
            Intent i=new Intent(
                    CheckActivity.this,
                    yes_goal.class);
            startActivity(i);
        }
        else
        {
            no_full= (ImageButton) view;
            no_full.setImageResource(R.drawable.no_full);

            Intent j=new Intent(
                    CheckActivity.this,
                    no_goal.class);
            startActivity(j);
        }

    }
}
