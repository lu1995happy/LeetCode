import java.util.HashSet;
import java.util.Set;

public class TimeRealize {
	
	// 1. get all permutation
	// 2. 

    public static Set<String> perm1(String s) {
        Set<String> temp=new HashSet<>();//can not be added to the next function because of recursive
        return perm1("", s.substring(0,2)+s.substring(3),temp);//convey temp to the next recursive function
    }
    private static Set<String> perm1(String prefix, String s,Set<String> temp) {
        int n = s.length();

        if (n == 0) {
            //System.out.println(prefix);//test only: need to be deleted
            temp.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n),temp);
        }

        //System.out.println(temp.size());  for test
        return temp;

    }

    public static int stringToTime(String time){
        if(time.charAt(2)==':') {
            return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        }
        else
        return ((time.charAt(0)-'0')*10+(time.charAt(1)-'0'))*60+(time.charAt(2)-'0')*10+(time.charAt(3)-'0');
    }




    public static String timeForNow(String S){
    	System.out.println(S.substring(0,2));
    	System.out.println(S.substring(3));
        Set<String> cursive=perm1(S);
        int changeDiff=24*60;
        int cur = stringToTime(S);
        int result=cur;
        for(String k :cursive){
            //System.out.println(k);
            if(((k.charAt(0)-'0')*10+(k.charAt(1)-'0'))<24&&((k.charAt(2)-'0')*10+(k.charAt(3)-'0'))<60){

                int next=stringToTime(k);
                int mid =next-cur;
               if(mid<0){
                   mid=24*60-cur+next;
               }
//                else if(mid<=0){
//                    mid=mid+12*60;
//                }

                //int diff= Math.min(mid,changeDiff);
                if(mid>0&&mid<changeDiff) {
                    result = next;
                    changeDiff = mid;
                }
            }

        }
        return String.format("%02d:%02d",result/60,result%60);

    }

    public static void main(String[] args){
        System.out.println(timeForNow("11:21"));
        System.out.println(timeForNow("18:00"));
        System.out.println(timeForNow("24:00"));
        System.out.println(timeForNow("09:30"));
        System.out.println(timeForNow("13:24"));
        System.out.println(timeForNow("23:56"));
        System.out.println(timeForNow("11:11"));
        System.out.println(timeForNow("03:24"));
        System.out.println(timeForNow("18:37"));
        System.out.println(timeForNow("17:38"));
        System.out.println(timeForNow("11:00"));
        System.out.println(timeForNow("23:59"));

       }
    }
