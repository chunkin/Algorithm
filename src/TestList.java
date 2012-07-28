import java.net.SocketOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List a = new ArrayList();

        a.add(1);
        a.add(2);
        List b = new ArrayList();
        b.addAll(a);
        b.add(3);
        List c = new ArrayList();
        c.add(a);
        c.add(b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        List d = new ArrayList();
        List e = new ArrayList() ;
        List f = new ArrayList();
        d.addAll(e);
        d.addAll(f);
        System.out.println("llllll");
        e.add(1);
        System.out.println(d);
        System.out.println(e);
        for(Iterator it = d.iterator();it.hasNext();){
          System.out.println("aaa");
        }
    }
}
