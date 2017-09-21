
import java.util.HashMap;
import java.util.Map;


class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.solution("00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090\n00:01:06,701-080-080"));
	}
	    public int solution(String S) {
	        // write your code in Java SE 8
	        
	        int amount = 0;
	        String[] lines = S.split("\n");
	        HashMap<String,int[]> pairs = new HashMap<String,int[]>();
	        
	        int max = 0;
	        String maxPhone = null;
	        for(String s : lines){
	            String[] time_number = s.split(",");
	            String time = time_number[0];
	            String number = time_number[1];
	            String[] time1 = time.split(":");
	            int mins = 0;
	            boolean isLessThan5 = false;
	            if(Integer.parseInt(time1[0]) == 0 && Integer.parseInt(time1[1])<5){
            		isLessThan5 = true;
            		mins = Integer.parseInt(time1[1]) * 60 + Integer.parseInt(time1[2]);
	            }
	            else if(Integer.parseInt(time1[2]) > 0) mins = Integer.parseInt(time1[1]) + Integer.parseInt(time1[0]) + 1;
	            else mins = Integer.parseInt(time1[1]) + Integer.parseInt(time1[0]);
	            
	            String[] number1 = number.split("-");
	            String phone = number1[0]+number1[1]+number1[2];
	            
	            if(pairs.containsKey(phone)){
	            	int[] nums = pairs.get(phone);
	            	if(isLessThan5)
	            		nums[1] = nums[1]+mins;
	            	else
	            		nums[0] = nums[0]+mins;
	            	pairs.put(phone, nums);
	            }
	            else{
	            	int[] nums = {0,0};
	            	if(isLessThan5)
	            		nums[1]  = mins;
	            	else
	            		nums[0] = mins;
	            	pairs.put(phone, nums);
	            }
	        }
	        for(Map.Entry<String,int[]> map : pairs.entrySet()){
	        	int[] curr = map.getValue();
	        	if(curr[0]+curr[1] > max){
	        		max = curr[0]+curr[1];
	        		maxPhone = map.getKey();
	        	}
	        	else if(curr[0]+curr[1] == max){
	        		if(map.getKey().compareTo(maxPhone) < 1){
	        			max = curr[0]+curr[1];
		        		maxPhone = map.getKey();
	        		}
	        		
	        	}
	        }
	        pairs.remove(maxPhone);
	        
	        
	        for(Map.Entry<String,int[]> map : pairs.entrySet()){
	        	int[] curr = map.getValue();
	        	amount += curr[0]*150 + curr[1]*3;
	        }
	        
	        return amount;    
	    }
	    
	}

