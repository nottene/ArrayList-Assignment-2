import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(SieveOfEratosthenes(100));
        System.out.println(GoldbachConjecture(120));
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(7);
        arr1.add(1);
        arr1.add(9);


        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(4);
        arr2.add(8);
        arr2.add(5);

        System.out.println(add(arr1,arr2));
    }

    public static ArrayList<Integer> SieveOfEratosthenes(int n) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int i = 2; i < n+1; i++) {
            numList.add(i);
        }

        for(int i = 0; i < numList.size(); i++) {
            for(int j = i + 1; j < numList.size(); j++) {
                if(numList.get(j) > numList.get(i) && numList.get(j) % numList.get(i) == 0) {
                    numList.remove(j);
                    j--;
                }
            }
        }
        return numList;
    }

    //pre-condition: parameter n has to be an even number
    public static ArrayList<Integer> GoldbachConjecture(int n) {
        ArrayList<Integer> temp = SieveOfEratosthenes(n);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < temp.size(); i++) {
            if(temp.contains(n - temp.get(i))) {
                result.add(temp.get(i));
                result.add(n - temp.get(i));
                break;
            }
        }
        return result;
    }

    public static ArrayList<Integer> add(ArrayList<Integer> first, ArrayList<Integer> second) {

        int max = Math.max(first.size(), second.size());
        ArrayList<Integer> sum = new ArrayList<Integer>();

        for (int i = 0; i < max; i++) {
            sum.add(0);
        }

        if(first.size() > second.size()) {
            for(int i = first.size()-1-second.size(); i >= 0; i--) {
                second.add(0,0);
            }
        } else if(second.size() > first.size()) {
            for(int i = second.size()-1-first.size(); i >= 0; i--) {
                first.add(0,0);
            }
        }
        System.out.println(first);
        System.out.println(second);

        int temp = 0;

        for(int i = sum.size()-1; i >= 0; i--) {
            sum.set(i,(first.get(i) + second.get(i) + temp) % 10);
            temp = ((first.get(i) + second.get(i) + temp) / 10);
        }
        if(temp > 0) {
            sum.add(0,temp);
        }

        return sum;
    }
}
