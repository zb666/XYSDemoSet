package com.example.okhttpentra.net

import java.net.URLEncoder

class RequestBody {


    //请求格式的参数
    private val encodeBody = HashMap<String, String>()

    companion object {
        //数据的类型格式
        val CONTENT_TYPE = "application/x-www-form-urlencoded"

        val CHARSET = "utf-8"

    }

    //取出来键值对
    fun body(): String {
        val stringBuffer = StringBuffer()
        for (entry in encodeBody.entries) {
            stringBuffer.append(entry.key)
                    .append("=")
                    .append(entry.value)
                    .append("&")
        }
        if (stringBuffer.isNotEmpty()) {
            stringBuffer.deleteCharAt(stringBuffer.length - 1)
        }
        return stringBuffer.toString()
    }

    /**
     * 添加数据
     */
    fun add(name: String, value: String): RequestBody {
        try {
            encodeBody.put(URLEncoder.encode(name, CHARSET), URLEncoder.encode(value, CHARSET))
        } catch (ex: Exception) {
            //
        } finally {
            //do nothing
        }
        return this
    }


}
