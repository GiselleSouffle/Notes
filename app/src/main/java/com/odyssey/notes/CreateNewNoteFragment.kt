package com.odyssey.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateNewNoteFragment : BottomSheetDialogFragment() {

    interface OnItemAddedListener {
        fun onItemAddedListener(newItem: Note)
    }

    private var itemAddedListener: OnItemAddedListener? = null

        fun setOnItemAddedListener(listener: Note) {
        itemAddedListener
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bsd_new_note, container, false)

        val button = view.findViewById<Button>(R.id.bsd_submit)

        button.setOnClickListener {
            val note = Note(
                9,
                "China",
                "Pekin")

            itemAddedListener?.onItemAddedListener(note)
            dismiss()
        }

        return view
    }
}