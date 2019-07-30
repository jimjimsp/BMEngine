package com.bmengine.framework;

import com.bmengine.primitives.Interaction;
import com.bmengine.primitives.Position;
import com.bmengine.window.Handler;
import com.bmengine.worldobjects.Interactable;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XMLParser {

    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder builder;
    Handler handler;

    public XMLParser(Handler handler) {

        this.handler = handler;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();

        }
    }


    public Map<String,Interactable> parseInteractables(String filePath) {

        Map<String, Interactable> interactables = new HashMap<>();

        try {
            File interFile = new File(filePath);
            Document doc = builder.parse(interFile);
            doc.getDocumentElement().normalize();
            NodeList interList = doc.getElementsByTagName("interactable");

            for (int i = 0; i < interList.getLength(); i++) {

                Node currInter = interList.item(i);

                if (currInter.getNodeType() == Node.ELEMENT_NODE) {

                    Element interElement = (Element) currInter;
                    String name = interElement.getElementsByTagName("name").item(0).getTextContent();
                    String id = interElement.getElementsByTagName("inter_id").item(0).getTextContent();
                    String[] states = new String[interElement.getElementsByTagName("state").getLength()];
                    Map<String,String> descriptions = new HashMap<String, String>();

                    for( int j = 0; j < interElement.getElementsByTagName("state").getLength(); j++){

                        String stateName = interElement.getElementsByTagName("state").item(j).getTextContent();
                        states[j] = stateName;
                        descriptions.put(stateName, interElement.getElementsByTagName("description").item(j).getTextContent());

                    }

                    Position spawnPosition = new Position(Double.parseDouble(interElement.getElementsByTagName("x").item(0).getTextContent()), Double.parseDouble(interElement.getElementsByTagName("y").item(0).getTextContent()));
                    int width = Integer.parseInt(interElement.getElementsByTagName("width").item(0).getTextContent());
                    int height = Integer.parseInt(interElement.getElementsByTagName("height").item(0).getTextContent());

                    NodeList interactList = interElement.getElementsByTagName("interaction");
                    ArrayList<Interaction> interactions = new ArrayList<>();

                    for (int k = 0; k < interactList.getLength(); k++) {
                        Node currInteract = interactList.item(k);
                        if( currInteract.getNodeType() == Node.ELEMENT_NODE) {
                            Element interactElement = (Element) currInteract;

                            String required_item = interactElement.getElementsByTagName("required_item").item(0).getTextContent();
                            String required_state = interactElement.getElementsByTagName("required_state").item(0).getTextContent();
                            String[] verbs = new String[interactElement.getElementsByTagName("verb").getLength()];
                            
                            for (int k_0 = 0; k_0 < interactElement.getElementsByTagName("verb").getLength(); k_0++) {
                                verbs[k_0] = interactElement.getElementsByTagName("verb").item(k_0).getTextContent();
                            }
                            interactions.add(k, new Interaction(required_item, required_state, verbs));
                        }
                    }
                    interactables.put(id, new Interactable(name, id, states, spawnPosition, width, height, descriptions, interactions, handler));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return interactables;
    }
}
