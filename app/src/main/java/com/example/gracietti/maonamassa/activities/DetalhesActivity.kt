package com.example.gracietti.maonamassa.activities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.gracietti.maonamassa.R
import com.example.gracietti.maonamassa.modelos.Turma
import com.example.gracietti.maonamassa.utils.TurmaAdapter
import kotlinx.android.synthetic.main.activity_lista.*

class DetalhesActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
    }

}
