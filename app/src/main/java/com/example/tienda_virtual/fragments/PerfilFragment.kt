package com.example.tienda_virtual.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda_virtual.R

class PerfilFragment : Fragment() {

    private lateinit var tvNombre: TextView
    private lateinit var tvCorreo: TextView
    private lateinit var tvTelefono: TextView
    private lateinit var btEditar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        tvNombre = view.findViewById(R.id.tv_nombre)
        tvCorreo = view.findViewById(R.id.tv_correo)
        tvTelefono = view.findViewById(R.id.tv_telefono)
        btEditar = view.findViewById(R.id.bt_eperfil)

        val prefs = requireActivity().getSharedPreferences("perfil", Context.MODE_PRIVATE)
        tvNombre.text = prefs.getString("nombre", "Nombre por defecto")
        tvCorreo.text = prefs.getString("correo", "Correo por defecto")
        tvTelefono.text = prefs.getString("telefono", "Teléfono por defecto")

        btEditar.setOnClickListener {
            findNavController().navigate(R.id.action_perfilFragment_to_editPerfilFragment)
        }

        return view
    }
}
