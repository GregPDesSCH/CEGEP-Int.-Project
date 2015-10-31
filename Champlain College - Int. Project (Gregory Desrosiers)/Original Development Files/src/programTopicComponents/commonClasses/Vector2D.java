/**
 * Desrosiers Mechanics Teaching Tool - Vector2D Class
 * 
 * Replicates any two-dimensional vectors using two data fields, holding the components of the
 * vector, and several methods to perform same operations as actual vectors; add, subtract,
 * even multiply with a scalar.
 * 
 * Because many different physics equations involve the use of vectors, this class will be
 * used to feed the necessarily variables in order to solve for a resulting quantity or another
 * vector as part of the problem solution process.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 22, 2014 - Feb 24, 2014)
 * 
 * UPDATE: March 7, 2014 - Cardinal Based Angle fixed.
 * March 8, 2014 - Two methods added: getXComponent, getYComponent.
 * March 10, 2014 - Problem still existing with Cardinal Based Angle method is now solved.
 * April 26, 2014 - Class is no longer immutable; individual components can be set.
 * April 27, 2014 - Independent direction of the vector can be now set.
 * May 3, 2014 - setDirection method corrected.
 * May 13, 2014 - Final comments and changes made.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programTopicComponents.commonClasses;

public class Vector2D
{
	// Vector Components
	private double xComponent;
	private double yComponent;
	
	/**
	 * Creates an instance of Vector2D with the components set to 0.
	 */
	
	public Vector2D()
	{
		xComponent = 0.0;
		yComponent = 0.0;
	}
	
	/**
	 * Creates an instance of Vector2D with specified components.
	 * @param xComponent A value representing the X component of the vector.
	 * @param yComponent A value representing the Y component of the vector.
	 */
	public Vector2D(double xComponent, double yComponent)
	{
		this.xComponent = xComponent;
		this.yComponent = yComponent;
	}
	
	/**
	 * Sets the components of this vector.
	 * @param xComponent A value representing the X component of the vector.
	 * @param yComponent A value representing the Y component of the vector.
	 */
	public void setComponents(double xComponent, double yComponent)
	{
		this.xComponent = xComponent;
		this.yComponent = yComponent;
	}
	
	/**
	 * Sets the direction, based on the unit circle, of this vector.
	 * @param angleInRadians The new unit circle direction of this vector in radians.
	 */
	public void setDirection(double angleInRadians)
	{
		double magnitude = magnitude();
		
		if (angleInRadians == Math.PI / 2)
		{
			xComponent = 0.0;
			yComponent = magnitude;
		}
		else if (angleInRadians == Math.PI)
		{
			xComponent = -magnitude;
			yComponent = 0.0;
		}
		else if (angleInRadians == 3 * Math.PI / 2)
		{
			xComponent = 0.0;
			yComponent = -magnitude;
		}
		else if (angleInRadians == 0.0 || angleInRadians == 2 * Math.PI)
		{
			xComponent = magnitude;
			yComponent = 0.0;
		}
		else 
		{
			xComponent = magnitude * Math.cos(angleInRadians);
			yComponent = magnitude * Math.sin(angleInRadians);
		}
	}
	
	/**
	 * Adds this vector with another vector, resulting in a vector congruent to the
	 * summed vectors. Particularly, the components of this vector are added with the
	 * components of the vector passed here.
	 * 
	 * @param secondComponent The secondary vector the first will be added by.
	 * @return New Vector2D with the addition in place.
	 */
	
	public Vector2D add(Vector2D secondComponent)
	{
		return new Vector2D(this.xComponent + secondComponent.xComponent,
				this.yComponent + secondComponent.yComponent);
	}
	
	/**
	 * Adds, to this vector, the individual components.
	 * @param xComponent
	 * @param yComponent
	 * @return	New Vector2D with the addition in place.
	 */
	
	public Vector2D add(double xComponent, double yComponent)
	{
		return new Vector2D(this.xComponent + xComponent, this.yComponent + yComponent);
	}
	
	/**
	 * Subtracts this vector with another vector; essentially, it's adding a vector,
	 * but that vector is in the opposite direction as it is multiplied with a multiple,
	 * known as a scalar, of -1.
	 * 
	 * @param secondVector
	 * @return New Vector2D with the subtraction in place.
	 */
	
	public Vector2D subtract(Vector2D secondVector)
	{
		return new Vector2D(this.xComponent - secondVector.xComponent, this.yComponent - secondVector.yComponent);
	}
	
	/**
	 * Subtracts, to this vector, the individual components.
	 * @param xComponent
	 * @param yComponent
	 * @return New Vector2D with the subtraction in place.
	 */
	
	public Vector2D subtract(double xComponent, double yComponent)
	{
		return new Vector2D(this.xComponent - xComponent, this.yComponent - yComponent);
	}
	
	/**
	 * 
	 * @param scalar
	 * @return
	 */
	
	public Vector2D multiply(double scalar)
	{
		return new Vector2D(scalar * this.xComponent, scalar * this.yComponent);
	}
	
	/**
	 * Divides this vector by a given factor. If you pass 0, the components will be
	 * treated as "Infinity," and thus the methods intended to return a value won't
	 * work properly.
	 * 
	 * Calculating an angle from this 'infinite' object returns NaN, "Not a Number."
	 * 
	 * @param factor
	 * @return A Vector2D with its components divided.
	 */
	
	public Vector2D divide(double factor)
	{
		return new Vector2D(this.xComponent / factor, this.yComponent / factor);
	}
	
	/**
	 * Returns the length of the vector by the Pythagoras Theorem.
	 * @return Vector magnitude.
	 */
	
	public double magnitude()
	{
		return Math.sqrt(Math.pow(xComponent, 2.0) + Math.pow(yComponent, 2.0));
	}
	
	/**
	 * Calculates the angle of the vector, namely in a counterclockwise circular
	 * fashion.
	 * @return A double indicating an angle in the following range: 0 <= theta < 2pi radians.
	 */
	
	public double calculateCardinalBasedAngle()
	{
		if (xComponent > 0 && yComponent >= 0)
			return Math.atan(yComponent / xComponent);
		else if (xComponent == 0 && yComponent > 0)
			return Math.PI / 2;
		else if (xComponent == 0 && yComponent == 0)
			return 0;
		else if (xComponent == 0 && yComponent < 0)
			return 3 * Math.PI / 2;
		else if (xComponent < 0)
			return Math.atan(yComponent / xComponent) + Math.PI;
		else
			return Math.atan(yComponent / xComponent) + 2 * Math.PI;
	}
	
	/**
	 * Calculates the angle of the vector based on the X axis of the first quadrant of
	 * a Cartesian plane, with its origin at (0,0).
	 * 
	 * @return The angle of the vector relative to the x-axis of a
	 * positive Cartesian plane, or 0 < theta < pi radians above,
	 * 0 > theta > -pi below.
	 */
	
	public double calculateUnitCircleBasedAngle()
	{
		if (xComponent < 0 && yComponent == 0)
			return Math.PI;
		else if (yComponent >= 0 || (xComponent >= 0 && yComponent < 0))
			return Math.atan(yComponent / xComponent);
		else
			return Math.atan(yComponent / xComponent) - Math.PI;
	}
	
	/**
	 * Calculates the cross product between two vectors; namely, the magnitude of this vector
	 * times the magnitude of the second vector passed here, and the angle between the vectors
	 * as calculated from this class.
	 * 
	 * Take note that the cross product vector points in a direction not specified in this class,
	 * because depending on the vectors, it will either have a positive z component or a negative
	 * z component.
	 * @param secondVector The secondary vector to be used in the vector cross product.
	 * @return The magnitude of the cross product vector. Take note that if it's positive, then the
	 * vector is out of the screen. It's into the screen if negative.
	 */
	
	public double crossProduct(Vector2D secondVector)
	{
		if (secondVector.calculateCardinalBasedAngle() - this.calculateCardinalBasedAngle() == Math.PI ||
				secondVector.calculateCardinalBasedAngle() - this.calculateCardinalBasedAngle() == -Math.PI)
			return 0;
		else
			return this.magnitude() * secondVector.magnitude() * Math.sin(secondVector.calculateCardinalBasedAngle() - this.calculateCardinalBasedAngle());
	}
	
	/**
	 * Calculates the dot product of this vector and another vector passed into this method.
	 * 
	 * @param secondVector
	 * @return The magnitude of the dot product vector.
	 */
	
	public double dotProduct(Vector2D secondVector)
	{
		if (secondVector.calculateCardinalBasedAngle() - this.calculateCardinalBasedAngle() == Math.PI / 2 ||
				secondVector.calculateCardinalBasedAngle() - this.calculateCardinalBasedAngle() == -Math.PI / 2)
			return 0;
		else
			return this.magnitude() * secondVector.magnitude() * Math.cos(secondVector.calculateCardinalBasedAngle() - this.calculateCardinalBasedAngle());
	}
	
	/**
	 * Returns the corresponding X component of this vector.
	 * 
	 * @return The vector's X component.
	 */
	
	public double getXComponent()
	{
		return xComponent;
	}
	
	/**
	 * Returns the corresponding Y component of this vector.
	 * 
	 * @return The vector's Y component.
	 */
	
	public double getYComponent()
	{
		return yComponent;
	}
	
	/**
	 * Returns the same string as Object.toString() usually intends to.
	 * @return The reference address of this string
	 */
	
	public String returnActualObjectAddress()
	{
		return super.toString();
	}


}
