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

    private MaptexLatLng ARAK = new MaptexLatLng(34.0954, 49.7013);
    private MaptexLatLng SHIRAZ = new MaptexLatLng(29.591, 52.5837);
    private MaptexLatLng RASHT = new MaptexLatLng(37.2682, 49.5891);

    private List polygonPointList = new ArrayList<>();
    private MaptexMap maptexMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_polygon);

        SupportMaptexFragment supportMapFragment =
                (SupportMaptexFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView);

        supportMapFragment.getMaptexAsync(new OnMaptexReadyCallback() {
            @Override
            public void onMaptexReady(MaptexMap map) {
                AddPolygonActivity.this.maptexMap = map;
                if (AddPolygonActivity.this.maptexMap != null) { // Checks if we were successful in obtaining the map.

                    AddPolygonActivity.this.polygonPointList.add(ARAK);
                    AddPolygonActivity.this.polygonPointList.add(SHIRAZ);
                    AddPolygonActivity.this.polygonPointList.add(RASHT);

                    AddPolygonActivity.this.maptexMap.addPolygon(new MaptexPolygonOptions()
                            .addAll(AddPolygonActivity.this.polygonPointList)
                            .fillColor(Color.TRANSPARENT)
                            .strokeColor(Color.BLUE)
                            .strokeWidth(5));

                }
            }
        });
    }
}
