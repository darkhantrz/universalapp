package com.example.universalapp

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.universalapp.database.BMI
import com.example.universalapp.databinding.ActivityBmiCalculatorBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BmiCalculatorActivity : AppCompatActivity() {

    lateinit var binding: ActivityBmiCalculatorBinding
    private val viewModel : BmiViewModel by viewModels()
    lateinit var adapter: BmiAdapter

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context = this

        val calculateBtn: Button = findViewById(R.id.btn_calculate)
        val userName: EditText = findViewById(R.id.name)
        val height: EditText = findViewById(R.id.height)
        val weight: EditText = findViewById(R.id.weight)
        val result: TextView = findViewById(R.id.result)

        val firebaseDB = Firebase.database
        val myRef = firebaseDB.getReference("BMI data")

        calculateBtn.setOnClickListener {
            viewModel.calculate(
                userName.text.toString(),
                weight.text.toString(),
                height.text.toString(),
                context,
                myRef
            )

            hideSoftKeyboard(calculateBtn)
        }

        //onChangeListener(myRef)
        initRecyclerView()


        val goBackToMainActivity: ImageView = findViewById(R.id.goBackToMain)

        goBackToMainActivity.setOnClickListener {
            finish()
        }
        viewModel.result.observe(this) {
            result.text = it
        }
        viewModel.color.observe(this) {
            result.setTextColor(Color.parseColor(it))
        }

    }

    private fun initRecyclerView() = with(binding){
        adapter = BmiAdapter()
        rcViewBmiList?.layoutManager = LinearLayoutManager(this@BmiCalculatorActivity)
        rcViewBmiList?.adapter = adapter
    }

//    private fun onChangeListener(myRef: DatabaseReference) {
//        myRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val list = ArrayList<BMI>()
//                for (s in snapshot.children) {
//                    val bmi = s.getValue(BMI::class.java)
//                    if (bmi != null)list.add(bmi)
//                }
//                adapter.submitList(list)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }

    private fun hideSoftKeyboard(view: View) {
        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


}