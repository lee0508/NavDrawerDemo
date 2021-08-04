package com.example.navdrawerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }
    
    public void ClickMenu(View view){
        //Open drawer
        openDrawer(drawerLayout);
        
    }
    
    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }
    
    public void ClickLogo(View view){
        //Closer drawer
        closerDrawer(drawerLayout);
    }
    
    public static void closerDrawer(DrawerLayout drawerLayout) {
        //Closer drawer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        
    }
    
    public void ClickHome(View view){
        //Recreate activity
        recreate();
    }
    
    public void ClickDashboard(View view){
        //Redirect activity to dashboard
        redirectActivity(this,Dashboard.class);
    }
    public void ClickAboutUs(View view){
        //Redirect activity to about us
        redirectActivity(this,AboutUs.class);
    }
    
    public void ClickLogout(View view){
        //Close app
        logout(this);
    }
    
    public static void logout(final Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        
        //Set title
        builder.setTitle("LogOut");
        builder.setMessage("Are you sure you want to logout ?");
        //Positive yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener(){
    
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Finish activity
                activity.finishAffinity();
                //Exit App
                System.exit(0);
            }
        });
        //Negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Dismiss dialog
                dialogInterface.dismiss();
            }
        });
        //Show dialog
        builder.show();
    }
    
    public static void redirectActivity(Activity activity, Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity, aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        closerDrawer(drawerLayout);
    }
}
