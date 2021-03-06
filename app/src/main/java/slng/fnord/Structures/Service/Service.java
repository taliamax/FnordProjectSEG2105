package slng.fnord.Structures.Service;

import java.util.ArrayList;
import java.util.HashMap;

import slng.fnord.Database.Interfaces.Identifiable;
import slng.fnord.Structures.Meta.ServiceProviderMeta;
import slng.fnord.Structures.User.ServiceProvider;

public class Service implements Identifiable {
    private String serviceName;
    private double serviceRate;
    private String id;

    // HashMap holds 'true' if provider is certified, 'false' if not
    private HashMap<String, ServiceProviderMeta> providers;

    public Service() {

    }

    public Service(String name, double serviceRate) {
        this.serviceName = name;
        this.serviceRate = serviceRate;
        providers = new HashMap<>();
    }

    public void addProvider(ServiceProvider provider) {
        if (providers == null) {
            providers = new HashMap<>();
        }
        providers.put(provider.getCompany(), new ServiceProviderMeta(provider, provider.isCertified(serviceName)));
    }

    public void deleteProvider(String name) {
        if (providers == null) {
            providers = new HashMap<>();
        }
        providers.remove(name);
    }

    public boolean isProvider(String name) {
        if (!providers.containsKey(name)){
            return false;
        }

        return true;
    }

    public ServiceProviderMeta getProvider(String name) {
        return providers.get(name);
    }

    public String getProviderEmail(String name) {
        return providers.get(name).getEmail();
    }

    public boolean providerIsCertified(String name) {
        if (!isProvider(name)) {
            return false;
        }

        return providers.get(name).isCertified();
    }

    public ArrayList<String> providerList() {
        return new ArrayList<>(providers.keySet());
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(double serviceRate) {
        this.serviceRate = serviceRate;
    }

    public HashMap<String, ServiceProviderMeta> getProviders() {
        return providers;
    }

    public void setProviders(HashMap<String, ServiceProviderMeta> providers) {
        this.providers = providers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
