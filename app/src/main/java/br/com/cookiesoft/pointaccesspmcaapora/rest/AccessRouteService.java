package br.com.cookiesoft.pointaccesspmcaapora.rest;

import java.util.List;

import br.com.cookiesoft.pointaccesspmcaapora.domains.RouteAccess;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Cookiesoft on 16/10/2017.
 */

public interface AccessRouteService {

    @GET("/api/access")
    Call<List<RouteAccess>> allAccessRoutes();
}
