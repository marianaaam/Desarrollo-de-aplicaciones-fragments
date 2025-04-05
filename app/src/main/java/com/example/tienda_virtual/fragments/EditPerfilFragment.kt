package com.example.tienda_virtual.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda_virtual.R

class EditPerfilFragment : Fragment() {

    private lateinit var etNombre: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etTelefono: EditText
    private lateinit var btnGuardar: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_perfil, container, false)

        etNombre = view.findViewById(R.id.et_nombre)
        etCorreo = view.findViewById(R.id.et_correo)
        etTelefono = view.findViewById(R.id.et_telefono)
        btnGuardar = view.findViewById(R.id.btnGuardarCambios)

        val prefs = requireActivity().getSharedPreferences("perfil", Context.MODE_PRIVATE)
        etNombre.setText(prefs.getString("nombre", ""))
        etCorreo.setText(prefs.getString("correo", ""))
        etTelefono.setText(prefs.getString("telefono", ""))

        btnGuardar.setOnClickListener {
            val editor = prefs.edit()
            editor.putString("nombre", etNombre.text.toString())
            editor.putString("correo", etCorreo.text.toString())
            editor.putString("telefono", etTelefono.text.toString())
            editor.apply()

            // Navegar de vuelta al fragment_perfil
            findNavController().navigate(R.id.action_editPerfilFragment_to_perfilFragment)
        }

        return view
    }
}