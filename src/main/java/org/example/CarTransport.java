package org.example;

import java.util.PriorityQueue;

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

        // create max heap based on the seat remaining
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < n; i++) {
            q.offer(new int[] {seats[i] - people[i], i});
        }

        // count total people
        int totalPeople = 0;
        for (int e : people) {
            totalPeople += e;
        }

        // prioritizes cars with the most remaining seats after placing their corresponding group
        int totalCar = 0;
        while (!q.isEmpty() && totalPeople > 0) {
            int[] poll = q.poll();
            int index = poll[1];
            totalCar++;
            totalPeople -= seats[index];
        }
        return totalCar;
    }
}
