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

public class GoogleContactsParser {

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

		// get the root elememt
		Element docEle = dom.getDocumentElement();

		NodeList nl = docEle.getElementsByTagName("entry");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				mylist.add(getContact((Element) nl.item(i)));
			}
		}
		return mylist;
	}

	private Contact getContact(Element empEl) {

		Contact contact = new Contact();

		NodeList nl = empEl.getElementsByTagName("gd:name");

		if (nl != null && nl.getLength() > 0) {
			contact.setFullName(getTextValue(empEl, "gd:fullName"));
		}

		NodeList nl1 = empEl.getElementsByTagName("gd:email");

		if (nl1 != null && nl1.getLength() > 0) {
			Element el = (Element) nl1.item(0);
			contact.setEmailId((el.getAttribute("address")));
		}
		return contact;
	}

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}
}
