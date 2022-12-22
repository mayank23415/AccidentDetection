package com.example.accidentdetection.SMS;

import android.Manifest;
import android.content.Context;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.List;

public class sendSms {

    //private EditText text;
    private String text = "Accident Detection App Test";
    List<String> results =  new ArrayList<>();


    public void sendSms(Context context,String lastUpdatedLocation,Double lastUpdatedLat,Double lastUpdatedLong){
//        results.add("7797571334");
//        results.add("6294433062");
////        results.add("8670632396");
//        results.add("Kokonad Clg");
//        results.add("Swarup");
//        results.add("8768478562");
////        results.add("7407535973");
//
//        //sandipan sir
////        results.add("9830561274");
////        results.add("8240290384");
//        results.add("7586949429");
        results.add("8394026174");
        //results.add("9997017879");
        //results.add("9634418131");
        //results.add("7417093980");
        results.add("7017872915");
        results.add("8445952977");


        //  text = findViewById(R.id.txt_message);
        //PERMISSION
//        Dexter.withContext(context)
//                .withPermission(Manifest.permission.SEND_SMS)
//                .withListener(new PermissionListener() {
//                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {/* ... */}
//                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {/* ... */}
//                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* ... */}
//                }).check();
        checkSmsPermission(context);
        //

        SmsManager smsManager =  SmsManager.getDefault();
        try {
            String txt ="Accident Location : "+lastUpdatedLocation.toString();
            String mapLink = "https://www.google.com/maps/search/?api=1&query="+"29.8923161"+ "," + "77.9601853";
            for (int i = 0; i < results.toArray().length; i++)
                smsManager.sendTextMessage(results.get(i), null, txt+ mapLink.toString(), null, null);
            Toast.makeText(context,"SMS sent",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(context,"SMS not sent",Toast.LENGTH_SHORT).show();
        }

    }

    public void checkSmsPermission(Context context){
        Dexter.withContext(context)
                .withPermission(Manifest.permission.SEND_SMS)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {/* ... */}
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {/* ... */}
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* ... */}
                }).check();
    }

}
