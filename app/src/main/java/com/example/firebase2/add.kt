package com.example.firebase2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class add : AppCompatActivity() {
    lateinit var FBFS: FirebaseFirestore
    lateinit var addBtn: Button
    lateinit var nameTxt: EditText
    lateinit var contentTxt: EditText

//    var channel_id: String = "123"
//    var id: Int = 1
//    var manager: NotificationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add)
        FBFS = Firebase.firestore


        addBtn = findViewById<Button>(R.id.addBtn)
        nameTxt = findViewById<EditText>(R.id.nameTxt)
        contentTxt = findViewById<EditText>(R.id.contentTxt)
        addBtn.setOnClickListener {
            if(nameTxt.text.toString().isEmpty()) {
                nameTxt.error = "Fill this field"
                nameTxt.requestFocus()
            }else if(contentTxt.text.toString().isEmpty()){
                contentTxt.error = "Fill this field"
                contentTxt.requestFocus()
            }
            addNewNote(nameTxt.text.toString(), contentTxt.text.toString())
        }
    }

    private fun addNewNote(name: String, content: String) {
        var note = hashMapOf(
            "name" to name,
            "content" to content
        )
        FBFS.collection("note")
            .add(note)
            .addOnSuccessListener { documentReference ->
                Log.e("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                startActivity(Intent(this, MainActivity::class.java))

            }
            .addOnFailureListener { e ->
                Log.e("TAG", "Error adding document",e)
            }

    }

    }
