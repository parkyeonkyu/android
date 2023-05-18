package com.anyul.diet_memo

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<DataModel>()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.getReference("message")

        val listView = findViewById<ListView>(R.id.mainLV)
        val adapter = ListViewAdapter(dataModelList)

        listView.adapter = adapter

        myRef.child(Firebase.auth.currentUser!!.uid).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                dataModelList.clear()
                for(dataModel in snapshot.children){
                    Log.d("DATA", dataModel.toString())
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                }
                adapter.notifyDataSetChanged()
                Log.d("DataModel", dataModelList.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        val writeButton = findViewById<ImageView>(R.id.writeBtn)
        writeButton.setOnClickListener{
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog,null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")
            val mAlertDialog =  mBuilder.show()

            var dateText = ""

            mAlertDialog.findViewById<Button>(R.id.dateSelectBtn)?.setOnClickListener {

                val today = GregorianCalendar()
                val year : Int = today.get(Calendar.YEAR)
                val month : Int = today.get(Calendar.MONTH)
                val date : Int = today.get(Calendar.DATE)

                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                    override fun onDateSet(
                        view: DatePicker?,
                        year: Int,
                        month: Int,
                        dayOfMonth: Int
                    ) {
                        Log.d("MAIN", "${year}, ${month + 1}, ${dayOfMonth}")
                        mAlertDialog.findViewById<Button>(R.id.dateSelectBtn)?.setText("${year}, ${month + 1}, ${dayOfMonth}")

                        dateText = "${year}, ${month + 1}, ${dayOfMonth}"

                    }

                },year, month, date)

                dlg.show()
            }

            mAlertDialog.findViewById<Button>(R.id.saveBtn)?.setOnClickListener{
                val healthMemo = mAlertDialog.findViewById<EditText>(R.id.healthMemo)?.text.toString()
                val database = Firebase.database
                val myRef = database.getReference("message").child(Firebase.auth.currentUser!!.uid)

                val model = DataModel(dateText, healthMemo)
                myRef.push().setValue(model) // 중복값 계속해서 보냄
                //myRef.setValue("Hello,world!")

                mAlertDialog.dismiss()
            }
        }
    }
}