package com.example.axiateams.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.axiateams.LoginActivity;
import com.example.axiateams.R;
import com.example.axiateams.adapters.DashboardAdapter;
import com.example.axiateams.objects.ProjetDashboard;
import com.example.axiateams.objects.account.Account;
import com.example.axiateams.remote.ApiClient;
import com.example.axiateams.remote.response.DashboardResponse;
import com.example.axiateams.static_data.StaticData;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {
    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private Account account;
//    private DashboardAdapter adapter;
    private SpringDotsIndicator springDotsIndicator;
    private ViewPager2 viewPager;
    private List<ProjetDashboard> projetList;
    Fragment fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        setupArrowButtons(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        springDotsIndicator = (SpringDotsIndicator) view.findViewById(R.id.spring_dots_indicator);
        viewPager = view.findViewById(R.id.pager);
        account = LoginActivity.getAccount();

        fragment = this;

        fetchProjects();

    }


    private void setupArrowButtons(View view) {
        ImageButton leftButton = view.findViewById(R.id.left_arrow_button);
        ImageButton rightButton = view.findViewById(R.id.right_arrow_button);


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        });
    }

    private void fetchProjects() {

        projetList = StaticData.getProjetsDashboard();
        DashboardAdapter adapter = new DashboardAdapter(fragment, projetList);
        viewPager.setAdapter(adapter);
        springDotsIndicator.attachTo(viewPager);

//        Call<DashboardResponse> call = ApiClient.getService().getProjets("Bearer " + account.getToken());
//        call.enqueue(new Callback<DashboardResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<DashboardResponse> call, @NonNull Response<DashboardResponse> response) {
//
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    projetList = response.body().getData();
//                    adapter = new DashboardAdapter(fragment, projetList);
//                    viewPager.setAdapter(adapter);
//                    springDotsIndicator.attachTo(viewPager);
//                } else {
//                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<DashboardResponse> call, @NonNull Throwable t) {
//                String message = t.getLocalizedMessage();
//                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
//            }
//        });

    }
}

