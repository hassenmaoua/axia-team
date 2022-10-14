package com.example.axiateams;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.axiateams.adapters.TacheAdapter;
import com.example.axiateams.objects.account.Account;
import com.example.axiateams.objects.projet.Projet;
import com.example.axiateams.objects.tache.Tache;
import com.example.axiateams.remote.ApiClient;
import com.example.axiateams.remote.response.ProjetResponse;
import com.example.axiateams.remote.response.TacheResponse;
import com.example.axiateams.static_data.FilteredData;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailProjetActivity extends AppCompatActivity {
    private ListView listView;
    private List<Tache> tacheList;

    private Account account;

    private Projet projet;
    private int cbmarq;

    boolean isWrapped;

    // variable for bar chart
    private BarChart barChart;
    private BarData barData;
    private BarDataSet barDataSet;


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_projet);

        getWindow().setBackgroundDrawableResource(R.drawable.background_module);

        account = LoginActivity.getAccount();

        Intent previousIntent = getIntent();
        cbmarq = previousIntent.getIntExtra("cbmarq", 0);

        initSearchWidgets();


        setupNavigationDrawer();

        fetchProjetDetails();
        fetchTacheList();


        ImageButton closeButton = (ImageButton) findViewById(R.id.closebtn);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailProjetActivity.this.finish();
            }
        });

    }


    private void fetchProjetDetails() {

        projet = FilteredData.getProjetByCBMARQ(cbmarq);
        setupData();

//        Call<ProjetResponse> call = ApiClient.getService().getDetailsProjet("Bearer " + account.getToken(), cbmarq, 1);
//        call.enqueue(new Callback<ProjetResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<ProjetResponse> call, @NonNull Response<ProjetResponse> response) {
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    projet = response.body().getData();
//                    setupData();
//                } else {
//                    Toast.makeText(DetailProjetActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<ProjetResponse> call, @NonNull Throwable t) {
//                Toast.makeText(DetailProjetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

    private void setupData() {

        CircularImageView projetImage = (CircularImageView) findViewById(R.id.photo_image);
        TextView intituleView = (TextView) findViewById(R.id.title_text);
        TextView etatView = (TextView) findViewById(R.id.state_text);
        TextView descriptionView = (TextView) findViewById(R.id.description_projet);
        TextView nomResponsableView = (TextView) findViewById(R.id.nomResponsable);
        TextView dateDebutView = (TextView) findViewById(R.id.date_debut_projet);
        TextView dateFinView = (TextView) findViewById(R.id.date_fin_projet);

        Picasso.get().load(projet.getPhoto()).into(projetImage);
        intituleView.setText(projet.getIntitule());
        etatView.setText(projet.getEtat().getLabel());
        etatView.setTextColor(Color.parseColor(projet.getEtat().getStyle()));
        descriptionView.setText(projet.getDescription());
        nomResponsableView.setText(projet.getResponsable().getNom());
        dateDebutView.setText(projet.getDateDebut());
        dateFinView.setText(projet.getDateFin());

    }

    private void setupNavigationDrawer() {
        drawerLayout = findViewById(R.id.detail_projet_drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        Button menu_button = (Button) findViewById(R.id.detial_menu_button);
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
                Intent intent = new Intent(DetailProjetActivity.this, AccueilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        achatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProjetActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.achat);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        projetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProjetActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.projet);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        venteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProjetActivity.this, NavigationActivity.class);
                intent.putExtra("key", R.id.vente);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        decButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProjetActivity.this, LoginActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        });
    }

    private void setupNavigationData() {
        TextView fullName = findViewById(R.id.full_name);
        fullName.setText(account.getNomComplet());

        CircularImageView image = findViewById(R.id.profile_picture);
        Picasso.get().load(account.getPhoto()).into(image);
    }

    private void fetchTacheList() {
        TextView progressText = (TextView) findViewById(R.id.progress_percent);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.static_progressBar);

        listView = (ListView) findViewById(R.id.tache_listView);

        tacheList = FilteredData.getListTache(cbmarq);
        barChartSetup(tacheList);
        TacheAdapter adapter = new TacheAdapter(DetailProjetActivity.this, 0, tacheList);
        listView.setAdapter(adapter);
        int progress = TacheAdapter.getTotal(tacheList);

        progressText.setText(progress + "%");
        progressBar.setProgress(progress);


