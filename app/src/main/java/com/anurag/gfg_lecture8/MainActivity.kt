package com.anurag.gfg_lecture8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*var auth: FirebaseAuth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword("test@gmail.com", "1234567")
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Email is verified", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this,it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }*/

        val firebaseDatabase = FirebaseDatabase.getInstance()

        val list: MutableList<KeyValuePair> = mutableListOf()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = ListAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        firebaseDatabase.reference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()

                for(child in snapshot.children){
                    val KeyValuePair = KeyValuePair(child.key.toString(), child.value.toString())
                    list.add(KeyValuePair)
                }
                (recyclerView.adapter as ListAdapter).notifyDataSetChanged()

            }
            override fun onCancelled(error: DatabaseError) {
                println(error.message)

            }
        })
    }
}