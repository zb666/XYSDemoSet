package com.example.okhttpentra.net;

import android.text.TextUtils;

import java.net.MalformedURLException;
import java.net.URL;

//Http请求 URl 包含哪些内容
public class HttpUrl {

    public String protocol;

    public String host;

    public String file;

    public int port;

    public HttpUrl(String url) throws MalformedURLException {
        //转化成统一资源定位符
        URL url1 = new URL(url);
        //解析Host主机地址
        host = url1.getHost();
        file = url1.getFile();
        file = TextUtils.isEmpty(file) ? "/" : file;
        protocol = url1.getProtocol();
        //端口号
        port = url1.getPort();
        port = port == -1 ? url1.getDefaultPort() : port;
    }


}
