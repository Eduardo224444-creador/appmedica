package com.unms.navigationsalud.ui.home

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.unms.navigationsalud.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configurar el listener para el botón "GUARDAR"
        binding.buttonGuardar.setOnClickListener {
            // Obtener los datos de los EditText
            val nombres = binding.txtNombres.text.toString()
            val apellidos = binding.txtApellidos.text.toString()
            val direccion = binding.txtDireccion.text.toString()
            val telefono = binding.txtTelefono.text.toString()

            // Crear el mensaje del Toast con saltos de línea para que se vea completo
            val mensaje = "Nombres y apellidos: $nombres $apellidos\nDirección: $direccion\nNúmero de teléfono: $telefono"

            // Mostrar el Toast
            val toast = Toast.makeText(requireContext(), mensaje, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 1300)
            toast.show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}