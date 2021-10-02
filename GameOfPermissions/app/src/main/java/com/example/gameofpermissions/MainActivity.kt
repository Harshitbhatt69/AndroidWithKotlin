package com.example.gameofpermissions

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnPermission)
        btn.setOnClickListener {
            requestFun()
        }
    }

    private fun checkForExternalStorage() =
        ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun checkForBackground() =
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun checkForLocation() =
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED


    private fun requestFun()
    {
        if(Build.VERSION.SDK_INT>23)
        {
            var permissionsToRequest = mutableListOf<String>()
            if(!checkForExternalStorage())
                permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            if(!checkForLocation())
                permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
            if(!checkForBackground())
                permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)

            if(permissionsToRequest.isNotEmpty())
            {
                ActivityCompat.requestPermissions(this,permissionsToRequest.toTypedArray(),0)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==0 && grantResults.isNotEmpty())
        {
            for(i in grantResults.indices)
            {
                if(grantResults[i]==PackageManager.PERMISSION_GRANTED)
                {
                    Log.d("PermissionRequest","${permissions[i]} granted.")
                }
            }
        }
    }

}