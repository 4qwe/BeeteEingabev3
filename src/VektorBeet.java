import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* Vektorbeet - schreibt die Formen aller plots in die Canvas */
public class VektorBeet {

    public Document buildVek(Beet[] alle) {
        DOMImplementation impel = SVGDOMImplementation.getDOMImplementation();
        Document das_svg_dokument = impel.createDocument("http://www.w3.org/2000/svg", "svg", null);
        Element svg_root = das_svg_dokument.getDocumentElement(); //root node (?) des SVG Documents
        svg_root.setAttributeNS(null, "width", "140"); /*todo Canvasgröße woher*/
        svg_root.setAttributeNS(null, "height", "70");
        for (int i = 0; i < alle.length; i++) {
            Element poly = das_svg_dokument.createElementNS("http://www.w3.org/2000/svg", "polygon");
            poly.setAttributeNS(null, "points", alle[i].points);
            poly.setAttributeNS(null, "fill", "none");
            poly.setAttributeNS(null, "stroke", "black");
            poly.setAttributeNS(null, "stroke-width", "2");
            svg_root.appendChild(poly);
        }
        return das_svg_dokument;
    }

}