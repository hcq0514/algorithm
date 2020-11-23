package com.hcq.algorithm.深度搜索BFS;


import java.util.*;

public class 打开转盘锁752 {

    /**
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     * <p>
     * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * 输出：6
     * 解释：
     * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
     * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
     * 因为当拨动到 "0102" 时这个锁就会被锁定。
     */

    public static int openLock(String[] deadends, String target) {
        List<String> deads = Arrays.asList(deadends);
        LinkedList<String> queues = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        String startString = "0000";
        if ("0000".equals(target)) {
            return 0;
        }
        visited.add(startString);
        queues.offer(startString);
        while (!queues.isEmpty()) {
            //要在这边写size，不然如果下面是i<queues.size()的话 在循环的时候 queues的长度会一直改变
            int size = queues.size();
            for (int i = 0; i < size; i++) {
                String cur = queues.poll();
                if (deads.contains(cur)) {
                    continue;
                }
                if (target.equals(cur)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = pullUp(cur, j);
                    if (!visited.contains(up)) {
                        visited.add(up);
                        queues.offer(up);
                    }
                    String down = pullDown(cur, j);
                    if (!visited.contains(down)) {
                        visited.add(down);
                        queues.offer(down);
                    }
                }
            }
            step++;

        }
        return -1;
    }

    /**
     * 向上滑动
     */
    public static String pullUp(String str, int i) {
        char[] chars = str.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i]++;
        }
        return new String(chars);
    }

    public static String pullDown(String str, int i) {
        char[] chars = str.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i]--;
        }
        return new String(chars);
    }


    public static void main(String[] args) {

//             * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"

        String[] strArray = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock(strArray, "0202"));

    }



}


