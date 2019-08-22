package com.example.f1r3z.myapplicationdocument;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.f1r3z.myapplicationdocument.adapter.adt_rv_cardview_group;

public class UsingNavigationDrawer extends AppCompatActivity {
        //Defining Variables
        private Toolbar toolbar;
        private NavigationView navigationView;
        private DrawerLayout drawerLayout;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_using_navigation_drawer);

            // Initializing Toolbar and setting it as the actionbar
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("หน้าหลัก");


            //Initializing NavigationView
            navigationView = (NavigationView)
                    findViewById(R.id.navigation_view);

            //Default Fragment
            HomeFragment homefragment = new HomeFragment();
            android.support.v4.app.FragmentTransaction homeFragmentTransaction
                    = getSupportFragmentManager().beginTransaction();
            homeFragmentTransaction.replace(R.id.frame,homefragment);
            homeFragmentTransaction.commit();

            //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
            navigationView.setNavigationItemSelectedListener
                    (new NavigationView.OnNavigationItemSelectedListener() {

                        // This method will trigger on item Click of navigation menu
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {


                            //Checking if the item is in checked state or not, if not make it in checked state
                            if(menuItem.isChecked()) menuItem.setChecked(false);
                            else menuItem.setChecked(true);

                            //Closing drawer on item click
                            drawerLayout.closeDrawers();

                            //Check to see which item was being clicked and perform appropriate action
                            switch (menuItem.getItemId()){

                                case R.id.home:
                                    HomeFragment homefragment = new HomeFragment();
                                    android.support.v4.app.FragmentTransaction homeFragmentTransaction
                                            = getSupportFragmentManager().beginTransaction();
                                    homeFragmentTransaction.replace(R.id.frame,homefragment);
                                    homeFragmentTransaction.commit();
                                    toolbar.setTitle("หน้าหลัก");
                                    return true;

                                case R.id.a1:

                                    GroupFragment groupFragment = new GroupFragment();
                                    android.support.v4.app.FragmentTransaction groupfragment
                                            = getSupportFragmentManager().beginTransaction();
                                    groupfragment.replace(R.id.frame,groupFragment);
                                    groupfragment.commit();
                                    toolbar.setTitle("หน้ากลุ่ม");
                                    return true;

                                case R.id.a2:

                                    InsertGroupFragment insertGroupFragment = new InsertGroupFragment();
                                    android.support.v4.app.FragmentTransaction addgroup
                                            = getSupportFragmentManager().beginTransaction();
                                    addgroup.replace(R.id.frame,insertGroupFragment);
                                    addgroup.commit();
                                    toolbar.setTitle("หน้าเพิ่มกลุ่ม");
                                    return true;

                                default:
                                    Toast.makeText(getApplicationContext(),"Somethings Wrong",Toast.LENGTH_SHORT).show();
                                    return true;

                            }
                        }
                    });

            // Initializing Drawer Layout and ActionBarToggle
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
            ActionBarDrawerToggle actionBarDrawerToggle
                    = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                    R.string.openDrawer, R.string.closeDrawer){

                @Override
                public void onDrawerClosed(View drawerView) {
                    // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                    super.onDrawerClosed(drawerView);
                }

                @Override
                public void onDrawerOpened(View drawerView) {
                    // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                    super.onDrawerOpened(drawerView);
                }
            };

            //Setting the actionbarToggle to drawer layout
            drawerLayout.setDrawerListener(actionBarDrawerToggle);

            //calling sync state is necessay or else your hamburger icon wont show up
            actionBarDrawerToggle.syncState();

        }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
}