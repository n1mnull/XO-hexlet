package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field){
        try {
            for (int i=0;i<3;i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1)))
                    return field.getFigure(new Point(i, 0));}
            for (int i=0;i<3;i++) {
                if (check(field, new Point(0, i), p -> new Point(p.x+1, p.y)))
                    return field.getFigure(new Point(0, i));}

            if (check(field, new Point(0, 0), p -> new Point(p.x+1, p.y+1)))
                return field.getFigure(new Point(1,1));
            if (check(field, new Point(0, 2), p -> new Point(p.x+1, p.y-1)))
                return field.getFigure(new Point(1,1));








            /* ¬ тупую перебор линий длиной 3 €чейки
            for (int i=0;i<3;i++){
                if (check(field, new Point(i,0), new Point(i,1), new Point(i,2)))
                    return field.getFigure(new Point(i,0));
            }
            for (int i=0;i<3;i++){
                if (check(field, new Point(0,i), new Point(1,i), new Point(2,i)))
                    return field.getFigure(new Point(0,i));
            }
            if (check(field, new Point(0,0), new Point(1,1), new Point(2,2)))
                return field.getFigure(new Point(1,1));
            if (check(field, new Point(0,2), new Point(1,1), new Point(2,0)))
                return field.getFigure(new Point(1,1));*/

            /* ѕеребор с использованием генератора €чеек начина€ с заданной
            for (int i=0;i<3;i++) {
                if (check(field, new Point(i, 0), new IPointChanger() {
                    @Override
                    public Point next(Point p) {
                        return new Point(p.x, p.y + 1);
                    }
                }))
                    return field.getFigure(new Point(i, 0));
            }

            for (int i=0;i<3;i++) {
                if (check(field, new Point(0, i), new IPointChanger() {
                    @Override
                    public Point next(Point p) {
                        return new Point(p.x+1, p.y);
                    }
                }))
                    return field.getFigure(new Point(0, i));
            }

            if (check(field, new Point(0, 0), new IPointChanger() {
                @Override
                public Point next(Point p) {
                    return new Point(p.x+1, p.y+1);
                }
            }))
                return field.getFigure(new Point(0, 0));

            if (check(field, new Point(0, 2), new IPointChanger() {
                @Override
                public Point next(Point p) {
                    return new Point(p.x+1, p.y-1);
                }
            }))
                return field.getFigure(new Point(0, 2));*/


        }

        catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*private boolean check(final Field field, final Point startPoint, final IPointChanger pointChanger){
        final Point p1 = startPoint;
        final Point p2 = pointChanger.next(p1);
        final Point p3 = pointChanger.next(p2);*/
    //private boolean check(final Field field, final Point p1, final Point p2, final Point p3){

    private boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator){
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);
        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;

        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointGenerator);

        /*try {
            if (field.getFigure(p1)==null) return false;
            if (field.getFigure(p1) == field.getFigure(p2) &&
                    field.getFigure(p1) == field.getFigure(p3)) return true;
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;*/
    }

    private interface IPointGenerator {
        public Point next (final Point point);
    }


}
