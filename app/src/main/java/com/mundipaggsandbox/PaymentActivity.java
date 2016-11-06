package com.mundipaggsandbox;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mundi.R;
import com.mundipaggsandbox.helper.PaymentHelper;
import com.mundipaggsandbox.model.Merchant;
import com.mundipaggsandbox.model.Payment;
import com.mundipaggsandbox.model.User;
import com.mundipaggsandbox.task.PaymentTask;


public class PaymentActivity extends ActionBarActivity {

    private User user;
    private Merchant merchant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
        merchant = (Merchant) intent.getSerializableExtra("merchant");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_payment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            PaymentHelper ph = new PaymentHelper(this);
            if (ph.isValidate()){
                Payment payment = ph.getPayment();
                new PaymentTask(this,payment,user,merchant).execute();
            }else{
                Toast.makeText(this,ph.getValidateMessage(), Toast.LENGTH_SHORT).show();

            }


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
