package io.hexlet.xo.model;

import io.hexlet.xo.model.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Alenka on 29.10.2015.
 */
public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field();

        assertEquals(3,field.getSize());

    }

    @Test
    public void testSetFigure() throws Exception {

        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure,actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureNotSet() throws Exception {

        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXLessThenZero() throws Exception {

        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);

        try {

            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e) {

        }

    }
}