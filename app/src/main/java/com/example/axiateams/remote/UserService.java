package com.example.axiateams.remote;

import com.example.axiateams.remote.response.DocumentResponse;
import com.example.axiateams.remote.response.EtatResponse;
import com.example.axiateams.remote.response.FactureResponse;
import com.example.axiateams.remote.response.LoginResponse;
import com.example.axiateams.remote.response.ListProjetResponse;
import com.example.axiateams.remote.response.PhaseResponse;
import com.example.axiateams.remote.response.ProjetResponse;
import com.example.axiateams.remote.response.SocieteResponse;
import com.example.axiateams.remote.response.DashboardResponse;
import com.example.axiateams.remote.response.TacheResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

    @POST ("api/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("api/projet/list")
    Call<ListProjetResponse> getListProjet(@Header("Authorization") String auth);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("api/projet/list")
    Call<DashboardResponse> getProjets(@Header("Authorization") String auth);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("api/projet/details/{cbmarq}/{type}")
    Call<ProjetResponse> getDetailsProjet(@Header("Authorization") String auth, @Path("cbmarq") String cbmarq, @Path("type") int type);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("api/taches/list/{cbmarqProjet}")
    Call<TacheResponse> getListTaches(@Header("Authorization") String auth, @Path("cbmarqProjet") String cbmarq);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("api/listDocuments/{type}")
    Call<FactureResponse> getListDocuments(@Header("Authorization") String auth, @Path("type") String type);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("api/document/{cbmarq}")
    Call<DocumentResponse> getDocument(@Header("Authorization") String auth, @Path("cbmarq") int cbmarq);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("api/societe/{cbmarq}?type=3")
    Call<SocieteResponse> getSociete(@Header("Authorization") String auth, @Path("cbmarq") int cbmarq);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("api/parametre/listphaseprojet")
    Call<PhaseResponse> getListPhaseProjet(@Header("Authorization") String auth);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("api/parametre/listbycategorie")
    Call<EtatResponse> getListByCategorie(@Header("Authorization") String auth, @Query("codeCat") String codeCat);

}
