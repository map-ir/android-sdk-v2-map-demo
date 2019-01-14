package ir.map.sdkdemo_map;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ir.map.sdk_common.MaptexLatLng;
import ir.map.sdk_map.wrapper.MaptexMap;
import ir.map.sdk_map.wrapper.MaptexPolygonOptions;
import ir.map.sdk_map.wrapper.OnMaptexReadyCallback;
import ir.map.sdk_map.wrapper.SupportMaptexFragment;

public class AddPolygonActivity extends AppCompatActivity {

    private static final MaptexLatLng ARAK = new MaptexLatLng(34.0954, 49.7013);
    private static final MaptexLatLng SHIRAZ = new MaptexLatLng(29.591, 52.5837);
    private static final MaptexLatLng MASHHAD = new MaptexLatLng(36.2605, 59.6168);
    private static final MaptexLatLng RASHT = new MaptexLatLng(37.2682, 49.5891);
    private List polygonPointList = new ArrayList<>();
    private MaptexMap maptexMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_polygon);

        ((SupportMaptexFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView))
                .getMaptexAsync(new OnMaptexReadyCallback() {
                    @Override
                    public void onMaptexReady(MaptexMap map) {
                        maptexMap = map;
                        // Check if we were successful in obtaining the map.
                        if (maptexMap != null) {

                            polygonPointList.add(ARAK);
                            polygonPointList.add(SHIRAZ);
                            polygonPointList.add(MASHHAD);
                            polygonPointList.add(RASHT);

                            maptexMap.addPolygon(new MaptexPolygonOptions()
                                    .addAll(polygonPointList)
                                    .fillColor(Color.TRANSPARENT)
                                    .strokeColor(Color.BLUE)
                                    .strokeWidth(5));

                        }
                    }
                });
    }
}
