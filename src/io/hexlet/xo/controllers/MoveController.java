package io.hexlet.xo.controllers;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exception.AlreadyOccupaiedException;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws InvalidPointException,
                                                        AlreadyOccupaiedException {

        if (field.getFigure(point) != null) {
            throw new AlreadyOccupaiedException();
        }
        field.setFigure(point,figure);

    }
}
