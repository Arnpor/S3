package com.company;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.Iterator;

public class PointSET {
    SET set;

    //constructs an empty set of points
    public PointSET(){
        set = new SET();
    }

    //is the set empty?
    public boolean isEmpty(){
        return set.isEmpty();
    }

    //returns set's size
    public int size(){
        return set.size();
    }

    //adds the point p to the set
    public void insert(Point2D p){
        if (p.x() > 1 || p.x() < 0 || p.y() > 1 || p.y() < 0){
            System.out.println("Point is out of bounds");
            return;
        }
        set.add(p);
    }

    //does the set contain the point p?
    public boolean contains(Point2D p){
        return set.contains(p);
    }

    // draw all the points to standard draw
    public void draw(){
        double offset = 0.90;
        StdDraw.setCanvasSize(600,600);
        StdDraw.setPenRadius(0.01);
        StdDraw.line(0, 1.0-offset, 1, 1.0-offset);
        StdDraw.line(1.0-offset, 0, 1.0-offset, 1);
        double pos = 0.1;
        StdDraw.setPenRadius(0.001);
        for (int i = 0; i < 10; i++) {
            StdDraw.line(0, pos*offset+0.1, 1, pos*offset+0.1);
            StdDraw.line(pos*offset+0.1, 0, pos*offset+0.1, 1);
            pos+=0.1;
        }
        Iterator points = set.iterator();
        StdDraw.setPenRadius(0.03);
        while (points.hasNext()){
            Point2D point = (Point2D) points.next();
            double x = point.x();
            double y = point.y();
            StdDraw.point(x*offset+0.1,y*offset+0.1);
        }
    }
    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect){
        Iterator points = set.iterator();
        ArrayList inbox = new ArrayList();
        while (points.hasNext()){
            Point2D point = (Point2D) points.next();
            boolean withinX = point.x() > rect.xmin() && point.x() < rect.xmax();
            boolean withinY = point.y() > rect.ymin() && point.y() < rect.ymax();
            if (withinX && withinY){
                inbox.add(point);
            }
        }
        return inbox;
    }

    public Point2D nearest(Point2D p){
        Iterator points = set.iterator();
        double nearestDistance = 0.0;
        Point2D nearestPoint = null;
        while (points.hasNext()){
            Point2D point = (Point2D) points.next();
            double dist = p.distanceTo(point);
            if (point == null){
                return null;
            }
            if (point.equals(p)){
                ;
            }
            else if (nearestPoint == null){
                nearestPoint = point;
                nearestDistance = dist;
            }
            else if(dist < nearestDistance){
                nearestPoint = point;
                nearestDistance = dist;
            }
        }
        return nearestPoint;
    }

}
