package exam3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.layout.Pane;

/**
 *
 * @author jlmcc
 */
public class DoSorts extends Pane{
    private long startTime;
    private long execTime;
    private long endTime;
    
public ArrayList<Integer> getRandom(ArrayList<Integer> list, int size){
    list.clear();
    for(int i = 0; i < size; i++){
                Random rand = new Random();
                int randomNum = rand.nextInt(99);
                list.add(i, randomNum);
            }
    return list;
}
    
public ArrayList<Integer> selectionSort(ArrayList<Integer> list){
    startTime = System.currentTimeMillis();
    for(int i = 0; i < list.size(); i++){
        int pos = i;
        for(int j = i; j < list.size(); j++){
            if(list.get(j) < list.get(pos))
                pos = j;
        }
        int min = list.get(pos);
        list.set(pos, list.get(i));
        list.set(i, min);
    }
    endTime = System.currentTimeMillis();
    return list;
}
    
public ArrayList<Integer> radixSort(ArrayList<Integer> list){

        final int modulus = 10;
        startTime = System.currentTimeMillis();
        
        // Create the buckets, and an ArrayList for each bucket
        List<Integer>[] bucket = new ArrayList[modulus];
        for(int i = 0; i < bucket.length; i++){
            bucket[i] = new ArrayList<Integer>();
        }
        
        // Perform the sort
        int temp = -1, place = 1;
        boolean flag = false;
        while(!flag){
            flag = true;
            for (Integer i : list){
                temp = i / place;
                bucket[temp % modulus].add(i);
                if(flag && temp > 0){
                    flag = false;
                }
            }
            // Empty the buckets
            int a = 0;
            for(int b = 0; b < modulus; b++){
                for(Integer i : bucket[b]){
                    list.set(a++, i);
                }
                bucket[b].clear();
            }
            place *= modulus;
        }
        endTime = System.currentTimeMillis(); 
        return list;
    }

public void bubbleSort(ArrayList<Integer> list){
    startTime = System.currentTimeMillis();
    int n = list.size();
    for(int i = 0; i < n - 1; i++)
        for(int j = 0; j < n - i - 1; j++)
            if(list.get(j) > list.get(j + 1)){
                int temp = list.get(j);
                list.set(j, j + 1);
                list.set(j+1, temp);
            }
    endTime = System.currentTimeMillis(); 
}

public ArrayList<Integer> mergeSort(ArrayList<Integer> list){
    startTime = System.currentTimeMillis();
    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();
    int middle;
    int leftIndex = 0;
    int rightIndex = 0;
    int totalIndex = 0;
    
    if(list.size() == 1){
        return list;
    }
    else{
        // Define the midway point in the list
        middle = list.size()/2;
        // Add the integers less than the middle to the "left" list
        for(int i = 0; i < middle; i++){
            left.add(list.get(i));
        }
        // Add the integers greater than the middle to the "right" list
        for(int i = middle; i < list.size(); i++){
            right.add(list.get(i));
        }
        
        left = mergeSort(left);
        right = mergeSort(right);        
    }
    while(leftIndex < left.size() && rightIndex < right.size()){
        if((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0){
            list.set(totalIndex, left.get(leftIndex));
            leftIndex++;
        }
        else{
            list.set(totalIndex, right.get(rightIndex));
            rightIndex++;
        }
    totalIndex++;   
    }
    ArrayList<Integer> remainder;
    int remainderIndex;
    if(leftIndex >= left.size()){
       remainder = right;
       remainderIndex = rightIndex;
    }
    else{
        remainder = left;
        remainderIndex = leftIndex;
    }
    for(int i = remainderIndex; i < remainder.size(); i++){
        list.set(totalIndex, remainder.get(i));
        totalIndex++;
    }
    endTime = System.currentTimeMillis();
    return list;
}

public ArrayList<Integer> quickSort(ArrayList<Integer> list){
    startTime = System.currentTimeMillis();
    ArrayList<Integer> sort = new ArrayList<Integer>();
    if(list.size() <= 1){
        return list;
    }
    int middle = list.size() / 2;
    int pivot = list.get(middle);
    
    ArrayList<Integer> less = new ArrayList<Integer>();
    ArrayList<Integer> more = new ArrayList<Integer>();
    
    for(int i = 0; i < list.size(); i++){
        if(list.get(i) <= pivot){
            if(i == middle){
                continue;
            }
            less.add(list.get(i));
        }
        else{
            more.add(list.get(i));
        }
    }
    
    for(int i = 0; i < less.size(); i++){
        sort.add(less.get(i));
    }
    
    sort.add(pivot);
    
    for(int i = 0; i < more.size(); i++){
        sort.add(more.get(i));
    }
    endTime = System.currentTimeMillis();
    return sort;
}

public ArrayList<Integer> heapSort(ArrayList<Integer> list){
   startTime = System.currentTimeMillis();
   int size = list.size();
   doHeap(list, size);
   int end = size - 1;
   while(end > 0){
       doSwap(list, end, 0);
       end = end - 1;
       moveDown(list, 0, end);
   }
   endTime = System.currentTimeMillis();
   return list;
}

public void doHeap(ArrayList<Integer> list, int size){
    int start = size / 2 - 1;
    while(start >= 0){
        moveDown(list, start, size - 1);
        start -= 1;
    }
}

public void moveDown(ArrayList<Integer> list, int start, int end){
    int root = start;
    while(root * 2 + 1 <= end){
        int child = root * 2 + 1;
        int swap = root;
        if(list.get(swap) < list.get(child))
        {
            swap = child;
        }
        if(child + 1 <= end && list.get(swap) < list.get(child + 1))
        {
            swap = child + 1;
        }
        if(swap != root){
            doSwap(list, root, swap);
            root = swap;
        }
        else
        {
            return;
        }
    }
}

public void doSwap(ArrayList<Integer> list, int swapOne, int swapTwo){
    int temp = list.get(swapOne);
    list.set(swapOne, list.get(swapTwo));
    list.set(swapTwo, temp);
}

public long getStartTime(){
    return startTime;    
}

public long getEndTime(){
    return endTime;
}

public long getExecTime(){
    long end = endTime - startTime;
    return end;
}

}


