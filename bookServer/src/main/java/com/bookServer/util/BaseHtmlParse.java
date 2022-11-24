package com.bookServer.util;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class BaseHtmlParse {

    /**
     *  根据网址解析网页
     * @return
     */
    public static Document getDocument(String url){
        List<String> asd = new ArrayList<>();


        try {
            return  Jsoup.parse(new URL(url), 5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Element getElementById(String url,String id){
        Document document = getDocument(url);
        Element elementById = document.getElementById(id);
        return elementById;
    }

    /**
     * 根据classname获取标签
     * @param url
     * @param className
     * @param tagIndex
     * @return
     */
    public static Element getElement(String url, String className, int tagIndex){
        Document document = getDocument(url);
        Elements elementsByClass = document.getElementsByClass(className);
        return elementsByClass.get(tagIndex);
    }

    /**
     * 获取
     * @param url
     * @param className
     * @return
     */
    public static Elements getElements(String url, String className){
        Document document = getDocument(url);
        return document.getElementsByClass(className);

    }
    /**
     * 获取属性值
     * @param element
     * @param attrKey
     * @return
     */
    public static String getStringByAttr(Element element,String attrKey){
        return element.attr(attrKey);
    }

    /**
     * 获取标签值
     * @param element
     * @return
     */
    public static String getStringByText(Element element){
        return element.text();
    }
}
