package com.befun.util.input.impl.access.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestParseUtils {

    @Test
    public void testOrientationEast() {
        Short orientation = 1;
        assertTrue(ParseUtils.getEast(orientation));
    }

    @Test
    public void testOrientationSouth() {
        Short orientation = 1;
        assertFalse(ParseUtils.getSouth(orientation));
    }

    @Test
    public void testOrientationWest() {
        Short orientation = 1;
        assertFalse(ParseUtils.getWest(orientation));
    }

    @Test
    public void testOrientationNorth() {
        Short orientation = 1;
        assertFalse(ParseUtils.getNorth(orientation));
    }

    @Test
    public void testOrientationEast1() {
        Short orientation = 2;
        assertFalse(ParseUtils.getEast(orientation));
    }

    @Test
    public void testOrientationSouth1() {
        Short orientation = 2;
        assertTrue(ParseUtils.getSouth(orientation));
    }

    @Test
    public void testOrientationWest1() {
        Short orientation = 2;
        assertFalse(ParseUtils.getWest(orientation));
    }

    @Test
    public void testOrientationNorth1() {
        Short orientation = 2;
        assertFalse(ParseUtils.getNorth(orientation));
    }

    @Test
    public void testOrientationEast2() {
        Short orientation = 3;
        assertTrue(ParseUtils.getEast(orientation));
    }

    @Test
    public void testOrientationSouth2() {
        Short orientation = 3;
        assertTrue(ParseUtils.getSouth(orientation));
    }

    @Test
    public void testOrientationWest2() {
        Short orientation = 3;
        assertFalse(ParseUtils.getWest(orientation));
    }

    @Test
    public void testOrientationNorth2() {
        Short orientation = 3;
        assertFalse(ParseUtils.getNorth(orientation));
    }

    @Test
    public void testOrientationEast3() {
        Short orientation = 12;
        assertFalse(ParseUtils.getEast(orientation));
    }

    @Test
    public void testOrientationSouth3() {
        Short orientation = 12;
        assertFalse(ParseUtils.getSouth(orientation));
    }

    @Test
    public void testOrientationWest3() {
        Short orientation = 12;
        assertTrue(ParseUtils.getWest(orientation));
    }

    @Test
    public void testOrientationNorth3() {
        Short orientation = 12;
        assertTrue(ParseUtils.getNorth(orientation));
    }
}
