package Day14_GraphAndGreedy;

public class LemonadeChange {
    public static boolean lemonadeChangeSimulation(int[] bills) {
        if (bills == null) return false;
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean lemonadeChangeGreedy(int[] bills) {
        if (bills == null) return false;
        int fiveCount = 0, tenCount = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount == 0) return false;
                fiveCount--;
                tenCount++;
            } else {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        assert lemonadeChangeSimulation(new int[]{5, 5, 5, 10, 20});
        assert lemonadeChangeGreedy(new int[]{5, 5, 5, 10, 20});
        assert !lemonadeChangeGreedy(new int[]{5, 5, 10, 10, 20});
    }
}
