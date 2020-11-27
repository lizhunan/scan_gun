package com.sm.scan.view.main;

import android.os.Bundle;

import com.ctrl.base.view.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sm.scan.R;
import com.sm.scan.databinding.ActivityMainBinding;
import com.sm.scan.viewmodel.CommonViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

/**
 * @author lizhunan
 */
public class MainActivity
        extends BaseActivity<ActivityMainBinding, CommonViewModel> {

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

}
