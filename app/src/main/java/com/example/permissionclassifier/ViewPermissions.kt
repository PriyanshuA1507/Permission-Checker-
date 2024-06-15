package com.example.permissionclassifier

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewPermissions : AppCompatActivity() {
    var packageName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_permissions)
        val tvAppName = findViewById<TextView>(R.id.tvAppNameView)
        val icon = findViewById<ImageView>(R.id.appIconView)
        val safePermissionsListView = findViewById<ListView>(R.id.safePermissionsListView)
        val unsafePermissionsListView = findViewById<ListView>(R.id.unsafePermissionsListView)
        val btnChange = findViewById<Button>(R.id.btnChange)
        val extras = intent.extras
        val b = extras!!.getByteArray("icon")
        val bmp = BitmapFactory.decodeByteArray(b, 0, b!!.size)
        icon.setImageBitmap(bmp)
        tvAppName.text = extras.getString("name")
        packageName = extras.getString("package")
        val safePermissions: List<String>? = extras.getStringArrayList("safePermissions")
        val unsafePermissions: List<String>? = extras.getStringArrayList("unsafePermissions")

        // Create and set the adapter for the safe permissions ListView
        val safePermissionsAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            removeNumbering(safePermissions)
        )
        safePermissionsListView.adapter = safePermissionsAdapter

        // Create and set the adapter for the unsafe permissions ListView
        val unsafePermissionsAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            removeNumbering(unsafePermissions)
        )
        unsafePermissionsListView.adapter = unsafePermissionsAdapter
        btnChange.setOnClickListener {
            val intent = Intent()
            intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            val uri = Uri.fromParts("package", packageName, null)
            intent.data = uri
            startActivity(intent)
        }
    }

    private fun removeNumbering(permissions: List<String>?): List<String> {
        val result: MutableList<String> = ArrayList()
        for (permission in permissions!!) {
            val dotIndex = permission.indexOf(". ")
            if (dotIndex != -1 && dotIndex + 2 < permission.length) {
                result.add(permission.substring(dotIndex + 2))
            } else {
                result.add(permission)
            }
        }
        return result
    }
}