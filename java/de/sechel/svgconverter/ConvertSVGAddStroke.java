package de.sechel.svgconverter;

import java.io.File;
import java.io.InputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConvertSVGAddStroke {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("usage: ConvertSVG <infile> <outfile>");
			return;
		}
		File inFile = new File(args[0]);
		File outFile = new File(args[1]);
		StreamResult result = new StreamResult(outFile);
		StreamSource source = new StreamSource(inFile);
		transform(source, result);
	}
	
	
	static void transform(StreamSource source, Result result) throws Exception {
		InputStream xslIn = ConvertSVGAddStroke.class.getResourceAsStream("addstroke.xsl");
		StreamSource xslSource = new StreamSource(xslIn);
		Transformer T = TransformerFactory.newInstance().newTransformer(xslSource);
		T.setOutputProperty(OutputKeys.INDENT, "yes");
		T.transform(source, result);
	}
	
}
