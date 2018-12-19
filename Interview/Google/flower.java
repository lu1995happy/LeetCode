import java.util.ArrayList;
import java.lang.reflect.Array;

public class flower {
  /*
   * 1. original
   * 2. group m  �����鵹�������� ����һ��set��0��n+1�ŵ�����ȥ �������ڿ�������0��n+1 Ȼ�����ν���'�պ�' ÿ�αպϵĻ��ŵ�set����Ȼ���������ٽ��պϻ�������仨�պ���û�п���һ������n�Ŀ����� �����ǿ�������������һ������û�� �������ӶȾ���nlogn��
   * ��unionfind������parent��size����array��parent��ʼֵ����-1����ʾ��û��������size��ʼֵ��1���ұ�����һ��flower��ÿ��һ��position���ж�һ��position-1��position+1�Ƿ񿪻��������������group-1�����ֻ��һ��������group���䣬������������Ǿ�group+1.��group=M��ʱ���ٱ���һ��flower�ж��ѿ�����groups��Ҳ����size[position]���Ƿ�ÿ�������ڵ���k��������������
WeightedQuickUnionUF
   * 3. last day �ڶ����������û����Ļ���ò�ƿ���������⡣�������һ�쿪��������[1��n]��������һ�쿪����λ����x�������ڶ���Ŀ���������[1, x - 1], [x + 1, n]������������ֽ��������䣬������һ�����������ļ�Ϊ���á�
   * 
�ڶ����Ƿ�����������������ǡ�����һ��set <pair<int,int>> s ά����ǰ�Ѿ����������䣬��ʼΪ{<0,N-1>}����ʼ��>=K����������Ϊcnt=(N>=K)��
����������飬��������i��λ��ʱ��it = s.upper_bound ({a[i], a[i]}); it--; ���� it ����Ϊ<it->first, a[i]-1>, <a[i]+1, it->second>��ͬʱ����cnt�� ��cnt >= M��һ������ʱ��Ӧ���±���Ǵ�

1. �Ӻ���ǰɨ����TreeSet����¼δ������λ�ã�Ȼ������һ������һ��δ������λ�ã������߽磩�����´��ڵ���K�Ļ��������ҵ����������ĵ�һ�����ھͷ��أ����ֽⷨʱ��Ӧ����nlogn
2. ��ǰ����ɨ����һ���µĵȳ���array����¼�����������ѵ�size��ÿ��һ�仨�Ϳ���֪���������ڻ��ѵ�size��Ȼ�������������»��ѵĳ��ȣ������»���segment���˵��ֵ��ͬ�����´��ڵ���K�Ļ��������з������������ھ͸��£���Ϊ���������ڣ����ֽⷨҪɨ������array��ʱ�临�Ӷȿ���O(n)
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
	        int k = 2;
	        int m = 2;
	        System.out.println(latest(input, k, m));
	    }
}


