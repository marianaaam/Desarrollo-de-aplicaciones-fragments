package com.example.tienda_virtual.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tienda_virtual.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var drawerLayout: androidx.drawerlayout.widget.DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Configuración de la barra de herramientas*/
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        /*Navegación de los fragments*/
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment)

        navController = navHostFragment?.findNavController()!!


        drawerLayout = findViewById(R.id.drawer_layout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        drawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open,
            R.string.close
        )

        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.inicioFragment,
                R.id.productosFragment,
                R.id.categoriasFragment,
                R.id.carritoFragment,
                R.id.perfilFragment
        ),
            drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, _, _ ->
            supportActionBar?.title = ""
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}