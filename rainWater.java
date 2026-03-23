public class rainWater {
    public static void maxWater(int height[]){
        int n = height.length;
        //now we will find the left max boundary for each element in the array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        // now we will find the right max boundary for each element in the array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
      // now we will find the water level
      int trappedWater = 0;
      for(int i=0;i<n;i++){
          int waterLevel = Math.min(leftMax[i], rightMax[i]);
          trappedWater += waterLevel - height[i];
      }
        System.out.println( "the total trapped water is " + trappedWater);
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
       
       maxWater(height);
    }
}