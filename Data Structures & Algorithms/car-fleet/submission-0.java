class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<List<Integer>> comb = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(position[i]);
            temp.add(speed[i]);
            comb.add(temp);
        }

        comb.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        Stack<Double> stack = new Stack<>();

        for (int i = comb.size() - 1; i >= 0; i--) {

            double time = (double)(target - comb.get(i).get(0)) / comb.get(i).get(1);

            if (stack.isEmpty()) {
                stack.push(time);
            }
            else if (time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}