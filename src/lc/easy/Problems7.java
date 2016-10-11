package lc.easy;

/*
 * problems
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class Problems7 {
	
	public int reverse(int x) {
        if(x == 0)
            return 0;
            
        int max = (int)Math.pow(2, 32);	//最大值：2147483647
        int min = max*-1 - 1;			//最小值：-2147483648
        
        //最小值min*-1仍然等于min
        //因为min的绝对值超过了最大值
        if(x == max || x == min)
            return 0;
        
        //对负数求绝对值，然后可以按正数的方式来处理（只需要一套处理流程）
        boolean isNeg = false;
        if(x > 0)
            isNeg = false;
        else{
            isNeg = true;
            x = x*-1;
        }
        
        int result = 0;
        
        while(x%10!=0 || x/10!=0){	//要考虑到10这种情况
        	//防止溢出
        	if(result > max/10)
                return 0;
                
            int n = x%10;
            result = result*10 + n;
            x = x/10;
        }  
        
        //还原正负号
        if(isNeg)
            return result*-1;
        else
            return result;
    }
	
	public int reverse2(int x) {
        if(x == 0)
            return 0;
            
        int max = (int)Math.pow(2, 32);
        boolean isNeg = false;
        if(x > 0)
            isNeg = false;
        else{
            isNeg = true;
            x = x*-1;
        }
            
        String[] arr = String.valueOf(x).split("");
        int result = 0;
        for(int i=arr.length-1; i>=0; i--){
            if(result > max/10)
                return 0;
            result = result*10 + Integer.parseInt(arr[i]);
        }
        
        if(isNeg)
            return result*-1;
        else
            return result;
    }

	public static void main(String[] args) {
		
	     
	}

}
