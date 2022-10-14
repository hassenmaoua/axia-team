package com.example.axiateams.adapters;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.axiateams.LoginActivity;
import com.example.axiateams.R;
import com.example.axiateams.objects.categorie.Categorie;
import com.example.axiateams.objects.tache.Tache;
import com.example.axiateams.remote.ApiClient;
import com.example.axiateams.remote.response.EtatResponse;
import com.example.axiateams.static_data.FilteredData;
import com.example.axiateams.static_data.StaticData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TacheAdapter extends ArrayAdapter<Tache> {

    private static int eColor;

    public TacheAdapter(Context context, int resource, List<Tache> tacheList) {
        super(context, resource, tacheList);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Tache tache = getItem(position);

        if (view == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_tache, parent, false);

        if (tache.isTitre()) return view;


        TextView intituleView = view.findViewById(R.id.intitule_tache);

        TextView progressView = view.findViewById(R.id.progress_tache);


        View leftView = view.findViewById(R.id.leftview_tache);


        eColor = Color.parseColor(tache.getEtat().getCouleur());


        ConstraintLayout layout = view.findViewById(R.id.details_tache);
        layout.setVisibility(View.GONE);

        intituleView.setText(tache.getIntitule());


        progressView.setTextColor(eColor);


        leftView.setBackgroundColor(eColor);

        String perc = tache.getProgress() + "%";
        progressView.setText(perc);


        intituleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layout.getVisibility() == View.GONE) {
                    layout.setVisibility(View.VISIBLE);
                } else {
                    layout.setVisibility(View.GONE);
                }
            }
        });

        detailsChanger(view, tache);

        return view;
    }

    private void detailsChanger(View view, Tache tache) {
        Button debutBtn = view.findViewById(R.id.date_debut_button);
        Button finBtn = view.findViewById(R.id.date_find_button);

        TextView dateDebutView = view.findViewById(R.id.dateDebut_tache);
        TextView dateFinView = view.findViewById(R.id.dateFin_tache);

        Button etatBtn = view.findViewById(R.id.etat_tache);

        Button estimeBtn = view.findViewById(R.id.estime_button);

        debutBtn.setText(tache.getDateDebut());
        finBtn.setText(tache.getDateFin());

        dateDebutView.setText(tache.getDateDebut());
        dateFinView.setText(tache.getDateFin());

        etatBtn.setText(tache.getEtat().getTitre());
        etatBtn.setTextColor(eColor);

        String temp = tache.getTempsEstime() + " " + tache.getUniteTemps().getLabel();
        estimeBtn.setText(temp);

        initDatePicker(debutBtn, dateDebutView);
        initDatePicker(finBtn, dateFinView);

        initEtatPicker(etatBtn);

        initEstimePicker(estimeBtn);
    }

    private void initEtatPicker(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchEtat(btn);
            }
        });
    }

    private void initEstimePicker(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchUnite(btn);
            }
        });
    }

    public void fetchEtat(Button btn) {

        showCustomDialog(FilteredData.getListByCategorie("ETT"), btn);

//        Call<EtatResponse> call = ApiClient.getService().getListByCategorie("Bearer " + LoginActivity.TOKEN, "ETT");
//        call.enqueue(new Callback<EtatResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<EtatResponse> call, @NonNull Response<EtatResponse> response) {
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    showCustomDialog(response.body().getData(), btn);
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

    public void fetchUnite(Button btn) {
        showCustomDialog2(FilteredData.getListByCategorie("PRD"), btn);


//        Call<EtatResponse> call = ApiClient.getService().getListByCategorie("Bearer " + LoginActivity.TOKEN, "PRD");
//        call.enqueue(new Callback<EtatResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<EtatResponse> call, @NonNull Response<EtatResponse> response) {
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    showCustomDialog2(response.body().getData(), btn);
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

    private void showCustomDialog(List<Categorie> etatList, Button btn) {
//        String[] arrayPicker = new String[]{"Nouveaux", "En Cours", "Colturé", "Annuler"};
        String[] arrayPicker = new String[etatList.size()];

        for (int i = 0; i < etatList.size(); i++) {
            arrayPicker[i] = etatList.get(i).getLabel();
        }

        final Dialog dialog = new Dialog(getContext());
        dialog.setTitle("NumberPicker");
        dialog.setContentView(R.layout.custom_dialog);
        Button b1 = (Button) dialog.findViewById(R.id.button1);
        Button b2 = (Button) dialog.findViewById(R.id.button2);
        NumberPicker np = (NumberPicker) dialog.findViewById(R.id.numberPicker);


        np.setMaxValue(etatList.size() - 1);
        np.setMinValue(0);
        np.setDisplayedValues(arrayPicker);
        np.setWrapSelectorWheel(false);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setText(arrayPicker[np.getValue()]);
                dialog.dismiss();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void showCustomDialog2(List<Categorie> uniteList, Button btn) {
//        String[] arrayPicker = new String[]{"Heureux", "Jour", "Mois", "Semaine"};
        String[] arrayPicker = new String[uniteList.size()];

        for (int i = 0; i < uniteList.size(); i++) {
            arrayPicker[i] = uniteList.get(i).getLabel();
        }

        Dialog dialog = new Dialog(getContext());

        dialog.setTitle("Temps Estime");
        dialog.setContentView(R.layout.custom_dialog_2);
        Button button_close = (Button) dialog.findViewById(R.id.button_close);
        Button button_submit = (Button) dialog.findViewById(R.id.button_submit);


        NumberPicker unitNumberPicker = (NumberPicker) dialog.findViewById(R.id.unit_numberPicker);

        unitNumberPicker.setMaxValue(arrayPicker.length - 1);
        unitNumberPicker.setMinValue(0);
        unitNumberPicker.setDisplayedValues(arrayPicker);
        unitNumberPicker.setWrapSelectorWheel(true);

        NumberPicker valueNumberPicker = (NumberPicker) dialog.findViewById(R.id.value_numberPicker);

        valueNumberPicker.setMaxValue(60);
        valueNumberPicker.setMinValue(1);
        valueNumberPicker.setWrapSelectorWheel(true);


        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = valueNumberPicker.getValue() + " " + arrayPicker[unitNumberPicker.getValue()];
                btn.setText(string);
                dialog.dismiss();
            }
        });

        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void initDatePicker(Button btn, TextView textView) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);

                String date = makeDateString(calendar);

                btn.setText(date);
                textView.setText(date);
            }
        };


        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), AlertDialog.THEME_HOLO_LIGHT, dateSetListener, year, month, day);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
    }

    private String makeDateString(Calendar calendar) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(calendar.getTime());
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public void clear() {
        super.clear();
    }

    public static int getTotal(List<Tache> list) {
        int total = 0;
        for (Tache tache : list) {
            total = total + tache.getProgress();
        }

        if (total != 0) {
            return total / list.size();
        } else
            return 0;
    }
}

