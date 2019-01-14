package ir.map.sdkdemo_map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basicMap:
                startActivity(new Intent(this, BasicMapActivity.class));
                break;
            case R.id.currentLocation:
                startActivity(new Intent(this, CurrentLocationActivity.class));
                break;
            case R.id.zoomLocation:
                startActivity(new Intent(this, ZoomLocationActivity.class));
                break;
            case R.id.addMarker:
                startActivity(new Intent(this, AddMarkerActivity.class));
                break;
            case R.id.addPolyLine:
                startActivity(new Intent(this, AddPolylineActivity.class));
                break;
            case R.id.addPolygon:
                startActivity(new Intent(this, AddPolygonActivity.class));
                break;
        }
    }
}
