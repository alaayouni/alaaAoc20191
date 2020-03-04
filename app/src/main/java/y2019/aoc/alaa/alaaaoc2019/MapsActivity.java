package y2019.aoc.alaa.alaaaoc2019;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final int REQUEST_CODE = 101;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        LocationRequest mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(60000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationCallback mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        currentLocation= location;
                        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                        mapFragment.getMapAsync(MapsActivity.this);
                        Toast.makeText(getApplicationContext(),location.toString(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();


    }

    private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
            // return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location !=null)
                {
                    currentLocation= location;
                    Toast.makeText(getApplicationContext(),currentLocation.getLatitude()
                            +" "+currentLocation.getLongitude(),Toast.LENGTH_SHORT).show();

                    Toast.makeText(getApplicationContext(),"Inside Fetch",Toast.LENGTH_SHORT).show();
                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.map);
                    mapFragment.getMapAsync(MapsActivity.this);

                }
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(getApplicationContext(),"Inside OnMapReady",Toast.LENGTH_SHORT).show();
        LatLng latLng = new LatLng (currentLocation.getLatitude(),currentLocation.getLongitude());
        MarkerOptions markerOptions=new MarkerOptions().position(latLng).title("i am here.");

        googleMap.addMarker(markerOptions);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if(grantResults.length>0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED)
                {
                    fetchLastLocation();
                }
                break;
        }

    }






   // private GoogleMap mMap;
 //   public  Location currentLocation;



  //  @Override
    //protected void onCreate(Bundle savedInstanceState) {
      //  super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
          //      .findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
    //}


    ///**
     //* Manipulates the map once available.
     //* This callback is triggered when the map is ready to be used.
     //* This is where we can add markers or lines, add listeners or move the camera. In this case,
     //* we just add a marker near Sydney, Australia.
     //* If Google Play services is not installed on the device, the user will be prompted to install
     //* it inside the SupportMapFragment. This method will only be triggered once the user has
     //* installed Google Play services and returned to the app.
     //*/
    //private void fetchLastLocation() {

      //  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        //    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
//        //            Toast.makeText(MainActivity.this, "Permission not granted, Kindly allow permission", Toast.LENGTH_LONG).show();
            //    showPermissionAlert();
              //  return;
            //}
        //}
        //fusedLocationClient.getLastLocation()
          //      .addOnSuccessListener(this, new OnSuccessListener<Location>() {
            //        @Override
              //      public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                //        if (location != null) {
                            // Logic to handle location object
                  //          Log.e("LAST LOCATION: ", location.toString());
                    //    }
                    //}
                //});

    //}
    //public void onMapReady(GoogleMap googleMap) {
      //  Toast.makeText(getApplicationContext(), "Inside OnMapReady", Toast.LENGTH_SHORT).show();
        //LatLng latLng = new LatLng(Location.getLatitude(), Location.getLongitude());
        //MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("i am here");
        //googleMap.addMarker(markerOptions);
        //googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
    //}

    //@Override
    //public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      //  super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    //}





}
