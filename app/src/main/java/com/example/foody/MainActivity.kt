package com.example.foody

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.navigation.fragment.NavHostFragment

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //make navController accessible inside onSupportNavigateUp method
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //target the navigation layout
        //val navController = findNavController(R.id.navHostFragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // so it doesnt crash the app with java illegal something
        //https://stackoverflow.com/questions/50502269/illegalstateexception-link-does-not-have-a-navcontroller-set
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        // create destination links to each layout fragments  in our bottom navigation
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.recipesFragment,R.id.favoriteRecipesFragment,R.id.foodJokeFragment))

        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfiguration)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}