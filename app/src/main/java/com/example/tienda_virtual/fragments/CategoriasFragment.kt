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

    private lateinit var layoutBienestar: LinearLayout
    private lateinit var layoutRelax: LinearLayout
    private lateinit var layoutCuidado: LinearLayout
    private lateinit var layoutVida: LinearLayout
    private lateinit var layoutEstilo: LinearLayout

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

        layoutBienestar = view.findViewById(R.id.layoutBienestar)
        layoutRelax = view.findViewById(R.id.layoutRelax)
        layoutCuidado = view.findViewById(R.id.layoutCuidado)
        layoutVida = view.findViewById(R.id.layoutVida)
        layoutEstilo = view.findViewById(R.id.layoutEstilo)

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
