package Day14_GraphAndGreedy;

public class GasStation {
    public static int canCompleteCircuitNaive(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) return -1;
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int tank = 0;
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                int station = (start + i) % n;
                tank += gas[station] - cost[station];
                if (tank < 0) {
                    possible = false;
                    break;
                }
            }
            if (possible) return start;
        }
        return -1;
    }
    public static int canCompleteCircuitGreedy(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) return -1;
        int totalTank = 0, currTank = 0, startStation = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currTank += diff;
            if (currTank < 0) {
                startStation = i + 1;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startStation : -1;
    }
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        assert canCompleteCircuitNaive(gas, cost) == 3;
        assert canCompleteCircuitGreedy(gas, cost) == 3;
        assert canCompleteCircuitGreedy(new int[]{2,3,4}, new int[]{3,4,3}) == -1;
        assert canCompleteCircuitGreedy(null, cost) == -1;
    }
}
