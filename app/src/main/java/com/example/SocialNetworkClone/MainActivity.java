package com.example.SocialNetworkClone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ImageView imageStart, imageRight;
    ImageView imageClose;

    NavigationView navigationView;
    View headerView;
    TextView toolBarTitle;

    String usernameBundle;
    Button btnok;

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameBundle = getIntent().getStringExtra("id");

        drawerLayout = findViewById(R.id.drawerLayout1);

        toolbar = findViewById(R.id.toolbar);
        imageStart = toolbar.findViewById(R.id.imgStart);
        toolBarTitle = toolbar.findViewById(R.id.toolbarTitle);
        imageRight = toolbar.findViewById(R.id.reset);

        imageRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reload(usernameBundle);
            }
        });


        navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);
        imageClose = headerView.findViewById(R.id.imgClose);

        imageStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawers();
            }
        });

        displayFragment(R.id.menu_feed);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                displayFragment(menuItem.getItemId());
                drawerLayout.closeDrawers();

                return false;
            }
        });
    }

    public void displayFragment(int id) {
        Fragment fragment = null;

        if (id == R.id.menu_feed) {
            fragment = new FeedFragment();
            toolBarTitle.setText("New Feed");
        }
        else if (id == R.id.menu_event) {
            fragment = new EventFragment();
            toolBarTitle.setText("Event");
        }
        else if (id == R.id.menu_setting) {
            return;
        }
        else {
            fragment = new FeedFragment();
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, fragment);

        ft.addToBackStack(null);

        ft.commit();
    }

    public void reload(String usernameBundle) {
        FeedFragment fragment = new FeedFragment();
        Bundle bundle = new Bundle();
        bundle.putString("userNameSelect", usernameBundle);
        fragment.setArguments(bundle);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.commit();
    }
}
