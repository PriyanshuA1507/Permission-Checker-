package com.example.permissionclassifier

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.permissionclassifier.ml.DecisionTree
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.IOException
import java.nio.ByteBuffer

class MLAnalysisActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.csvfileefficiency)

        textView = findViewById(R.id.textview)
        button = findViewById(R.id.button)

        button?.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "text/csv"
            startActivityForResult(
                Intent.createChooser(intent, "Select CSV file"),
                PICK_CSV_FILE_REQUEST
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_CSV_FILE_REQUEST && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                val filePath = uri.path
                filePath?.let { predictEfficiency(it) }
            }
        }
    }

    private fun predictEfficiency(filePath: String) {
        // Load the TFLite model
        val model = try {
            DecisionTree.newInstance(applicationContext)
        } catch (e: IOException) {
            e.printStackTrace()
            return
        }

        // Allocate a ByteBuffer for the input data
        val capacity = 4 * 2
        val byteBuffer = ByteBuffer.allocateDirect(capacity)
        // Fill the byteBuffer with some data here if needed

        // Create and load input tensor buffer
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 2), DataType.FLOAT32)
        inputFeature0.loadBuffer(byteBuffer)

        // Run model inference and get output tensor buffer
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        // Display the result
        val ans = outputFeature0.getFloatValue(0)
        textView?.text = ans.toString()
    }

    companion object {
        private const val PICK_CSV_FILE_REQUEST = 1
    }
}
