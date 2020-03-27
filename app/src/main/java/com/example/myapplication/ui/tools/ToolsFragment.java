package com.example.myapplication.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    MapView mMapView;
    private GoogleMap googleMap;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tools, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.map);
//        MapFragment fragment = rootView.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady( final GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                googleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                LatLng oswego = new LatLng(43.453710, -76.513342);
                googleMap.addMarker(new MarkerOptions().position(oswego).title("Center?").snippet("just remaking things"));

                // For zooming automatically to the location of the marker
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oswego,13));
                mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng point) {
//                allPoints.add(point);
//                mMap.clear();
                        mMap.addMarker(new MarkerOptions().position(point));
                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(final Marker marker) {     //popup to confirm or remove pickup point
                                System.out.println(marker.getPosition().latitude+","+marker.getPosition().longitude);
                                return false;
                            }
                        });

                    }
                });
            }
        });

        return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;//was a GoogleMap type
//        Marker[] markers = new Marker[5];
//        // Add a marker in Sydney and move the camera
//        LatLng oswego = new LatLng(43.453710, -76.513342);
////        mMap.addMarker(new MarkerOptions().position(oswego).title("Marker in Oswego?"));
////        mMap.addMarker(new MarkerOptions().title("Walmart Oswego"));
//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng point) {
////                allPoints.add(point);
////                mMap.clear();
//                mMap.addMarker(new MarkerOptions().position(point));
//                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//                    @Override
//                    public boolean onMarkerClick(final Marker marker) {     //popup to confirm or remove pickup point
//                        System.out.println(marker.getPosition().latitude+","+marker.getPosition().longitude);
//                        return false;
//                    }
//                });
//
//            }
//        });
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oswego,13));
//    }
}