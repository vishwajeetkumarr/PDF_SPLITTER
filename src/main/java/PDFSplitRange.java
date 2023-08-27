import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFSplitRange {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("///home/vishwajeet/Desktop/PDF/sample.PDF");  //INPUT FILE PATH
        PDDocument document = PDDocument.load(oldFile);
        File newFileDestination = new File("///home/vishwajeet/Desktop/PDF/extract");  //OUTPUT FILE PATH
        //newFileDestination.mkdirs();

        Splitter splitter = new Splitter();

        //SET RANGE
        splitter.setStartPage(5); //START RANGE
        splitter.setEndPage(8);  //END RANGE

        List<PDDocument> splitPages = splitter.split(document);

        PDDocument newDoc = new PDDocument();
        for(PDDocument mydoc : splitPages)
        {
            newDoc.addPage(mydoc.getPage(0));
        }
        newDoc.save(newFileDestination+"/split.pdf");// SPLIT FILE NAME
        newDoc.close();
        System.out.println("PDF Splitted");
    }
}
