package ir.map.sdkdemo_map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.map.sdk_common.MaptexLatLng;
import ir.map.sdk_map.wrapper.MaptexBitmapDescriptorFactory;
import ir.map.sdk_map.wrapper.MaptexMap;
import ir.map.sdk_map.wrapper.MaptexMarker;
import ir.map.sdk_map.wrapper.MaptexMarkerOptions;
import ir.map.sdk_map.wrapper.OnMaptexReadyCallback;
import ir.map.sdk_map.wrapper.SupportMaptexFragment;

public class AddMarkerActivity extends AppCompatActivity {


    private static final MaptexLatLng TEHRAN = new MaptexLatLng(35.6970118, 51.2097353);
    private MaptexMap maptexMap;
    private MaptexMarker mTehran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_marker);

        ((SupportMaptexFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView))
                .getMaptexAsync(new OnMaptexReadyCallback() {
                    @Override
                    public void onMaptexReady(MaptexMap map) {
                        maptexMap = map;
                        // Check if we were successful in obtaining the map.
                        if (maptexMap != null) {
                            // Uses a custom icon.
                            mTehran = maptexMap.addMarker(new MaptexMarkerOptions()
                                    .position(TEHRAN).title("Tehran").snippet("Population: 8,627,300")
                                    .icon(MaptexBitmapDescriptorFactory.fromResource(R.drawable.ic_marker)));
                        }
                    }
                });
    }
}
