package leetcode;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		recursion(coins, amount, 0, coins.length - 1);
		return minCount == Integer.MAX_VALUE ? -1 : minCount;
	}
	int minCount = Integer.MAX_VALUE;

	void recursion(int[] coins, int amount, int count, int index) {
		if (index < 0 || count + amount / coins[index] >= minCount) return;
		if (amount % coins[index] == 0) {
			minCount = Math.min(minCount, count + amount / coins[index]);
			return;
		}
		for (int i = amount / coins[index]; i >= 0; i--) {
			recursion(coins, amount - i * coins[index], count + i, index - 1);
		}
	  
	}
}
