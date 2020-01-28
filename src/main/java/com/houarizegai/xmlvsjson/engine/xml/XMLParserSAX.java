package com.houarizegai.xmlvsjson.engine.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.houarizegai.xmlvsjson.engine.model.Employee;
import org.xml.sax.SAXException;

public class XMLParserSAX {

    public static List<Employee> parseXML(String filePath) {
        List<Employee> empList = null;

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File(filePath), handler);
            //Get Employees list
            empList = handler.getEmpList();
            //print employee information
            for(Employee emp : empList)
                System.out.println(emp);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return empList;
    }

}
