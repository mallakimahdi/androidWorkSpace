import java.util.LinkedList;
import java.util.ListIterator;


public class listiterator 
{
	public static void main(String[] args) 
	{
        final LinkedList<String> list = new LinkedList<String> ();

        list.add ("1"); list.add ("2"); list.add ("3"); list.add ("4");

        final ListIterator<String> it = list.listIterator();

        System.out.println(it.next());
        System.out.println(it.next ());
        System.out.println(it.next ());
        System.out.println(it.previous ());
        System.out.println(it.previous ());
        System.out.println(it.next ());
    }
}
