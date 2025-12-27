package Review;

public class MaxCharFrequency {

    /**
     * 题目要求：
     * 给定一个字符串，找出其中出现次数最多的字符的次数。
     * 注意：大小写敏感（'A' != 'a'）。
     *
     * 示例：
     * "aaa" -> 返回 3
     * "aabcA" -> 返回 2 (因为 'a' 出现了 2 次，'b','c','A' 各 1 次)
     */
    public int findMaxOccurrence(String s) {
        // TODO: 在这里编写你的逻辑
        return 0;
    }

    public static void main(String[] args) {
        MaxCharFrequency solution = new MaxCharFrequency();

        // 测试用例
        String test1 = "aaa";
        String test2 = "aabcA";
        String test3 = "AbcdeA";
        String test4 = ""; // 边界情况：空字符串

        System.out.println("Test 1 Result: " + solution.findMaxOccurrence(test1)); // 应输出 3
        System.out.println("Test 2 Result: " + solution.findMaxOccurrence(test2)); // 应输出 2
        System.out.println("Test 3 Result: " + solution.findMaxOccurrence(test3)); // 应输出 2
        System.out.println("Test 4 Result: " + solution.findMaxOccurrence(test4)); // 应输出 0
    }
}