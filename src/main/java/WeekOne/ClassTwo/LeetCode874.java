package WeekOne.ClassTwo;

import java.util.HashSet;
import java.util.Set;

public class LeetCode874 {
    /**
     * 874. 模拟行走机器人
     * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
     *
     * -2 ：向左转 90 度
     * -1 ：向右转 90 度
     * 1 <= x <= 9 ：向前移动 x 个单位长度
     * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
     *
     * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
     *
     * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
     *
     *
     * 注意：
     *
     * 北表示 +Y 方向。
     * 东表示 +X 方向。
     * 南表示 -Y 方向。
     * 西表示 -X 方向。
     *
     *
     * 示例 1：
     *
     * 输入：commands = [4,-1,3], obstacles = []
     * 输出：25
     * 解释：
     * 机器人开始位于 (0, 0)：
     * 1. 向北移动 4 个单位，到达 (0, 4)
     * 2. 右转
     * 3. 向东移动 3 个单位，到达 (3, 4)
     * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
     * 示例 2：
     *
     * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
     * 输出：65
     * 解释：机器人开始位于 (0, 0)：
     * 1. 向北移动 4 个单位，到达 (0, 4)
     * 2. 右转
     * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
     * 4. 左转
     * 5. 向北走 4 个单位，到达 (1, 8)
     * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
     */
    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        System.out.println(maxDistance(commands,obstacles));
    }
    public static int maxDistance(int[]commands, int[][] obstacles){
        Set<String> set = new HashSet<>();
        for(int j = 0; j < obstacles.length;j++){
            set.add(calcHash(obstacles[j][0],obstacles[j][1]));
        }
        //方向组
        //         N  E S W
        int[] x = {0,1,0,-1};
        int[] y = {1,0,-1,0};
        int dir = 0;
        int maxDistance = 0;
        int xLocation = 0;
        int yLocation = 0;
        for(int command : commands){
            if(command > 0){
                for(int i = 0; i < command; i++){
                    if(set.contains(calcHash(xLocation+x[dir],yLocation+y[dir]))){
                        break;
                    }
                    xLocation += x[dir];
                    yLocation += y[dir];
                    maxDistance = Math.max(maxDistance,xLocation * xLocation + yLocation * yLocation);
                }
            }else if(command == -1){
                dir = (dir + 1)%4;
            }else{
                dir = (dir - 1 + 4) % 4;
            }
        }
        return maxDistance;
    }

    public static String calcHash(int x, int y){
        return x + "," + y;

    }
}
