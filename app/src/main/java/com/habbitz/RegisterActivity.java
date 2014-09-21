package com.habbitz;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class RegisterActivity extends ActionBarActivity {

    dbSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView RegText =(TextView)findViewById(R.id.reg_text);
        Typeface font = Typeface.createFromAsset(getAssets(), "helvetica-l.ttf");
        RegText.setTypeface(font);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
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


    public boolean registerUser(String fname, String sname, String username, String email, String password){

        Profile user = new Profile();
        user.setFirstName(fname);
        user.setLastName(sname);
        user.setUsername(username);
        user.setEmail(email);

        if (dataSource.createUser(user) == null){
            return false;
        }

        return true;
    }

}