//        Call<TacheResponse> call = ApiClient.getService().getListTaches("Bearer " + account.getToken(), cbmarq);
//        call.enqueue(new Callback<TacheResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<TacheResponse> call, @NonNull Response<TacheResponse> response) {
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    listView = (ListView) findViewById(R.id.tache_listView);
//                    tacheList = response.body().getData();
//                    barChartSetup(tacheList);
//                    TacheAdapter adapter = new TacheAdapter(DetailProjetActivity.this, 0, tacheList);
//                    listView.setAdapter(adapter);
//                    int progress = TacheAdapter.getTotal(response.body().getData());
//
//                    progressText.setText(progress + "%");
//                    progressBar.setProgress(progress);
//                } else {
//                    Toast.makeText(DetailProjetActivity.this, "Tache List : " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    progressText.setText("0%");
//                    progressBar.setProgress(0);
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<TacheResponse> call, @NonNull Throwable t) {
//                Toast.makeText(DetailProjetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void initSearchWidgets() {
        SearchView searchView = (SearchView) findViewById(R.id.tache_searchView);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setIconified(false);
            }
        });


        AutoCompleteTextView search_text = (AutoCompleteTextView) searchView.findViewById(searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null));
        search_text.setHintTextColor(Color.WHITE);
        search_text.setTextColor(Color.WHITE);
        search_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                String currentSearchText = s;

                if (tacheList != null) {
                    List<Tache> filteredTacheList = new ArrayList<Tache>();

                    for (Tache tache : tacheList) {
                        if (tache.getIntitule().toLowerCase().contains(s.toLowerCase())) {
                            filteredTacheList.add(tache);
                        }
                    }

                    TacheAdapter adapter = new TacheAdapter(DetailProjetActivity.this, 0, filteredTacheList);
                    listView.setAdapter(adapter);
                }
                return false;
            }
        });

    }

    private void barChartSetup(List<Tache> tacheList) {
        barChart = findViewById(R.id.barChart);

        List<Tache> filteredTaches = new ArrayList<Tache>();
        for (Tache tache : tacheList) {
            if (!tache.isTitre())
                filteredTaches.add(tache);
        }

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<String> barFactors = new ArrayList<>();
        int[] colors = new int[filteredTaches.size()];

        for (int i = 0; i < filteredTaches.size(); i++) {
            barEntries.add(new BarEntry(i + 1, filteredTaches.get(i).getProgress()));
            colors[i] = Color.parseColor(filteredTaches.get(i).getEtat().getCouleur());
            barFactors.add(filteredTaches.get(i).getIntitule());

        }
        barDataSet = new BarDataSet(barEntries, "Avencement des Taches");


        // creating a new bar data and
        // passing our bar data set.
        barData = new BarData(barDataSet);

        // below line is to set data
        // to our bar chart.
        barChart.setData(barData);

        // adding color to our bar data set.

        barDataSet.setColors(colors);

        // setting text color.
        barDataSet.setValueTextColor(Color.GRAY);

        // setting text size
        barDataSet.setValueTextSize(14f);

        barChart.invalidate();

        barChart.getDescription().setEnabled(false);

        barChart.getAxisLeft().setAxisMaximum(100f);
        barChart.getAxisRight().setEnabled(false);

        barChart.getAxisLeft().setAxisMinimum(0);
        barChart.getAxisRight().setEnabled(false);

        barChart.getXAxis().setEnabled(false);

        }

    }

