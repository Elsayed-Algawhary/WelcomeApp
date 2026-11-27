package com.example.welcomeapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * الشاشة الرئيسية لتطبيق الترحيب بالمستخدم (Welcome App).
 *
 * تعرض عبارة ترحيبية أولية، وتتيح للمستخدم إدخال اسمه،
 * ثم تعرض رسالة ترحيب تتضمن الاسم عند الضغط على الزر.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var tvGreeting: TextView
    private lateinit var etName: EditText
    private lateinit var btnShow: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ربط عناصر الواجهة بالكود باستخدام findViewById
        tvGreeting = findViewById(R.id.tvGreeting)
        etName = findViewById(R.id.etName)
        btnShow = findViewById(R.id.btnShow)
        tvResult = findViewById(R.id.tvResult)

        // استعادة الرسالة بعد تدوير الشاشة (إن وُجدت)
        savedInstanceState?.getString(KEY_RESULT)?.let { saved ->
            tvResult.text = saved
            tvResult.visibility = View.VISIBLE
        }

        // تنفيذ الإجراء عند الضغط على الزر
        btnShow.setOnClickListener {
            val name = etName.text.toString().trim()

            if (name.isEmpty()) {
                tvResult.visibility = View.GONE
                etName.error = getString(R.string.error_empty_name)
                etName.requestFocus()
            } else {
                etName.error = null
                tvResult.text = getString(R.string.welcome_message, name)
                tvResult.visibility = View.VISIBLE
                hideKeyboard()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (tvResult.visibility == View.VISIBLE) {
            outState.putString(KEY_RESULT, tvResult.text.toString())
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(etName.windowToken, 0)
    }

    private companion object {
        const val KEY_RESULT = "key_result"
    }
}
