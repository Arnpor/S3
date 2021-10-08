package com.company;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdRandom;

public class Main {

    public static void main(String[] args) {
        PointSET p = new PointSET();
        for (int i = 0; i < 10; i++) {
            double x = StdRandom.uniform(0.0, 1.0);
            double y = StdRandom.uniform(0.0, 1.0);
            p.insert(new Point2D(x,y));
        }
        double nearx = StdRandom.uniform(0.0, 1.0);
        double neary = StdRandom.uniform(0.0, 1.0);
        p.draw();
        Point2D nearest = new Point2D(nearx,neary);
        System.out.println("Point nearest: "+nearest.toString()+"\n"+p.nearest(nearest));
        RectHV topright = new RectHV(0.5,0.5,1,1);
        RectHV bottomright = new RectHV(0.5,0,1,0.5);
        RectHV bottomleft = new RectHV(0,0,0.5,0.5);
        RectHV topleft = new RectHV(0,0.5,0.5,1);
        System.out.println("Top Right Quardrant: "+p.range(topright));
        System.out.println("Bottom Right Quardrant: "+p.range(bottomright));
        System.out.println("Bottom Left Quardrant: "+p.range(bottomleft));
        System.out.println("Top Left Quardrant: "+p.range(topleft));
    }
}
