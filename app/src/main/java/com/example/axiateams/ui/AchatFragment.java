package com.example.axiateams.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.axiateams.AccueilActivity;
import com.example.axiateams.DetailFactureActivity;
import com.example.axiateams.LoginActivity;
import com.example.axiateams.R;
import com.example.axiateams.adapters.FactureAdapter;
import com.example.axiateams.objects.categorie.Categorie;
import com.example.axiateams.objects.facture.Facture;
import com.example.axiateams.remote.response.EtatResponse;
import com.example.axiateams.remote.response.FactureResponse;
import com.example.axiateams.remote.ApiClient;
import com.example.axiateams.static_data.FilteredData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AchatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AchatFragment extends Fragment {

    private View view;
    private List<Facture> factureList = new ArrayList<>();
    private Facture selectedFacture;

    private ListView listView;
    private String currentSearchText = "";
    private String selectedFilter = "";

    private FactureAdapter adapter;

    private boolean isSort;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AchatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AchatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AchatFragment newInstance(String param1, String param2) {
        AchatFragment fragment = new AchatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_achat, container, false);

        listView = (ListView) view.findViewById(R.id.achat_listView);

        setupNavigationButton();

        fetchDocuments();

        initSearchWidgets();

        fetchEtat();

        return view;
    }


    private void setupNavigationButton() {

        DrawerLayout drawerLayout = getActivity().findViewById(R.id.navigation_drawerLayout);

        Button menu_button = (Button) view.findViewById(R.id.achat_menu_button);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        Button accuielBtn = view.findViewById(R.id.achat_accueil_button);
        accuielBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AccueilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initSearchWidgets() {
        SearchView searchView = (SearchView) view.findViewById(R.id.achatSearchView);

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
                List<Facture> filteredFactures = new ArrayList<Facture>();


                for (Facture facture : factureList) {
                    if (facture.getReference().toLowerCase().contains(s.toLowerCase())
                            || facture.getIntituleTiers().toLowerCase().contains(s.toLowerCase())) {
                        if (selectedFilter.equals("tout")) {
                            filteredFactures.add(facture);
                        } else if (facture.getEtat().getCode().equals(selectedFilter)) {
                            filteredFactures.add(facture);
                        }
                    }
                }

                adapter = new FactureAdapter(getContext(), 0, filteredFactures);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                return false;
            }
        });
    }

    private void fetchDocuments() {

        factureList = FilteredData.getListDocument("P0013");

        adapter = new FactureAdapter(getActivity(), 0, factureList);
        listView.setAdapter(adapter);

        setupOnclickListener();

//        Call<FactureResponse> call = ApiClient.getService().getListDocuments("Bearer " + LoginActivity.TOKEN, "P0013");
//        call.enqueue(new Callback<FactureResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<FactureResponse> call, @NonNull Response<FactureResponse> response) {
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    factureList = response.body().getData();
//
//                    adapter = new FactureAdapter(getActivity(), 0, factureList);
//                    listView.setAdapter(adapter);
//
//                    setupOnclickListener();
//
//                } else if (response.body().getData() == null) {
//                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<FactureResponse> call, @NonNull Throwable t) {
//
//            }
//        });
    }

    private void setupOnclickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                selectedFacture = (Facture) listView.getItemAtPosition(position);
                if (selectedFacture != null) {
                    Intent intent = new Intent(getActivity(), DetailFactureActivity.class);
                    intent.putExtra("cbmarqF", selectedFacture.getCbmarq());
                    intent.putExtra("cbmarqS", LoginActivity.getAccount().getSociete().getCbmarq());
                    startActivity(intent);
                }
            }
        });
    }


    public void fetchEtat() {
//        setupFilter(FilteredData.getListByCategorie("ETD"));

//        Call<EtatResponse> call = ApiClient.getService().getListByCategorie("Bearer " + LoginActivity.TOKEN, "ETD");
//        call.enqueue(new Callback<EtatResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<EtatResponse> call, @NonNull Response<EtatResponse> response) {
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    setupFilter(response.body().getData());
//                } else {
//                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<EtatResponse> call, @NonNull Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }


    public void setupFilter(List<Categorie> etatList) {
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

                for (int i = 0; i < etatList.size(); i++) {
                    popupMenu.getMenu().add(0, popupMenu.getMenu().FIRST + i + 1, Menu.NONE, etatList.get(i).getLabel());
                }

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        if (menuItem.getItemId() == popupMenu.getMenu().FIRST) {
                            selectedFilter = "tout";
                            FactureAdapter adapter = new FactureAdapter(getActivity(), 0, factureList);
                            listView.setAdapter(adapter);
                            Toast.makeText(wrapper, "Tout Selectionné", Toast.LENGTH_SHORT).show();
                            return true;
                        }

                        for (int i = 0; i < etatList.size(); i++) {
                            if (menuItem.getItemId() == popupMenu.getMenu().FIRST + i + 1) {
                                filterList(etatList.get(i).getCode());
                                Toast.makeText(wrapper, "Categorie " + etatList.get(i).getLabel() + " Selectionné", Toast.LENGTH_SHORT).show();
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

        List<Facture> filteredFactureList = new ArrayList<Facture>();

        for (Facture facture : factureList) {
            if (facture.getEtat().getCode().equals(selectedFilter)) {
                if (currentSearchText.equals("")) {
                    filteredFactureList.add(facture);
                } else if (facture.getReference().toLowerCase().contains(currentSearchText.toLowerCase()) ||
                        facture.getIntituleTiers().toLowerCase().contains(currentSearchText.toLowerCase())) {
                    filteredFactureList.add(facture);
                }
            }
        }

        FactureAdapter adapter = new FactureAdapter(getContext(), 0, filteredFactureList);
        listView.setAdapter(adapter);
    }

}