class Solution {
    public int scheduleCourse(int[][] courses) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        int currDays = 0;
        for(int[] course: courses) {
            pq.offer(course[0]);
            currDays += course[0];
            if(currDays > course[1]) {
                currDays -= pq.poll();
            }
        }
        return pq.size();
        
    }
}