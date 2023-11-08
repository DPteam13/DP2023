package com.holub.database;

import java.io.*;
import java.util.Iterator;

public class HTMLExporter implements Table.Exporter{
	private final Writer out;

	private		int		width;

	public HTMLExporter( Writer out )
	{	this.out = out;
	}
	public void storeMetadata(
			String tableName,
			int width,
			int height,
			Iterator columnNames )	throws IOException
	{	this.width = width;
		while(columnNames.hasNext())
		{
			Object columnName = columnNames.next();
			if (columnName != null)
				out.write("<th>" + columnName.toString() + "</td>");
			else
				out.write("<td></td>");
		}

	};
	public void storeRow(Iterator data) throws IOException
	{	int i = width;
		out.write("<tr>");
		while( data.hasNext())
		{	Object datum = data.next();
			if( datum != null)
				out.write("<td>" + datum.toString() + "</td>");
			else
				out.write("<td></td>");
		}
		out.write("</tr>");

	};
	public void startTable() throws IOException
	{
		out.write("<table>");
	};
	public void endTable()	throws IOException
	{
		out.write("</table>");
	};
}