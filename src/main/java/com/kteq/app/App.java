package com.kteq.app;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.util.Matrix;

/**
 * Hello world!
 *
 */
public class App  {
    public App() {
    }

    public static void main( String[] args ) throws IOException {


        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);

        String txt = "_8*L0G0L4G1G7L2**R0R6R0R4R0R6*";

        PDPageContentStream contentStream = new PDPageContentStream(doc, doc.getPage(0), PDPageContentStream.AppendMode.APPEND, true, true);

        contentStream.beginText();
        PDFont font = PDType0Font.load(doc, new File("src/main/resources/MyEan13.ttf"));

        contentStream.setFont(font, 80);
        contentStream.newLineAtOffset(20, 200);

        //contentStream.setTextMatrix(new Matrix(0.3f*element.getWidth() / width, 0, 0, 0.4f*element.getHeight() / height, currentx, currenty));

        System.err.println("TXT: "+txt);
        contentStream.showText(txt);

        contentStream.endText();

        contentStream.close();

        doc.save("/tmp/sample.pdf");


        System.out.println( "saved" );
    }
}
