package com.example.axiateams.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.axiateams.LoginActivity;
import com.example.axiateams.R;
import com.example.axiateams.adapters.TacheAdapter;
import com.example.axiateams.objects.ProjetDashboard;
import com.example.axiateams.objects.tache.Tache;
import com.example.axiateams.remote.ApiClient;
import com.example.axiateams.remote.response.TacheResponse;
import com.example.axiateams.static_data.FilteredData;
import com.example.axiateams.static_data.StaticData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatiqueFrame extends Fragment {
    public static final String ARG_OBJECT = "object";
    private ProjetDashboard projet;
    private List<Tache> tacheList;
    Bundle args;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.statique_frame, container, false);
        args = getArguments();

        projet = (ProjetDashboard) (args != null ? args.getSerializable(ARG_OBJECT) : null);

        TextView nomProjet = view.findViewById(R.id.nomProjet_static);
        nomProjet.setText(projet.getIntitule());

        fetchTacheList(projet.getCbmarq());

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @SuppressLint("SetTextI18n")
    private void setProgress(int value, int nbTaches) {
        TextView nb_taches = view.findViewById(R.id.nb_taches_static);
        TextView perc = view.findViewById(R.id.txtProgress);
        ProgressBar progressBar = view.findViewById(R.id.static_progressBar);


        nb_taches.setText(nbTaches + " Taches");
        perc.setText(value + "%");
        progressBar.setProgress(value);
    }

    private void fetchTacheList(int cbmarq) {

        tacheList = FilteredData.getListTache(cbmarq);

        if (tacheList.size() != 0) {
            int progress = TacheAdapter.getTotal(tacheList);

            setProgress(progress, tacheList.size());
        } else {
            setProgress(0, 0);
        }

//        Call<TacheResponse> call = ApiClient.getService().getListTaches("Bearer " + LoginActivity.getAccount().getToken(), cbmarq);
//        call.enqueue(new Callback<TacheResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<TacheResponse> call, @NonNull Response<TacheResponse> response) {
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    int progress = TacheAdapter.getTotal(response.body().getData());
//
//                    setProgress(progress, response.body().getData().size());
//                } else {
//                    setProgress(0, 0);
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<TacheResponse> call, @NonNull Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}

