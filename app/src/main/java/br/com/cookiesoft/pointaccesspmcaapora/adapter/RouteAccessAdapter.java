package br.com.cookiesoft.pointaccesspmcaapora.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.cookiesoft.pointaccesspmcaapora.R;
import br.com.cookiesoft.pointaccesspmcaapora.domains.RouteAccess;
import br.com.cookiesoft.pointaccesspmcaapora.listener.OnListClickInterationListener;

/**
 * Created by Cookiesoft on 30/10/2017.
 */

public class RouteAccessAdapter extends RecyclerView.Adapter<RouteAccessAdapter.RouteAccessViewHolder> {

    private Context context;
    private List<RouteAccess> routeAccessList;
    private RouteAccessOnClickListener routeAccessOnClickListener;

    public RouteAccessAdapter(Context context, List<RouteAccess> routeAccessList, RouteAccessOnClickListener listener){
        this.context = context;
        this.routeAccessList = routeAccessList;
        this.routeAccessOnClickListener = listener;
    }

    @Override
    public RouteAccessViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_route_list, parent, false);
        RouteAccessViewHolder holder = new RouteAccessViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RouteAccessViewHolder holder, final int position) {
        RouteAccess routeAccess = this.routeAccessList.get(position);
        holder.mTextLocalName.setText(routeAccess.getName());

        if(routeAccessOnClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    routeAccessOnClickListener.onClickRouteAccess(holder.itemView, position);
                }
            });
        }
    }

    public interface RouteAccessOnClickListener{

        public void onClickRouteAccess(View view, int idx);
    }

    @Override
    public int getItemCount() {
        return this.routeAccessList.size();
    }

    public static class RouteAccessViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextLocalName;

        public RouteAccessViewHolder(View itemView) {
            super(itemView);

            this.mTextLocalName = (TextView) itemView.findViewById(R.id.local_name);


        }

    }

}
