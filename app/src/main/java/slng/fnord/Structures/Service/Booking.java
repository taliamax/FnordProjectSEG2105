package slng.fnord.Structures.Service;

import java.util.Calendar;

import slng.fnord.Database.Interfaces.Identifiable;
import slng.fnord.Structures.Meta.HomeOwnerInfo;
import slng.fnord.Structures.Meta.ServiceProviderInfo;
import slng.fnord.Structures.User.HomeOwner;
import slng.fnord.Structures.User.ServiceProvider;

public class Booking implements Identifiable {
    private String id;
    private ServiceProviderInfo serviceProviderInfo;
    private HomeOwnerInfo homeOwnerInfo;
    private String service;

    private int bookingDay;
    private int bookingMonth;
    private int bookingYear;

    private int startTime;
    private int endTime;

    public Booking() {

    }

    public Booking(ServiceProvider serviceProvider, HomeOwner homeOwner, String service, Calendar bookingDate, int startTime, int endTime) {
        this.serviceProviderInfo = new ServiceProviderInfo(serviceProvider);
        this.homeOwnerInfo = new HomeOwnerInfo(homeOwner);
        this.bookingDay = bookingDate.get(Calendar.DAY_OF_MONTH);
        this.bookingMonth = bookingDate.get(Calendar.MONTH);
        this.bookingYear = bookingDate.get(Calendar.YEAR);
        this.startTime = startTime;
        this.endTime = endTime;
        this.service = service;
    }

    public ServiceProviderInfo getServiceProviderInfo() {
        return serviceProviderInfo;
    }

    public void setServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
        this.serviceProviderInfo = serviceProviderInfo;
    }

    public HomeOwnerInfo getHomeOwnerInfo() {
        return homeOwnerInfo;
    }

    public void setHomeOwnerInfo(HomeOwnerInfo homeOwnerInfo) {
        this.homeOwnerInfo = homeOwnerInfo;
    }

    public Calendar dateAsCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.set(bookingYear, bookingMonth, bookingDay);
        return cal;
    }

    public void setBookingDate(Calendar bookingDate) {
        this.bookingDay = bookingDate.get(Calendar.DAY_OF_MONTH);
        this.bookingMonth = bookingDate.get(Calendar.MONTH);
        this.bookingYear = bookingDate.get(Calendar.YEAR);
    }

    public int getBookingDay() {
        return bookingDay;
    }

    public int getBookingMonth() {
        return bookingMonth;
    }

    public int getBookingYear() {
        return bookingYear;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }


}
