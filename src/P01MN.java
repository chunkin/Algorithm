import com.sun.tools.doclets.internal.toolkit.util.SourceToHTMLConverter;

import java.util.*;

/*
* 数列1..N ,求所有和等M的组合
* */
public class P01MN  {

    public static Set cal(int n , int m){
        Set[][] a = new HashSet[n+1][m+1];
        for(int i= 0; i<=n;i++)
            for(int j = 0; j<=m;j++){
                a[i][j] = new HashSet();
                //a[i][j].add(new ArrayList());
                if(j==i && i >= 1) {
                    List l = new ArrayList();
                    l.add(j);
                    a[i][j].add(l);
                }
            }

        for(int i = 1; i <= n ; i++){    //2

             for(int j = m ; j >=0; j--){   //3

//                 System.out.println(j+"   *******************"+a[2][1]);

//                 System.out.println("a["+(i-1)+"]["+j+"] = "+a[i-1][j]);
                 if(a[i-1][j].size() >0)
                 addAll( a[i][j],a[i-1][j]);
//                 System.out.println("add j  "+"a["+i+"]["+j+"] = "+a[i][j]);
                 if(j-i < 0) continue;
                 //i 放
                 Set tmpM_i = new HashSet();
                 addAll(tmpM_i,a[i-1][j-i]);



//                 System.out.println("a["+(i-1)+"]["+(j-i)+"] = "+a[i-1][j-i]);

//                 ArrayList<Integer> integers = new ArrayList<Integer>();
//                 integers.add(i);
//                 if(tmpM_i.size()==0)tmpM_i.add(integers);
//                 else{
                     for(Iterator it = tmpM_i.iterator();it.hasNext();){
                         List l = (List) it.next();
                         l.add(i);
                     }
//                 System.out.println("----------------------"+a[1][1]);
//                 }
                 addAll(a[i][j],tmpM_i);
//                 System.out.println("add j-"+i+"  "+"a["+i+"]["+j+"] = "+a[i][j]);
//                 if(j==1){
//                     List l = new ArrayList();
//                     l.add(1);
//                     a[i][j].add(l);
//                 }
             }
//            System.out.println("i="+(i+1)+"  //////////////////////////////////////////");
        }

       return a[n][m];
    }
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
        long l = System.currentTimeMillis();
        System.out.println(P01MN.cal(4,3));
        System.out.println(System.currentTimeMillis()-l);
        System.out.println(P01MN.cal(10,16).size());
    }
}
