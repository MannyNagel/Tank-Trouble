/** 
 * This is a generic interface, for example, you 
 *    might declare:
 *   public class Cat implements Overlapable<Cat>
 *    and that means that Cat variables can be checked for overlap
 *    with other Cat variables
 */
public interface Overlapable<T> {
 
  // returns true if any portion of this rectangle 
  //   overlaps other rectangle
  boolean anyOverlap(T other);
  
  // returns true if center of this is within 5 pixels
  //   of the center of other along x and y.
  boolean centralOverlap(T other);
  
}