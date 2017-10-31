package br.com.cookiesoft.pointaccesspmcaapora.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.com.cookiesoft.pointaccesspmcaapora.domains.Error;

import java.util.List;

import br.com.cookiesoft.pointaccesspmcaapora.R;
import br.com.cookiesoft.pointaccesspmcaapora.adapter.RouteAccessAdapter;
import br.com.cookiesoft.pointaccesspmcaapora.domains.RouteAccess;
import br.com.cookiesoft.pointaccesspmcaapora.rest.AccessRouteService;
import br.com.cookiesoft.pointaccesspmcaapora.rest.ServiceGenerator;
import br.com.cookiesoft.pointaccesspmcaapora.util.Preferences;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AccessRouteFragment extends Fragment {

    private static final String TAG = "AccessRouteFragment";
    protected RecyclerView recyclerView;
    private List<RouteAccess> routeAccessList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_access_route, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        findAccessRoutes();

        return view;
    }

    public void findAccessRoutes(){

        Call<List<RouteAccess>> call = ServiceGenerator.createService(AccessRouteService.class, Preferences.getString(getActivity(),"token_access")).allAccessRoutes();

        call.enqueue(new Callback<List<RouteAccess>>() {
            @Override
            public void onResponse(Call<List<RouteAccess>> call, Response<List<RouteAccess>> response) {

                if(response.isSuccessful()){
                    routeAccessList = response.body();
                    recyclerView.setAdapter(new RouteAccessAdapter(getActivity(),routeAccessList, onClickRouteAccess()));
                }else {
                    Error error = new Error();
                    error.setError(response.message());
                    Toast.makeText(getActivity(),error.getError(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<RouteAccess>> call, Throwable t) {
                Error error = new Error();
                error.setError(t.getMessage());
                Toast.makeText(getActivity(),error.getError(),Toast.LENGTH_LONG).show();
                Log.d(TAG,"Error na chamada " +t.getMessage());
            }
        });
    }

    private RouteAccessAdapter.RouteAccessOnClickListener onClickRouteAccess(){
        return new RouteAccessAdapter.RouteAccessOnClickListener() {
            @Override
            public void onClickRouteAccess(View view, int idx) {
                RouteAccess routeAccess = routeAccessList.get(idx);
                Toast.makeText(getActivity(),"RouteAccess: " + routeAccess.getName(), Toast.LENGTH_LONG).show();
            }
        };
    }


}
