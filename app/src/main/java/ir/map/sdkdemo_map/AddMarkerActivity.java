package ir.map.sdkdemo_map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.map.sdk_common.MaptexLatLng;
import ir.map.sdk_map.wrapper.MaptexMap;
import ir.map.sdk_map.wrapper.MaptexMarker;
import ir.map.sdk_map.wrapper.MaptexMarkerOptions;
import ir.map.sdk_map.wrapper.OnMaptexReadyCallback;
import ir.map.sdk_map.wrapper.SupportMaptexFragment;

public class AddMarkerActivity extends AppCompatActivity {

    //TODO Change following position for getting your desired location
    private MaptexLatLng TEHRAN = new MaptexLatLng(35.732521, 51.422575);

    private MaptexMap maptexMap;
    private MaptexMarker mTehran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_marker);

        SupportMaptexFragment supportMapFragment =
                (SupportMaptexFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView);

        supportMapFragment.getMaptexAsync(new OnMaptexReadyCallback() {
            @Override
            public void onMaptexReady(MaptexMap map) {
                AddMarkerActivity.this.maptexMap = map;
                if (AddMarkerActivity.this.maptexMap != null) { // Checks if we were successful in obtaining the map
                    //mTehran object holds marker instance for future use like remove marker from Map
                    AddMarkerActivity.this.mTehran = AddMarkerActivity.this.maptexMap.addMarker(new MaptexMarkerOptions()
                            .position(TEHRAN)
                            .title("تهران")
                            .snippet("جمعیت : 8,627,300 نفر"));
                }
            }
        });
    }
}
