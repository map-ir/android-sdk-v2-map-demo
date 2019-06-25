package ir.map.sdkdemo_map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.map.sdk_common.MaptexLatLng;
import ir.map.sdk_map.wrapper.MaptexMap;
import ir.map.sdk_map.wrapper.MaptexPolylineOptions;
import ir.map.sdk_map.wrapper.OnMaptexReadyCallback;
import ir.map.sdk_map.wrapper.SupportMaptexFragment;

public class AddPolylineActivity extends AppCompatActivity {

    private static final MaptexLatLng ARAK = new MaptexLatLng(34.0954, 49.7013);
    private static final MaptexLatLng SHIRAZ = new MaptexLatLng(29.591, 52.5837);
    private static final MaptexLatLng RASHT = new MaptexLatLng(37.2682, 49.5891);

    private MaptexMap maptexMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_polyline);

        SupportMaptexFragment supportMapFragment =
                (SupportMaptexFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView);

        supportMapFragment.getMaptexAsync(new OnMaptexReadyCallback() {
            @Override
            public void onMaptexReady(MaptexMap map) {
                AddPolylineActivity.this.maptexMap = map;
                if (AddPolylineActivity.this.maptexMap != null) { // Checks if we were successful in obtaining the map.
                    AddPolylineActivity.this.maptexMap.addPolyline((new MaptexPolylineOptions())
                            .add(ARAK, SHIRAZ, RASHT));
                }
            }
        });
    }
}
