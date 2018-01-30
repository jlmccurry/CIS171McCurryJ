import java.util.*;
/**
 *
 * @author jlmcc
 */
public class TestGeometricObject {
    
    public static void main(String[] args){
    
    // Initialize two geometric objects
    GeometricObject geometricObject1 = new Circle(7);
    GeometricObject geometricObject2 = new Rectangle(4, 6);
    
    // State the area of the two objects
    double object1 = geometricObject1.getArea();
    double object2 = geometricObject2.getArea();
    
    // Print the area of each object
    System.out.println("Area of object 1: " + object1);
    System.out.println("Area of object 2: " + object2);
    
    // Print the object that has the max area
    System.out.println("The largest object has an area of " + GeometricObject.max(object1, object2));
    }
}
