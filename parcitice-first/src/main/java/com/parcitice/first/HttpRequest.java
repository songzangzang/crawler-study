package com.parcitice.first;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author songxibo
 * @date 2018/10/321:49
 */
public class HttpRequest {

    private HttpClient httpClient;

    public HttpEntity getEntityByHttpGetMethod(String url) {

        httpClient = HttpClients.custom().build();
        HttpGet httpGet = new HttpGet(url);

        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.getEntity();

    }

    /**
     * 获取HTML内容
     *
     * @param url 内容
     * @param code 编码
     * @return
     */
    public String getHTMLContentByHttpGetMethod(String url, String code) {

        try {
            return EntityUtils.toString(getEntityByHttpGetMethod(url), code);
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }

    }

}
