package com.example.taoying.longclick

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_hello.setOnClickListener {
            showToast("click")
            //println("hello")
            Log.i("TAG","Clicked ..... " + getClassName(txt_hello))
        }
        txt_hello.setOnLongClickListener {
            showToast("long click")
            Log.i("TAG","Long clicked ..... " + getClassName(txt_hello))
            true
        }

        btn_hello.setOnClickListener {
            showToast("click")
            //println("hello")
            Log.i("TAG","Clicked ..... " + getClassName(btn_hello))
        }
        btn_hello.setOnLongClickListener {
            showToast("long click")
            Log.i("TAG","Long clicked ..... " + getClassName(btn_hello))
            true
        }
    }

    //支持默认参数值，减少方法重载
    private fun Context.showToast(message:String, duration:Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    //获取控件类型名称
    private fun getClassName(view: View): String{
        return view.javaClass.toString().split(".")[4].substring(9)
    }
}
