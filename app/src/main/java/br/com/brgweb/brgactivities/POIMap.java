package br.com.brgweb.brgactivities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;


public class POIMap extends FragmentActivity implements OnMapReadyCallback {

    //Points of Interest with K as marker name and V as LatLng Object
    HashMap<String, LatLng> POI = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_map);

        //POI load data
        POI.put("Marker1", new LatLng(0, 0));
        POI.put("Marker2", new LatLng(10, 10));
        POI.put("Marker3", new LatLng(20, 20));
        POI.put("Marker4", new LatLng(-10, -10));
        POI.put("Marker5", new LatLng(-20, -20));

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    //add markers
    @Override
    public void onMapReady(GoogleMap map) {
        //loop through POI to add markers
        for (Object o : POI.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            map.addMarker(new MarkerOptions().position((LatLng) pair.getValue()).title((String) pair.getKey()));
        }
    }
}
