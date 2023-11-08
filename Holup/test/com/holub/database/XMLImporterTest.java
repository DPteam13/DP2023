package com.holub.database;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class XMLImporterTest {

    public void testXMLImporterForPeople() throws IOException, ParserConfigurationException, SAXException {
        String file = "people.xml"; // read people.xml
        XMLImporter xmlImporter = new XMLImporter(file);
        xmlImporter.startTable();
        assertThat(xmlImporter.loadTableName(), is(equalTo("people")));
        assertThat(xmlImporter.loadWidth(), is(equalTo(3)));
    }

    public void testXMLImporterForUniversity() throws IOException, ParserConfigurationException, SAXException {
        String file = "university.xml"; // read university.xml
        XMLImporter xmlImporter = new XMLImporter(file);
        xmlImporter.startTable();
        assertThat(xmlImporter.loadTableName(), is(equalTo("university")));
        assertThat(xmlImporter.loadWidth(), is(equalTo(2)));
    }
}
