package com.example.stopwatchcleanarchitecture

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.stopwatchcleanarchitecture.calculation.ElapsedTimeCalculator
import com.example.stopwatchcleanarchitecture.calculation.timestampProvider
import com.example.stopwatchcleanarchitecture.formatter.TimestampMillisecondsFormatter
import com.example.stopwatchcleanarchitecture.state.StopwatchStateCalculator
import com.example.stopwatchcleanarchitecture.state.StopwatchStateHolder
import com.example.stopwatchcleanarchitecture.viewmodel.StopwatchViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var stopwatchViewModel: StopwatchViewModel

    private fun iniViewModel() {
        val viewModel: StopwatchViewModel by viewModel()
        stopwatchViewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniViewModel()
        val textView = findViewById<TextView>(R.id.text_time)
        CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob()
        ).launch {
            stopwatchViewModel
                .ticker
                .collect { data ->
                    textView.text = data
                }
        }

        findViewById<Button>(R.id.button_start).setOnClickListener {
            stopwatchViewModel.start()
        }
        findViewById<Button>(R.id.button_pause).setOnClickListener {
            stopwatchViewModel.pause()
        }
        findViewById<Button>(R.id.button_stop).setOnClickListener {
            stopwatchViewModel.stop()
        }

    }
}

