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
		ConvertSVG.transform(svgSource, testResult);
		Assert.assertEquals("", resultWriter.getBuffer().toString());
	}
	
}
