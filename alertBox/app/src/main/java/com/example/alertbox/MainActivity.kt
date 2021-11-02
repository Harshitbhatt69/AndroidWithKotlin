package com.example.alertbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 = findViewById<Button>(R.id.btn1);
        var btn2 = findViewById<Button>(R.id.btn2);
        var btn3 = findViewById<Button>(R.id.btn3);

        val addContactDialogue = AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_baseline_person_add)
            .setTitle("Add Contact")
            .setMessage("Do you want to add this contact in your contact list?")
            .setPositiveButton("Yes"){_,_ ->
                Toast.makeText(this, "Contact added", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_ ->
                Toast.makeText(this,"Contact not added", Toast.LENGTH_SHORT).show()
            }.create()

        btn1.setOnClickListener {
            addContactDialogue.show()
        }

        val options = arrayOf("Option1","Option2","Option3","Option4");
        val singleChoiceDialoge = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options,0) {dialogInterface, i ->
                Toast.makeText(this, "You have selected ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){_,_ ->
                Toast.makeText(this, "Accepted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){_,_ ->
                Toast.makeText(this, "Declined", Toast.LENGTH_SHORT).show()
            }.create()
        btn2.setOnClickListener {
            singleChoiceDialoge.show()
        }

        val multiChoiceDialogue = AlertDialog.Builder(this)
            .setTitle("Multichoice dialog box")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false, false)){ _, i, ifChecked ->
                if(ifChecked)
                Toast.makeText(this, "${options[i]} selected", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this,"${options[i]} unselected", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){_,_ ->
                Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancelled"){_,_ ->
                Toast.makeText(this,"Cancelled", Toast.LENGTH_SHORT).show()
            }
            .create()

        btn3.setOnClickListener {
            multiChoiceDialogue.show()
        }
    }
}