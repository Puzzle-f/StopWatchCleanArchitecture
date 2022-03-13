//package com.example.stopwatchcleanarchitecture
//
//import com.example.stopwatchcleanarchitecture.state.StopwatchStateHolder
//import com.example.stopwatchcleanarchitecture.viewmodel.StopwatchViewModel
//import junit.framework.Assert.assertEquals
//import kotlinx.coroutines.CoroutineScope
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.MockitoAnnotations
//
//class TestViewModel {
//
//    private lateinit var stopwatchViewModel: StopwatchViewModel
//
//    @Mock
//    private lateinit var stopwatchStateHolder: StopwatchStateHolder
//
//    @Mock
//    private lateinit var scope: CoroutineScope
//
//    @Before
//    fun setUp(){
//        MockitoAnnotations.initMocks(this)
//        stopwatchViewModel = StopwatchViewModel(stopwatchStateHolder, scope)
//    }
//
//    @Test
//    fun testStart(){
//        stopwatchViewModel.start()
//        Mockito.verify(stopwatchViewModel, Mockito.times(1)).start()
//        assertEquals(10, 10)
//    }
//
//
//}