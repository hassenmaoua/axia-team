package com.example.axiateams;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.axiateams.databinding.ActivityAccueilBinding;
import com.example.axiateams.objects.account.Account;
import com.example.axiateams.ui.DashboardFragment;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;


public class AccueilActivity extends AppCompatActivity {

    ActivityAccueilBinding binding;
    private Account account;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccueilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        account = LoginActivity.getAccount();

        setupNavigationDrawer();

        setupDashboard();

        setupButtons();

    }

    private void setupNavigationDrawer() {
        drawerLayout = findViewById(R.id.accueil_drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        Button menu_button = (Button) findViewById(R.id.accueil_menu_button);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        setupNavigationData();
        setupNavigationButtons();
    }

    private void setupNavigationButtons() {
        LinearLayout accuielButton = (LinearLayout) findViewById(R.id.accueil_nav_button);
        LinearLayout achatButton = (LinearLayout) findViewById(R.id.achat_nav_button);
        LinearLayout projetButton = (LinearLayout) findViewById(R.id.projet_nav_button);
        LinearLayout venteButton = (LinearLayout) findViewById(R.id.vente_nav_button);
        LinearLayout decButton = (LinearLayout) findViewById(R.id.deconnexion_nav_button);


        accuielButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, AccueilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        achatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.achat);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        projetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.projet);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        venteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.vente);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        decButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, LoginActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        });
    }

    private  void setupNavigationData(){
        TextView fullName = findViewById(R.id.full_name);
        fullName.setText(account.getNomComplet());

        CircularImageView image = findViewById(R.id.profile_picture);
        Picasso.get().load(account.getPhoto()).into(image);
    }

    private void setupDashboard() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout1, new DashboardFragment());
        fragmentTransaction.commit();

    }

    private void setupButtons() {
        ImageButton achatButton = (ImageButton) findViewById(R.id.achat_imageButton);
        ImageButton projetButton = (ImageButton) findViewById(R.id.projet_imageButton);
        ImageButton venteButton = (ImageButton) findViewById(R.id.vente_imageButton);

        achatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.achat);

                startActivity(intent);
            }
        });

        projetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.projet);

                startActivity(intent);
            }
        });

        venteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.vente);

                startActivity(intent);
            }
        });
    }
}