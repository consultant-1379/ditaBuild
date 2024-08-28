
package com.ericsson.ReadXml;
import java.io.*;   
import java.util.jar.Manifest;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;   
import javax.xml.parsers.DocumentBuilderFactory;   
import org.w3c.dom.Document;   
import org.w3c.dom.Element;   
import org.w3c.dom.Node;   
import org.w3c.dom.NodeList; 


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;



public class App extends DefaultHandler{

	
	XMLStreamWriter xmlOut;
	String CurrentTagName="";
	OutputStream outputStream;
	Document SDIFDoc;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//main function	
		
		
		
//	Manifest manifest = new Manifest();
//Attributes global = manifest.getMainAttributes();
//global.put(new Attributes.Name("CLASS_PATH"), "com.ericsson.ReadXml.App");


		// TODO Auto-generated method stub
		System.out.println("Hello World"); 
		   App readXml = new App();   
		   readXml.getXml();   


	}

	 
public void getXml(){
  try {
   // obtain and configure a SAX based parser
   SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
   saxParserFactory.setValidating(false);
   try {
	   saxParserFactory.setFeature("http://xml.org/sax/features/validation", false);
	   saxParserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
	   saxParserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
	   saxParserFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
	   saxParserFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
   }
   catch (Exception e1) {
     e1.printStackTrace();
   }
   
   
   // obtain object for SAX parser
   SAXParser saxParser = saxParserFactory.newSAXParser();
   


   // default handler for SAX handler class
   // all three methods are written in handler's body
   DefaultHandler defaultHandler = new DefaultHandler(){
    
    String firstNameTag="close";
    
    
    // this method is called every time the parser gets an open tag '<'
    // identifies which tag is being open at time by assigning an open flag
    public void startElement(String uri, String localName, String qName,
      Attributes attributes) throws SAXException {
		
		
     if (qName.equalsIgnoreCase("map")) {
    	 try {
    		 try {  
    			
    		//	 SDIFDoc = createDocument("-//ERICSSON//DTD XSEIF 1/FAD 110 05 R6//EN", "doc.sdif", "doc PUBLIC");
    			 
    				outputStream =new FileOutputStream(new File("doc.sdif"));
    				
    				xmlOut = XMLOutputFactory.newInstance().createXMLStreamWriter(
    					            new OutputStreamWriter(outputStream, "utf-8"));
    				
    				///xmlOut.writeDTD("ABCD");
    				xmlOut.writeDTD("<!DOCTYPE doc PUBLIC \"-//ERICSSON//DTD XSEIF 1/FAD 110 05 R6//EN\" \"XSEIF_R6.dtd\"\n");
    				xmlOut.writeDTD("\"XSEIF_R6.dtd\">\n");
    				System.out.println("sdif created"); 


    				}
    				catch (Exception e1) {
    				     e1.printStackTrace();
    				     System.out.println("sdif not created"); 
    				   } 
    		 
    		 
    		 
    		System.out.println("in the file header creation"); 
    		
    		//xmlOut.writeNamespace(arg0, arg1)
    		//xmlOut.writeAttribute("encoding", "UTF-8");
    		//xmlOut.writeCharacters("\n");
    		
    		
    	//	xmlOut.writeComment("DOCTYPE doc PUBLIC \"-//ERICSSON//DTD XSEIF 1/FAD 110 05 R6//EN\" \"XSEIF_R6.dtd\"");
    		//xmlOut.writeDTD("doc");
    		//xmlOut.writeDTD("PUBLIC");
    		//xmlOut.writeDTD("-//ERICSSON//DTD XSEIF 1/FAD 110 05 R6//EN");
    		//xmlOut.writeDTD("XSEIF_R6.dtd");
    		xmlOut.writeCharacters("\n");
    		xmlOut.writeStartElement("doc");
    	 xmlOut.writeAttribute("version", "XSEIF R6");
    	 xmlOut.writeAttribute("xmlns", "urn:x-ericsson:r2:reg-doc:1551-fad.110.05:en:*");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("meta-data");
    	 xmlOut.writeEmptyElement("confidentiality");
    	 
    	 //xmlOut.writeStartElement("confidentiality");
    	 xmlOut.writeAttribute("class", "ericsson-internal");

    	 xmlOut.writeStartElement("doc-name");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeCharacters("USER GUIDE");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("doc-id");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("doc-no");
    	 xmlOut.writeAttribute("type", "registration");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeCharacters("1543 APR 90109140");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEmptyElement("language");
    	 xmlOut.writeAttribute("code", "en");
    	 

    	 xmlOut.writeStartElement("rev");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeCharacters("PA1");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("date");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("y");
    	 xmlOut.writeCharacters("2014");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeStartElement("m");
    	 xmlOut.writeCharacters("02");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeStartElement("d");
    	 xmlOut.writeCharacters("28");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("company-id");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("business-unit");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("company-name");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("company-symbol");
    	 xmlOut.writeAttribute("logotype", "ericsson");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("title");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeCharacters("ABC, All Be Complete, User Guide");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("drafted-by");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("person");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("name");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeCharacters("EMAHGAR");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("signature");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeCharacters("EMAHGAR");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("approved-by");
    	 xmlOut.writeAttribute("approved", "no");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("person");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("name");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeCharacters("AUTO");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("signature");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeCharacters("AUTO");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("checked-by");
    	 xmlOut.writeAttribute("checked", "no");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("person");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("name");
    	 xmlOut.writeCharacters("AUTO");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("signature");
    	 xmlOut.writeCharacters("AUTO");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("factual-supervisor");
    	 
    	 xmlOut.writeAttribute("responsible", "department");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("person");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("name");
    	 xmlOut.writeCharacters("AUTO");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("signature");
    	 xmlOut.writeCharacters("AUTO");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("translated-by");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("person");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("name");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeCharacters("AUTO");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("signature");
    	 xmlOut.writeCharacters("AUTO");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("revision-history");
    	 xmlOut.writeAttribute("suppress", "yes");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("rev-info");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("rev");
    	 xmlOut.writeCharacters("PA1");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("date");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("y");
    	 xmlOut.writeCharacters("2014");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeStartElement("m");
    	 xmlOut.writeCharacters("02");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeStartElement("d");
    	 xmlOut.writeCharacters("28");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("signature");
    	 xmlOut.writeCharacters("EMAHGAR");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("description");
    	 xmlOut.writeStartElement("dp");
    	 xmlOut.writeCharacters("FirstCopy");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");

    	 xmlOut.writeStartElement("front");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("body");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("chl");
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeStartElement("title");
    	 
    	 xmlOut.writeAttribute("xml:id", "chl");
    	 xmlOut.writeCharacters("First Chapter");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();
    	 xmlOut.writeCharacters("\n");
    	 xmlOut.writeEndElement();

    	 }catch(XMLStreamException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

     }

     int len = attributes.getLength();
     // Loop through all attributes and save them as needed
     for(int i = 0; i < len; i++)
     {
        String sAttrName = attributes.getLocalName(i);
        if(sAttrName.compareTo("href") == 0) 
        {
            String sVal = attributes.getValue(i);
            System.out.println(sVal);
            //processAcronym(sVal.substring(2));
            processAcronymDOM(sVal);
        }
    }
    }

    // prints data stored in between '<' and '>' tags
    public void characters(char ch[], int start, int length)
      throws SAXException {
     
     if (firstNameTag.equals("open")) {
      System.out.println("topicref: " + new String(ch, start, length));
     }
    
    }

    // calls by the parser whenever '>' end tag is found in xml 
    // makes tags flag to 'close'
    public void endElement(String uri, String localName, String qName)
      throws SAXException {
     
     if (qName.equalsIgnoreCase("map")) {
     firstNameTag = "close";
      try {
    	  System.out.println("Writing end element");
	    	xmlOut.writeEndElement();
	    	 xmlOut.writeCharacters("\n");
		    	xmlOut.writeEndElement();
		    	 xmlOut.writeCharacters("\n");
		xmlOut.flush();
		xmlOut.close();
	} catch (XMLStreamException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      

     }

    }
   };
   
   // parse the XML specified in the given path and uses supplied
   // handler to parse the document
   // this calls startElement(), endElement() and character() methods
   // accordingly
   
   saxParser.parse("/var/lib/jenkins/jobs/GITMavenEricssonXMLDITAOT/workspace/ERICditaBuild_CXP1234567/src/main/DITAFiles/E.ditamap", defaultHandler);
  } catch (Exception e) {
   e.printStackTrace();
  }
 }

public void processAcronym(String DITAFileName){
	
	 try {
		   // obtain and configure a SAX based parser
		   SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		   saxParserFactory.setValidating(false);
		   try {
			   saxParserFactory.setFeature("http://xml.org/sax/features/validation", false);
			   saxParserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
			   saxParserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			   saxParserFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			   saxParserFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		   }
		   catch (Exception e1) {
		     e1.printStackTrace();
		   }
		   
		   
		   // obtain object for SAX parser
		   SAXParser saxParser = saxParserFactory.newSAXParser();

		 /*  xmlOut.writeComment("all elements here are explicitly in the HTML namespace");
		   xmlOut.writeStartDocument("utf-8","1.0");
		   xmlOut.setPrefix("html", "http://www.w3.org/TR/REC-html40");
		   xmlOut.writeStartElement("http://www.w3.org/TR/REC-html40","html");
		   xmlOut.writeNamespace("html", "http://www.w3.org/TR/REC-html40");
		   xmlOut.writeStartElement("http://www.w3.org/TR/REC-html40", "head");
		   xmlOut.writeStartElement("http://www.w3.org/TR/REC-html40", "title");
		   xmlOut.writeComment("DO NOT EDIT THIS FILE\n"); */

		   // default handler for SAX handler class
		   // all three methods are written in handler's body
		   DefaultHandler defaultHandler = new DefaultHandler(){
		    
		    String firstNameTag="close";
		    String glossaryExplanation="";
		    
		    
		    // this method is called every time the parser gets an open tag '<'
		    // identifies which tag is being open at time by assigning an open flag
		    public void startElement(String uri, String localName, String qName,
		      Attributes attributes) throws SAXException {
		    	CurrentTagName=qName;
		    try {
		     if (qName.equalsIgnoreCase("glossentry")) {
		    	 xmlOut.writeStartElement("back");
		    	 xmlOut.writeCharacters("\n");
		    	 xmlOut.writeStartElement("glossary");
		    	 xmlOut.writeCharacters("\n");
		    	 xmlOut.writeStartElement("glossary-list");
		    	 xmlOut.writeCharacters("\n");
		    	 xmlOut.writeStartElement("gl-item");
		    	 xmlOut.writeCharacters("\n");
		     }
		     if (qName.equalsIgnoreCase("glossterm")) {
		    	 xmlOut.writeStartElement("term");
		    	 xmlOut.writeCharacters("\n");
		    	 
		     }

		     if (qName.equalsIgnoreCase("glossdef")) {
		    	 xmlOut.writeStartElement("expansion");
		    	 xmlOut.writeCharacters("\n");
		    	 xmlOut.writeStartElement("p");
		    	 xmlOut.writeCharacters("\n");
   	 		    	 
		     }
		     
		     if (qName.equalsIgnoreCase("glossSurfaceForm")) {
		    	 
		    	 xmlOut.writeStartElement("p");
		    	 xmlOut.writeCharacters("\n");
		    	 		    	 
		     }
		     
		     
		     
			} catch (XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	
		     int len = attributes.getLength();
		     // Loop through all attributes and save them as needed
		     for(int i = 0; i < len; i++)
		     {
		        String sAttrName = attributes.getLocalName(i);
		        if(sAttrName.compareTo("id") == 0) 
		        {
		            String sVal = attributes.getValue(i);
		            System.out.println(sVal);
		        }
		    }
		    }

		    // prints data stored in between '<' and '>' tags
		    public void characters(char ch[], int start, int length)
		      throws SAXException {
		     
			try {

					xmlOut.writeCharacters(new String(ch, start, length));
				
			}catch (XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		     }
		    
		    }

		    // calls by the parser whenever '>' end tag is found in xml 
		    // makes tags flag to 'close'
		    public void endElement(String uri, String localName, String qName)
		      throws SAXException {
		     
	     
			    try {
				     if (qName.equalsIgnoreCase("glossterm")) {
				    	 xmlOut.writeEndElement();
				    	 xmlOut.writeCharacters("\n");				    	 
				     }
				     if (qName.equalsIgnoreCase("glossentry")) {
				    	 xmlOut.writeEndElement();
				    	 xmlOut.writeCharacters("\n");
				    	 xmlOut.writeEndElement();
				    	 xmlOut.writeCharacters("\n");
				    	 xmlOut.writeEndElement();
				    	 xmlOut.writeCharacters("\n");
				    	 xmlOut.writeEndElement();
				    	 xmlOut.writeCharacters("\n");
				     }
				     
				     if (qName.equalsIgnoreCase("glossdef")) {
				    	 xmlOut.writeEndElement();
				    	 xmlOut.writeCharacters("\n");
				    	 xmlOut.writeEndElement();
				    	 xmlOut.writeCharacters("\n");

				     }
				     
				     
				     if (qName.equalsIgnoreCase("glossSurfaceForm")) {
				    	 xmlOut.writeEndElement();
				    	 xmlOut.writeCharacters("\n");


				     }			     
				     
					} catch (XMLStreamException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		     
		     
		     
		     

		    }
		   };
		   
		   // parse the XML specified in the given path and uses supplied
		   // handler to parse the document
		   // this calls startElement(), endElement() and character() methods
		   // accordingly
		   
		   saxParser.parse(DITAFileName, defaultHandler);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
	
}

public void processAcronymDOM(String DITAFileName){
	try {
		 
		File inputDITAFile = new File(DITAFileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		

		   try {
			   dbFactory.setFeature("http://xml.org/sax/features/validation", false);
			   dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
			   dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			   dbFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			   dbFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		   }
		   catch (Exception e1) {
		     e1.printStackTrace();
		   }
		   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   
		Document doc = dBuilder.parse(inputDITAFile);
	 

		 //  OutputStream outputStream = new FileOutputStream(new File("doc.sdif"));
		//   xmlOut = XMLOutputFactory.newInstance().createXMLStreamWriter(
	       //         new OutputStreamWriter(outputStream, "utf-8"));
		/*   xmlOut.writeComment("all elements here are explicitly in the HTML namespace");
		   xmlOut.writeStartDocument("utf-8","1.0");
		   xmlOut.setPrefix("html", "http://www.w3.org/TR/REC-html40");
		   xmlOut.writeStartElement("http://www.w3.org/TR/REC-html40","html");
		   xmlOut.writeNamespace("html", "http://www.w3.org/TR/REC-html40");
		   xmlOut.writeStartElement("http://www.w3.org/TR/REC-html40", "head");
		   xmlOut.writeStartElement("http://www.w3.org/TR/REC-html40", "title");
		   xmlOut.writeComment("DO NOT EDIT THIS FILE\n"); */
		
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
	 
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	 
		NodeList nList = doc.getElementsByTagName("glossentry");
		NodeList glossbodyList = doc.getElementsByTagName("glossbody");
	 
		System.out.println("----------------------------");
	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			Node nNode = nList.item(temp);
	 
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
				xmlOut.writeStartElement("back");
				xmlOut.writeCharacters("\n");
				xmlOut.writeStartElement("glossary");
			//	xmlOut.writeAttribute("id", eElement.getAttribute("id"));
				xmlOut.writeCharacters("\n");
				xmlOut.writeStartElement("glossary-list");
				xmlOut.writeCharacters("\n");
				xmlOut.writeStartElement("gl-item");
				xmlOut.writeCharacters("\n");
				xmlOut.writeStartElement("term");
				xmlOut.writeCharacters("\n");
				xmlOut.writeCharacters(eElement.getElementsByTagName("glossterm").item(0).getTextContent());
				xmlOut.writeCharacters("\n");
				xmlOut.writeEndElement();
				xmlOut.writeCharacters("\n");
				xmlOut.writeStartElement("expansion");
				xmlOut.writeCharacters("\n");
				xmlOut.writeStartElement("p");
				xmlOut.writeCharacters("\n");
				xmlOut.writeCharacters(eElement.getElementsByTagName("glossdef").item(0).getTextContent());
				xmlOut.writeCharacters(" ");
		//		for (int glossBodyCount = 0; glossBodyCount < glossbodyList.getLength(); glossBodyCount++)
			//	{
				//	xmlOut.writeCharacters(eElement.getElementsByTagName("glossSurfaceForm").item(0).getTextContent());
					//xmlOut.writeCharacters(" ");
			//	}
				xmlOut.writeCharacters(eElement.getElementsByTagName("glossSurfaceForm").item(0).getTextContent());
				xmlOut.writeCharacters(" ");
				xmlOut.writeCharacters(eElement.getElementsByTagName("glossAcronym").item(0).getTextContent());
				xmlOut.writeCharacters("\n");
				xmlOut.writeEndElement();
				xmlOut.writeCharacters("\n");
				xmlOut.writeEndElement();
				xmlOut.writeCharacters("\n");
				xmlOut.writeEndElement();
				xmlOut.writeCharacters("\n");
				xmlOut.writeEndElement();
				xmlOut.writeCharacters("\n");
				xmlOut.writeEndElement();
				xmlOut.writeCharacters("\n");				
				
				
				System.out.println("Staff id : " + eElement.getAttribute("id"));
				System.out.println("First Name : " + eElement.getElementsByTagName("glossterm").item(0).getTextContent());
				System.out.println("Last Name : " + eElement.getElementsByTagName("glossdef").item(0).getTextContent());
				System.out.println("Nick Name : " + eElement.getElementsByTagName("glossBody").item(0).getTextContent());
				
			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }

}


}


