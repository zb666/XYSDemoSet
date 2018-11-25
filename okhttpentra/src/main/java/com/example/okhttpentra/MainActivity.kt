package com.example.okhttpentra

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.okhttpentra.net.Response
import java.net.InetSocketAddress
import java.net.Socket
import javax.net.ssl.SSLSocketFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val socket = SSLSocketFactory.getDefault().createSocket()
        //链接
        socket.connect(InetSocketAddress("",1))

        val outputStream = socket.getOutputStream()
        val inputStream = socket.getInputStream()

        val socketOutPutStream = socket.getOutputStream()

    }

}
