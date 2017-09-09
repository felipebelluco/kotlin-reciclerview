package br.com.felipebelluco.recyclerview

class MainPresenter(val view: MainView, val service: NameService) {

    fun getNames() {
        view.onShowLoading()

        val names = service.getNames()
        if(names.isNotEmpty())
            view.onSuccessLoading(names)

        view.onHideLoading()
    }

}