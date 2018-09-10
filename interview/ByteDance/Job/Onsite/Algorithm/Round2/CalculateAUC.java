package interview.ByteDance.Job.Onsite.Algorithm.Round2;

import java.util.*;

public class CalculateAUC {
    public static void main(String[] args) {
        IndexAndPrediction[] pairs = new IndexAndPrediction[5];
        pairs[0] = new IndexAndPrediction(0, 0.2);
        pairs[1] = new IndexAndPrediction(1, 0.6);
        pairs[2] = new IndexAndPrediction(2, 0.4);
        pairs[3] = new IndexAndPrediction(3, 0.5);
        pairs[4] = new IndexAndPrediction(4, 0.8);
        int[] labels = {0, 1, 1, 0, 1};
        System.out.println(solve(pairs, labels));
    }

    private static double solve(IndexAndPrediction[] predictions, int[] labels) {
        Arrays.sort(predictions, new Comparator<IndexAndPrediction>() {
            @Override
            public int compare(IndexAndPrediction o1, IndexAndPrediction o2) {
                double v1 = o1.getProbobility(), v2 = o2.getProbobility();
                return Math.abs(v1 - v2) < 1e-10 ? 0 : (v1 < v2 ? -1 : 1);
            }
        });
        int trueCount = 0, falseCount = 0;
        for (int label : labels) {
            if (label == 0) falseCount++;
            else trueCount++;
        }
        int preNegativeCount = 0, validPairCount = 0;
        for (int i = 0; i < labels.length; i++) {
            if (labels[predictions[i].getIndex()] == 1) validPairCount += preNegativeCount;
            else preNegativeCount++;
        }
        return (double) validPairCount / (trueCount * falseCount);
    }

    private static class IndexAndPrediction {
        private int index;
        private double probobility;
        private   IndexAndPrediction(int i, double p) {
            index = i;
            probobility = p;
        }
        public int getIndex() {
            return index;
        }

        private double getProbobility() {
            return probobility;
        }
    }
}
