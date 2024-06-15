package com.example.permissionclassifier

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class PermissionsAdapter(context: Context?, private val permissions: List<String>) :
    ArrayAdapter<String?>(
        context!!, android.R.layout.simple_list_item_1, permissions
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            holder = ViewHolder(convertView)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        val permission = permissions[position]
        holder.permissionTextView.text = permission
        return convertView!!
    }

    private class ViewHolder internal constructor(itemView: View?) {
        var permissionTextView: TextView

        init {
            permissionTextView = itemView!!.findViewById(android.R.id.text1)
        }
    }
}