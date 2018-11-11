package com.example.mechrevo.xysdemoset.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

import com.example.mechrevo.xysdemoset.R
import com.example.mechrevo.xysdemoset.view.StatusChangeView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    internal lateinit var statusChangeView: StatusChangeView

    private var mButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    fun setListener() {
        statusChangeView = findViewById(R.id.statusChangeView)
        mButton = findViewById(R.id.btn_press)
        statusChangeView.setOnClickListener(this)
        mButton!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === statusChangeView) {
            statusChangeView.onHandleText()
        } else if (v === mButton) {
                ll_love.addLoveView()
        }
    }
}
