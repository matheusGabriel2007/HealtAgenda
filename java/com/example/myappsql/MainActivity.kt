import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myappsql.R
import com.example.myappsql.SegundaTela

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Acessando o botão corretamente
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)

        // Configurando o evento de clique
        btnEntrar.setOnClickListener {
            val segundaTela = Intent(this, SegundaTela::class.java)
            startActivity(segundaTela)
        }
    }
}
