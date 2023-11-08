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
		out.write(tableName == null ? "<table>" : tableName );
		out.write("\n");
		storeRow( columnNames ); // comma separated list of columns ids
		out.write(tableName == null ? "</table>" : tableName);
	};
	public void storeRow(Iterator data) throws IOException
	{	int i = width;
		out.write("<tr><td>");
		while( data.hasNext())
		{	Object datum = data.next();
			if( datum != null)
				out.write(datum.toString());
			if(--i > 0) {
				out.write("</td><td>");
			}
		}
		out.write("</td></tr>");

	};
	public void startTable() throws IOException{/* nothing to do*/};
	public void endTable()	throws IOException{/* nothing to do*/};
}