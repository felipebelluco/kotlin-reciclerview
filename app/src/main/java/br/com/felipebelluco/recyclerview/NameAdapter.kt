package br.com.felipebelluco.recyclerview

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.card_name.view.*

class NameAdapter(val mainView: MainView, val values: MutableList<String>) :
        RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    /**
     * Infla o layout do card e passa para o [NameViewHolder].
     *
     * @param parent o [ViewGroup] pai onde a view será adicionada após ser preenchida
     * @param viewType tipo da view
     * @return [NameViewHolder] ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        /* Infla a view */
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_name, parent, false);

        /* Cria a viewHolder passando a view inflada */
        return NameViewHolder(view)
    }

    /**
     * Preenche a view com os dados de [values] na [position] atual.
     *
     * @param holder viewHolder
     * @param position posição do adapter
     */
    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        /* Recupera o dado na posição atual do adapter */
        val value = values.get(position)

        /* Delega a tarefa de preencher a view */
        holder.bind(value)
    }

    /**
     * @return a quantidade de itens da lista de dados
     */
    override fun getItemCount(): Int = this.values.size

    /**
     * @param names
     */
    fun setValues(values: List<String>) {
        /* Limpar os dados atuais */
        this.values.clear()

        /* Adiciona os novos */
        this.values.addAll(values)

        /* Notifica ao RecyclerView que os dados foram alterados */
        this.notifyDataSetChanged()
    }

    inner class NameViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val container: CardView = view.card_view
        val nameLabel: TextView = view.name

        /* Preenche a view com o dado recuperado */
        fun bind(value: String) {
            /* Preenche o label de nome */
            nameLabel.text = value

            /* Implementa o listener de click no container do item (card) */
            container.setOnClickListener { v -> mainView.onItemSelected(value) }
        }

    }

}