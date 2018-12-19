import java.util.ArrayList;
import java.lang.reflect.Array;

public class flower {
  /*
   * 1. original
   * 2. group m  把数组倒过来遍历 先用一个set把0跟n+1放到里面去 代表现在开花组是0到n+1 然后依次将花'闭合' 每次闭合的花放到set里面然后找他的临近闭合花看看这朵花闭合有没有砍断一个大于n的开花组 看看是砍成了两个还是一个还是没变 这样复杂度就是nlogn了
   * 我unionfind里面有parent和size两个array，parent初始值都是-1（表示都没开花），size初始值是1。我遍历了一下flower，每到一个position就判断一下position-1和position+1是否开花，如果都开花那group-1，如果只有一个开花那group不变，如果都不开花那就group+1.当group=M的时候，再遍历一遍flower判断已开花的groups（也就是size[position]）是否每个都大于等于k。差不多就是这样～
WeightedQuickUnionUF
   * 3. last day 第二题如果题意没理解错的话，貌似可以逆向求解。比如最后一天开花的区间[1，n]。如果最后一天开花的位置在x，则倒数第二天的开花区间是[1, x - 1], [x + 1, n]。逆向遍历，分解已有区间，遇到第一个满足条件的即为所得。
   * 
第二题是否可以这样做：逆序考虑。利用一个set <pair<int,int>> s 维护当前已经开花的区间，初始为{<0,N-1>}，初始化>=K的区间数记为cnt=(N>=K)；
逆序遍历数组，遍历到第i个位置时，it = s.upper_bound ({a[i], a[i]}); it--; 分裂 it 区间为<it->first, a[i]-1>, <a[i]+1, it->second>，同时更新cnt， 当cnt >= M第一次满足时对应的下标就是答案

1. 从后往前扫，用TreeSet来记录未开花的位置，然后找上一个和下一个未开花的位置（包括边界），更新大于等于K的花堆数，找到符合条件的第一个日期就返回，这种解法时间应该是nlogn
2. 从前往后扫，用一个新的等长的array来记录连续开花花堆的size，每开一朵花就可以知道左右相邻花堆的size，然后计算出开花后新花堆的长度，更新新花堆segment两端点的值，同步更新大于等于K的花堆数，有符合条件的日期就更新，因为是最晚日期，这种解法要扫完整个array，时间复杂度可以O(n)
   */
	


	    public static int latest(int[] p, int K, int m){
	        int[] bloom = new int[p.length];
	        int result = -1;
	        int date = 0;
	        int group = 0;
	        for(int slot:p){
	            date += 1;
	            bloom[slot-1] = 1;//new 0 array
	            int continues = 0;
	            int index_pre = -1;
	            for(int i = 0; i < bloom.length; i++){
	                if(bloom[i] == 1 && i == index_pre+1){
	                    continues += 1;
	                    index_pre = i;
	                }else{
	                    if(bloom[i]==0 &&K==continues ){
	                        result = date;
	                        //continue;
	                    }
	                    if(bloom[i] == 1 && i != index_pre+1) {
	                        index_pre = i;
	                        continues = 1;
	                    }
	                }
	            }
	            if(K == continues){
	                result = date;
	                group++;
	                if (group == m) {
	                	return result;
	                }
	            }
	        }
	        return -1;
	    }
	    public static void main(String[] args) {
	        int[] input = {2,1,5,4,7,8,3,6};
	        r r r r r 0 r r
	        int k = 2;
	        int m = 2;
	        System.out.println(latest(input, k, m));
	    }
}


