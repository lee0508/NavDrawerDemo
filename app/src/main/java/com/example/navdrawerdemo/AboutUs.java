package com.example.navdrawerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class AboutUs extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        
        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }
    
    public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }
    
    public void ClickLogo(View view){
        //Close drawer
        MainActivity.closerDrawer(drawerLayout);
    }
    
    public void ClickHome(View view){
        //Redirect activity to home
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    
    public void ClickDashboard(View view){
    
        //Redirect activity to dashboard
        MainActivity.redirectActivity(this,Dashboard.class);
    }
    
    public void ClickAboutUs(View view){
        //Recreate activity
        recreate();
    }
    
    public void ClickLogout(View view){
        //Close app
        MainActivity.logout(this);
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        MainActivity.closerDrawer(drawerLayout);
    }
}
