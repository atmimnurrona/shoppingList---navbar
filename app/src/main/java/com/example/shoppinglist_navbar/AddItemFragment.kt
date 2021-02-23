package com.example.shoppinglist_navbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add_item.*

class AddItemFragment(private val onNavigationListener: OnNavigationListener) : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btn_addItem.setOnClickListener {
            val item = Item(
                quantity = et_qty.text.toString().toInt(),
                note = et_note.text.toString(),
                itemName = et_item.text.toString()
            )

            if (item != null) {
                onNavigationListener.addItem(item)
                Toast.makeText(
                    activity,
                    "Item : ${item.itemName} has been added",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
    @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) =
            AddItemFragment(onNavigationListener)
    }
}