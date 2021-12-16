package javasol;

public class TheCakeThief {
    public static class CakeType {
        final int weight;
        final int value;
        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {
        // calculate the maximum value that we can carry
        long[] maxVals = new long[weightCapacity+1];
        for (int i = 0; i < cakeTypes.length; i++) {
            if(cakeTypes[i].weight==0 && cakeTypes[i].value==0) continue;
//            System.out.println("cake type "+cakeTypes[i].weight+" are going to execute..");
            for (int j = 0; j < weightCapacity+1; j++) {
                if(j==0) continue;

                long maxWithCurrentCakeIOnly = ((long) (j/cakeTypes[i].weight))*cakeTypes[i].value;
//             /   System.out.println(maxWithCurrentCakeIOnly+" is value if we use only cake of weight, value "+cakeTypes[i].weight+" "+cakeTypes[i].value);

                int remainingCapacity = j%cakeTypes[i].weight;
                maxVals[j] = Math.max(maxVals[j],  maxWithCurrentCakeIOnly+maxVals[(int) remainingCapacity]);
//              /  System.out.println(maxVals[j]+" is max value for cake with weight "+j);
            }
        }
    return maxVals[maxVals.length-1];
    }
    public static void main(String[] args) {
        long maxWithCurrentCakeIOnly = ((long) (5/4))*4;
        System.out.println(maxWithCurrentCakeIOnly);
        final CakeType[] cakeTypes = {new CakeType(5, 5), new CakeType(4, 4)};
        final int weightCapacity = 9;
        System.out.println(maxDuffelBagValue(cakeTypes, weightCapacity));
    }
}