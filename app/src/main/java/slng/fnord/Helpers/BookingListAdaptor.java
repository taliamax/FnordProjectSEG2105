package slng.fnord.Helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import slng.fnord.Activities.HomeOwner.BookingList;
import slng.fnord.R;
import slng.fnord.Structures.Service.Booking;


public class BookingListAdaptor extends BaseAdapter {
    private ArrayList<Booking> bookings;
    private BookingList context;
    private SimpleDateFormat dateFormatter;

    // override other abstract methods here

    public BookingListAdaptor(ArrayList<Booking> bookings, BookingList ctx ){
        this.bookings = bookings;
        this.context=ctx;
        dateFormatter = new SimpleDateFormat("EEE, MMM d, yyyy", Locale.US);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        View view;
        if (convertView == null) {
            convertView = LayoutInflater.from(container.getContext()).inflate(R.layout.booking_list_layout, container, false);
            convertView.setOnClickListener(this::onBookingItemClick);
        }
        fillItem(position, convertView, getBooking(position));
        return convertView;
    }

    @Override
    public int getCount() {
        return bookings.size();
    }

    public void fillItem(int pos, View v, Booking booking){
        //TODO: Set more stuff to display to the user
        ((TextView) v.findViewById(R.id.bookingLService)).setText(booking.getService());
        ((TextView) v.findViewById(R.id.bookingLPosition)).setText(((Integer)pos).toString());
        ((TextView) v.findViewById(R.id.bookingLProvider)).setText(booking.getServiceProviderInfo().getCompany());
        ((TextView) v.findViewById(R.id.bookingLStartTime)).setText(booking.getStartTime()+":00");
        ((TextView) v.findViewById(R.id.bookingLEndTime)).setText(booking.getEndTime()+":00");
        ((TextView) v.findViewById(R.id.bookingLDate)).setText(dateFormatter.format(booking.dateAsCalendar().getTime()));
    }

    public String getItem(int pos){
        return getService(pos);
    }

    public Booking getBooking(int pos){return bookings.get(pos);}

    private String getService(int pos){
        return bookings.get(pos).getService();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void onBookingItemClick(View v){
        int pos = Integer.parseInt((String) ((TextView) v.findViewById(R.id.bookingLPosition)).getText());
        Booking b = bookings.get(pos);
        context.openBookingActivity(b);
    }

}
