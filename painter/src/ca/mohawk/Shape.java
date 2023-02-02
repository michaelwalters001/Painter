/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.mohawk;

/**
 *
 * @author Michael Walters
 *
 * This class holds of all of the information being stored to then be pull when the user wants to draw on the application
 */
class Shape {
    private int width, hieght, drawValue, colorOne, colorTwo, colorThree, radius;

    public Shape(int width, int hieght, int drawValue, int colorOne, int colorTwo, int colorThree, int radius) {
        this.width = width;
        this.hieght = hieght;
        this.drawValue = drawValue;
        this.colorOne = colorOne;
        this.colorTwo = colorTwo;
        this.colorThree = colorThree;
        this.radius = radius;
    }
     

    

    public int getDrawValue() {
        return this.drawValue;
    }


    public int getWidth() {
        return this.width;
    }

    public int getHieght() {
        return this.hieght;
    }

    public int getColorOne() {
        return colorOne;
    }

    public int getColorTwo() {
        return colorTwo;
    }

    public int getColorThree() {
        return colorThree;
    }

    public int getRadius() {
        return radius;
    }
    
    
    
}
