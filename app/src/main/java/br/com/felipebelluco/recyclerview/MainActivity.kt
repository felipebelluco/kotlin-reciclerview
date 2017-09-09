package br.com.felipebelluco.recyclerview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val context: Context = this

    private val presenter: MainPresenter = MainPresenter(this, NameService())

    private val DEFAULT_SPAN_COUNT = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            Inicializa o gerenciador de layout. Deixe apenas um das 3 linhas seguintes descomentada e veja o que cada
            gerenciador faz.
        */
        nameList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        nameList.layoutManager = GridLayoutManager(context, DEFAULT_SPAN_COUNT)
//        nameList.layoutManager = StaggeredGridLayoutManager(DEFAULT_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)

        /* Inicializa o adapter passando uma lista editável vazia */
        nameList.adapter = NameAdapter(this, mutableListOf())

        /* Busca os nomes */
        presenter.getNames()
    }

    override fun onShowLoading() = Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()

    override fun onHideLoading() = Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show()

    override fun onSuccessLoading(names: List<String>) {
        /* Faz o cast do adaptador do recyclerView para NameAdapter e altera o conteúdo pelos valores retornados */
        (nameList.adapter as NameAdapter).setValues(names)
    }

    override fun onItemSelected(item: String) = Toast.makeText(this, item, Toast.LENGTH_LONG).show()

}
