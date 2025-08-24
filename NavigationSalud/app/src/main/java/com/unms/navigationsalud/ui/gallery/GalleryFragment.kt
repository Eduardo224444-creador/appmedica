package com.unms.navigationsalud.ui.gallery

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.unms.navigationsalud.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonCalcular.setOnClickListener {
            // Obtener los datos de los EditText
            val sexo = binding.txtSexo.text.toString().trim().lowercase()
            val alturaCm = binding.txtAltura.text.toString().toDoubleOrNull()
            val pesoKg = binding.txtPeso.text.toString().toDoubleOrNull()

            if (alturaCm != null && pesoKg != null && sexo.isNotEmpty()) {
                val alturaPulgadas = alturaCm / 2.54 // Convertir cm a pulgadas

                val pesoIdeal: Double
                val categoria: String
                val diferenciaPeso: Double

                if (sexo == "masculino" || sexo == "hombre") {
                    // Fórmula para hombres
                    pesoIdeal = 48.0 + 2.7 * (alturaPulgadas - 60.0) // 60 pulgadas = 5 pies
                    diferenciaPeso = pesoKg - pesoIdeal
                } else if (sexo == "femenino" || sexo == "mujer") {
                    // Fórmula para mujeres
                    pesoIdeal = 45.5 + 2.2 * (alturaPulgadas - 60.0) // 60 pulgadas = 5 pies
                    diferenciaPeso = pesoKg - pesoIdeal
                } else {
                    Toast.makeText(requireContext(), "Sexo no válido. Por favor, ingresa 'masculino' o 'femenino'.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener // Salir del listener si el sexo no es válido
                }

                // Determinar la categoría (bajo peso, normal, sobrepeso)
                categoria = when {
                    diferenciaPeso < -3.0 -> "Bajo peso"
                    diferenciaPeso > 3.0 -> "Sobrepeso"
                    else -> "Peso normal"
                }

                // Crear el mensaje del Toast
                val mensaje = "Tu peso ideal es: %.2f kg\n".format(pesoIdeal) +
                        "Tu peso es: %.2f kg\n".format(pesoKg) +
                        "Categoría: $categoria"

                // Mostrar el Toast
                val toast = Toast.makeText(requireContext(), mensaje, Toast.LENGTH_LONG)
                toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 100)
                toast.show()

            } else {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}