package com.holub.database;

import com.holub.tools.ArrayIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
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

    public XMLImporter(String in) throws IOException {
		this.in = in;
		this.startTable();
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
        
		NodeList TagList1 = document.getElementsByTagName("row");

		columnNames = new String[TagList1.item(0).getChildNodes().getLength()];
		rows = new String[TagList1.getLength()][TagList1.item(0).getChildNodes().getLength()];

		for(int i=0; i < TagList1.getLength(); i++){//row수 만큼 반복
			Node row = TagList1.item(i);

			for(int j=0; j < row.getChildNodes().getLength(); j++){//column수 만큼 반복
				Node node = row.getChildNodes().item(j);

				if(node.getNodeType() == Node.ELEMENT_NODE) {
					if (i == 0 ){
						columnNames[j] = node.getNodeName();
					}
					rows[i][j] = node.getTextContent();
				}
			}
		}
		tableName = document.getDocumentElement().getNodeName();
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
		return new ArrayIterator(rows);
	}

	@Override
	public void endTable() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
