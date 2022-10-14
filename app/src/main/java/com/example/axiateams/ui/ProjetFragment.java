package com.example.axiateams.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.axiateams.AccueilActivity;
import com.example.axiateams.DetailProjetActivity;
import com.example.axiateams.LoginActivity;
import com.example.axiateams.adapters.ProjetAdapter;
import com.example.axiateams.R;
import com.example.axiateams.objects.Phase;
import com.example.axiateams.objects.ProjetItem;
import com.example.axiateams.remote.ApiClient;
import com.example.axiateams.remote.response.ListProjetResponse;
import com.example.axiateams.remote.response.PhaseResponse;
import com.example.axiateams.static_data.StaticData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProjetFragment extends Fragment {

    private View view;

    private List<ProjetItem> projetList = new ArrayList<ProjetItem>();
    private GridView gridView;

    private String currentSearchText = "";
    private String selectedFilter = "tout";

    private List<Phase> phaseList;


    public ProjetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_projet, container, false);

        setupButtons();

        fetchProjets();

        fetchPhaseProjet();

        initSearchWidgets();

        return view;
    }


    private void initSearchWidgets() {
        SearchView searchView = (SearchView) view.findViewById(R.id.projetSearchView);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setIconified(false);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                currentSearchText = s;
                List<ProjetItem> filteredProjets = new ArrayList<ProjetItem>();

                for (ProjetItem projet : projetList) {
                    if (projet.getIntitule().toLowerCase().contains(s.toLowerCase())) {

                        if (selectedFilter.equals("tout")) {
                            {
                                filteredProjets.add(projet);
                            }
                        } else if (projet.getEtat().getCode().equals(selectedFilter)) {
                            filteredProjets.add(projet);
                        }
                    }
                }

                ProjetAdapter adapter = new ProjetAdapter(getContext(), 0, filteredProjets);
                gridView.setAdapter(adapter);

                return false;
            }
        });
    }

    private void fetchPhaseProjet() {

        phaseList = StaticData.getListPhaseProjet();
        setupFilter();

//        Call<PhaseResponse> call = ApiClient.getService().getListPhaseProjet("Bearer " + LoginActivity.TOKEN);
//        call.enqueue(new Callback<PhaseResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<PhaseResponse> call, @NonNull Response<PhaseResponse> response) {
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    phaseList = response.body().getData();
//                    setupFilter();
//                } else {
//                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<PhaseResponse> call, @NonNull Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

    public void setupFilter() {
        // Referencing and Initializing the button
        ImageButton filterButton = (ImageButton) view.findViewById(R.id.moduleFilterButon);

        // Setting onClick behavior to the button
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initializing the popup menu and giving the reference as current context
                Context wrapper = new ContextThemeWrapper(getActivity(), R.style.filter_PopupMenu);
                PopupMenu popupMenu = new PopupMenu(wrapper, filterButton);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.filter_menu, popupMenu.getMenu());

                popupMenu.getMenu().clear();
                popupMenu.getMenu().add(0, popupMenu.getMenu().FIRST, Menu.NONE, "Tout");

                int i = 1;
                for (Phase phase : phaseList) {
                    popupMenu.getMenu().add(0, Menu.FIRST + i++, Menu.NONE, phase.getLabel());
                }


                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        if (menuItem.getItemId() == Menu.FIRST) {
                            selectedFilter = "tout";
                            ProjetAdapter adapter = new ProjetAdapter(getActivity(), 0, projetList);
                            gridView.setAdapter(adapter);
                            Toast.makeText(wrapper, "Tout Selectionné", Toast.LENGTH_SHORT).show();
                            return true;
                        }

                        for (int i = 0; i < phaseList.size(); i++) {
                            if (menuItem.getItemId() == popupMenu.getMenu().FIRST + i + 1) {
                                filterList(phaseList.get(i).getCode());
                                Toast.makeText(wrapper, "Phase " + phaseList.get(i).getLabel() + " Selectionné", Toast.LENGTH_SHORT).show();
                                return true;
                            }
                        }

                        return true;
                    }

                });

                // Showing the popup menu
                popupMenu.show();
            }
        });
    }

    private void filterList(String code) {
        selectedFilter = code;

        List<ProjetItem> filteredProjetList = new ArrayList<ProjetItem>();

        for (ProjetItem projet : projetList) {
            if (projet.getEtat().getCode().equals(selectedFilter)) {
                if (currentSearchText.equals("")) {
                    filteredProjetList.add(projet);
                } else if (projet.getIntitule().toLowerCase().contains(currentSearchText.toLowerCase())) {
                    filteredProjetList.add(projet);
                }
            }
        }

        ProjetAdapter adapter = new ProjetAdapter(getContext(), 0, filteredProjetList);
        gridView.setAdapter(adapter);
    }

    private void setupButtons() {
        DrawerLayout drawerLayout = getActivity().findViewById(R.id.navigation_drawerLayout);

        Button menu_button = (Button) view.findViewById(R.id.projet_menu_button);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        Button accuielBtn = view.findViewById(R.id.projet_accueil_button);
        accuielBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AccueilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void fetchProjets() {

        projetList = StaticData.getListProjetItem();
        gridView = (GridView) view.findViewById(R.id.projet_gridView);
        ProjetAdapter adapter = new ProjetAdapter(getActivity(), 0, projetList);
        gridView.setAdapter(adapter);
        setupOnclickListener();

//        Call<ListProjetResponse> call = ApiClient.getService().getListProjet("Bearer " + LoginActivity.TOKEN);
//        call.enqueue(new Callback<ListProjetResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<ListProjetResponse> call, @NonNull Response<ListProjetResponse> response) {
//
//                if (response.isSuccessful() && response.body().getData() != null) {
//
//                    projetList = response.body().getData();
//                    gridView = (GridView) view.findViewById(R.id.projet_gridView);
//                    ProjetAdapter adapter = new ProjetAdapter(getActivity(), 0, projetList);
//                    gridView.setAdapter(adapter);
//                    setupOnclickListener();
//
//                } else {
//                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<ListProjetResponse> call, @NonNull Throwable t) {
//                String message = t.getLocalizedMessage();
//                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
//
//            }
//        });

    }

    private void setupOnclickListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                ProjetItem selectedProjet = (ProjetItem) gridView.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), DetailProjetActivity.class);
                intent.putExtra("cbmarq", selectedProjet.getCbmarq());

                startActivity(intent);
            }
        });
    }
}