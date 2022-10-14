package com.example.axiateams.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.axiateams.objects.ProjetDashboard;
import com.example.axiateams.ui.StatiqueFrame;

import java.io.Serializable;
import java.util.List;

public class DashboardAdapter extends FragmentStateAdapter {
    private List<ProjetDashboard> projetList;

    public DashboardAdapter(Fragment fragment, List<ProjetDashboard> projetList) {
        super(fragment);
        this.projetList = projetList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new StatiqueFrame();

        Bundle args = new Bundle();

        args.putSerializable(StatiqueFrame.ARG_OBJECT, (Serializable) projetList.get(position));

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return projetList.size();
    }
}