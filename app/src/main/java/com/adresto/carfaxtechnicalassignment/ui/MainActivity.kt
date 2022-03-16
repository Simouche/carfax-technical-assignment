package com.adresto.carfaxtechnicalassignment.ui

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.adresto.carfaxtechnicalassignment.R
import com.adresto.carfaxtechnicalassignment.model.Listing
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions


class MainActivity : AppCompatActivity() {
    private val permissions = arrayOf(
        Manifest.permission.CALL_PHONE,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissionCheck()
        supportFragmentManager.commit {
            add(R.id.fragment_container_view, CarsListFragment(),"cars-list")
        }
    }

    private fun permissionCheck() {
        Permissions.check(
            this,
            permissions,
            null,
            null,
            object : PermissionHandler() {
                override fun onGranted() {
                    Log.d("permission tag", "thanks")
                }

                override fun onDenied(
                    context: Context?,
                    deniedPermissions: ArrayList<String>?
                ) {
                    super.onDenied(context, deniedPermissions)
                    finishAffinity()
                }
            })
    }


}