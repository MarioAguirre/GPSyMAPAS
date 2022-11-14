package com.aguirre.gpsymapas;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class Localizacion implements LocationListener {

    MainActivity mainActivity;
    TextView tvMensaje;

    public MainActivity getMainActivity(){
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity, TextView tvMensaje){
        this.mainActivity = mainActivity;
        this.tvMensaje = tvMensaje;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        String text = "Mi ubicacion es:\n"
                + "Latitud =" + location.getLatitude() + "\n"
                + "Longitud =" + location.getLongitude();
        tvMensaje.setText(text);

        mapa(location.getLongitude(), location.getLatitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras){

    }


    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
        tvMensaje.setText("GPS Activado");
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
        tvMensaje.setText("GPS Desactivado");
    }
}
