/**
 * Copyright 2013, 2014  by Patrick Nicolas - Scala for Machine Learning - All rights reserved
 *
 * The source code in this file is provided by the author for the only purpose of illustrating the 
 * concepts and algorithms presented in Scala for Machine Learning.
 */
package org.scalaml.unsupervised


		/**
		 * <p>Singleton which defines the different distances used by 
		 * unsupervised machine learning techniques.</p>
		 * @author Patrick Nicolas
		 * @date February 16, 2014
		 */
object Distance {
	
		/**
		 * <p>Function that compute the Manhattan distance between two
		 * array (vectors ) of values.</p>
		 * @param x first array/vector/data point
		 * @param y second array/vector/data point
		 * @exception IllegalArgumentException if the input array are undefined or have different size
		 * @return distance between two data points
		 */
  def manhattan[T <% Double, U <% Double](x: Array[T], y: Array[U]): Double = {
  	 require(x != null && x.size > 0 && y != null && y.size > 0, "Cannot compute the Manhattan distance between undefined data points")
  	 require( x.size == y.size, "Cannot compute the Manhattan distance between 2 arrays of size " + x.size +" and " + y.size)
    
  	 (x, y).zipped.foldLeft(0.0)((s, t) => s + Math.abs(t._1 - t._2))
  }
  
  		/**
		 * <p>Function that compute the Euclidean distance between two
		 * array (vectors ) of values.</p>
		 * @param x first array/vector/data point
		 * @param y second array/vector/data point
		 * @exception IllegalArgumentException if the input array are undefined or have different size
		 * @return distance between two data points
		 */
  def euclidean[T <% Double, U <% Double](x: Array[T], y: Array[U]): Double = {
  	 require(x != null && x.size > 0 && y != null && y.size > 0, "Cannot compute the Euclidean distance between undefined data points")
  	 require( x.size == y.size, "Cannot compute the Euclidean distance between 2 arrays of size " + x.size +" and " + y.size)

     Math.sqrt((x, y).zipped.foldLeft(0.0)((s, t) => { val d = t._1 - t._2; s + d*d} )) 
  }
     
  
    	/**
		 * <p>Function that compute the Cosine distance between two
		 * array (vectors ) of values.</p>
		 * @param x first array/vector/data point
		 * @param y second array/vector/data point
		 * @exception IllegalArgumentException if the input array are undefined or have different size
		 * @return distance between two data points
		 */
  def cosine[T <% Double, U <% Double](x: Array[T], y: Array[U]): Double = {
  	 require(x != null && x.size > 0 && y != null && y.size > 0, "Cannot compute the Cosine distance between undefined data points")
  	 require( x.size == y.size, "Cannot compute the Cosine distance between 2 arrays of size " + x.size +" and " + y.size)
 
	  val zeros = (0.0, 0.0, 0.0)
	  val norms = (x, y).zipped.foldLeft(zeros)((s, t) => 
            (s._1 + t._1*t._2, s._2 + t._1*t._1, s._3 + t._2*t._2))
      norms._1/Math.sqrt(norms._2*norms._3)
  }
}

// -------------------------------  EOF ----------------------------------------------------