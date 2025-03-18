package org.example;

import java.util.Arrays;

/**
 * @author dungptm2
 */
public class CarTransport {

    /**
     * Find the minimum number of cars required to transport all the people.
     * Multiple groups can share a car as long as there's enough total capacity.
     *
     * [1,2,4] & [1, 1, 4] => 2
     * The seats array represents the number of seats in each car: [1,2,4].
     * The groups array represents the number of people in each group: [1,1,4]
     * In this case, we need at least 2 cars to transport all the people.
     * The input must satisfy:
     * - len(seats) == len(people)
     * - For each index `i`, `seats[i]` must be greater than or equal to `people[i]`.
     * [1,2,4] & [1, 2, 4] => 3
     *
     * @param seats Array representing the number of seats in each car
     * @param people Array representing the number of people in each group
     * @return Minimum number of cars required
     */
    public int numberOfCar(int[] seats, int[] people) {
        // check input
        if (seats.length != people.length) {
            throw new IllegalArgumentException("seats and people arrays must have the same length.");
        }
        int n = seats.length;
        for (int i = 0; i < n; i++) {
            if (seats[i] < people[i]) {
                throw new IllegalArgumentException("seats[i] must be greater than or equal to people[i]");
            }
        }

        // Sort seats in ascending order
        Arrays.sort(seats);

        // count total people
        int totalPeople = 0;
        for (int e : people) {
            totalPeople += e;
        }

        // Fill people into the cars with the most seats first.
        int totalCar = 0;
        for (int i = seats.length - 1; i >= 0 && totalPeople > 0; i--) {
            totalPeople -= seats[i];
            totalCar++;
        }
        return totalCar;
    }
}
