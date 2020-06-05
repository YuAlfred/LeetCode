import java.util.HashMap;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2019/4/22 23:31
 * @description : 两数之和
 * @modified By  :
 */
public class A001 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Solution");
    }
}
