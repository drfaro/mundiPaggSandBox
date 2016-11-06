package com.mundipaggsandbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mundi.R;
import com.mundipaggsandbox.adapter.MerchantAdapter;
import com.mundipaggsandbox.model.Merchant;
import com.mundipaggsandbox.model.User;
import com.mundipaggsandbox.task.ListMerchantTask;

import java.util.List;


public class ListMerchantActivity extends AppCompatActivity {

    private ListView listViewMerchant;
    private String accessToken;
    private User user;
    private TextView listMerchantMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_merchant);

        Intent i = getIntent();

        user = (User) i.getSerializableExtra("user");
        String term = (String) i.getSerializableExtra("term");
        Toast.makeText(this,user.getName()+""+user.getUserId(),Toast.LENGTH_LONG).show();
        listMerchantMessage = (TextView) findViewById(R.id.list_merchant_message);

        if (term !=null)
            new ListMerchantTask(this,user,listMerchantMessage,term).execute();
        else
            new ListMerchantTask(this,user,listMerchantMessage).execute();

    }

    public void loadMerchant(List<Merchant> listMerchants) {


        listViewMerchant = (ListView) findViewById(R.id.list_view_merchant);

        MerchantAdapter adapter = new MerchantAdapter(this,listMerchants);
        listViewMerchant.setAdapter(adapter);


        listViewMerchant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Merchant merchant = (Merchant) listViewMerchant.getItemAtPosition(i);
                Toast.makeText(ListMerchantActivity.this, merchant.getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListMerchantActivity.this, PaymentActivity.class);
                intent.putExtra("merchant", merchant);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });


        if (listMerchants.size() == 0  ){
            listMerchantMessage.setText("0 Resultados");
        }else{
            listMerchantMessage.setText("");
        }

        registerForContextMenu(listViewMerchant);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_merchant, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.bt_search_merchant) {
            Intent intent = new Intent(this,SearchActivity.class);
            intent.putExtra("user",user);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
