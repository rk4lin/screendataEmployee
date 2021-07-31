package com.example.viewspecialties

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

class AppSpecialty : Application(), LifecycleObserver {

    private var isFirstStart = true

    private val classLogTag = "[${this.javaClass.simpleName}]"

    init{
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onProcessStopped() {
        Log.d(classLogTag,"Приложение свернуто в фон или остановлено")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onProcessStarted() {
        if (isFirstStart) {
            Log.d(classLogTag,"Приложение запущено", )
             isFirstStart = false
        } else {
            Log.d(classLogTag,"Приложение развернуто из фона")
        }
    }


    private val presenterStore: HashMap<String, HashMap<String, BasePresenter<*>>> = HashMap()

    init {
        instance = this
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : BasePresenter<*>> savePresenter(
        storeKey: String,
        presenterKey: String,
        presenterClass: Class<T>
    ): T {
        val presenters = getPresenters(storeKey)

        val presenter = presenters[presenterKey]
        if (presenter != null) {
            return presenter as T
        }

        try {
            val newPresenter = presenterClass.newInstance()
            presenters[presenterKey] = newPresenter
            presenterStore[storeKey] = presenters
            return newPresenter
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
            throw IllegalStateException()
        } catch (e: InstantiationException) {
            e.printStackTrace()
            throw IllegalStateException()
        }

    }


    fun <T : BasePresenter<*>> getPresenter(

        storeKey: String,
        presenter: Class<T>
    ): T {

        val presenterKey = presenter.simpleName
        return savePresenter(storeKey, presenterKey, presenter)
    }


    fun clear(store: String) {
        presenterStore.remove(store)
    }

    fun getPresenters(storeKey: String): HashMap<String, BasePresenter<*>> {

        var presenters = presenterStore[storeKey]
        if (presenters == null) {
            presenters = HashMap()
        }
        return presenters
    }



    companion object{
        private var instance : AppSpecialty? = null

       fun baseContext(): Context {
            return instance!!.baseContext
        }

        fun getContext() : Context {
            return instance!!.applicationContext
        }
    }

}