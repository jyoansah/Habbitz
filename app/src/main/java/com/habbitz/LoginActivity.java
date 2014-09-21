package com.habbitz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class LoginActivity extends ActionBarActivity {

    dbSource dataSource;
    SharedPreferences pref =this.getSharedPreferences(
            "com.habbitz.app", Context.MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dataSource = new dbSource(this);
        dataSource.open();

        //read the fields
        //
        // Profile user = dataSource.login(username, password);
        //
        //if( user == null){
            //login incorrect
        //}
        //else{
        //    pref.edit().putLong("userid", user.getId());
        //}
        //redirect to List



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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

}
