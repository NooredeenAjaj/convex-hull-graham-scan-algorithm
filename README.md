# convex-hull-graham-scan-algorithm



This project is a Java implementation of the Graham's Scan algorithm.

Description

The Graham's Scan algorithm is used to find the convex hull of a given set of points in a plane. A convex hull is the smallest convex polygon that contains all the points in a given set. This implementation takes an input of x, y coordinates and generates a convex hull.

# Features

The project contains the following main methods:

main(): Runs the whole program, including inputting data and calling the grahamScan() method.
grahamScan(): Implementation of the Graham's Scan algorithm. This method takes a list of points as input and returns the convex hull as a list of points.
orientation(): Computes the orientation of ordered triple points.
sortMeDady(): Sorts the points according to their polar angle.
print(): Prints out the coordinates up to three decimal places.
Point: An class representing a point with x, y coordinates.
Usage

The program takes a sequence of x, y coordinate pairs, each pair representing a point in the plane. The points are separated by a "#" symbol.

Example input:

1.2#2.3
2.3#3.4
3.4#4.5
...
Once all the points have been input, the program outputs the convex hull as a sequence of x, y coordinates. 
If the input coordinates are integers, they are output as integers, otherwise, they are output with three decimal places.
