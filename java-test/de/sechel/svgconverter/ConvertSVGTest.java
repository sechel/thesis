package de.sechel.svgconverter;

import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Assert;
import org.junit.Test;

public class ConvertSVGTest {

	@Test
	public void testConvertSimple() throws Exception {
		StreamSource svgSource = new StreamSource(getClass().getResourceAsStream("test01.svg"));
		StringWriter resultWriter = new StringWriter();
		Result testResult = new StreamResult(resultWriter);
		ConvertSVGAddStroke.transform(svgSource, testResult);
		Assert.assertEquals(
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + 
			"<svg:svg xmlns:svg=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n" + 
			"<svg:polygon id=\"polygon2\" style=\"fill:#7a7682; stroke:#7a7682;stroke-width:1.0\" points=\" 194.76555151294065 169.6691965873889 123.65704588773411 253.37144396718264 129.14425116980732 258.03305079234366\"/>\n" + 
			"</svg:svg>\n",
			resultWriter.getBuffer().toString()
		);
	}
	
}
