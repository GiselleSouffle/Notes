package com.odyssey.notes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {
    private var users: List<User> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val user = view.findViewById<EditText>(R.id.username)
        val password = view.findViewById<EditText>(R.id.password)
        val button = view.findViewById<Button>(R.id.submit)

        button.setOnClickListener {
            validUsers()

            if(user.text != null && password.text != null) {

                val email = user.text.toString()
                val pass = password.text.toString()

                if(checkUser(email, pass, users)){
                    Toast.makeText(context,"Login Correcto", Toast.LENGTH_SHORT)
                        .show()

                    //TODO Cambiar a MainActivity
                    val i = Intent(view.context, MainActivity::class.java)
                    startActivity(i)
                    activity?.finish()

                } else {
                    Toast.makeText(context,
                        "Las credenciales no coinciden",
                        Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(
                    context,
                    "Ambos campos son requeridos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return view
    }

    private fun checkUser(username: String, password: String,
                          users: List<User>): Boolean {
        return users.any { user ->
            username == user.email && password == user.password
        }
    }

    private fun validUsers() {
        users = listOf(
            User(1, "gisellej@gmail.com", "12345"),
        )
    }
}