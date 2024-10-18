package com.example.actividadesclase.data

import com.example.actividadesclase.logic.Client

class RepositoryClient {

    companion object {
        var primary = 100

        val listClient : List<Client> = listOf(
            Client (incrementPrimary(), "Javier", "Segovia", 987987654),
            Client (incrementPrimary(), "Ruben", "Dominguez", 678543123),
            Client (incrementPrimary(), "Pablo", "Perez", 678908765),
            Client (incrementPrimary(), "Alvaro", "Fuentes", 612312098  )
        )

        fun incrementPrimary() = primary ++

    }

}