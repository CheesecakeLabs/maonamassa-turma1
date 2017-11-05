package com.example.gracietti.maonamassa.activities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.gracietti.maonamassa.R
import com.example.gracietti.maonamassa.modelos.Turma
import com.example.gracietti.maonamassa.utils.TurmaAdapter
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        setupRecyclerView()
        popularRecyclerView()
    }

    fun setupRecyclerView() {
        turmaRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun popularRecyclerView() {
        val listaDeTurma: MutableList<Turma> = mutableListOf()

        val turma1 = Turma()
        turma1.local = "CELTA"
        turma1.nome = "Turma Android"
        turma1.total = 16

        val turma2 = Turma()
        turma2.local = "CELTA"
        turma2.nome = "Turma Servidor"
        turma2.total = 12

        listaDeTurma.add(turma1)
        listaDeTurma.add(turma2)

        turmaRecyclerView.adapter = TurmaAdapter(listaDeTurma)
    }
}
