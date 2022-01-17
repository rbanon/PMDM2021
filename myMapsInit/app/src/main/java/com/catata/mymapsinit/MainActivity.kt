package com.catata.mymapsinit

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.catata.mymapsinit.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

import android.text.style.TextAppearanceSpan

import android.text.SpannableString




class MainActivity : AppCompatActivity(), OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        val mainOptions = listOf(R.id.option1, R.id.option4)
        val menu = navView.menu
        val secOptions = listOf(R.id.option2, R.id.option3, R.id.option5, R.id.option6)
        /*for(option in mainOptions){
            val tools = menu.findItem(option)

            tools.icon.setTint(getColor(R.color.black))

            val s = SpannableString(tools.title)
            s.setSpan(TextAppearanceSpan(this, R.style.MainOptionStyle), 0, s.length, 0)
            tools.title = s
        }

        for(option in secOptions){
            val tools = menu.findItem(option)

            tools.icon.setTint(getColor(R.color.black))

            val s = SpannableString(tools.title)
            s.setSpan(TextAppearanceSpan(this, R.style.SecondaryOptionStyle), 0, s.length, 0)
            tools.title = s
        }*/


        val mActionBarDrawerToggle = ActionBarDrawerToggle(this,
            drawerLayout, binding.appBarMain.toolbar, R.string.drawer_opened, R.string.drawer_closed )
        mActionBarDrawerToggle.syncState()



        navView.setNavigationItemSelectedListener(this)

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "${item.itemId}", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onMapReady(gmap: GoogleMap) {
        mMap = gmap
    }
}