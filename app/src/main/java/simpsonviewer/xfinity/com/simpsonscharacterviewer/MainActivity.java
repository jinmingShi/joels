package simpsonviewer.xfinity.com.simpsonscharacterviewer;

import android.graphics.drawable.Drawable;
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

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ClickOnItemListener {
    private FragmentManager fragmentManager;
    private ApiClient apiClient;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            ListFragment listFragment = ((ListFragment)fragmentManager.findFragmentByTag("list"));
            boolean isSwitched = listFragment.getAdapter().toggleItemViewType();
            listFragment.recyclerView.setLayoutManager(isSwitched ? new LinearLayoutManager(this) : new GridLayoutManager(this, 2));
            listFragment.getAdapter().notifyDataSetChanged();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickOnItemListender(String title, String description, String image) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        bundle.putString("description", description);
        bundle.putString("image", image);
        detailFragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.contentPanel, detailFragment)
                .addToBackStack("")
                .commit();
    }
}
