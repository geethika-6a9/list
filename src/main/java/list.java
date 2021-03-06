import java.util.Arrays;
class List<E>
{
        private int size = 0;
        private static final int capacity = 10;
        private Object elements[];
        public List()
        {
            elements = new Object[capacity];
        }
        public void add(E e)
        {
            if (size == elements.length) {
                ensureCapacity();
            }
            elements[size++] = e;
        }
        public E get(int i)
        {
            if (i >= size || i < 0) {
                throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
            }
            return (E) elements[i];
        }
        public E remove(int i)
        {
            if (i >= size || i < 0)
            {
                throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
            }
            Object item = elements[i];
            int numElts = elements.length - ( i + 1 ) ;
            System.arraycopy( elements, i + 1, elements, i, numElts ) ;
            size--;
            return (E) item;
        }
        public int size()
        {
            return size;
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < size; i++) {
                sb.append(elements[i].toString());
                if (i < size - 1) {
                    sb.append(",");
                }
            }
            sb.append(']');
            return sb.toString();
        }
        private void ensureCapacity() {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }
    class Main
    {
        public static void main(String[] args)
        {
            List<Integer> list = new List<Integer>();
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println(list);
            list.remove(2);
            System.out.println(list);
            System.out.println( list.get(0) );
            System.out.println( list.get(1) );
            System.out.println(list.size());
        }
    }
