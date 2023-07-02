package com.freedom.javacodesimple.api.xxe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class XxeController {


    //2023.06.23:返回值为success.
    //攻击Payload:"<!DOCTYPE doc [ \n" +
    //                    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:1664\">\n" +
    //                    "]><doc>&xxe;</doc>"

    @GetMapping("/xxe/bad01")
    public String xxe01(String xmlContent) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputStream is = new ByteArrayInputStream(xmlContent.getBytes());
        Document doc = db.parse(is);
        return "success";
    }
}
