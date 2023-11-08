package com.holub.database;

import java.io.*;
import java.util.Iterator;

public class HTMLExporter implements Table.Exporter{
	public void startTable()			throws IOException{

	};
	public void storeMetadata(
			String tableName,
			int width,
			int height,
			Iterator columnNames )	throws IOException{

	};
	public void storeRow(Iterator data) throws IOException{

	};
	public void endTable()			 	throws IOException{

	};
}