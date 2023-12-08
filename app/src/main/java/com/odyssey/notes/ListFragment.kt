package com.odyssey.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {
    private var notes : MutableList<Note> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)
        initData()
        val adapter = NoteAdapter(notes)

        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.notesRecycler
            )



        //Variables para el elemento nuevo
        var _id : Int = 0
        var _title : String
        var _text : String

        fab.setOnClickListener {


            // Show Bottom Sheet Dialog and add a new item
            val bottomSheetFragment = BottomSheetDialog(view.context)
            val parentView : View = layoutInflater.inflate(R.layout.bsd_new_note, null)
            bottomSheetFragment.setContentView(parentView)
            bottomSheetFragment.show()

            //elementos del formulario bsd
            val newId = parentView.findViewById<EditText>(R.id.bsd_note_id)
            val newTitle = parentView.findViewById<EditText>(R.id.bsd_note_title)
            val newText = parentView.findViewById<EditText>(R.id.bsd_note_text)

            val button = parentView.findViewById<Button>(R.id.bsd_submit)

            //boton guardar del bsd, asignación de valores y creación del nuevo elemento
            button.setOnClickListener{
                _id = newId.text.toString().toInt()
                _title = newTitle.text.toString()
                _text = newText.text.toString()

                val newProductAdd = Note(
                    _id,
                    _title,
                    _text,
                )

                notes.add(newProductAdd)

                recyclerView.adapter?.notifyDataSetChanged()

                bottomSheetFragment.dismiss()
            }
        }

        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {

        notes = mutableListOf(
            Note(1, "Querido Diario", "Hoy aprobe una materia"),
            Note(2, "Querido Diario", "Hoy aprobe una materia"),
            Note(3, "Querido Diario", "Hoy aprobe una materia"),
            Note(4, "Querido Diario", "Hoy aprobe una materia"),
            Note(5, "Querido Diario", "Hoy aprobe una materia"),
            Note(6, "Querido Diario", "Hoy aprobe una materia"),
            Note(7, "Querido Diario", "Hoy aprobe una materia"),
            Note(8, "Querido Diario", "Hoy aprobe una materia"),
            Note(9, "Querido Diario", "Hoy aprobe una materia"),
            Note(10, "Querido Diario", "Hoy aprobe una materia")
        )
    }
}