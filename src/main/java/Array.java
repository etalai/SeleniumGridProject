
public class Array {
	public static void main(String[] args) {
		int[] nums = {10,20,20,7,40};

	loop: for(int a=0; a<nums.length; a++) {
			for(int b=a+1; b<nums.length; b++) {
				if(nums[a]==nums[b]) {
					System.out.println("dublicate found: "+nums[b]);
					break loop;
				}
			}
	      }
		
		
	}
}
