package simpsonviewer.xfinity.com.simpsonscharacterviewer;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import simpsonviewer.xfinity.com.simpsonscharacterviewer.network.ApiClient;
import simpsonviewer.xfinity.com.simpsonscharacterviewer.network.RetrofitClient;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //apiClient = RetrofitClient.getRetrofit().create(ApiClient.class);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.contentPanel, new ListFragment(), "list")
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.switch_menu, menu);
        return true;
    }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
     switch (item.getItemId()){
    case android.R.id.home:
        finish();
        break;
    case R.id.switch_view:
        supportInvalidateOptionsMenu();
       /* boolean isSwitched = mAdapter.toggleItemViewType();
        mRecyclerView.setLayoutManager(isSwitched ? new LinearLayoutManager(this) : new GridLayoutManager(this, 2));
        mAdapter.notifyDataSetChanged();*/
        break;
     }
return true;
    }
}
