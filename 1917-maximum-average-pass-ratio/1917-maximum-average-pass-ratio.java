class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        //Max heap comparing gain of passsing a student
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a,b) -> Double.compare(b[0], a[0])
        );

        //Initialize the heap
        for(int[] c: classes) {
            double p = c[0];
            double t = c[1];
            pq.offer(new double[]{gain(p,t), p, t});
        }

        //assign extra students
        while(extraStudents-- > 0) {
            double[] top = pq.poll();
            double p = top[1]+1, t = top[2]+1;
            pq.offer(new double[]{gain(p,t), p, t});
        }

        double sum = 0.0;
        Object[] arr = pq.toArray();
        for (int i = 0; i < arr.length; i++) {
            double[] c = (double[]) arr[i];
            sum += c[1] / c[2];
        }

        return sum / classes.length;

    }

    private double gain(double pass, double total) {
        return (pass + 1.0) / (total + 1.0) - (pass/total);
    }
}