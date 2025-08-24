package com.unms.navigationsalud

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unms.navigationsalud.databinding.FragmentDoctoresBinding

/**
 * Este fragmento exibe a lista de doutores com botões de chamada.
 * Ele configura os listeners de clique para abrir o discador do telefone.
 */
class Doctores : Fragment() {

    // A variável de binding para acessar as views do layout.
    private var _binding: FragmentDoctoresBinding? = null

    // Esta propriedade é válida apenas entre onCreateView e onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla o layout usando o View Binding.
        _binding = FragmentDoctoresBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configura os listeners de clique para cada botão de chamada.
        setupButtonClickListeners()

        return root
    }

    /**
     * Configura os listeners de clique para cada botão "LLAMAR".
     */
    private fun setupButtonClickListeners() {
        // Listener para o botão do Doutor 1.
        binding.buttonLlamar1.setOnClickListener {
            // Pega o número de telefone do TextView correspondente.
            val phoneNumber = binding.textViewPhone1.text.toString()
            callPhoneNumber(phoneNumber)
        }

        // Listener para o botão do Doutor 2.
        binding.buttonLlamar2.setOnClickListener {
            val phoneNumber = binding.textViewPhone2.text.toString()
            callPhoneNumber(phoneNumber)
        }

        // Listener para o botão do Doutor 3.
        binding.buttonLlamar3.setOnClickListener {
            val phoneNumber = binding.textViewPhone3.text.toString()
            callPhoneNumber(phoneNumber)
        }
    }

    /**
     * Inicia uma intent para abrir o discador do telefone com o número fornecido.
     * @param phoneNumber O número de telefone para o qual discar.
     */
    private fun callPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        // Inicia o discador do telefone.
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Evita vazamentos de memória ao liberar a referência de binding.
        _binding = null
    }
}
