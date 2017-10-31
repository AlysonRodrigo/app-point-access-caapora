package br.com.cookiesoft.pointaccesspmcaapora.rest;


import br.com.cookiesoft.pointaccesspmcaapora.domains.Auth;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Cookiesoft on 14/10/2017.
 */

public interface AuthService {

    @FormUrlEncoded
    @POST("/api/login")
    Call<Auth> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("/api/refresh_token")
    Call<Auth> refreshToken();
}
