package com.habbitz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    dbSource dataSource;
    SharedPreferences pref;
    String userString;
    String passString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref =this.getSharedPreferences(
                       "com.habbitz", Context.MODE_PRIVATE);

        dataSource = new dbSource(this);
        dataSource.open();

        final EditText username = (EditText) findViewById(R.id.txt_username);
        final EditText password = (EditText) findViewById(R.id.txt_password);

        Button Signin = (Button) findViewById(R.id.button_signin);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               userString =  username.getText().toString();
               passString = password.getText().toString();


                Profile user = dataSource.login(userString, passString);


                if( user == null){
                    //login incorrect
                }
                else{
                    pref.edit().putLong("userid", user.getId());
                    Intent signUpIntent = new Intent(LoginActivity.this, ListActivity.class);
                    startActivity(signUpIntent);
                }
            }
        });



        Button Signup = (Button) findViewById(R.id.button_signup);

        Signup.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view)
            {
                Intent signUpIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(signUpIntent);

            }

        });


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
