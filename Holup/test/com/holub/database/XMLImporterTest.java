package com.holub.database;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLImporterTest {
    @org.junit.jupiter.api.Test
    void XMLImport() throws IOException {

        String ans = "address";
        try {
            String testFile = "C:\\DP2023\\Holup\\people.xml";
            XMLImporter builder = new XMLImporter(testFile);
            System.out.println(builder.loadTableName());
            assertEquals(builder.loadTableName(),ans );
            assertEquals(builder.loadWidth(), 5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
