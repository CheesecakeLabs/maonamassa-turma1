package com.example.gracietti.maonamassa.utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gracietti.maonamassa.R
import com.example.gracietti.maonamassa.modelos.Turma
import kotlinx.android.synthetic.main.item_turma.view.*

/**
 * Created by gracietti on 04/11/17.
 */

//Logica para processar os dados e chamar o ViewHolder
class TurmaAdapter(var lista: List<Turma>, var listener: TurmaClickListener): RecyclerView.Adapter<TurmaViewHolder>() {

    override fun getItemCount(): Int {
         return lista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TurmaViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_turma, parent, false)
        return TurmaViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: TurmaViewHolder?, position: Int) {
        val turma = lista[position]
        holder?.turma = turma
    }
}

//Faz o match de cada atributo com as variaveis do XML
class TurmaViewHolder(itemView: View, var listener: TurmaClickListener): RecyclerView.ViewHolder(itemView) {

    var turma: Turma? = null
        set(turma) {
            field = turma
            turma ?: return

            itemView.nomeTextView.text = turma.nome
            itemView.localTextView.text = turma.local
            itemView.totalTextView.text = turma.total.toString()

            Picasso.with(itemView.context).load(turma.fotoUrl).into(itemView.turmaImageView)

            itemView.setOnClickListener {
                listener.onTurmaClicked(turma)
            }
        }
}

interface TurmaClickListener {
    fun onTurmaClicked(turma: Turma)
}