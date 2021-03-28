package com.example.redline_project.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.redline_project.MainApplication
import com.example.redline_project.R
import com.example.redline_project.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private val appComponent by lazy { MainApplication.appComponent }

    private var fragmentFirstBinding: FragmentFirstBinding?=null
    private val binding get() = fragmentFirstBinding!!

    private lateinit var timer: CountDownTimer
    private  var term:Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        appComponent.inject(this)
        fragmentFirstBinding = FragmentFirstBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        timer = object : CountDownTimer(5000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                term += 20
                fragmentFirstBinding?.firstFragmentProgressBar?.progress = term
            }
            override fun onFinish() {
                val navController : NavController = Navigation.findNavController(requireActivity(), R.id.fragment_view_main_container)
                navController.navigate(R.id.mainFragment_navigation)
            }
        }
        timer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentFirstBinding = null
    }
}