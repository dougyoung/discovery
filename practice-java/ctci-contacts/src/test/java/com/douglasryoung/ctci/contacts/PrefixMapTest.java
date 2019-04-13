package com.douglasryoung.ctci.contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

class PrefixMapTest {

    private PrefixMap prefixMap;

    @BeforeEach
    void setUp() {
        prefixMap = new PrefixMap();
    }

    @Test
    void insert() {
        assertFalse(prefixMap.containsKey("h"));
        assertFalse(prefixMap.containsKey("ha"));
        assertFalse(prefixMap.containsKey("hac"));
        assertFalse(prefixMap.containsKey("hack"));

        prefixMap.insert("hack");

        assertTrue(prefixMap.containsKey("h"));
        assertTrue(prefixMap.containsKey("ha"));
        assertTrue(prefixMap.containsKey("hac"));
        assertTrue(prefixMap.containsKey("hack"));

        assertEquals(prefixMap.get("h").size(),  1);
        assertEquals(prefixMap.get("ha").size(),  1);
        assertEquals(prefixMap.get("hac").size(),  1);
        assertEquals(prefixMap.get("hack").size(),  1);

        assertTrue(prefixMap.get("h").contains("hack"));
        assertTrue(prefixMap.get("ha").contains("hack"));
        assertTrue(prefixMap.get("hac").contains("hack"));
        assertTrue(prefixMap.get("hack").contains("hack"));

        prefixMap.insert("hackerrank");

        assertTrue(prefixMap.containsKey("h"));
        assertTrue(prefixMap.containsKey("ha"));
        assertTrue(prefixMap.containsKey("hac"));
        assertTrue(prefixMap.containsKey("hack"));
        assertTrue(prefixMap.containsKey("hacke"));
        assertTrue(prefixMap.containsKey("hacker"));
        assertTrue(prefixMap.containsKey("hackerr"));
        assertTrue(prefixMap.containsKey("hackerra"));
        assertTrue(prefixMap.containsKey("hackerran"));
        assertTrue(prefixMap.containsKey("hackerrank"));

        assertEquals(prefixMap.get("h").size(), 2);
        assertEquals(prefixMap.get("ha").size(), 2);
        assertEquals(prefixMap.get("hac").size(),  2);
        assertEquals(prefixMap.get("hack").size(),  2);
        assertEquals(prefixMap.get("hacke").size(),  1);
        assertEquals(prefixMap.get("hacker").size(),  1);
        assertEquals(prefixMap.get("hackerr").size(),  1);
        assertEquals(prefixMap.get("hackerra").size(),  1);
        assertEquals(prefixMap.get("hackerran").size(),  1);
        assertEquals(prefixMap.get("hackerrank").size(),  1);

        assertEquals(prefixMap.get("h"), Arrays.asList("hack", "hackerrank"));
        assertEquals(prefixMap.get("ha"), Arrays.asList("hack", "hackerrank"));
        assertEquals(prefixMap.get("hac"), Arrays.asList("hack", "hackerrank"));
        assertEquals(prefixMap.get("hack"), Arrays.asList("hack", "hackerrank"));
        assertEquals(prefixMap.get("hacke"), Collections.singletonList("hackerrank"));
        assertEquals(prefixMap.get("hacker"), Collections.singletonList("hackerrank"));
        assertEquals(prefixMap.get("hackerr"), Collections.singletonList("hackerrank"));
        assertEquals(prefixMap.get("hackerra"), Collections.singletonList("hackerrank"));
        assertEquals(prefixMap.get("hackerran"), Collections.singletonList("hackerrank"));
        assertEquals(prefixMap.get("hackerrank"), Collections.singletonList("hackerrank"));
    }

    @Test
    void search() {
        assertEquals(prefixMap.search("hack"),  0);
        assertEquals(prefixMap.search("hackerrank"),  0);
        assertEquals(prefixMap.search("hak"),  0);

        prefixMap.insert("hack");

        assertEquals(prefixMap.search("hack"),  1);
        assertEquals(prefixMap.search("hackerrank"),  0);
        assertEquals(prefixMap.search("hak"),  0);

        prefixMap.insert("hackerrank");

        assertEquals(prefixMap.search("hack"),  2);
        assertEquals(prefixMap.search("hackerrank"),  1);
        assertEquals(prefixMap.search("hak"),  0);
    }
}
