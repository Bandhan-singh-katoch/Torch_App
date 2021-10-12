package com.example.utilities_app

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var cameraM : CameraManager
    private lateinit var powerBtn : ImageButton
    var isFlash = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        powerBtn = findViewById(R.id.power)
        cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        powerBtn.setOnClickListener{ flashLightOnOrOff(it) }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun flashLightOnOrOff(v: View?) {

        if(!isFlash){
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,true)
            isFlash = true
            powerBtn.setImageResource(R.drawable.ic_power_on)
        }
        else{
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,false)
            isFlash = false
            powerBtn.setImageResource(R.drawable.ic_power_off)
        }

    }
}