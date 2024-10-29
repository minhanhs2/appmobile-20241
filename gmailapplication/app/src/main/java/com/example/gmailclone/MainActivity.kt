package com.example.gmailclone
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sample data
        val emailList = listOf(
            Email("Edurila.com", "$19 Only (First 10 spots) - Bestselling... \nAre you looking to Learn Web Designin...", "12:34 PM", true),
            Email("Chris Abad", "Help make Campaign Monitor better! \nLet us know your thoughs! No images...", "11:22 AM", true),
            Email("Tuto.com", "8h de formation gratuite et les nouvea... \nPhotoshop, SEO, Blender, CSS, WordPre...", "11:04 AM", true),
            Email("support", "Société Ovh: suivi de vos services - hp... \nSAS OVH - http://www.ovh.com 2 rue K...", "10:26 AM", true),
            Email("Matt from Ionic", "The New Ionic Creator Is Here! \nAnnouncing yhr all-new Creator, build...", "5:22 AM", true)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(emailList)


        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.divider_color)))
        recyclerView.addItemDecoration(divider)
    }
}
