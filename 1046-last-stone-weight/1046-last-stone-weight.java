class Solution {
    public int lastStoneWeight(int[] stones) {
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the max heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Smash stones until at most one remains
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // second heaviest

            if (y != x) {
                maxHeap.offer(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}