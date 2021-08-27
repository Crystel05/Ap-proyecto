package Adm_proyectos.approyecto

import Adm_proyectos.approyecto.databinding.LoginBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: LoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = LoginBinding.inflate(inflater, container, false)
        return binding.root

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        binding.buttonFirst.setOnClickListener {
////            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
////        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}