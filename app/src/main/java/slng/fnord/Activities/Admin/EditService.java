package slng.fnord.Activities.Admin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Optional;

import slng.fnord.Activities.Shared.MainActivity;
import slng.fnord.Helpers.Common;
import slng.fnord.Database.DBHelper;
import slng.fnord.Managers.ServicesManager;
import slng.fnord.R;
import slng.fnord.Structures.Service;
import slng.fnord.Structures.Services;

public class EditService extends AppCompatActivity {
    private Button confirm;
    ServicesManager manager = new ServicesManager(new DBHelper());
    String newServiceName;
    String rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_services2);

        //two textviews for the editable service and service rate
        final TextView serviceView = findViewById(R.id.serviceNameEditField);
        serviceView.setText(EditServicesSelect.currentService);

        final TextView rateView = findViewById(R.id.serviceRateEditField);
        manager.getServiceRateForView(EditServicesSelect.currentService, rateView);

        confirm = findViewById(R.id.confirmChangesBtn);
        confirm.setOnClickListener(view -> {
            //will need to make some validations on the new service name and rate before we actually add it
            //i.e. if the new service we are trying to add is blank or if it already exists, we make a toast saying it was not added (and ofc it wasnt added)

            if (serviceView.getText().toString().isEmpty() || rateView.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "That Field Cannot Be Blank.",
                        Toast.LENGTH_SHORT).show();
                return;

            }

            newServiceName = serviceView.getText().toString();
            String prevServiceName = EditServicesSelect.currentService;
            rate = rateView.getText().toString();


            if (!Common.validateService(newServiceName)) {
                Toast.makeText(getApplicationContext(), "The service name is invalid",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Common.validatePrice(rate)) {
                Toast.makeText(getApplicationContext(),"The service rate is invalid",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (!prevServiceName.equals(newServiceName)) {
                manager.getService(newServiceName, this::handleServiceConflict);
            } else {
                manager.getService(prevServiceName, this::updateServiceObject);
            }

        });

    }

    public void handleServiceConflict(Optional<Service> service) {
        if (!service.isPresent()) {
            manager.getService(((TextView) findViewById(R.id.serviceNameEditField)).getText().toString(), this::updateServiceObject);
        } else {
            Toast.makeText(getApplicationContext(), "A service with this name already exists", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateServiceObject(Optional<Service> serviceOptional) {
        if (!serviceOptional.isPresent()) {
            return;
        }

        Service service = serviceOptional.get();
        service.setServiceName(newServiceName);
        service.setServiceRate(Double.valueOf(rate));
        manager.updateService(service);

    }
}