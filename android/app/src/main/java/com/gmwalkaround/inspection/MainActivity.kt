package com.gmwalkaround.inspection

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.gmwalkaround.inspection.services.SyncWorker
import com.gmwalkaround.inspection.ui.InspectionActivity
import com.gmwalkaround.inspection.ui.DashboardActivity
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val syncRequest = PeriodicWorkRequestBuilder<SyncWorker>(
            15, TimeUnit.MINUTES
        ).build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "inspection_sync",
            androidx.work.ExistingPeriodicWorkPolicy.KEEP,
            syncRequest
        )

        findViewById<Button>(R.id.newInspectionButton).setOnClickListener {
            startActivity(Intent(this, InspectionActivity::class.java))
        }

        findViewById<Button>(R.id.dashboardButton).setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }
}
