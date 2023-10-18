package com.vk.dwzkf.stackoverflow.question_77317821;

/**
 * @author Roman Shageev
 * @since 18.10.2023
 */
public class Answer77317821 {
    public static void main(String[] args) {
        print(30, 1);
    }

    public static void print(int threshold, int startElement) {
        //find how much diagonal lines we have
        int layers = layers(threshold-startElement+1);
        //find max elements for this layers
        int maxElement = sum(1, layers);
        int minElement = getVal(layers, maxElement, startElement, layers - 1, 0);
        int length = Math.max(String.valueOf(minElement).length(), (threshold+"").length());
        System.out.println("Layers: " + layers);
        for (int i = 0; i < layers; i++) {
            for (int j = 0; j < i + 1; j++) {
                int indexI = i;
                int indexY = j;
                int val = getVal(layers, maxElement, startElement, indexI, indexY);
                if (val <= threshold) {
                    System.out.print(String.format("%"+(length+1)+"d ", val));
                }
            }
            if (getVal(layers, maxElement, startElement, i, 0) <= threshold) {
                System.out.println();
            }
        }
    }

    private static int getVal(int layers, int maxElement, int startElement, int i, int j) {
        //find elements count for this diagonal
        int layerSize = layers - i + j;
        //find how much diagonal above current diagonal
        int upperLayers = layers - layerSize;
        //find total number of elements of all above diagonals
        int upperElements = upperLayers == 0 ? 0 : sum(layerSize + 1, layerSize + upperLayers);
        // if elements in this diagonal % 2 == 0 then bot-right is lowest
        boolean fromLeftToRight = layerSize % 2 == 0;
        // max element on this diagonal
        // equals to last element minus count elements above this diagonal
        int currMax = maxElement - upperElements;
        // find index of element of current diagonal
        // same as "j" (left-to-right) or "i"(right-to-left) counting from bottom
        // (layers-1) is max index of "i"
        int currentElement = fromLeftToRight ? j : (layers - 1) - i;
        return currMax - currentElement + (startElement - 1);
    }

    public static int sum(int a, int b) {
        return ((a + b) * (b - a + 1)) / 2;
    }

    public static int layers(int threshold) {
        //to find how much diagonal lines we have
        //we have to find N that sum 1..N >= threshold
        //sum 1..N = ((n+1)*n)/2
        //((n+1)*n)/2 >= t, t = threshold
        //equals 2n^2+2n-4t=0
        if (threshold < 1) return 0;
        //D = k^2 - ac
        // k = 1, a = 2, c = -4
        int d = 1 + 2 * threshold * 4;
        int x1 = (int) Math.ceil((-1 - Math.sqrt(d * 1.0)) / 2.0);
        int x2 = (int) Math.ceil((-1 + Math.sqrt(d * 1.0)) / 2.0);

        return x1 <= 0 ? x2 : Math.min(x1, x2);
    }
}
