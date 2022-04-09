package com.example.test02_image_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "애완동물 볼래?"

        val content = arrayOf(rad, tv, img) // 한 번에 visibility 변경하기 위해 VIEW들을 묶어둠

        startSel.setOnCheckedChangeListener { compoundButton, b -> // "시작함" 스위치가 변경되면
            if (startSel.isChecked) { for (i in content) i.visibility = android.view.View.VISIBLE } // checked, VISIBLE
            else { for (i in content) i.visibility = android.view.View.INVISIBLE } // unchecked, INVISIBLE
        }

        rad.setOnCheckedChangeListener { radioGroup, checkedID -> // 라디오 체크가 변경되면
            when (checkedID) {
                R.id.rad1 -> img.setImageResource(R.drawable.dog)
                R.id.rad2 -> img.setImageResource(R.drawable.cat)
                else -> img.setImageResource(R.drawable.rabbit)
            }
        }

        exit.setOnClickListener { finish() }
        // "처음으로" 버튼이 눌리면 라디오 클리어, 이미지 없애기, 뷰들 INVISIBLE
        reset.setOnClickListener { rad.clearCheck(); img.setImageResource(0); startSel.setChecked(false); for (i in content) i.visibility = android.view.View.INVISIBLE }

    }
}