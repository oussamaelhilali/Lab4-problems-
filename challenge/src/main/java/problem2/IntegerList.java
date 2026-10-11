package problem2;

public class IntegerList
{
    int[] list;
    int numElements;

    //create a list of the given size
    public IntegerList(int size) {
        list = new int[size];
        numElements = 0;
    }

    //fill array with integers between 1 and 100, inclusive
    public void randomize()
    {
        for (int i=0; i<list.length; i++)
            list[i] = (int)(Math.random() * 100) + 1;
    }
    //print array elements with indices
    public void print()
    {
        for (int i=0; i<list.length; i++)
            System.out.println(i + ":\t" + list[i]);
    }

    public void IncreaseSize() {
        int newSize = 0;
        if (list.length == 0) {
            newSize = 2;
        } else {
            newSize = list.length * 2;
        }
        int[] new_list = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            new_list[i] = list[i];
        }
        list = new_list;
    }

    public void addElement(int newVal) {
        if (numElements == list.length) {
            IncreaseSize();
        }
        list[numElements] = newVal;
        numElements++;
    }

    public void removeFirst(int newVal) {
        int index = -1;
        for (int i = 0; i < numElements; i++) {
            if (list[i] == newVal) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < numElements - 1; i++) {
                list[i] = list[i + 1];
            }
            numElements--;
        }
    }

    public void removeAll(int newVal) {
        int i = 0;
        while (i < numElements) {
            if (list[i] == newVal) {
                for (int j = i; j < numElements - 1; j++) {
                    list[j] = list[j + 1];
                }
                numElements--;
            } else {
                i++;
            }
        }
    }
}