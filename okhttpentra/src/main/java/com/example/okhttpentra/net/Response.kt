package com.example.okhttpentra.net

data class Response(var code: Int,
                    var conotentLength: Int,
                    var headers:HashMap<String,String>,
                    val body:String,
                    val isKeepAlive:Boolean) {

}