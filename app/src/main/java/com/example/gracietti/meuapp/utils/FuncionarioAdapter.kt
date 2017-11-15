package com.example.gracietti.meuapp.utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gracietti.meuapp.R
import com.example.gracietti.meuapp.modelos.Funcionario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_funcionario.view.*

class FuncionarioAdapter(var lista: List<Funcionario>, var listener: FuncionarioClickListener): RecyclerView.Adapter<FuncionarioViewHolder>() {

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FuncionarioViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_funcionario, parent, false)
        return FuncionarioViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: FuncionarioViewHolder?, position: Int) {
        val funcionario = lista[position]
        holder?.funcionario = funcionario
    }
}

class FuncionarioViewHolder(itemView: View, var listener: FuncionarioClickListener): RecyclerView.ViewHolder(itemView) {

    var funcionario: Funcionario? = null
        set(funcionario) {
            field = funcionario
            funcionario ?: return

            itemView.nameTextView.text = funcionario.nome
            itemView.idadeTextView.text = funcionario.idade.toString()
            itemView.cidadeTextView.text = funcionario.cidade

            Picasso.with(itemView.context).load(funcionario.fotoUrl).into(itemView.avatarImageView)

            itemView.setOnClickListener {
                listener.onFuncionarioClicked(funcionario)
            }

        }
}

interface FuncionarioClickListener {
    fun onFuncionarioClicked(funcionario: Funcionario) {
    }
}