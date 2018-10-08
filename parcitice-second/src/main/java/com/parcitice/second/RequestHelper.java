package com.parcitice.second;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 请求辅助类
 *
 * @author songxibo
 * @date 2018/10/513:47
 */
public class RequestHelper {

    public static final String REQUEST_URL = "https://search.jd.com/Search?";

    private RequestHelper() {

    }

    /**
     * 获取京东商品信息
     *
     * @param searchKey 搜索关键字
     * @return
     */
    public static String requestProductDetail(String searchKey) throws URISyntaxException, IOException {

        // 构建请求路径
        List<NameValuePair> urlParams = new ArrayList();
        urlParams.add(new BasicNameValuePair("keyword", searchKey));
        urlParams.add(new BasicNameValuePair("enc", "utf-8"));
        urlParams.add(new BasicNameValuePair("pvid", "d312176cf646427aa53ea0b14d478e5c"));

        URI uri = new URIBuilder(RequestHelper.REQUEST_URL).addParameters(urlParams).build();

        // 构建请求头信息
        List<Header> headers = new ArrayList();
        headers.add(new BasicHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
        headers.add(new BasicHeader("accept-encoding", "gzip, deflate, br"));
        headers.add(new BasicHeader("accept-language", "zh-CN,zh;q=0.9"));
        headers.add(new BasicHeader("referer", "https://list.jd.com/list.html?cat=670,671,672"));
        headers.add(new BasicHeader("upgrade-insecure-requests", "1"));
        headers.add(new BasicHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36"));

        HttpClient client = HttpClients.custom().setDefaultHeaders(headers).build();

        // 请求
        HttpResponse response = client.execute(RequestBuilder.get().setUri(uri).build(), HttpClientContext.create());
        HttpEntity entity = response.getEntity();

        return EntityUtils.toString(entity);

    }

}
