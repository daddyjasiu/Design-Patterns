import java.util.Arrays;

interface Strategy{
    public void Sort(int[] tab);
}

class SortContext{
    private Strategy strategy;

    public SortContext(Strategy strategy){
        this.strategy = strategy;
    }
    public void sort(int[] tab){
        strategy.Sort(tab);
    }
}

class BubbleSort implements Strategy{
    @Override
    public void Sort(int[] tab)
    {
        int n = tab.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (tab[j] > tab[j+1])
                {
                    int temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = temp;
                }
    }
}

class InsertionSort implements Strategy{
    @Override
    public void Sort(int[] tab){
        int n = tab.length;
        for (int i = 1; i < n; ++i) {
            int key = tab[i];
            int j = i - 1;

            while (j >= 0 && tab[j] > key) {
                tab[j + 1] = tab[j];
                j = j - 1;
            }
            tab[j + 1] = key;
        }
    }
}

class JavaSort implements Strategy{
    @Override
    public void Sort(int[] tab){
        Arrays.sort(tab);
    }
}

public class ZadanieA {
    public static void main(String[] main){
        int[] tab = {9,3,4,5,6,1,2,8,7};

        SortContext sortContext = new SortContext(new JavaSort());
        sortContext.sort(tab);

        for (int i : tab){
            System.out.print(i + " ");
        }
    }
}
