package com.data.sangam.contacts.util;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.data.sangam.contacts.bean.*;
import com.data.sangam.contacts.parsers.GoogleContactsParser;
import com.data.sangam.contacts.parsers.YahooContactsParser;
public class ContactUtil  extends DefaultHandler {
	
	 SAXParserFactory spf = SAXParserFactory.newInstance();
	 


	public  List<Contact> parseContactResourses(String xml,String provider){
		if(provider.equalsIgnoreCase("google")){
			return new GoogleContactsParser().parseContactResourses(xml);
		}else if(provider.equalsIgnoreCase("yahoo")){
			return new YahooContactsParser().parseContactResourses(xml);
		}
		return null;
	}
/*	
	private void parseDocument(String xml){
		try {
			//get a new instance of parser
			spf.setValidating(false);
			SAXParser sp = spf.newSAXParser();
			
			//parse the file and also register this class for call backs
			sp.parse(new ByteArrayInputStream(xml.getBytes()),this);

		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
			//reset
			tempVal = "";
			if(qName.equalsIgnoreCase("gd:name")) {
				tempContact = new Contact();
			}
		}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		tempVal = new String(ch, start, length);
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if (qName.equalsIgnoreCase("gd:name")) {
			// add it to the list
			contacts.add(tempContact);

		} else if (qName.equalsIgnoreCase("gd:givenName")) {
			tempContact.setName(tempVal);

		}
	}*/
}




