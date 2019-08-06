package com.cynmjcn.p13mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumberEvent(view:View){
        if (isNewOp){
            shownum.setText("")
        }
        isNewOp=false

        val btnSelect = view as Button
        var btnClickValue:String = shownum.text.toString()

        when(btnSelect.id){
            bu0.id->{
                if (shownum.text.toString().endsWith("0")){
                    shownum.setText("")
                }else {
                    btnClickValue+="0"
                }
            }
            bu1.id->{
                btnClickValue+="1"
            }
            bu2.id->{
                btnClickValue+="2"
            }
            bu3.id->{
                btnClickValue+="3"
            }
            bu4.id->{
                btnClickValue+="4"
            }
            bu5.id->{
                btnClickValue+="5"
            }
            bu6.id->{
                btnClickValue+="6"
            }
            bu7.id->{
                btnClickValue+="7"
            }
            bu8.id->{
                btnClickValue+="8"
            }
            bu9.id->{
                btnClickValue+="9"
            }
            budot.id->{
                if (shownum.text.toString().endsWith(".")){
                    shownum.setText("")
                }else {
                    btnClickValue+="."
                }
            }
            buplusminus.id->{
                btnClickValue="-" + btnClickValue
            }
        }
        shownum.setText(btnClickValue)
    }

    var operation="*"
    var oldNumber=""
    var isNewOp =true
    fun btnOpEvent(view: View) {
        val btnSelect = view as Button

        when (btnSelect.id) {
            buMul.id -> {
                operation = "*"
            }

            buDiv.id -> {
                operation = "/"
            }

            buSub.id -> {
                operation = "-"

            }
            buAdd.id -> {
                operation = "+"

            }

        }
        oldNumber=shownum.text.toString()
        isNewOp=true
    }

    fun btnEqualEvent(view: View){
        val newNumber=shownum.text.toString()
        var answer:Double?=null
        when(operation){
            "*"->{
                answer=oldNumber.toDouble() * newNumber.toDouble()

            }
            "/"->{
                answer=oldNumber.toDouble() / newNumber.toDouble()

            }
            "+"->{
                answer=oldNumber.toDouble() + newNumber.toDouble()

            }
            "-"->{
                answer=oldNumber.toDouble() - newNumber.toDouble()

            }
        }

        shownum.setText(answer.toString())
        isNewOp=true

    }

    fun btnPercent(view: View){
        val number:Double=shownum.text.toString().toDouble()/100
        shownum.setText(number.toString())
        isNewOp=true
    }

    fun btnClear(view: View){
        shownum.setText("")
        isNewOp=true
    }
}