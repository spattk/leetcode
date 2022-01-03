/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    Set<Pair<Integer, Integer>> visited;
    int[][] d = {{-1,0}, {0,1},{1,0}, {0,-1}};
    
    public void backtrack(Robot robot){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
    public void cleanRoomHelper(Robot robot, int x, int y, int dir){
        robot.clean();
        visited.add(new Pair(x,y));
        
        for(int i=0;i<4;i++){
            int ndir = (dir + i) % 4;
            int nx = x + d[ndir][0];
            int ny = y + d[ndir][1];
            
            if(!visited.contains(new Pair(nx, ny)) && robot.move()){
                cleanRoomHelper(robot, nx, ny, ndir);
                backtrack(robot);
            }
            
            robot.turnRight();
               
               
        }
        
    }
    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        cleanRoomHelper(robot, 0, 0, 0);
    }
}