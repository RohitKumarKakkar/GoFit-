package example.healthapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class HealthServices extends AppCompatActivity implements View.OnClickListener {
    private CardView hospitalcrdv, medicalcrdv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_services);

        hospitalcrdv = (CardView) findViewById(R.id.hospitalcv);
        medicalcrdv = (CardView) findViewById(R.id.medicalcv);


        // setting click listner

        hospitalcrdv.setOnClickListener(this);
        medicalcrdv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.hospitalcv:
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=hospital");
                i = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);
                break;
            case R.id.medicalcv:
                i = new Intent(this, MedicalCard.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
