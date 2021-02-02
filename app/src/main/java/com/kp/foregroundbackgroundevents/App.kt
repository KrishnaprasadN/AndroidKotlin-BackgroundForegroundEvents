package com.kp.foregroundbackgroundevents

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

class App : Application(), LifecycleObserver {

  override fun onCreate() {
    super.onCreate()
    Log.i("process", "onCreate first")
    ProcessLifecycleOwner.get().lifecycle.addObserver(this)
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  fun onAppCreate() {
    Log.i("process", "onCreate")
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  fun onAppStart() {
    Log.i("process", "onStart")
    Toast.makeText(this, "Foreground Event", Toast.LENGTH_SHORT).show()
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  fun onAppStop() {
    Log.i("process", "onStop")
    Toast.makeText(this, "Background Event", Toast.LENGTH_SHORT).show()
  }


  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  fun onAppResume() {
    Log.i("process", "onResume")
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  fun onAppPause() {
    Log.i("process", "onPause")
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  fun onAppDestroy() {
    Log.i("process", "onDestroy")
  }

  override fun onTerminate() {
    super.onTerminate()
    Log.i("process", "onTerminate")
  }
}