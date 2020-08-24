package com.example.google.map.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>

    companion object {
        // const val is only primitives or string
        val MY_HOUSE_LAT_LNG = LatLng(35.699778, 139.576081)
        val MY_OFFICE_LAT_LNG = LatLng(35.658208, 139.701636)
        val KAMIKOUCHI_LAT_LNG = LatLng(36.251606, 137.653653)
        val SHIRETOKO_LAT_LNG = LatLng(44.199790, 145.239638)
        val KAGOSHIMA_LAT_LNG = LatLng(31.586445, 130.649869)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // CoordinatorLayout の 直下に配置している View を渡す
        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout))

        // 仮でMyHouse=吉祥寺, MyOffice=渋谷
        findViewById<Button>(R.id.buttonMyHouse).setOnClickListener {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MY_HOUSE_LAT_LNG, 16f))
        }
        findViewById<Button>(R.id.buttonMyOffice).setOnClickListener {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MY_OFFICE_LAT_LNG, 16f))
        }
        findViewById<Button>(R.id.buttonKamikouchi).setOnClickListener {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KAMIKOUCHI_LAT_LNG, 16f))
        }
        findViewById<Button>(R.id.buttonShiretoko).setOnClickListener {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SHIRETOKO_LAT_LNG, 16f))
        }
        findViewById<Button>(R.id.buttonKagoshima).setOnClickListener {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KAGOSHIMA_LAT_LNG, 16f))
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // 初期値は自宅
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MY_HOUSE_LAT_LNG, 16f))
    }
}