package com.jophnny.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavController navController = null;
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(R.id.drawer_host).build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationView navView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(navView, navController);
    }

    Button card1 = (Button) findViewById(R.id.card1);
    Button card2 = (Button) findViewById(R.id.card2);
    card1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Do something in response to button click
        }
    });
    card2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Do something in response to button click
        }
    });

}
