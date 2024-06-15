package com.example.permissionclassifier

class AppInfo(
    val name: String,
    val packageName: String,
    val category: String,
    val permissions: List<String>
) {

    companion object {
        const val CATEGORY_UNDEFINED = -1
    }
}