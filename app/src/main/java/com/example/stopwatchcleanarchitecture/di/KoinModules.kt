package com.example.stopwatchcleanarchitecture.di

import com.example.stopwatchcleanarchitecture.calculation.ElapsedTimeCalculator
import com.example.stopwatchcleanarchitecture.calculation.TimestampProvider
import com.example.stopwatchcleanarchitecture.calculation.timestampProvider
import com.example.stopwatchcleanarchitecture.formatter.TimestampMillisecondsFormatter
import com.example.stopwatchcleanarchitecture.state.StopwatchStateCalculator
import com.example.stopwatchcleanarchitecture.state.StopwatchStateHolder
import com.example.stopwatchcleanarchitecture.viewmodel.StopwatchViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myViewModel = module {

        factory {
            StopwatchViewModel(
                stopwatchStateHolder = get(),
                scope = get()
            )
        }


    single<TimestampProvider>{
        timestampProvider
    }

    single {
        StopwatchStateHolder(stopwatchStateCalculator = get(),
                            elapsedTimeCalculator = get(),
                            timestampMillisecondsFormatter = get())
    }

    single {
        StopwatchStateCalculator(timestampProvider = get(),
                                 elapsedTimeCalculator = get()
        )
    }

    single {
        ElapsedTimeCalculator(timestampProvider = get())
    }

    single {
        TimestampMillisecondsFormatter()
    }

    single <CoroutineScope> {
        CoroutineScope(
            Dispatchers.Main
        + SupervisorJob()
        )
    }
}
