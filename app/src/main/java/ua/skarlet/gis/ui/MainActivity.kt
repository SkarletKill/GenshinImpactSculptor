package ua.skarlet.gis.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.skarlet.gis.R
import ua.skarlet.gis.util.logger.log

class MainActivity : AppCompatActivity() {

    val navController: NavController?
        get() = try {
            Navigation.findNavController(this, R.id.fragment_container)
        } catch (e: IllegalStateException) {
            log(e)
            null
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}