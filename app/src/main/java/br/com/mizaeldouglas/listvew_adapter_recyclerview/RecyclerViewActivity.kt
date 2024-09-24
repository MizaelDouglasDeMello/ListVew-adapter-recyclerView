package br.com.mizaeldouglas.listvew_adapter_recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var rvList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lista = listOf(
            Mensagem("Mizael", "Olá Tudo Bem?", "10:00"),
            Mensagem("Carol", "Oi, tudo bem e você?", "10:01"),
            Mensagem("Jaque", "Tudo ótimo", "11:02"),
            Mensagem("Tiago", "Não sei", "15:03"),
            Mensagem("Sophia", "HAHAHA!", "22:44"),
            Mensagem("Helena", "Ok", "10:05"),
            Mensagem("Elisa", "Digitando..", "10:00")
        )

        rvList = findViewById(R.id.rvLista)

//        rvList.adapter = MensagemAdapter(lista)
        rvList.adapter = MensagemAdapter(lista){ name ->

            Toast.makeText(this, "Olá ${name}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,ListViewActivity::class.java)
            intent.putExtra("nome", name)

            startActivity(
                intent
            )
        }

        rvList.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )




//        rvList.addItemDecoration(
//            DividerItemDecoration(this,RecyclerView.VERTICAL)
//        )


//        rvList.layoutManager = GridLayoutManager(
//            this,
//            2,
//            RecyclerView.VERTICAL,
//            false
//        )

//        rvList.layoutManager = StaggeredGridLayoutManager(
//            2,
//            RecyclerView.VERTICAL
//        )


    }
}