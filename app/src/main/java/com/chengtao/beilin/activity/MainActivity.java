package com.chengtao.beilin.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.chengtao.beilin.R;
import com.chengtao.beilin.fragment.ActivityFragment;
import com.chengtao.beilin.fragment.GroupFragment;
import com.chengtao.beilin.fragment.SchoolFragment;
import com.chengtao.framework.activity.BaseActivity;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener ,
        View.OnClickListener,
        BottomNavigationBar.OnTabSelectedListener{
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private BottomNavigationBar bottomNavigationBar;
    private ActivityFragment activityFragment;
    private GroupFragment groupFragment;
    private SchoolFragment schoolFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        toolbar = obtainView(R.id.toolbar);
        drawer = obtainView(R.id.drawer_layout);
        navigationView = obtainView(R.id.nav_view);
        bottomNavigationBar = obtainView(R.id.bottom_navigation_bar);
    }

    @Override
    protected void setListener() {
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    protected void initData() {
        toolbar.setTitle("北林北林");
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_wifi_tethering_white_24dp, "活动")
                        .setActiveColorResource(R.color.colorPrimary)
                )
                .addItem(new BottomNavigationItem(R.drawable.ic_group_white_24dp, "社团")
                        .setActiveColorResource(R.color.colorPrimary)
                )
                .addItem(new BottomNavigationItem(R.drawable.ic_whatshot_white_24dp, "校园")
                        .setActiveColorResource(R.color.colorPrimary)
                )
                .setFirstSelectedPosition(0)
                .setMode(BottomNavigationBar.MODE_DEFAULT)
                .initialise();
        activityFragment = new ActivityFragment();
        groupFragment = new GroupFragment();
        schoolFragment = new SchoolFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_main,activityFragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }  else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_main,activityFragment)
                        .commit();
                break;
            case 1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_main,groupFragment)
                        .commit();
                break;
            case 2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_main,schoolFragment)
                        .commit();
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    /**
     * 本界面跳转
     * @param activity
     */
    public static void invoke(Activity activity){
        Intent intent = new Intent(activity,MainActivity.class);
        activity.startActivity(intent);
    }
}
