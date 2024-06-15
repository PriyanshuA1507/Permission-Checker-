package com.example.permissionclassifier

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.permissionclassifier.databinding.ActivityMainBinding
import org.jsoup.Jsoup
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.*
import java.util.concurrent.ExecutionException
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity(), OnAppClickListener {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var adapter: AppListAdapter
    private lateinit var apps: ArrayList<AppItem>
    private lateinit var filteredApps: ArrayList<AppItem>
    private lateinit var context: Context
    private var showSystemApps = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // For toolbar
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        mRecyclerView = findViewById(R.id.appList)
        apps = installedPackages
        filteredApps = ArrayList(apps)
        adapter = AppListAdapter(filteredApps, applicationContext)
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.setHasFixedSize(true)
        adapter.setClickListener(this)
        context = this

        val pullToRefresh = findViewById<SwipeRefreshLayout>(R.id.pullToRefresh)
        pullToRefresh.setOnRefreshListener {
            updateAppListAllApps()
            pullToRefresh.isRefreshing = false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        // Get the search item from the toolbar menu
        val searchItem = menu.findItem(R.id.action_search)

        // Set the search item as an expandable action view
        val searchView = searchItem.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                performSearch(query)
                return false // Set this to false instead of true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                performSearch(newText)
                return true
            }
        })
        return true
    }

    private fun performSearch(query: String) {
        val lowercaseQuery = query.lowercase(Locale.getDefault())
        filteredApps.clear()
        if (query.isEmpty()) {
            filteredApps.addAll(apps)
        } else {
            filteredApps.addAll(
                apps.filter { app ->
                    app.appName?.lowercase(Locale.getDefault())?.contains(lowercaseQuery) == true
                }
            )
        }
        adapter.notifyDataSetChanged()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        // For Excel Exported
        return when (id) {
            R.id.menu_excel_exporter -> {
                updateAppListInstalledApps()
                true
            }
            R.id.csv_file_analysis -> {
                val intent = Intent(this@MainActivity, MLAnalysisActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateAppList() {
        if (showSystemApps) {
            updateAppListAllApps()
        } else {
            updateAppListInstalledApps()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateAppListAllApps() {
        // Update app list to show all apps (including system apps)
        apps.clear()
        apps.addAll(installedPackages)
        adapter.notifyDataSetChanged()
    }

    private val installedPackages: ArrayList<AppItem>
        get() {
            val packageManager = packageManager
            val intent = Intent(Intent.ACTION_MAIN, null)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
            val resolveInfoList = packageManager.queryIntentActivities(intent, 0)
            val applist = ArrayList<AppItem>()
            for (resolveInfo in resolveInfoList) {
                val activityInfo = resolveInfo.activityInfo
                val packageName = activityInfo.applicationInfo.packageName
                if (activityInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM == 0) {
                    val label = packageManager.getApplicationLabel(activityInfo.applicationInfo) as String
                    val icon = packageManager.getApplicationIcon(activityInfo.applicationInfo)
                    val item = AppItem().apply {
                        this.packageName = packageName
                        this.appName = label
                        this.appIcon = icon
                    }
                    applist.add(item)
                }
            }
            return applist
        }

    /*
    protected String getPermissionsByPackageName(String packageName) {
        StringBuilder builder = new StringBuilder();

        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
            int counter = 1;
            for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                if ((packageInfo.requestedPermissionsFlags[i] & PackageInfo.REQUESTED_PERMISSION_GRANTED) != 0) {
                    String permission = packageInfo.requestedPermissions[i];
                    builder.append("" + counter + ". " + permission + "\n");
                    counter++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
*/
    //My Modified Permission Fetched only who is in sheet
    /*
    protected String getPermissionsByPackageName(String packageName, String appName) {
        StringBuilder builder = new StringBuilder();
        String []permissionSet = {"ACCESS_NETWORK_STATE","READ_NETWORK_USAGE_HISTORY","CONTENT_READ","MANAGE_USB","DEVICE_POWER","READ_WIFI_CREDENTIAL","VIBRATE","RESTART_PACKAGES","READ_PHONE_STATE","CHANGE_WIFI_MULTICAST_STATE","CHECK_LICENSE","ACCOUNT_MANAGER","ACCESS_COARSE_LOCATION","ACCESS_FINE_LOCATION","MODIFY_AUDIO_SETTINGS","RECORD_AUDIO","ACCESS_BLUETOOTH_SHARE","NEARBY_WIFI_DEVICES","GET_TASKS","CAMERA","SET_ALARM","READ_MY_DATA","CHANGE_NETWORK_STATE","USE_CREDENTIALS","BLUETOOTH_ADMIN","HIDE_OVERLAY_WINDOWS","READ_GSERVICES","WRITE_SETTINGS","BROADCAST_STICKY","KILL_BACKGROUND_PROCESSES","WAKE_LOCK","INSTALL_SHORTCUT","WRITE_EXTERNAL_STORAGE","FLASHLIGHT","NFC","MANAGE_EXTERNAL_STORAGE","BATTERY_STATS","READ_CONTACTS","WRITE_CALENDAR","MANAGE_ACCOUNTS","READ_CALENDAR","UNINSTALL_SHORTCUT","GET_PASSWORD","ACCESS_LOCATION_EXTRA_COMMANDS","WRITE_SETTINGS","CALL_PRIVILEGED","SET_DEBUG_APP","READ_HISTORY_BOOKMARKS","REORDER_TASKS","DUMP","SET_WALLPAPER","WRITE_HISTORY_BOOKMARKS","FOREGROUND_SERVICE","ADD_VOICEMAIL","WRITE_USER_DICTIONARY","BODY_SENSORS_BACKGROUND","CHANGE_WIMAX_STATE","WRITE_APN_SETTINGS","CLEAR_APP_CACHE","CALL_PHONE","WRITE_SMS","MANAGE_USB","EXPAND_STATUS_BAR","SET_ALWAYS_FINISH","SET_PROCESS_LIMIT","PERSISTENT_ACTIVITY","USE_SIP","ACCESS_MOCK_LOCATION","SET_ANIMATION_SCALE","MODIFY_PHONE_STATE","WRITE_CONTACTS","WRITE_PROFILE","READ_CALL_LOG","READ_CELL_BROADCASTS","READ_SYNC_SETTINGS","READ_USER_DICTIONARY","READ_PROFILE","READ_SMS","RECEIVE_MMS","RECEIVE_SMS","RECEIVE_WAP_PUSH","PROCESS_OUTGOING_CALLS","SIGNAL_PERSISTENT_PROCESSES","SEND_SMS","SET_PREFERRED_APPLICATIONS","SET_TIME_ZONE","WRITE_SYNC_SETTINGS","WRITE_CALL_LOG"};
        Set<String> requiredpermission = new HashSet<String>();
        Collections.addAll(requiredpermission, permissionSet);

//
//        String filePath = "C:\\Users\\Jaikishan Mohanty\\Downloads\\permission_checker-master\\permission_checker-master\\app\\src\\main\\res\\ExcelSheet\\MergedMapping.xls";
//        List<String> dataList = ReadExcelData.readExcel();
        System.out.println("Pacage Name : "+packageName);
        PackageManager pm = context.getPackageManager();
        String category = getCategory(pm, packageName);
        System.out.println("Category : "+category);
       // PermissionChecker permissionChecker = new PermissionChecker();
       // permissionChecker.checkPermission(category,permissionsList );
        // Process the data as needed




        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);

            int counter = 1;
            for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                String oldpermission = packageInfo.requestedPermissions[i];
                String permission = oldpermission.replaceAll(".*\\.(.*)", "$1");
                Log.i("Package", "getPermissionsByPackageName: "+appName);

                if ((packageInfo.requestedPermissionsFlags[i] & PackageInfo.REQUESTED_PERMISSION_GRANTED) != 0 && requiredpermission.contains(permission)) {
                    builder.append(counter++).append(". ").append(permission).append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return builder.toString();

    }
*/
    protected fun getPermissionsByPackageName(packageName: String?): List<String> {
        val permissionsList: MutableList<String> = ArrayList()
        val permissionSet = setOf(
            "ACCESS_NETWORK_STATE",
            "READ_NETWORK_USAGE_HISTORY",
            "CONTENT_READ",
            "MANAGE_USB",
            "DEVICE_POWER",
            "READ_WIFI_CREDENTIAL",
            "VIBRATE",
            "RESTART_PACKAGES",
            "READ_PHONE_STATE",
            "CHANGE_WIFI_MULTICAST_STATE",
            "CHECK_LICENSE",
            "ACCOUNT_MANAGER",
            "ACCESS_COARSE_LOCATION",
            "ACCESS_FINE_LOCATION",
            "MODIFY_AUDIO_SETTINGS",
            "RECORD_AUDIO",
            "ACCESS_BLUETOOTH_SHARE",
            "NEARBY_WIFI_DEVICES",
            "GET_TASKS",
            "CAMERA",
            "SET_ALARM",
            "READ_MY_DATA",
            "CHANGE_NETWORK_STATE",
            "USE_CREDENTIALS",
            "BLUETOOTH_ADMIN",
            "HIDE_OVERLAY_WINDOWS",
            "READ_GSERVICES",
            "WRITE_SETTINGS",
            "BROADCAST_STICKY",
            "KILL_BACKGROUND_PROCESSES",
            "WAKE_LOCK",
            "INSTALL_SHORTCUT",
            "WRITE_EXTERNAL_STORAGE",
            "FLASHLIGHT",
            "NFC",
            "MANAGE_EXTERNAL_STORAGE",
            "BATTERY_STATS",
            "READ_CONTACTS",
            "WRITE_CALENDAR",
            "MANAGE_ACCOUNTS",
            "READ_CALENDAR",
            "UNINSTALL_SHORTCUT",
            "GET_PASSWORD",
            "ACCESS_LOCATION_EXTRA_COMMANDS",
            "WRITE_SETTINGS",
            "CALL_PRIVILEGED",
            "SET_DEBUG_APP",
            "READ_HISTORY_BOOKMARKS",
            "REORDER_TASKS",
            "DUMP",
            "SET_WALLPAPER",
            "WRITE_HISTORY_BOOKMARKS",
            "FOREGROUND_SERVICE",
            "ADD_VOICEMAIL",
            "WRITE_USER_DICTIONARY",
            "BODY_SENSORS_BACKGROUND",
            "CHANGE_WIMAX_STATE",
            "WRITE_APN_SETTINGS",
            "CLEAR_APP_CACHE",
            "CALL_PHONE",
            "WRITE_SMS",
            "MANAGE_USB",
            "EXPAND_STATUS_BAR",
            "SET_ALWAYS_FINISH",
            "SET_PROCESS_LIMIT",
            "PERSISTENT_ACTIVITY",
            "USE_SIP",
            "ACCESS_MOCK_LOCATION",
            "SET_ANIMATION_SCALE",
            "MODIFY_PHONE_STATE",
            "WRITE_CONTACTS",
            "WRITE_PROFILE",
            "READ_CALL_LOG",
            "READ_CELL_BROADCASTS",
            "READ_SYNC_SETTINGS",
            "READ_USER_DICTIONARY",
            "READ_PROFILE",
            "READ_SMS",
            "RECEIVE_MMS",
            "RECEIVE_SMS",
            "RECEIVE_WAP_PUSH",
            "PROCESS_OUTGOING_CALLS",
            "SIGNAL_PERSISTENT_PROCESSES",
            "SEND_SMS",
            "SET_PREFERRED_APPLICATIONS",
            "SET_TIME_ZONE",
            "WRITE_SYNC_SETTINGS",
            "WRITE_CALL_LOG"
        )
        val packageManager = context.packageManager
        try {
            val packageInfo = packageManager.getPackageInfo(packageName!!, PackageManager.GET_PERMISSIONS)
            val requestedPermissions = packageInfo.requestedPermissions
            if (requestedPermissions != null) {
                for (permission in requestedPermissions) {
                    if (permissionSet.contains(permission)) {
                        permissionsList.add(permission)
                    }
                }
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return permissionsList
    }

    @Throws(IOException::class)
    fun getPrivacyPolicyUrl(packageName: String?): String? {
        var url: String? = null
        try {
            url = "https://play.google.com/store/apps/details?id=$packageName&hl=en"
            val doc = Jsoup.connect(url).get()
            val link = doc.select("a.hrTbp.R8zArc")
            url = link.attr("href")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return url
    }

    override fun onAppSelected(view: View?, position: Int) {
        val app = apps[position]
        val pm = packageManager
        val category = getCategory(pm, app.packageName)
        println("Category: $category")
        val permissions = getPermissionsByPackageName(app.packageName)
        println("Permissions: $permissions")
        val permissionResult = processPermissions(permissions, category)
        val safePermissions = permissionResult["safePermissions"]!!
        val unsafePermissions = permissionResult["unsafePermissions"]!!

        val i = Intent(this@MainActivity, ViewPermissions::class.java)
        val bmp = DrawableToBitmap.drawableToBitmap(app.appIcon)
        if (bmp != null) {
            val stream = ByteArrayOutputStream()
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream)
            val byteArray = stream.toByteArray()
            i.putExtra("icon", byteArray)
        }

        i.putExtra("name", app.appName)
        i.putExtra("package", app.packageName)
        i.putStringArrayListExtra("safePermissions", ArrayList(safePermissions))
        i.putStringArrayListExtra("unsafePermissions", ArrayList(unsafePermissions))
        i.putExtra("rating", "safe")
        startActivity(i)
    }


    private fun updateAppListInstalledApps() {
        val appList: MutableList<AppInfo> = ArrayList()
        val pm = packageManager
        val packages = pm.getInstalledPackages(PackageManager.GET_PERMISSIONS)
        for (packageInfo in packages) {
            if (packageInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM == 1) {
                // Skip system apps
                continue
            }
            val name = packageInfo.applicationInfo.loadLabel(pm).toString()
            val packageName = packageInfo.packageName
            val category = getCategory(pm, packageName)
            println("Appname: $name Category : $category")
            val permissions: MutableList<String> = ArrayList()
            if (packageInfo.requestedPermissions != null) {
                for (permission in packageInfo.requestedPermissions) {
                    if (pm.checkPermission(
                            permission,
                            packageName
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        permissions.add(permission)
                    }
                }
            }
            appList.add(AppInfo(name, packageName, category, permissions))
        }

        // Export permissions and category to Excel file
        try {
            val exporter = ExcelExporter()
            exporter.exportToExcel(context, appList, "installedAppsCategory.xls")
            Toast.makeText(
                context,
                "Permissions and category exported successfully",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(
                context,
                "Error exporting app permissions and category",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun getCategory(pm: PackageManager, packageName: String?): String {
        try {
            val info = pm.getApplicationInfo(packageName!!, 0)
            //            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                if (info.category != AppInfo.CATEGORY_UNDEFINED) {
//                    return String.valueOf(info.category);
//                }
//            }

            // Use Google Play Store API to fetch category
            val url = "https://play.google.com/store/apps/details?id=$packageName"
            //   System.out.println("URL : "+url);
            return GetCategoryTask().execute(url).get()!!
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return "Unknown"
    }

    inner class GetCategoryTask : AsyncTask<String?, Void?, String>() {
        override fun doInBackground(vararg params: String?): String? {
            val packageName = params[0]
            var category: String? = null
            try {
                category = getPrivacyPolicyUrl(packageName)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return category
        }
    }

    private fun processPermissions(
        permissionsList: List<String>,
        category: String
    ): Map<String, List<String>> {
        val safePermissions: MutableList<String> = ArrayList()
        val unsafePermissions: MutableList<String> = ArrayList()
        for (permission in permissionsList) {
            val isSafe = PermissionSafetyChecker.isPermissionSafe(category, permission)
            if (isSafe) {
                safePermissions.add(permission)
            } else {
                unsafePermissions.add(permission)
            }
        }
        val result: MutableMap<String, List<String>> = HashMap()
        result["safePermissions"] = safePermissions
        result["unsafePermissions"] = unsafePermissions
        val inflater = LayoutInflater.from(this)
        val parentView = findViewById<ViewGroup>(android.R.id.content)
        val rootView = inflater.inflate(R.layout.activity_view_permissions, parentView, false)
        return result
    }
}
