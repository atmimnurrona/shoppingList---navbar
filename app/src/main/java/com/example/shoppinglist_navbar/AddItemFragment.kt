package com.example.shoppinglist_navbar

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add_item.*
import java.util.*

class AddItemFragment : Fragment() {


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

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        et_date.setInputType(InputType.TYPE_NULL)
        et_date.setOnClickListener(View.OnClickListener {
            val datePickerDialog = activity?.let { it1 ->
                DatePickerDialog(
                        it1, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    et_date.setText(
                            "$year/$monthOfYear/$dayOfMonth",
                            TextView.BufferType.EDITABLE
                    );
                }, year, month, day
                )
            }
            datePickerDialog?.show()
        })

        btn_addItem.setOnClickListener {
            if (et_date.text.toString() != "" &&
                    et_item.text.toString() != "" &&
                    et_qty.text.toString() != "" &&
                    et_note.text.toString() != ""
            ) {
                val item = Item(
                        date = et_date.text.toString(),
                        quantity = et_qty.text.toString().toInt(),
                        note = et_note.text.toString(),
                        itemName = et_item.text.toString()
                )
                ItemList.add(item)
                clearInput()

                Toast.makeText(
                        activity,
                        "Item : ${item.itemName} has been added",
                        Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                        activity,
                        "Input not be blank!",
                        Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun clearInput() {
        et_date.setText("")
        et_item.setText("")
        et_qty.setText("")
        et_note.setText("")
    }

    companion object {
        fun newInstance() =
                AddItemFragment()
    }

}