package com.example.redline_project.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.redline_project.MainApplication
import com.example.redline_project.R
import com.example.redline_project.databinding.FragmentDisplayScrenBinding
import com.example.redline_project.viewmodels.MainViewModel
import com.example.redline_project.viewmodels.util.viewModelProvider
import javax.inject.Inject

class DisplayScrenFragment : Fragment(), DisplayScreenRecyclerViewListener {

    private val appComponent by lazy { MainApplication.appComponent }

    private var fragmentdisplayScreenFragment : FragmentDisplayScrenBinding? = null
    private val binding get() = fragmentdisplayScreenFragment!!

    private lateinit var dogtype:String

    @Inject
    lateinit var viewModelFactory:ViewModelProvider.Factory
    private fun getViewModel():MainViewModel{
        return viewModelProvider(viewModelFactory)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        appComponent.inject(this)
        fragmentdisplayScreenFragment = FragmentDisplayScrenBinding.inflate(inflater, container, false)


        dogtype = arguments?.getString("getString").toString()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        getViewModel().fechDataRxjava(dogtype)
        getViewModel().getDataList(dogtype)
        getViewModel().resultDataLink.observe(viewLifecycleOwner, Observer {
            setAdapter(it)
        })
    }

    private fun setAdapter(list:List<String>){
        val adapter = DisplayScreenRecyclerViewAdapter(list, this)
        binding.displayScrenFragmentRecyclerview.layoutManager = GridLayoutManager(activity, 2)
        binding.displayScrenFragmentRecyclerview.adapter = adapter
    }
    override fun onDestroy() {
        super.onDestroy()
        fragmentdisplayScreenFragment = null
    }

    override fun mainDisplayScreenItemClicked(string: String) {
        val navController : NavController = Navigation.findNavController(requireActivity(), R.id.fragment_view_main_container)
        val bundle = Bundle()
        bundle.putString("getString", string)
        navController.navigate(R.id.detailscreen_fragment_navigation,bundle)
    }
}