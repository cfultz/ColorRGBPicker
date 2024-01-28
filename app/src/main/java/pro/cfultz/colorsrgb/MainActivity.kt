package pro.cfultz.colorsrgb

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Made the button nicer to call
        val createButton = findViewById<Button>(R.id.button)

        createButton?.setOnClickListener {
            // Set the values that we want to call
            val redChannel = findViewById<TextInputEditText>(R.id.red_channel_text)?.text.toString().trim()
            val greenChannel = findViewById<TextInputEditText>(R.id.green_channel_text)?.text.toString().trim()
            val blueChannel = findViewById<TextInputEditText>(R.id.blue_channel_text)?.text.toString().trim()
            val resultArea = findViewById<TextView>(R.id.results_area)

            // if/else statement to make sure user inputs something
            if (redChannel.isNotEmpty() && greenChannel.isNotEmpty() && blueChannel.isNotEmpty()) {
                // Set the values that we want to call
                val colorResult = redChannel.plus(greenChannel).plus(blueChannel)
                val colorAsInt = Color.parseColor("#".plus(colorResult))

                // Show the results from user input
                resultArea?.text = "${getString(R.string.pound_sign)}${colorResult}"
                resultArea?.setBackgroundColor(colorAsInt)

            }
            // Toast to tell the user to input something if they did not
            else {
                Toast.makeText(this, getString(R.string.no_input),Toast.LENGTH_LONG).apply { setGravity(
                    Gravity.CENTER,0,0)
                    show() }

                }
            }
        }
    }