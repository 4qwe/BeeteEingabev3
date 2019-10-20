package beete;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

/*Grafikmethoden und Fileoutput für Beeteobjekte*/
public class VektorBeet {


    /* Methode schreibt die Formen aller plots in die Canvas */
    public Document buildVek(Beet[] alle) {
        DOMImplementation impel = SVGDOMImplementation.getDOMImplementation();
        Document das_svg_dokument = impel.createDocument("http://www.w3.org/2000/svg", "svg", null);
        Element svg_root = das_svg_dokument.getDocumentElement(); //root node (?) des SVG Documents
        svg_root.setAttributeNS(null, "width", "140"); /*todo Canvasgröße woher*/
        svg_root.setAttributeNS(null, "height", "70");
        /*Loop schreibt für jedes Element im Plotsarray ein Poly-Element und heftet es an SVG node (DOM)*/
        for (int i = 0; i < alle.length; i++) {
            Element poly = das_svg_dokument.createElementNS("http://www.w3.org/2000/svg", "polygon");
            poly.setAttributeNS(null, "points", alle[i].getPoints());
            poly.setAttributeNS(null, "fill", "none");
            poly.setAttributeNS(null, "stroke", "black");
            poly.setAttributeNS(null, "stroke-width", "2");
            svg_root.appendChild(poly);
        }
        return das_svg_dokument;
    }

    /* Methode schreibt String aus SVG Document */
    public String getStringFromDocument(Document doc) {
        try {
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            return writer.toString();
        }
        catch (TransformerException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /*Methode schreibt String in eine Datei*/
    public void stringToFile(String s, String outFile) throws FileNotFoundException {
        PrintWriter prntWrtr = new PrintWriter(outFile); /*Exception kommt hier vor*/
        prntWrtr.println(s);
        prntWrtr.close();
    }

}