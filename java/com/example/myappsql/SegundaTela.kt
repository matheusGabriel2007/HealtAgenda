package com.example.myappsql


import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.ImageView
import android.widget.Button
import com.example.myappsql.R
import com.example.myappsql.TerceiraTela
import java.util.Calendar

class SegundaTela : AppCompatActivity() {

    private lateinit var txtSelecionarData: TextView
    private lateinit var btnVoltar: ImageView
    private lateinit var btnConfirmar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        txtSelecionarData = findViewById(R.id.txtSelecionarData)
        btnVoltar = findViewById(R.id.btnVoltar)
        btnConfirmar = findViewById(R.id.btnConfirmar)

        txtSelecionarData.setOnClickListener {
            abrirCalendario()
        }

        btnVoltar.setOnClickListener {
            finish()
        }

        btnConfirmar.setOnClickListener {
            val intent = Intent(this, TerceiraTela::class.java)
            startActivity(intent)
        }
    }

    private fun abrirCalendario() {
        val calendario = Calendar.getInstance()
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            { _, anoSelecionado, mesSelecionado, diaSelecionado ->
                val dataFormatada = "$diaSelecionado ${mesPorExtenso(mesSelecionado)}, $anoSelecionado"
                txtSelecionarData.text = dataFormatada
            },
            ano, mes, dia
        )

        datePickerDialog.show()
    }

    private fun mesPorExtenso(mes: Int): String {
        val nomes = listOf(
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        )
        return nomes[mes]
    }
}
