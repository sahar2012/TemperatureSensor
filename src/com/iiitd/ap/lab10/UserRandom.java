//@author - Nalin Gupta 2014065
//			Sahar Siddiqui 2014091

package com.iiitd.ap.lab10;

public class UserRandom {
	long seed;

		public double nextVal() {
		  long x = System.nanoTime();
		  x ^= (x << 21);
		  x ^= (x >>> 35);
		  x ^= (x << 4);
		  seed = x;
		  x &= ((1L << 16) - 1);
		  return (double) x/100000;
	 	}
}
