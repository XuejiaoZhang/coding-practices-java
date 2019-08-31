package com.aws.rt;

/*
Problem Statement
In aviation, a "near miss" occurs if the distance between two aircraft at some point in time is less than or equal to some threshold distance R. At a moment in time, the positions and velocities of two aircraft are known exactly. Assuming that each aircraft continues to fly with constant speed and direction, you need to work out if the aircraft will undergo a near miss now or at some point in the future.

You will be given the threshold distance R and the positions and velocities of the aircraft in 4 s: p1, v1, p2 and v2. The position of the first aircraft in 3-D cartesian space is given by (p1[0] , p1[1] , p1[2]) and its velocity vector by (v1[0] , v1[1] , v1[2]) and similarly the second aircraft's position and velocity are given by (p2[0] , p2[1] , p2[2]) and (v2[0] , v2[1] , v2[2]). So, if an aircraft's initial position is the vector p and its velocity vector is v, the position of this aircraft at some future time t will be p + v * t. You should return a String containing "YES" if the aircraft will undergo a near miss now or in the future or "NO" if they won't (quotes for clarity).

Definition
Class: Aircraft
Method: nearMiss
Parameters: int[], int[], int[], int[], int
Returns: String
Method signature: String nearMiss(int[] p1, int[] v1, int[] p2, int[] v2, int R)
(be sure your method is public)

Limits
Time limit (s): 840.000
Memory limit (MB): 64
Notes
- The distance between two points (x1, y1, z1) and (x2, y2, z2) is given by sqrt((x1-x2)2 + (y1-y2)2 + (z1-z2)2).


Constraints
- p1, v1, p2 and v2 will contain exactly 3 elements.
- Each element of p1, v1, p2 and v2 will be between -10000 and 10000, inclusive.
- R will be between 0 and 10000, inclusive.
Examples
0)
{15,50,5}
{25,1,0}
{161,102,9}
{-10,-10,-1}
10
Returns: "YES"
At time 4, the first aircraft will be at position {115,54,5} and the second at {121,62,5}, which is the first point in time at which they are exactly 10 distance units apart.
1)
{0,0,0}
{2,2,0}
{9,0,5}
{-2,2,0}
5
Returns: "YES"
At time 2.25, aircraft 1 will be at {4.5, 4.5, 0} and aircraft 2 at {4.5, 4.5, 5}, exactly a distance of 5 units apart.
2)
{0,0,0}
{-2,2,0}
{9,0,5}
{2,2,0}
5
Returns: "NO"
The aircraft are flying away from each other here, so the distance always increases with time.
3){-2838,-7940,-2936}
{1,1,-2}
{532,3850,9590}
{1,0,-3}
3410
Returns: "YES"
The closest approach of the aircraft occurs at time 12,158
4)
{-8509,9560,345}
{-89,-33,62}
{-5185,-1417,2846}
{-58,24,26}
8344
Returns: "YES"
A near miss occurs between times 111 and 112
5)
{-7163,-371,-2459}
{-59,-41,-14}
{-2398,-426,-5487}
{-43,27,67}
5410
Returns: "NO"
The aircraft almost have a near miss between times 15 and 16, but stay just outside the threshold distance.
6)
{1774,-4491,7810}
{-12,19,-24}
{2322,3793,9897}
{-12,19,-24}
10000
Returns: "YES"
The aircraft are here flying with identical velocities, so the distance between them never changes. The distance at time 0 is lower than the threshold, so a near miss is already underway.
7)
{3731,8537,5661}
{-70,71,32}
{8701,-1886,-5115}
{28,-13,7}
9766
Returns: "NO"

 */


