package com.example.permissionclassifier

import android.content.Context
import android.widget.Toast
import jxl.Workbook
import jxl.write.Label
import jxl.write.WriteException
import java.io.File
import java.io.IOException

class ExcelExporter {
    fun exportToExcel(context: Context?, appList: List<AppInfo>, fileName: String?) {
        try {
            val file = File(context!!.getExternalFilesDir(null), fileName)
            if (!file.exists()) {
                file.createNewFile()
            }
            val workbook = Workbook.createWorkbook(file)
            val sheet = workbook.createSheet("Permissions", 0)

            // Add headers to sheet
            for (i in HEADERS.indices) {
                sheet.addCell(Label(i, 0, HEADERS[i]))
            }

            // Add data to sheet
            var row = 1
            for (appInfo in appList) {
                sheet.addCell(Label(0, row, appInfo.name))
                sheet.addCell(Label(1, row, appInfo.packageName))
                sheet.addCell(Label(2, row, appInfo.category))
                val permissions = appInfo.permissions
                val permissionString = StringBuilder()
                for (permission in permissions!!) {
                    permissionString.append(permission).append("\n")
                }
                sheet.addCell(Label(3, row, permissionString.toString()))
                row++
            }
            workbook.write()
            workbook.close()
            Toast.makeText(
                context,
                "Permissions and category exported to Excel file",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: IOException) {
            Toast.makeText(
                context,
                "Error exporting app permissions and category",
                Toast.LENGTH_SHORT
            ).show()
            e.printStackTrace()
        } catch (e: WriteException) {
            Toast.makeText(
                context,
                "Error exporting app permissions and category",
                Toast.LENGTH_SHORT
            ).show()
            e.printStackTrace()
        }
    }

    companion object {
        private const val TAG = "ExcelExporter"
        private val HEADERS = arrayOf("App Name", "Package Name", "Category", "Permissions")
    }
}