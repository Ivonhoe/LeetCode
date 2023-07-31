class TripleInOne {

    private int N = 3;
    private int size = 0;
    private int[] arrays = null;

    public TripleInOne(int stackSize) {
        size = stackSize;
        arrays = new int[N * stackSize + N];
        for (int i = 0; i < N; i++) {
            arrays[i] = N + i * size;
        }
    }

    public void push(int stackNum, int value) {
        int index = arrays[stackNum];
        if (index < (N + (stackNum + 1) * size)) {
            arrays[index] = value;
            arrays[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        int index = arrays[stackNum];
        if (index > (N + stackNum * size)) {
            arrays[stackNum]--;
            return arrays[index - 1];
        } else {
            return -1;
        }
    }

    public int peek(int stackNum) {
        int index = arrays[stackNum];
        if (index > (N + stackNum * size)) {
            return arrays[index - 1];
        } else {
            return -1;
        }
    }

    public boolean isEmpty(int stackNum) {
        return arrays[stackNum] == N + stackNum * size;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such: TripleInOne
 * obj = new TripleInOne(stackSize); obj.push(stackNum,value); int param_2 =
 * obj.pop(stackNum); int param_3 = obj.peek(stackNum); boolean param_4 =
 * obj.isEmpty(stackNum);
 */