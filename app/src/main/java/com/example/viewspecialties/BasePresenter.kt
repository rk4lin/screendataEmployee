package com.example.viewspecialties

abstract class BasePresenter<V: IBaseView> {

    protected var view: V? = null

    open fun onAttach(view: V) {
        this.view = view
    }

    open fun onDetach() {
        this.view = null
    }
    open fun onDestroy() {
    }

}