package com.example.viewspecialties

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.HashMap

abstract class BaseFragment : androidx.fragment.app.Fragment() {

    private var application: AppSpecialty? = null

    private val classLogTag = "[${this.javaClass.simpleName}]"


    private val presenters: HashMap<String, BasePresenter<*>>
        get() = application!!.getPresenters(storeKey)

    private val storeKey: String
        get() = requireActivity().javaClass.simpleName + this.javaClass.simpleName


    override fun onAttach(context: Context) {
        Log.d(classLogTag, "onAttach: context=$context")
        super.onAttach(context)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(classLogTag, "onCreate: savedInstanceState=$savedInstanceState")
        super.onCreate(savedInstanceState)

        if (this !is IBaseView) {
            throw IllegalStateException()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(classLogTag, "onCreateView: savedInstanceState=$savedInstanceState")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(classLogTag, "onActivityCreated: savedInstanceState=$savedInstanceState")
        super.onActivityCreated(savedInstanceState)

        application = requireActivity().application as AppSpecialty
    }

    override fun onStart() {
        Log.d(classLogTag, "onStart: ")
        super.onStart()
    }

    @Suppress("UNCHECKED_CAST")
    override fun onResume() {
        Log.d(classLogTag, "onResume: ")
        super.onResume()
        for (baseMvpPresenter in presenters.values) {
            val view = this as IBaseView
            (baseMvpPresenter as BasePresenter<IBaseView>).onAttach(view)
        }
    }

    override fun onPause() {
        Log.d(classLogTag, "onPause: ")
        super.onPause()
    }

    override fun onStop() {
        Log.d(classLogTag, "onStop: ")
        for (baseMvpPresenter in presenters.values) {
            baseMvpPresenter.onDetach()
        }
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(classLogTag, "onDestroyView: ")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(classLogTag, "onDestroy: ")

        for (baseMvpPresenter in presenters.values) {
            baseMvpPresenter.onDestroy()
        }
        application!!.clear(storeKey)

        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(classLogTag, "onDetach: ")
        super.onDetach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(classLogTag, "onSaveInstanceState: outState=$outState")
        super.onSaveInstanceState(outState)
    }

    protected fun <T : BasePresenter<*>> getPresenter(presenter: Class<T>) : T {
        return application!!.getPresenter(storeKey, presenter)
    }
}