package com.unms.navigationsalud.ui.slideshow

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.unms.navigationsalud.databinding.FragmentSlideshowBinding

/**
 * Este fragmento exibe uma lista de URLs de saúde com botões para visitá-los.
 * Ele usa o layout XML definido no arquivo fragment_slideshow.xml.
 */
class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // Esta propriedade só é válida entre onCreateView e onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val SlideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root


        setupButtonClickListeners()

        return root
    }


    private fun setupButtonClickListeners() {
        // Listener para o botão da primeira URL.
        binding.buttonPagina1.setOnClickListener {
            var url1 = "https://medlineplus.gov/"
            val Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url1))
            startActivity(Intent)
        }
        binding.buttonPagina2.setOnClickListener {
            var url2 = "https://www.paho.org/es/peru"
            val Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url2))
            startActivity(Intent)
        }
        binding.buttonPagina3.setOnClickListener {
            var url3 = "https://www.sanna.pe/"
            val Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url3))
            startActivity(Intent)
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
