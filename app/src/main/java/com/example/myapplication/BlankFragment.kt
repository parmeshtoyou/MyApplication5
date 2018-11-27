package com.example.myapplication


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import org.jetbrains.anko.find


/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment : Fragment() {

    lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        button = view.find(R.id.fragButton)
        button.setOnClickListener {
            val someClass = SomeClass()
            someClass.doSomeWork {
                Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }


}
