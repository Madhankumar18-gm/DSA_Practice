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
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        assert canCompleteCircuitNaive(gas, cost) == 3;
    }
}
