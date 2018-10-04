package com.parcitice.first;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author songxibo
 * @date 2018/10/410:41
 */
public class RequestTest {

    public static void main(String[] args) {

        HttpRequest request = new HttpRequest();

        String responseHtml = request.getHTMLContentByHttpGetMethod("http://vacations.ctrip.com/grouptravel/p1740331s0-comment-0.html", "UTF-8");

        // 1. 转换 html 信息
        Document document = Jsoup.parse(responseHtml);

        // 2. 获取内部信息
        Elements contentLi = document.select("div[id=js_commentData]").select("ul[class=detail_comment_list] > li");

        contentLi.forEach(li -> {

            Elements ps = li.select("p");
            String userId = ps.get(0).text();
            String comment = ps.get(2).text();
            String score = li.select("strong[class=score]").text();
            String userType = li.select("span[class=user_type]").text();

            XieChengModel model = new XieChengModel();
            model.setComment(comment);
            model.setScore(score);
            model.setUserId(userId);
            model.setUserType(userType);
            System.out.println(model);
            System.out.println();

        });

    }

}
