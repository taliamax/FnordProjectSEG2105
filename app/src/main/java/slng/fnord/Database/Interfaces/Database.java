package slng.fnord.Database.Interfaces;

import java.util.ArrayList;
import java.util.Optional;

import io.reactivex.Observable;
import slng.fnord.Structures.Service.Booking;
import slng.fnord.Structures.Service.Service;
import slng.fnord.Structures.User.ServiceProvider;
import slng.fnord.Structures.User.User;

public interface Database {
    Observable<Optional<User>> getUser(String email);

    void addUser(User user);

    void updateUser(User user);

    Observable<Optional<Service>> getService(String name);

    void addService(Service service);

    void updateService(Service service);

    void removeService(String name);

    void addBooking(Booking booking);

    void updateBooking(Booking booking);

    void removeBooking(String id);

    Observable<Optional<Booking>> getBooking(String id);

    Observable<Booking> getAllBookings();

    Observable<Optional<ArrayList<String>>> getAllServiceNames();

    Observable<Service> getAllServices();

    Observable<ServiceProvider> getAllServiceProviders();

}
