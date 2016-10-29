package com.pr.gfce.util;

import com.pr.gfce.exception.TransformException;
import com.sun.jmx.remote.internal.Unmarshal;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author Oscar Blancarte
 */
public class XMLConverter {

    public static String toJson(Object obj, Class clazz, boolean format) throws TransformException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, format);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(obj, stream);
            return new String(stream.toByteArray());
        } catch (Exception e) {
            throw new TransformException(e.getMessage(), e);
        }
    }

    public static <T> T toObject(String xml, Class<T> clazz) throws TransformException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes());
            return (T) unmarshaller.unmarshal(stream);
        } catch (Exception e) {
            throw new TransformException(e.getMessage(), e);
        }
    }

    public static String getRootNameElement(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);

            factory.setExpandEntityReferences(false);

            Document doc = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));

            Element root = null;

            NodeList list = doc.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                if (list.item(i) instanceof Element) {
                    root = (Element) list.item(i);
                    break;
                }
            }
            root = doc.getDocumentElement();
            return root.getTagName();
            
        } catch (Exception e) {
            throw new RuntimeException("No fue posible determinar el nodo Raíz");
        }

    }

}
