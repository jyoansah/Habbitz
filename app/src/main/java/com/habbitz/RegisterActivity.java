package com.habbitz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class RegisterActivity extends ActionBarActivity {

    dbSource dataSource;
    String fnameS;
    String lnameS;
    String usernameS;
    String EmailS;
    String passwordS;
    String passverS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        TextView RegText =(TextView)findViewById(R.id.reg_text);
        Typeface font = Typeface.createFromAsset(getAssets(), "helvetica-l.ttf");
        RegText.setTypeface(font);


        EditText fname = (EditText) findViewById(R.id.txt_fname);
        EditText lname = (EditText) findViewById(R.id.txt_lname);
        EditText username = (EditText) findViewById(R.id.txt_username);
        EditText Email = (EditText) findViewById(R.id.txt_email);
        EditText password = (EditText) findViewById(R.id.txt_pass);
        EditText passver = (EditText) findViewById(R.id.txt_passver);

         fnameS = fname.getText().toString();
         lnameS = lname.getText().toString();
         usernameS = username.getText().toString();
         EmailS = Email.getText().toString();
        passwordS = password.getText().toString();
         passverS = passver.getText().toString();

        Button Signup = (Button) findViewById(R.id.button_signup);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if(passwordS.equals(passverS))
                {
                    registerUser(fnameS,lnameS,usernameS,EmailS,passwordS);
                }
                else
                {
                    new AlertDialog.Builder(RegisterActivity.this)
                            .setTitle("Password Mismatch!")
                            .setMessage("Please Retype your password")
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }

            }
        });



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
