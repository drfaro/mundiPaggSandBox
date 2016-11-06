package com.mundipaggsandbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.mundi.R;
import com.mundipaggsandbox.task.LoginTask;


public class LoginActivity extends AppCompatActivity implements Animation.AnimationListener{

    private Animation fadeIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fadeIn.setAnimationListener(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btLogin = (Button) findViewById(R.id.bt_login_submit);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText username = (EditText) findViewById(R.id.login_user);
                EditText password = (EditText) findViewById(R.id.login_password);

                new LoginTask(LoginActivity.this).execute();


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_login, menu);

        menu.close();
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*
        if (id == R.id.action_settings) {
            return true;
        }*/

        return false;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
