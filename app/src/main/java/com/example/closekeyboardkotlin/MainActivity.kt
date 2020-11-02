package com.example.closekeyboardkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener

class MainActivity : AppCompatActivity() {

    lateinit var editTextInput : EditText
    lateinit var textViewOutput : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextInput=edit_text_input
        textViewOutput=text_view_result

         KeyboardVisibilityEvent.setEventListener(this,object:KeyboardVisibilityEventListener{
             override fun onVisibilityChanged(isOpen: Boolean) {
                 if(isOpen){
                     Toast.makeText(this@MainActivity,"OPEN",Toast.LENGTH_SHORT).show();
                 }else{
                     Toast.makeText(this@MainActivity,"CLOSE",Toast.LENGTH_SHORT).show();

                 }
             }

         })


    }

    fun setText(v:View){
        textViewOutput.setText(editTextInput.text.toString())
        closeKeypad()

    }

    fun closeKeypad(){
         val view=this.currentFocus
        if(view!=null){
            val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken,0)

        }
    }
}
