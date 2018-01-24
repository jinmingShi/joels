package com.xfinity.util.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.xfinity.R;

import static com.xfinity.util.Constants.*;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ClickOnItemListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.contentPanel) != null)
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.contentPanel, new ListFragment(), LIST_FRAGMENT_TAG)
                .commit();
    }

//Options menu will allow the user to change the layout from the list view to a scrollable grid view.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.switch_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
        case R.id.switch_view:
            supportInvalidateOptionsMenu();
            switchLayout();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Method to switch the Layouts.
     * Checks what layout is currently being populated and switches the view
     */
    private void switchLayout() {
        ListFragment listFragment = ((ListFragment)fragmentManager.findFragmentByTag("list"));
        boolean isSwitched = listFragment.getAdapter().toggleItemViewType();
        listFragment.recyclerView.setLayoutManager(isSwitched ? new LinearLayoutManager(this) : new GridLayoutManager(this, 2));
        listFragment.getAdapter().notifyDataSetChanged();
    }

    /**
     * onClickOnItemListener is a method from the custom interface.
     * It takes 3 paraemters that need to be displayed in the detailed view
     * Theses params are sent to the details fragment
     * @param title is the title of the item clicked on the list view
     * @param description is the description of the item clicked
     * @param image is the image url of the item clicked
     */
    @Override
    public void onClickOnItemListener(String title, String description, String image) {
        DetailFragment detailsFragment = (DetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment4);

        if (detailsFragment != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            detailsFragment.updateArticleView(title,description,image);
        } else {
            DetailFragment detailFragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("description", description);
            bundle.putString("image", image);
            detailFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .replace(R.id.contentPanel, detailFragment)
                    .addToBackStack("")
                    .commit();
        }
    }

    /**
     * Sets the title on the action bar to the custom title.
     * This method is called in the details fragments to update the title.
     * @param title is the title to be displayed on the action bar
     */
    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
