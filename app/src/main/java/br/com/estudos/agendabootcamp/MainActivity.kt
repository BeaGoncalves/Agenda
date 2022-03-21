package br.com.estudos.agendabootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.*
import android.provider.CalendarContract.Events.*
import android.provider.ContactsContract.CommonDataKinds.Organization.TITLE
import br.com.estudos.agendabootcamp.databinding.ActivityMainBinding
import android.provider.CalendarContract.Events.CONTENT_URI as CONTENT_URI


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSetEventMain.setOnClickListener {
            val intent = Intent(Intent.ACTION_INSERT).setData(CONTENT_URI)
                .putExtra(TITLE, "Bootcamp Kotlin")
                .putExtra(EVENT_LOCATION, "OnLine")
                .putExtra(EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis())
                .putExtra(EXTRA_EVENT_END_TIME, System.currentTimeMillis() + (60*60*1000))

            startActivity(intent)
        }
    }
}