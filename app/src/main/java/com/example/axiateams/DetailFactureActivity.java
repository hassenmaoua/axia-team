package com.example.axiateams;

import static java.lang.Double.parseDouble;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.axiateams.adapters.ArticleAdapter;
import com.example.axiateams.function.Money;
import com.example.axiateams.objects.account.Account;
import com.example.axiateams.objects.facture.Facture;
import com.example.axiateams.objects.facture.Lignes;
import com.example.axiateams.objects.societe.Societe;
import com.example.axiateams.remote.ApiClient;
import com.example.axiateams.remote.response.DocumentResponse;
import com.example.axiateams.remote.response.SocieteResponse;
import com.example.axiateams.static_data.FilteredData;
import com.example.axiateams.static_data.StaticData;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFactureActivity extends AppCompatActivity {
    private int cbmarqF;
    private int cbmarqS;
    private Account account;
    private Facture facture;
    private Societe societe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_facture);

        account = LoginActivity.getAccount();

        Intent previousIntent = getIntent();
        cbmarqF = previousIntent.getIntExtra("cbmarqF", 0);
        cbmarqS = previousIntent.getIntExtra("cbmarqS", 0);


        fetchDocument();
        setupButtons();
    }


    private void fetchDocument() {

        facture = FilteredData.getDocument(cbmarqF);
        setupData(facture);


//        Call<DocumentResponse> callDocument = ApiClient.getService().getDocument("Bearer " + account.getToken(), cbmarqF);
//        callDocument.enqueue(new Callback<DocumentResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<DocumentResponse> call, @NonNull Response<DocumentResponse> response) {
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    facture = response.body().getData();
//                    setupData(facture);
//
//                } else {
//                    Toast.makeText(DetailFactureActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<DocumentResponse> call, @NonNull Throwable t) {
//                Toast.makeText(DetailFactureActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });


        societe = StaticData.getSociete();
        setupSociete(societe);

//        Call<SocieteResponse> callSociete = ApiClient.getService().getSociete("Bearer " + account.getToken(), cbmarqS);
//        callSociete.enqueue(new Callback<SocieteResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<SocieteResponse> call, @NonNull Response<SocieteResponse> response) {
//                if (response.isSuccessful() && response.body().getData() != null) {
//                    societe = response.body().getData();
//                    setupSociete(societe);
//                } else {
//                    Toast.makeText(DetailFactureActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<SocieteResponse> call, @NonNull Throwable t) {
//                Toast.makeText(DetailFactureActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @SuppressLint("SetTextI18n")
    private void setupData(Facture facture) {
        TextView refernce = findViewById(R.id.reference_facture);
        TextView dateDoc = findViewById(R.id.dateDoc_facture);

        TextView montantHT = findViewById(R.id.montantHT_facture);
        TextView montantNetHT = findViewById(R.id.montantNetHT_facture);
        TextView montantTVA = findViewById(R.id.montantTVA_facture);
        TextView montantTTC = findViewById(R.id.montantTTC_facture);
        TextView NETapayer = findViewById(R.id.NETapayer_facture);
        TextView intituleTier = findViewById(R.id.intituleTier_facture);
        TextView tier_information = findViewById(R.id.tier_information_facture);
        TextView montant_en_lettres = findViewById(R.id.montant_en_lettres_facture);


        TextView nomProjet = findViewById(R.id.nomProjet_facture);
        TextView phaseProjet = findViewById(R.id.phaseProjet_facture);

        LinearLayout layout = findViewById(R.id.projetLayout);

        List<TextView> listDevise = new ArrayList<TextView>(
                Arrays.asList(
                        findViewById(R.id.devise_facture),
                        findViewById(R.id.devise_facture2),
                        findViewById(R.id.devise_facture3),
                        findViewById(R.id.devise_facture4),
                        findViewById(R.id.devise_facture5)
                ));

        refernce.setText(facture.getReference());
        dateDoc.setText(facture.getDateDoc());
        montantHT.setText(facture.getMontantHT());
        montantNetHT.setText(facture.getMontantNetHT());
        montantTVA.setText(facture.getMontantTVA());
        montantTTC.setText(facture.getMontantTTC());
        NETapayer.setText(facture.getNETapayer());

        double money = parseDouble(facture.getNETapayer().replaceAll(" ", ""));

        montant_en_lettres.setText(Money.getMoneyIntoWords(money, facture.getDevise().getDescription().toLowerCase()));

        intituleTier.setText(facture.getIntituleTiers());
        tier_information.setText(facture.getTiers().getInformation());

        for (TextView view : listDevise) {
            view.setText(facture.getDevise().getLabel());
        }


        TableLayout tableLayout = findViewById(R.id.tableLayout);
        for (Lignes ligne : facture.getLignes()) {
            ArticleAdapter adapter = new ArticleAdapter(DetailFactureActivity.this, 0, ligne.getFils());

            View view = LayoutInflater.from(DetailFactureActivity.this).inflate(R.layout.item_article, tableLayout, false);

            TextView num = view.findViewById(R.id.num_article);
            TextView designation = view.findViewById(R.id.designation_article);

            num.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            designation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);


            num.setText(ligne.getNum());
            designation.setText(ligne.getDesignation());

            tableLayout.addView(view);

            int count = adapter.getCount();
            for (int i = 0; i < count; i++) {
                tableLayout.addView(adapter.getView(i, null, tableLayout));
            }
        }


        if (facture.getType().getCode().equals("P0014")) {
            nomProjet.setText(facture.getIntituleProjet());
            phaseProjet.setText("Phase: " + facture.getPhaseProjet().getIntitule());
        }

        if (facture.getType().getCode().equals("P0013")) {
            layout.setVisibility(View.GONE);
        }

    }

    private void setupSociete(Societe societe) {
        TextView raisonSociale = findViewById(R.id.raisonSociale_societe);
        TextView telephone = findViewById(R.id.telephone_societe);
        TextView email = findViewById(R.id.email_societe);
        TextView adresse = findViewById(R.id.adresse_societe);
        TextView intitule_societe = findViewById(R.id.intitule_societe_facture);
        ImageView logo = findViewById(R.id.logo_societe);

        raisonSociale.setText(societe.getRaisonSociale());
        telephone.setText(societe.getTelephone());
        email.setText(societe.getEmail());
        adresse.setText(societe.getAdresse());
        intitule_societe.setText(societe.getRaisonSociale());

        Picasso.get().load(societe.getLogo()).into(logo);
    }

    private void setupButtons() {
        ImageButton closeButton = (ImageButton) findViewById(R.id.close_facture);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailFactureActivity.this.finish();
            }
        });
    }

}