package slng.fnord.Database;

import java.util.ArrayList;
import java.util.Optional;

import io.reactivex.Observable;
import slng.fnord.Database.Interfaces.Database;
import slng.fnord.Structures.Service.Booking;
import slng.fnord.Structures.Service.Service;
import slng.fnord.Structures.User.ServiceProvider;
import slng.fnord.Structures.User.User;

public class DBMock implements Database {
    @Override
    public void addService(Service service) {

    }

    @Override
    public Observable<Optional<Service>> getService(String name) {
        return null;
    }

    @Override
    public Observable<Optional<User>> getUser(String email) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeService(String name) {

    }

    @Override
    public void addBooking(Booking booking) {

    }

    @Override
    public void updateBooking(Booking booking) {

    }

    @Override
    public void removeBooking(String id) {

    }

    @Override
    public Observable<Optional<Booking>> getBooking(String id) {
        return null;
    }

    @Override
    public void updateService(Service service) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public Observable<Optional<ArrayList<String>>> getAllServiceNames() {
        return null;
    }

    @Override
    public Observable<Service> getAllServices() {
        return null;
    }

    @Override
    public Observable<Booking> getAllBookings() {
        return null;
    }

    @Override
    public Observable<ServiceProvider> getAllServiceProviders() {
        return null;
    }
}
