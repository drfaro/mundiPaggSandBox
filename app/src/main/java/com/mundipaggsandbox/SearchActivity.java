package com.mundipaggsandbox;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.mundi.R;
import com.mundipaggsandbox.model.User;


public class SearchActivity extends ActionBarActivity {

    private User user;
    private EditText searchTerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");

        searchTerm  = (EditText) findViewById(R.id.search_term);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            Intent intent = new Intent(this,ListMerchantActivity.class);
            intent.putExtra("user",user);
            intent.putExtra("term",searchTerm.getText().toString());
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
