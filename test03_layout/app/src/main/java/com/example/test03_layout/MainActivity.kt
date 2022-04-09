package com.example.test03_layout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "계산기"

        val nums = arrayOf(num1, num2, num3, num5, num6, num7, num8, num9, num0)

        for (i in nums)
            i.setOnClickListener {
                if (edt1.isFocused) edt1.setText(edt1.text.toString() + i.text.toString())
                else if (edt2.isFocused) edt2.setText(edt2.text.toString() + i.text.toString())
                else Toast.makeText(applicationContext, "먼저 에디트덱스트를 선택하세요", Toast.LENGTH_SHORT)
                    .show()
            }

        btnAdd.setOnClickListener {
            if (edt1.text.isNotEmpty() && edt2.text.isNotEmpty()) result.text =
                "계산결과 : ${edt1.text.toString().toInt() + edt2.text.toString().toInt()}"
        }
        btnSub.setOnClickListener {
            if (edt1.text.isNotEmpty() && edt2.text.isNotEmpty()) result.text =
                "계산결과 : ${edt1.text.toString().toInt() - edt2.text.toString().toInt()}"
        }
        btnMul.setOnClickListener {
            if (edt1.text.isNotEmpty() && edt2.text.isNotEmpty()) result.text =
                "계산결과 : ${edt1.text.toString().toInt() * edt2.text.toString().toInt()}"
        }
        btnDiv.setOnClickListener {
            if (edt2.text.toString().toInt().equals(0)) {
                Toast.makeText(
                    applicationContext,
                    "0으로 나눌 수 없음",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (edt1.text.isNotEmpty() && edt2.text.isNotEmpty()) {
                result.text =
                    "계산결과 : ${edt1.text.toString().toInt() / edt2.text.toString().toInt()}"
            }
        }

    }
}