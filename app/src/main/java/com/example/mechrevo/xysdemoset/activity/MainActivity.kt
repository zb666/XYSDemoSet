package com.example.mechrevo.xysdemoset.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

import com.example.mechrevo.xysdemoset.R
import com.example.mechrevo.xysdemoset.kotlin.KotlinAndroid
import com.example.mechrevo.xysdemoset.view.StatusChangeView
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


class MainActivity : AppCompatActivity(), View.OnClickListener {

    internal lateinit var statusChangeView: StatusChangeView

    private var mButton: Button? = null


    private var kotlinAndroid: KotlinAndroid = KotlinAndroid(1, "zb666")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateDiary("人民公园")
        generateDiary("鸟巢")
        setListener()

        val t = Test()

        val list = listOf<String>("zb666", "2")
        list.forEach(::println)

        list.map {
            it + " 666"
        }

        val listInList = listOf {
            1..20
            2..5
        }

        val oldList = listOf(1, 3, 2)
        oldList.takeWhile { it != 2 }

        BufferedReader(FileReader("test.txt")).use {
            //简化Closeable 的一些操作
            var line: String?
            while (true) {
                line = it.readLine() ?: break
                print(line)
            }
        }

    }


    fun getScrollOffset(i: Int?,j:String) {
        File("test.txt")
                .readText()
                .filterNot(Char::isWhitespace)
                .groupBy { it }
                .map { it.key to it.value.size }
                .forEach(::println)
    }

    fun generateDiary(place: String) {
        val template = "天气晴朗 万里无云" +
                "我们去$place 玩" +
                "首先映入眼帘的是 , $place ${place.length}" +
                "几个大字"
    }

    fun setListener() {

        statusChangeView = findViewById(R.id.statusChangeView)
        mButton = findViewById(R.id.btn_press)
        statusChangeView.setOnClickListener(this)
        mButton!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === statusChangeView) {

        } else if (v === mButton) {

        }
    }

    class Test {
        fun println(any: Any) {
            println(any)
        }
    }
}
