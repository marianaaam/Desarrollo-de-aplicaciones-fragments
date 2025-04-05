package com.example.tienda_virtual.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda_virtual.R

class CategoriasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categorias, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val layoutBienestar = view.findViewById<LinearLayout>(R.id.layoutBienestar)
        val layoutRelax = view.findViewById<LinearLayout>(R.id.layoutRelax)
        val layoutCuidado = view.findViewById<LinearLayout>(R.id.layoutCuidado)
        val layoutVida = view.findViewById<LinearLayout>(R.id.layoutVida)
        val layoutEstilo = view.findViewById<LinearLayout>(R.id.layoutEstilo)

        layoutBienestar.setOnClickListener {
            navController.navigate(R.id.bienestarFragment)
        }

        layoutRelax.setOnClickListener {
            navController.navigate(R.id.relajacionFragment)
        }

        layoutCuidado.setOnClickListener {
            navController.navigate(R.id.cuidadoFragment)
        }

        layoutVida.setOnClickListener {
            navController.navigate(R.id.vidaFragment)
        }

        layoutEstilo.setOnClickListener {
            navController.navigate(R.id.estiloFragment)
        }
    }
}