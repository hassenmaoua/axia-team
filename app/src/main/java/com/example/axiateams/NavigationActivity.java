package com.example.axiateams;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.axiateams.databinding.ActivityNavigationBinding;
import com.example.axiateams.objects.account.Account;
import com.example.axiateams.ui.AchatFragment;
import com.example.axiateams.ui.ProjetFragment;
import com.example.axiateams.ui.VenteFragment;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;


public class NavigationActivity extends AppCompatActivity {


    private ProjetFragment projetFragment;
    private AchatFragment achatFragment;
    private VenteFragment ventFragment;


    private Bundle bundle;

    private Account account;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;



    ActivityNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setBackgroundDrawableResource(R.drawable.background_module);

        account = LoginActivity.getAccount();

        projetFragment = new ProjetFragment();
        achatFragment = new AchatFragment();
        ventFragment = new VenteFragment();



        setupNavigationDrawer();

        bundle = new Bundle();



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int id = extras.getInt("key");

            binding.bottomNavBar.setSelectedItemId(id);
            switch (id) {
                case R.id.achat:
                    replaceFragment(achatFragment);
                    break;
                case R.id.projet:
                    replaceFragment(projetFragment);
                    break;
                case R.id.vente:
                    replaceFragment(ventFragment);
                    break;
            }
        }

        binding.bottomNavBar.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.achat:
                    replaceFragment(achatFragment);
                    break;
                case R.id.projet:
                    replaceFragment(projetFragment);
                    break;
                case R.id.vente:
                    replaceFragment(ventFragment);
                    break;

            }
            return true;

        });
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

        fragment.setArguments(bundle);
    }

    private void setupNavigationDrawer() {
        drawerLayout = findViewById(R.id.navigation_drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        setupNavigationData();

        setupNavigationButtons();

    }

    private  void setupNavigationData(){
        TextView fullName = findViewById(R.id.full_name);
        fullName.setText(account.getNomComplet());

        CircularImageView image = findViewById(R.id.profile_picture);
        Picasso.get().load(account.getPhoto()).into(image);
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
                Intent intent = new Intent(NavigationActivity.this, AccueilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        achatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.achat);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        projetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.projet);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        venteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.vente);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        decButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        });

    }

}