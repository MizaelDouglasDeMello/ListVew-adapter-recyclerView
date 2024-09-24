package br.com.mizaeldouglas.listvew_adapter_recyclerview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewActivity : AppCompatActivity() {

    private lateinit var listViewUsuario: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_veiw)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra("nome")
        val listaDeUsuarios = listOf(
            "Mizael", "Carol", "Jaque", "Tiago", "Sophia", "Helena", "Elisa"
        )

        listViewUsuario =  findViewById(R.id.listUsuario)
        listViewUsuario.adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,android.R.id.text1,listaDeUsuarios
        )

    }
}