class SnakeGame {

    int r, c;
    Queue<int[]> q;
    int score;
    Deque<int[]> snake;
    Set<Pair<Integer, Integer>> snakeBody;
    
    private boolean isSafe(int x, int y){
        return x >=0 && x<r && y>=0 && y<c;
    }
    
    public SnakeGame(int width, int height, int[][] food) {
        r = height;
        c = width;
        q = new LinkedList<>();
        for(int[] f: food){
            q.add(f);
        }
        snake = new LinkedList<>();
        snake.addLast(new int[]{0,0});
        snakeBody = new HashSet<>();
        snakeBody.add(new Pair(0, 0));
    }
    
    public int move(String direction) {
        int[] curr = snake.peekLast();
        int x = curr[0], y = curr[1];
        
        if(direction.equals("U")){
            x-=1;
        }
        else if (direction.equals("D")){
            x+=1;
        }
        else if (direction.equals("L")){
            y-=1;
        }
        else if (direction.equals("R")){
            y+=1;
        }
        
        if(!isSafe(x, y)){
            return -1;
        }
        
        if(!q.isEmpty() && q.peek()[0] == x && q.peek()[1] == y){
            //food is present in non-body location
            this.score += 1;
            q.poll();
            
        }
        else {
            //if no food
            int rem[] = snake.pollFirst();
            snakeBody.remove(new Pair(rem[0], rem[1]));
            
            if(snakeBody.contains(new Pair(x, y))){
                return -1;
            }

        }
        
        snake.addLast(new int[]{x, y});
        snakeBody.add(new Pair(x, y));
        
        return this.score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */