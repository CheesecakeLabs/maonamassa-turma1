package com.example.gracietti.meuapp.modulos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.gracietti.meuapp.R
import com.example.gracietti.meuapp.modelos.Funcionario
import com.example.gracietti.meuapp.utils.FuncionarioAdapter
import com.example.gracietti.meuapp.utils.FuncionarioClickListener
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity: AppCompatActivity(), FuncionarioClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        setupRecyclerView()
        popularRecyclerView()
    }

    override fun onFuncionarioClicked(funcionario: Funcionario) {
        super.onFuncionarioClicked(funcionario)
        val proximaTela = Intent(this, DetalhesActivity::class.java)
        startActivity(proximaTela)
    }

    fun setupRecyclerView() {
        funcionarioRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun popularRecyclerView() {
        var listaDeFuncionarios: MutableList<Funcionario> = mutableListOf()

        val funcionario1 = Funcionario()
        funcionario1.nome = "Marcelo"
        funcionario1.cidade = "Bologna"
        funcionario1.idade = 27
        funcionario1.fotoUrl = "https://d1zx4fn8ox8446.cloudfront.net/filemanager.rboxfile/651fa4102edb423caa08186b46776436/Logos_Vertical.png"


        listaDeFuncionarios.add(funcionario1)

        funcionarioRecyclerView.adapter = FuncionarioAdapter(listaDeFuncionarios, this)

    }
}
