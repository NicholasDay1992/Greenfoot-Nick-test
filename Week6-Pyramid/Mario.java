import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    private GreenfootImage image;
    
    public Mario()
    {
        image = getImage();
        image.scale(30, 30);
        Greenfoot.setSpeed(15);
    }
    
    public void act()
    {
        //if block in front is not taken
        move(1);
    }
}
