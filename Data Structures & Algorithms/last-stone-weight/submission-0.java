class Solution {
    public int lastStoneWeight(int[] stones) {
        
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();

            if (x == y) {
                continue;
            } else if (x > y) {
                x = x - y;
                queue.offer(x);
            } else {
                y = y - x;
                queue.offer(y);
            }
        }

        if (queue.size() == 1) {
            return queue.peek();
        } else {
            return 0;
        }
    }
}