public class Aircraft {

//    There were several approaches to this problem, but all of them benefited from some basic transformations which simplified the problem significantly.
//
//    Move the position of the first aircraft to the origin by subtracting p1 from both positions.
//    Consider only the velocities relative to the first aircraft by subtracting v1 from both velocity vectors.
//    We have now simplified the problem to consider how close an aircraft at p2 moving with velocity v2 will pass to the origin. Since we are only dealing with a single position and velocity from this point, I will merely refer to them as v and p.
//
//    I've seen 3 basic approaches to solving this, which I'll outline here:
//
//    Search for the closest point by using a ternary search
//    The distance between the two aircraft is unimodal over time, so it makes the problem a prime candidate for a ternary search. A ternary search is a great way to find a minimum or maximum of a function that has only one turning point.
//
//    Start with a full range of potential times that the aircraft would be nearest (Minimum 0, maximum 109 seem like good values). Iterate a suitable number of times to find the time x at which the aircraft were closest. Now we're basically done, right?
//
//    Wrong. You'll have to calculate the resulting distance at time x using imprecise doubles, and you'll be working with a small error. Considering that there are test cases where the aircraft fly to within 1e-11 of the "near-miss" threshold, working with doubles was very unreliable and could easily have failed on cases tailored to catch out this approach. Thankfully for contestants who used this method (including myself), some of the real killer cases were absent in the system tests and some technically incorrect solutions ended up passing.
//
//    Solve it using algebra
//    The distance (squared) between the aircraft at time x is (p[0]+x*v[0])2 + (p[1]+x*v[1])2 + (p[2]+x*v[2])2.
//    We want to know if this expression is ever less than or equal to R2.
//            Expressing this inequality in the form Ax2 + Bx + C ≤ 0 gives us:
//    A=v[0]2 + v[1]2 + v[2]2
//    B=2*(p[0]*v[0] + p[1]*v[1] + p[2]*v[2])
//    C=p[0]2 + p[1]2 + p[2]2
//
//    At this point you will need to know the properties of quadratic graphs to evaluate if there are any non-negative real roots. As misof's solution very neatly checked with the following 4 lines:
//            if (C <= R*R) return "YES";
//    if (A == 0) return "NO";
//    if (B >= 0) return "NO";
//    if (4*A*C - B*B <= R*R*4*A) return "YES";
//    This approach avoided the precision errors introduced by doubles, but care had to be taken to avoid overflows. In the most extreme cases, B could exceed 2.4 billion, requiring a 64-bit data type or unsigned 32-bit data type to store it.
    public String checkAircraftMath(int[] p1, int[] v1, int[] p2, int[] v2, int R) {
            int[] p = {p1[0] - p2[0], p1[1] - p2[1], p1[2] - p2[2]};
            int[] v = {v1[0] - v2[0], v1[1] - v2[1], v1[2] - v2[2]};
            int A=v[0] * v[0] + v[1]*v[1] + v[2]*v[2];
            int B=2*(p[0]*v[0] + p[1]*v[1] + p[2]*v[2]);
            int C=p[0]*p[0] + p[1]*p[1] + p[2]*p[2];

            if (A == 0) return "NO";
            if (B >= 0) return "NO";
            if (4*A*C - B*B <= R*R*4*A) return "YES"; else return "NO";
        }


        public String checkAircraft(int[] p1, int[] v1, int[] p2, int[] v2, int R) {
//
//        for (int i = 0; i < 3; i++) {
//            if ((p1[i] < p2[i] && v1[i] <= p2[i]) || (p1[i] > p2[i] && v1[i] >= p2[i])){
//                System.out.print("1111");
//
//                return "NO";
//            }
//        }


        // k might be ant value, not only integer
        int k = 0;
        while(true){
            int p11 = p1[0]+v1[0]*k;
            int p12 = p1[1]+v1[1]*k;
            int p13 = p1[2]+v1[2]*k;

            int p21 = p2[0]+v2[0]*k;
            int p22 = p2[1]+v2[1]*k;
            int p23 = p2[2]+v2[2]*k;
            if ( ( -10000 >= p11 || p11 >= 10000 ) || ( -10000 >= p12 || p12 >= 10000 ) || ( -10000 >= p13 || p13 >= 10000 ) ||
            ( -10000 >= p21 || p21 >= 10000 ) || ( -10000 >= p22 || p22 >= 10000 ) || ( -10000 >= p23 || p23 >= 10000 ) ) {
                System.out.print("2222");

                return "NO";
            }
            if (((p11-p21)*(p11-p21) + (p12-p22)*(p12-p22) + (p13-p23)*(p13-p23)) > R*R ) {
                System.out.printf("Check: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d \n", k, p11, p12, p13, p21, p22, p23, R, ((p11-p21)*(p11-p21) + (p12-p22)*(p12-p22) + (p13-p23)*(p13-p23)), R*R);

                k += 1;
            } else {
                System.out.printf("Check: %d, %d, %d, %d, %d, %d, %d, %d\n", k, p11, p12, p13, p21, p22, p23, R);

                return "YES";
            }
        }
    }

    public static final void main(String[] args){
        Aircraft a = new Aircraft();
        int[] p1 = new int[]{15,50,5};
        int[] v1 = new int[]{25,1,0};
        int[] p2 = new int[]{161,102,9};
        int[] v2 = new int[]{-10,-10,-1};
        int R = 10;

        int[] p12 = new int[]{0, 0, 0};
        int[] v12 = new int[]{-2, 2, 0};
        int[] p22 = new int[]{9, 0, 5};
        int[] v22 = new int[]{2, 2, 0};
        int R2 = 5;

//        String ret = a.checkAircraft(p12, v12, p22, v22, R2);
//        System.out.print(ret);


        String ret = a.checkAircraftMath(p12, v12, p22, v22, R2);
        System.out.print(ret);
    }
}
