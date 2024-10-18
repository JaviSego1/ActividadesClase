package com.example.actividadesclase.views

import com.example.actividadesclase.data.RepositoryClient
import kotlin.random.Random

class Dialog {

    private var onAdd: ((Int, String, String, Int) -> Unit)? = null
    private var onDelete: ((Int) -> Unit)? = null
    private var onUpdate: ((Int, String, String, Int) -> Unit)? = null

    fun setOnAddListener(listener: (Int, String, String, Int) -> Unit) {
        onAdd = listener
    }

    fun setOnDeleteListener(listener: (Int) -> Unit) {
        onDelete = listener
    }

    fun setOnUpdateListener(listener: (Int, String, String, Int) -> Unit) {
        onUpdate = listener
    }

    fun show(typeAction: Int) {
        val posibleId = Random.nextInt(1, 100)
        val posibleName = "CAMBIADO"
        val posibleApellidos = "CAMBIADO APELLIDO"
        val posibleTelefono = 123456789
        when (typeAction) {
            0 -> onAccept()
            1 -> if (posibleId != -1) onEdit(posibleId, posibleName, posibleApellidos, posibleTelefono)
            2 -> if (posibleId != -1) onDelete(posibleId)
        }
    }

    private fun onDelete(id: Int) {
        onDelete?.invoke(id)
    }

    private fun onEdit(id: Int, name: String, apellidos: String, telefono: Int) {
        onUpdate?.invoke(id, name, apellidos, telefono)
    }

    private fun onAccept() {
        onAdd?.invoke(RepositoryClient.incrementPrimary(), "NUEVO CLIENTE", "NUEVO APELLIDO", 678678541)
    }
}