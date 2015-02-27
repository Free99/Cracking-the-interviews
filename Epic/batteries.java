import java.util.List;
import java.util.ArrayList;

/*
 * http://blog.csdn.net/lsdtc1225/article/details/39949367
 * 问题14：
 * 电池有6节包装，9节包装，20节包装三种，input需要多少节电池，
 * 如果可以刚好用3种包装的凑到这个数，就输出这个解， 忘了是不是要输出所有的解。
 * e.g 输入20， 答{20} 输入17 答没有 输入18，那可能是{6,6,6}也可能是{9,9}。 
 * 有点像找钱的问题，似乎是从集合中找到所有集合值等于一个target这个题的简化版，因为集合只有6 9 20。
 * 如果是要求输出所有可能：DFS
 */

public class batteries {
	private static int[] bNum = {20, 9, 6};
	
	public static void main(String[] args) {
		doTests();
	}
	
	public static void helper(int target, List<List<Integer>> res, List<Integer> item, int pos) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = pos; i < bNum.length; i++) {
			item.add(bNum[i]);
			helper(target - bNum[i], res, item, i);
			item.remove(item.size() - 1);
		}
	}
	
	public static void doTests() {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int target = 18;
		helper(target, res, new ArrayList<Integer>(), 0);
		System.out.println(res);
	}
}
