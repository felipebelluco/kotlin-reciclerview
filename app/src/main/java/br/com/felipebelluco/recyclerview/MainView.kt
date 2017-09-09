package br.com.felipebelluco.recyclerview

interface MainView {

    fun onShowLoading()

    fun onHideLoading()

    fun onSuccessLoading(names: List<String>)

    fun onItemSelected(item: String)

}