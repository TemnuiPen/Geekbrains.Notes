package ru.myprojects.geekbrains.geekbrainsnotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import java.util.Collections;
import java.util.LinkedList;

import ru.myprojects.geekbrains.geekbrainsnotes.UI.Note;
import ru.myprojects.geekbrains.geekbrainsnotes.UI.NoteStatus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_main);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //регистрация drawer
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawerLayout, toolbar,
                        (R.string.open), (R.string.Close));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //обработка навигационного меню
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(sendNavigationFragment(id)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
                else return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(sendNavigationFragment(id)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean sendNavigationFragment(int id) {
        switch(id) {
            case R.id.action_favourite:
                //some code
                return true;
            case R.id.action_grid:
                //some code
                return true;
            case R.id.action_search:
                //some code
                return true;
            case R.id.action_settings:
                //some code
                return true;
            case R.id.action_recently_deleted:
                //some code
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem menuItemSearch = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItemSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getApplication(),"You entered:" + newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}