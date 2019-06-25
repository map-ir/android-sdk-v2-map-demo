package ir.map.sdkdemo_map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import ir.map.sdk_map.wrapper.MaptexMap;
import ir.map.sdk_map.wrapper.OnMaptexReadyCallback;
import ir.map.sdk_map.wrapper.SupportMaptexFragment;

public class CurrentLocationActivity extends AppCompatActivity {

    private MaptexMap maptexMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location);

        SupportMaptexFragment supportMapFragment = (SupportMaptexFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView);

        supportMapFragment.getMaptexAsync(new OnMaptexReadyCallback() {
            @Override
            public void onMaptexReady(MaptexMap map) {
                CurrentLocationActivity.this.maptexMap = map;
                if (CurrentLocationActivity.this.maptexMap != null) {
                    //TODO You need this region to get permissions in equals or greater than Marshmallow (Api level >= 23)
                    //region get permission
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                        ActivityCompat.requestPermissions(
                                CurrentLocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    else if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
                            PackageManager.PERMISSION_GRANTED)
                        ActivityCompat.requestPermissions(CurrentLocationActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                    //endregion get permissions
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) ==
                            PackageManager.PERMISSION_GRANTED) {
                        maptexMap.setMyLocationEnabled(true);
                    }
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the location-related task you need to do.
                    if (ActivityCompat.checkSelfPermission(CurrentLocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(CurrentLocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        maptexMap.setMyLocationEnabled(true);
                    }
                } else {
                    // TODO permission denied, boo! Disable the functionality that depends on this permission.
                }
            }
        }
    }
}
