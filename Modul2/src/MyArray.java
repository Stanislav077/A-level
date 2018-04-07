
import java.util.*;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Станислав on 07.04.2018.
 */
public class MyArray<T> implements List {

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    @Override
    public Object remove(int index) {
        for (int i = index; i<pointer; i++)
           array[i] = array[i+1];
       array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2);
        return index;
    }



    public int size()  {
        return pointer;
    }


    public T get(int index) {
        return (T) array[index];
    }

   public Object adds(Object e)
   {
       array[pointer++] = e;
       return pointer;
   }

    @Override
    public void add(int index, Object element) {


        System.out.println(pointer);

        if(pointer == array.length-1) {
            resize(array.length * 2);
        }
       array[pointer++] = element;


    }
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    @Override
    public Object set(int index, Object element) throws UnsupportedOperationException  {


                 return new UnsupportedOperationException();

    }

    @Override
    public boolean remove(Object o) throws UnsupportedOperationException {
        return false;
    }
    @Override
    public int indexOf(Object o) throws UnsupportedOperationException {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) throws UnsupportedOperationException {
        return 0;
    }

    @Override
    public ListIterator listIterator() throws UnsupportedOperationException {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) throws UnsupportedOperationException {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
        return null;
    }

    @Override
    public boolean isEmpty() throws UnsupportedOperationException {
        return false;
    }

    @Override
    public boolean contains(Object o) throws UnsupportedOperationException {
        return false;
    }

    @Override
    public Iterator iterator() throws UnsupportedOperationException {
        return null;
    }

    @Override
    public Object[] toArray() throws UnsupportedOperationException {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) throws UnsupportedOperationException {
        return false;
    }




    @Override
    public boolean addAll(Collection c) throws UnsupportedOperationException {
        return false;
    }

    @Override
    public boolean removeIf(Predicate filter) throws UnsupportedOperationException {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) throws UnsupportedOperationException {
        return false;
    }

    @Override
    public void clear() throws UnsupportedOperationException {

    }

    @Override
    public boolean retainAll(Collection c) throws UnsupportedOperationException {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) throws UnsupportedOperationException {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) throws UnsupportedOperationException {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) throws UnsupportedOperationException {
        return new Object[0];
    }






}
