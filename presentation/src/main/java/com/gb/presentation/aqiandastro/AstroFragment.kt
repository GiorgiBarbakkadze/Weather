package com.gb.presentation.aqiandastro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gb.domain.entities.AstroEntity
import com.gb.presentation.R
import com.gb.presentation.databinding.FragmentAqiBinding
import com.gb.presentation.databinding.FragmentAstroBinding

class AstroFragment : Fragment() {

    private lateinit var binding: FragmentAstroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAstroBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initValues(arguments?.getSerializable(ASTRO) as AstroEntity)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initValues(astro: AstroEntity?) {
        binding.apply {
            astroTitle.text = "Astro"
            sunrise.text = "Sunrise: ${astro?.sunrise}"
            sunSet.text = "Sun set: ${astro?.sunset}"
            moonrise.text = "Moon rise: ${astro?.moonrise}"
            moonSet.text = "Moon set: ${astro?.moonset}"
            moonPhase.text = "Moon Phase: ${astro?.moonPhase}"
            moonIlumaination.text = "Moon Ilumaination: ${astro?.moonIllumination}"
            issMoonUp.text = "Is moon up: ${if (astro?.isMoonUp == 1) "true" else "false"}"
            isSunUp.text = "Is sun up: ${if (astro?.isSunUp == 1) "true" else "false"}"


        }
    }

    companion object {

        private const val ASTRO = "astro"

        fun newInstance(astro: AstroEntity) =
            AstroFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ASTRO, astro)
                }
            }
    }
}