package br.com.cookiesoft.pointaccesspmcaapora.domains;

/**
 * Created by Cookiesoft on 30/10/2017.
 */

public class RouteAccess {

    private Integer id;
    private String name;
    private String routerName;
    private String routerPassword;
    private String ppoeUser;
    private String ppoePassword;
    private String wifiUser;
    private String wifiPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public String getRouterPassword() {
        return routerPassword;
    }

    public void setRouterPassword(String routerPassword) {
        this.routerPassword = routerPassword;
    }

    public String getPpoeUser() {
        return ppoeUser;
    }

    public void setPpoeUser(String ppoeUser) {
        this.ppoeUser = ppoeUser;
    }

    public String getPpoePassword() {
        return ppoePassword;
    }

    public void setPpoePassword(String ppoePassword) {
        this.ppoePassword = ppoePassword;
    }

    public String getWifiUser() {
        return wifiUser;
    }

    public void setWifiUser(String wifiUser) {
        this.wifiUser = wifiUser;
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword;
    }
}
