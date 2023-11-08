package com.holub.database;
import com.holub.tools.ArrayIterator;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Iterator;

public class XMLImporter implements Table.Importer {
	private String in;
    private String[] columnNames;
    private String tableName;
    private String[][] rows;

    public XMLImporter(String in) {
        this.in = in;
    }

	@Override
	public void startTable() throws IOException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Document document = null;
		try {
			document = builder.parse(in);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        document.getDocumentElement().normalize();
        
        NodeList TagList1 = document.getElementsByTagName("DATA");
        NodeList childNodes = TagList1.item(0).getChildNodes();
        columnNames = new String[childNodes.getLength()];
        rows = new String[TagList1.getLength()][childNodes.getLength()];
        for (int i = 0; i < TagList1.getLength(); i++) {
            childNodes = TagList1.item(i).getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                columnNames[j] = childNodes.item(j).getNodeName();
                rows[i][j] = (childNodes.item(j).getTextContent());
            }
        }
        NodeList TagList2 = document.getElementsByTagName("title");
        tableName = TagList2.item(0).getTextContent();
		
	}

	@Override
	public String loadTableName() throws IOException {
		return tableName;
	}

	@Override
	public int loadWidth() throws IOException {
		return columnNames.length;
	}

	@Override
	public Iterator loadColumnNames() throws IOException {
		return new ArrayIterator(columnNames);
	}

	@Override
	public Iterator loadRow() throws IOException {
		return null;
	}

	@Override
	public void endTable() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
