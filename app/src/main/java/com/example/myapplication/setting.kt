package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import androidx.annotation.IntegerRes
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_setting.*

class setting : AppCompatActivity() {
    val Hex_String: Array<String> = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f")

    fun HexToString(num: Int): String {
        var result: String = ""
        var temp: Int
        for (i in 0..7) {
            temp = (num ushr ((7-i) * 4)) and 0x000F
            result += Hex_String[temp]
        }

        return result
    }
    val String_Hex = mapOf<Char , Int>('0' to 0x0, '1' to 0x1, '2' to 0x2, '3' to 0x3, '4' to 0x4, '5' to 0x5, '6' to 0x6, '7' to 0x7, '8' to 0x8, '9' to 0x9, 'a' to 0xa, 'b' to 0xb, 'c' to 0xc, 'd' to 0xd, 'e' to 0xe, 'f' to 0xf)
    fun StringToHex(text:String):Int{
        var result : Int = 0
        for(i in 0..7){
            result += (String_Hex[text[i]]!!) shl ((7 - i)*4)
        }
        return result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        setSupportActionBar(toolbar)

        EnableToggle.isChecked = (this.application as ShareData).ButtonEnable

        CodeNum.setText(HexToString((this.application as ShareData).ColorCode))

        EnableToggle.setOnCheckedChangeListener { buttonView, isChecked ->
            (this.application as ShareData).ButtonEnable = isChecked
        }

        back_button.setOnClickListener {

            val a = Regex("""[0-9a-f]{8}""").matchEntire(CodeNum.text)?.value
            if (a == null){
                CodeNum.setText("")
            }else {
                (this.application as ShareData).ColorCode = StringToHex(CodeNum.text.toString())
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }


    }
}
