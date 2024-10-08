package com.example.pamakhir

import android.app.Application
import com.google.firebase.FirebaseApp

class PAMakhir : Application(){
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }

}