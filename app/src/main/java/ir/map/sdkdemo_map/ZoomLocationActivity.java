package ir.map.sdkdemo_map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.map.sdk_common.MaptexLatLng;
import ir.map.sdk_map.wrapper.MaptexCameraUpdateFactory;
import ir.map.sdk_map.wrapper.MaptexMap;
import ir.map.sdk_map.wrapper.OnMaptexReadyCallback;
import ir.map.sdk_map.wrapper.SupportMaptexFragment;

public class ZoomLocationActivity extends AppCompatActivity {

    //Change the following constants for getting your own location
    public static final double FOCUSED_LATTITUDE = 35.6964895;
    public static final double FOCUSED_LONGITUDE = 51.279745;
    public static final int FOCUSED_ZOOM_LEVEL = 12;
    private MaptexMap maptexMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_location);

        ((SupportMaptexFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView))
                .getMaptexAsync(new OnMaptexReadyCallback() {
                    @Override
                    public void onMaptexReady(MaptexMap map) {
                        maptexMap = map;
                        if (maptexMap != null) {
                            maptexMap.moveCamera(MaptexCameraUpdateFactory
                                    .newLatLngZoom(new MaptexLatLng(FOCUSED_LATTITUDE, FOCUSED_LONGITUDE),
                                            FOCUSED_ZOOM_LEVEL));
                        }
                    }
                });
    }
}
