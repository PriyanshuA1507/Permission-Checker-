package com.example.permissionclassifier

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.permissionclassifier.AppListAdapter.AppViewHolder

class AppListAdapter(apps: ArrayList<AppItem>, mContext: Context) :
    RecyclerView.Adapter<AppViewHolder>() {
    private var mApps = ArrayList<AppItem>()
    private val mContext: Context
    var onAppClickListener: OnAppClickListener? = null

    init {
        mApps = apps
        this.mContext = mContext
    }

    fun setClickListener(itemClickListener: OnAppClickListener?) {
        onAppClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): AppViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.app_item, viewGroup, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(appViewHolder: AppViewHolder, i: Int) {
        appViewHolder.bindApp(mApps[i])
    }

    override fun getItemCount(): Int {
        return mApps.size
    }

    inner class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var mAppIcon: ImageView
        var mAppName: TextView
        private val mContext: Context

        init {
            mContext = itemView.context
            mAppIcon = itemView.findViewById(R.id.appIcon)
            mAppName = itemView.findViewById(R.id.tvAppName)
            itemView.setOnClickListener(this)
        }

        fun bindApp(app: AppItem) {
            mAppName.text = app.appName
            mAppIcon.setImageDrawable(app.appIcon)
        }

        override fun onClick(v: View) {
            if (onAppClickListener != null) onAppClickListener!!.onAppSelected(v, adapterPosition)
        }
    }
}