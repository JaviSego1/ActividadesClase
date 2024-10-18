package com.example.actividadesclase.views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividadesclase.R
import com.example.actividadesclase.logic.Client
import com.example.actividadesclase.logic.Controller

class MainActivity : AppCompatActivity() {

    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonDel: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myDialog: Dialog
    private val controller = Controller()

    companion object {
        const val TAG = "---SALIDA---"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Esto es un ejemplo de log")
        start()
    }

    private fun start() {
        myButtonAdd = findViewById(R.id.iv_añadir)
        myButtonDel = findViewById(R.id.iv_delete)
        myButtonUpdate = findViewById(R.id.iv_edit)
        myDialog = Dialog().apply {
            setOnAddListener { id, name, apellidos, telefono ->
                val newClient = Client(id, name, apellidos, telefono)
                controller.ClientAddController(newClient)
                val msg = "El cliente con id = $id, ha sido insertado correctamente"
                Log.d(TAG, msg)
                showConsoleData(msg)
            }

            setOnUpdateListener { id, name, apellidos, telefono ->
                val msg: String
                val update = controller.ClientUpdateController(id, name, apellidos, telefono)
                msg = if (update) {
                    "El cliente con id = $id, ha sido actualizado correctamente"
                } else {
                    "El cliente con id = $id, no ha sido encontrado para actualizar"
                }
                Log.d(TAG, msg)
                showConsoleData(msg)
            }

            setOnDeleteListener { id ->
                val msg: String
                val delete = controller.ClientDelController(id)
                msg = if (delete) {
                    "El cliente con id = $id, ha sido eliminado correctamente"
                } else {
                    "El cliente con id = $id, no ha sido encontrado para eliminar"
                }
                Log.d(TAG, msg)
                showConsoleData(msg)
            }
        }


        myButtonAdd.setOnClickListener {
            Log.d(TAG, "HAS PULSADO EL BOTON ADD")
            myDialog.show(0)  // Simulamos la acción de añadir
        }

        myButtonUpdate.setOnClickListener {
            Log.d(TAG, "HAS PULSADO EL BOTON UPDATE")
            myDialog.show(1)  // Simulamos la acción de editar
        }

        myButtonDel.setOnClickListener {
            Log.d(TAG, "HAS PULSADO EL BOTON DEL")
            myDialog.show(2)  // Simulamos la acción de eliminar
        }
    }

    fun showConsoleData(msg: String) {
        val msgData = controller.showData()
        Thread.sleep(2000)
        Log.d(TAG, msgData)
    }




}