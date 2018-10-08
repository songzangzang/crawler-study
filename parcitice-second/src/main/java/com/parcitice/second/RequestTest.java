package com.parcitice.second;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 请求测试类
 *
 *
 * @author songxibo
 * @date 2018/10/514:28
 */
public class RequestTest {

    public static void main(String[] args) {

        try {
            RequestHelper.requestProductDetail("macbook pro");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
