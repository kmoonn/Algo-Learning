import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 

/* 解法 1 ：暴力枚举 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i){
            for (int j = i + 1; j < nums.length; ++j){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}


/* 解法 2 ：哈希表 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

public class twoSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toString();
        String[] arr = str.split(" ");
        int[] nums = new int[arr.length];
        for (int i=0; i<arr.length;i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        int target = scanner.nextInt();

        Solution2 solution = new Solution2();
        int[] res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
        scanner.close();
    }
}
