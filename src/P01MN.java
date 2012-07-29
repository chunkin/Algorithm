import com.sun.tools.doclets.internal.toolkit.util.SourceToHTMLConverter;

import java.util.*;

/*
* 数列1..N ,求所有和等M的组合
* */
public class P01MN  {
       /*
       * 优化空间复杂度至O（m），在i时，因i的上一轮循环i-1，已将i-1时a[j-i]计算出来
       * 即a[i][j] = a[i-1][j]并上a[i-1][j-i]+i的集合，因上一轮i-1 a[j-i]的集合已经计算出，
       * 但因只有一维数组要用j-i 推j,故j循环要从m开始，否则a[i][j]由a[i][j-i]推出与推导公式不符
       *
       * */
    public static Set cal2(int n , int m){
        Set[] a = new HashSet[m+1];
        for(int i= 0; i<=n;i++)
            for(int j = m; j >= 0 ;j--){
                a[j] = new HashSet();

            }

        for(int i = 1; i <= n ; i++){    //2

            for(int j = m ; j >=0; j--){   //3

                if(j==i && i >= 1) {
                    List l = new ArrayList();
                    l.add(j);
                    a[j].add(l);
                }
                if(j-i < 0) continue;
                //i 放
                Set tmpM_i = new HashSet();
                addAll(tmpM_i,a[j-i]);
                for(Iterator it = tmpM_i.iterator();it.hasNext();){
                    List l = (List) it.next();
                    l.add(i);
                }
                addAll(a[j],tmpM_i);
            }
        }

        return a[m];
    }


    /*
   * 空间复杂度至O（n*m),j的循环循序没有影响，所有j->m的中间状态都有保留，
   *
   * */
    public static Set cal(int n , int m){
        Set[][] a = new HashSet[n+1][m+1];
        for(int i= 0; i<=n;i++)
            for(int j = 0; j<=m;j++){
                a[i][j] = new HashSet();
                if(j==i && i >= 1) {
                    List l = new ArrayList();
                    l.add(j);
                    a[i][j].add(l);
                }
            }

        for(int i = 1; i <= n ; i++){    //2

             for(int j = m ; j >=0; j--){   //3
                 if(a[i-1][j].size() >0)
                 addAll( a[i][j],a[i-1][j]);
                 if(j-i < 0) continue;
                 //i 放
                 Set tmpM_i = new HashSet();
                 addAll(tmpM_i,a[i-1][j-i]);
                     for(Iterator it = tmpM_i.iterator();it.hasNext();){
                         List l = (List) it.next();
                         l.add(i);
                     }
                 addAll(a[i][j],tmpM_i);
             }
        }

       return a[n][m];
    }

    //深度复制set
    private static Set addAll(Set target, Set set){
        if(set.size() ==0) return target;

        for (Object  list : set) {
            List l = new ArrayList();
            for (Object o : (List)list) {

                   l.add(o);
            }
            target.add(l);
        }
        return target;
    }
    public static void main(String[] args) {
        System.out.println(P01MN.cal(10,16));
        System.out.println(P01MN.cal2(10,16));
    }
}
