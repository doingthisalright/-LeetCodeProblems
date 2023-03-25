package Q00057_InsertInterval.solutions;

import java.util.ArrayList;

public class OptimalSolution implements Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        final ArrayList<int[]> result = new ArrayList<>();
        boolean inserted = false;
        for (int[] interval : intervals) {
            int intervalStart = interval[0];
            int intervalEnd = interval[1];

            if (inserted) {
                result.add(new int[]{intervalStart, intervalEnd});
            } else if (newInterval[0] > intervalEnd) {
                // Interval:       -------
                // New Interval:             -------
                result.add(new int[]{intervalStart, intervalEnd});
            } else if (newInterval[1] < intervalStart) {
                // Interval:                 -------
                // New Interval:   -------
                inserted = true;
                result.add(new int[]{newInterval[0], newInterval[1]});
                result.add(new int[]{intervalStart, intervalEnd});
            } else {
                // 1
                // Interval:       -------        -------
                // New Interval:        -------
                // Interval:                      -------
                // New Interval:   ------------
                // 2
                // Interval:            -------   -------
                // New Interval:   -------
                // Interval:                      -------
                // New Interval:   ------------
                // 3: Starts as 1, then becomes 2
                // Interval:       -------   -------
                // New Interval:         -------
                // Interval:                 -------
                // New Interval:   -------------

                newInterval[0] = Math.min(newInterval[0], intervalStart);
                newInterval[1] = Math.max(newInterval[1], intervalEnd);
            }
        }

        if (!inserted) {
            result.add(new int[]{ newInterval[0], newInterval[1] });
        }

        return result.toArray(int[][]::new);
    }

    public String solutionDescription() {
        return "Optimal Solution";
    }
}
