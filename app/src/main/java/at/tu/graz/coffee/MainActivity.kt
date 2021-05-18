package at.tu.graz.coffee

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import at.tu.graz.coffee.controller.AppDatabase
import com.google.android.material.navigation.NavigationView
import java.util.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var localeToBeUsed: Locale
    private var currentLanguage: String? = null
    private lateinit var database:AppDatabase

    fun getDatabase(): AppDatabase{
        return this.database
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "coffee-data"
        ).build()
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_addCoffee, R.id.nav_filter, R.id.nav_support), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    fun changeToSettings(item: MenuItem) {
        //TODO: Validation Check if fragment is opened correctly
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.nav_settings)
    }

    fun onClickApplyButton(view: View) {
        val b1 : RadioButton = findViewById<RadioButton>(R.id.language_first_radio)
        val b2 : RadioButton = findViewById<RadioButton>(R.id.language_second_radio)
        var languageSelector : String = "en"
        if (b1.isChecked)
        {
            changeLanguage(languageSelector)
        }
        if (b2.isChecked)
        {
            languageSelector = "ru"
            changeLanguage(languageSelector)
        }
    }
    public fun changeLanguage(languageToSet: String) {

        val usedResource = resources
        val configurationToSet = usedResource.configuration
        val displayMetricsToSet = usedResource.displayMetrics

        localeToBeUsed = Locale(languageToSet)

        configurationToSet.locale = localeToBeUsed
        usedResource.updateConfiguration(configurationToSet, displayMetricsToSet)
        val currentUpdater = Intent(this, MainActivity::class.java)
        currentUpdater.putExtra(currentLanguage, languageToSet)
        startActivity(currentUpdater)
    }
}

