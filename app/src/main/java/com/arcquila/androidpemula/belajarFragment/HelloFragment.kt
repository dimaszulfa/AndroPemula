package com.arcquila.androidpemula.belajarFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.arcquila.androidpemula.R


class HelloFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment





        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnToFlex: Button = view.findViewById<Button>(R.id.btnFlex)

        btnToFlex.setOnClickListener {
            val mFlexibleFragment = FlexibleFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().replace(R.id.fragment_container, mFlexibleFragment, FlexibleFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }
}