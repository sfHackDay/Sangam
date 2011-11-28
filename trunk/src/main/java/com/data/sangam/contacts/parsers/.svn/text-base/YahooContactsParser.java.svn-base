package com.data.sangam.contacts.parsers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.data.sangam.contacts.bean.Contact;

public class YahooContactsParser {

	public List<Contact> parseContactResourses(String xml) {
		Document dom = parseXmlFile(xml);
		return parseDocument(dom);

	}

	private Document parseXmlFile(String xml) {

		// get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			// Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parse using builder to get DOM representation of the XML file
			return db.parse(new ByteArrayInputStream(xml.getBytes()));
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	private List<Contact> parseDocument(Document dom) {
		List<Contact> mylist = new ArrayList<Contact>();
		//get the root elememt
		Element docEle = dom.getDocumentElement();
		
		NodeList nl = docEle.getElementsByTagName("results");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				Element ele1 = (Element)(nl.item(i));
				NodeList nl1 = ele1.getElementsByTagName("contact");
				
				if(nl1 != null && nl1.getLength() > 0) {
					for(int i1 = 0 ; i1 < nl1.getLength();i1++) {
								Element ele2= (Element)nl1.item(i1);
								if(ele2.getNodeName().equalsIgnoreCase("contact")){
									if(getContact(ele2) != null){
										mylist.add(getContact(ele2));
							    	}
							    }
					 }
			    }
		   }
	   }
	    return mylist;
    }

	private Contact getContact(Element empEl) {
		
		NodeList nl = empEl.getElementsByTagNameNS("*", "*");
		Contact contact = null ;
		
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				Element ele = (Element)(nl.item(i));
				if(ele.getNodeName().equals("fields")){

					NodeList nl1 = empEl.getElementsByTagNameNS("*", "*");
					
					if(nl1 != null && nl1.getLength() > 0) {
						contact = new Contact();
						boolean email = false;
						for(int i1 = 0 ; i1 < nl1.getLength();i1++) {
							Element ele1 = (Element)(nl1.item(i1));
							if(ele1.getNodeName().equals("type")){
								email = true;
							}
							if(email && ele1.getNodeName().equals("value")){
								contact.setEmailId(ele1.getFirstChild().getNodeValue());
							}
						}
					}
					
			
				}
			}
			
		}
				return contact;
	}

}
