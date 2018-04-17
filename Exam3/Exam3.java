package exam3;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author jlmcc
 */
public class Exam3 extends Application {
    
    private TableView table = new TableView();
    ArrayList<Integer> list = new ArrayList();
    private final ObservableList<Sort> data = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage primaryStage) {
        DoSorts doSorts = new DoSorts();
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(5,5,5,5));
        
        table.setEditable(true);
        TableColumn arraySizeCol = new TableColumn("Arraysize");
        arraySizeCol.setCellValueFactory(new PropertyValueFactory<Sort, Long>("arraySize"));
        TableColumn selecSortCol = new TableColumn("Selection Sort");
        selecSortCol.setCellValueFactory(new PropertyValueFactory<Sort, Long>("selecSort"));
        TableColumn radSortCol = new TableColumn("Radix Sort");
        radSortCol.setCellValueFactory(new PropertyValueFactory<Sort, Long>("radSort"));
        TableColumn bubSortCol = new TableColumn("Bubble Sort");
        bubSortCol.setCellValueFactory(new PropertyValueFactory<Sort, Long>("bubSort"));
        TableColumn mergeSortCol = new TableColumn("Merge Sort");
        mergeSortCol.setCellValueFactory(new PropertyValueFactory<Sort, Long>("mergeSort"));
        TableColumn quickSortCol = new TableColumn("Quick Sort");
        quickSortCol.setCellValueFactory(new PropertyValueFactory<Sort, Long>("quickSort"));
        TableColumn heapSortCol = new TableColumn("Heap Sort");
        heapSortCol.setCellValueFactory(new PropertyValueFactory<Sort, Long>("heapSort"));
        
        table.getColumns().addAll(arraySizeCol, selecSortCol, radSortCol, bubSortCol, mergeSortCol, quickSortCol, heapSortCol);
        Button btn = new Button("Run");
  
        vbox.getChildren().addAll(table, btn);
        
        list = doSorts.getRandom(list, 50000);
        System.out.print(list);
        System.out.println(doSorts.radixSort(list));

        long test = 999;
        btn.setOnAction(e -> {
            // Sort a new random list for each sort for 50000 random integers
            // Selection Sort - 50000
            list = doSorts.getRandom(list, 50000);
            System.out.print(list);
            System.out.println(doSorts.selectionSort(list));
            long selectionTimeOne = doSorts.getExecTime();

            // Radix Sort - 50000
            list = doSorts.getRandom(list, 50000);
            doSorts.radixSort(list);
            long radTimeOne = doSorts.getExecTime();

            // Bubble Sort - 50000
            list = doSorts.getRandom(list, 50000);
            doSorts.bubbleSort(list);
            long bubTimeOne = doSorts.getExecTime();

            // Merge Sort - 50000
            list = doSorts.getRandom(list, 50000);
            doSorts.mergeSort(list);
            long mergeTimeOne = doSorts.getExecTime();

            // Quick Sort - 50000
            list = doSorts.getRandom(list, 50000);
            doSorts.quickSort(list);
            long selectSortOne = doSorts.getExecTime();

            // Heap Sort - 50000
            list = doSorts.getRandom(list, 50000);
            doSorts.heapSort(list);
            long heapSortOne = doSorts.getExecTime();
            
            data.add(new Sort(new Long(50000), selectionTimeOne, radTimeOne, bubTimeOne, mergeTimeOne, selectSortOne, heapSortOne));
            table.setItems(data);
            
            // Selection Sort - 100000
            list = doSorts.getRandom(list, 100000);
            doSorts.selectionSort(list);
            long selectionTimeTwo = doSorts.getExecTime();

            // Radix Sort - 100000
            list = doSorts.getRandom(list, 100000);
            doSorts.radixSort(list);
            long radTimeTwo = doSorts.getExecTime();

            // Bubble Sort - 100000
            list = doSorts.getRandom(list, 100000);
            doSorts.bubbleSort(list);
            long bubTimeTwo = doSorts.getExecTime();

            // Merge Sort - 100000
            list = doSorts.getRandom(list, 100000);
            doSorts.mergeSort(list);
            long mergeTimeTwo = doSorts.getExecTime();

            // Quick Sort - 100000
            list = doSorts.getRandom(list, 100000);
            doSorts.quickSort(list);
            long selectSortTwo = doSorts.getExecTime();

            // Heap Sort - 150000
            list = doSorts.getRandom(list, 100000);
            doSorts.heapSort(list);
            long heapSortTwo = doSorts.getExecTime();
            
            data.add(new Sort(new Long(100000), selectionTimeTwo, radTimeTwo, bubTimeTwo, mergeTimeTwo, selectSortTwo, heapSortTwo));
            table.setItems(data);
            
            // Selection Sort - 150000
            list = doSorts.getRandom(list, 150000);
            doSorts.selectionSort(list);
            long selectionTimeThree = doSorts.getExecTime();

            // Radix Sort - 150000
            list = doSorts.getRandom(list, 150000);
            doSorts.radixSort(list);
            long radTimeThree = doSorts.getExecTime();

            // Bubble Sort - 150000
            list = doSorts.getRandom(list, 150000);
            doSorts.bubbleSort(list);
            long bubTimeThree = doSorts.getExecTime();

            // Merge Sort - 150000
            list = doSorts.getRandom(list, 150000);
            doSorts.mergeSort(list);
            long mergeTimeThree = doSorts.getExecTime();

            // Quick Sort - 150000
            list = doSorts.getRandom(list, 150000);
            doSorts.quickSort(list);
            long selectSortThree = doSorts.getExecTime();

            // Heap Sort - 150000
            list = doSorts.getRandom(list, 150000);
            doSorts.heapSort(list);
            long heapSortThree = doSorts.getExecTime();
            
            data.add(new Sort(new Long(150000), selectionTimeThree, radTimeThree, bubTimeThree, mergeTimeThree, selectSortThree, heapSortThree));
            table.setItems(data);
            
            // Selection Sort - 200000
            list = doSorts.getRandom(list, 200000);
            doSorts.selectionSort(list);
            long selectionTimeFour = doSorts.getExecTime();

            // Radix Sort - 200000
            list = doSorts.getRandom(list, 200000);
            doSorts.radixSort(list);
            long radTimeFour = doSorts.getExecTime();

            // Bubble Sort - 200000
            list = doSorts.getRandom(list, 200000);
            doSorts.bubbleSort(list);
            long bubTimeFour = doSorts.getExecTime();

            // Merge Sort - 200000
            list = doSorts.getRandom(list, 200000);
            doSorts.mergeSort(list);
            long mergeTimeFour = doSorts.getExecTime();

            // Quick Sort - 200000
            list = doSorts.getRandom(list, 200000);
            doSorts.quickSort(list);
            long selectSortFour = doSorts.getExecTime();

            // Heap Sort - 200000
            list = doSorts.getRandom(list, 200000);
            doSorts.heapSort(list);
            long heapSortFour = doSorts.getExecTime();
            
            data.add(new Sort(new Long(200000), selectionTimeFour, radTimeFour, bubTimeFour, mergeTimeFour, selectSortFour, heapSortFour));
            table.setItems(data);
            
            // Selection Sort - 250000
            list = doSorts.getRandom(list, 250000);
            doSorts.selectionSort(list);
            long selectionTimeFive = doSorts.getExecTime();

            // Radix Sort - 250000
            list = doSorts.getRandom(list, 250000);
            doSorts.radixSort(list);
            long radTimeFive = doSorts.getExecTime();

            // Bubble Sort - 250000
            list = doSorts.getRandom(list, 250000);
            doSorts.bubbleSort(list);
            long bubTimeFive = doSorts.getExecTime();

            // Merge Sort - 250000
            list = doSorts.getRandom(list, 250000);
            doSorts.mergeSort(list);
            long mergeTimeFive = doSorts.getExecTime();

            // Quick Sort - 250000
            list = doSorts.getRandom(list, 250000);
            doSorts.quickSort(list);
            long selectSortFive = doSorts.getExecTime();

            // Heap Sort - 250000
            list = doSorts.getRandom(list, 250000);
            doSorts.heapSort(list);
            long heapSortFive = doSorts.getExecTime();
            
            data.add(new Sort(new Long(250000), selectionTimeFive, radTimeFive, bubTimeFive, mergeTimeFive, selectSortFive, heapSortFive));
            table.setItems(data);
            
            // Selection Sort - 300000
            list = doSorts.getRandom(list, 300000);
            doSorts.selectionSort(list);
            long selectionTimeSix = doSorts.getExecTime();

            // Radix Sort - 300000
            list = doSorts.getRandom(list, 300000);
            doSorts.radixSort(list);
            long radTimeSix = doSorts.getExecTime();

            // Bubble Sort - 300000
            list = doSorts.getRandom(list, 300000);
            doSorts.bubbleSort(list);
            long bubTimeSix = doSorts.getExecTime();

            // Merge Sort - 300000
            list = doSorts.getRandom(list, 300000);
            doSorts.mergeSort(list);
            long mergeTimeSix = doSorts.getExecTime();

            // Quick Sort - 300000
            list = doSorts.getRandom(list, 300000);
            doSorts.quickSort(list);
            long selectSortSix = doSorts.getExecTime();

            // Heap Sort - 300000
            list = doSorts.getRandom(list, 300000);
            doSorts.heapSort(list);
            long heapSortSix = doSorts.getExecTime();
            
            data.add(new Sort(new Long(300000), selectionTimeSix, radTimeSix, bubTimeSix, mergeTimeSix, selectSortSix, heapSortSix));
            table.setItems(data);
        });
        
        Scene scene = new Scene(vbox, 570, 250);
        
        primaryStage.setTitle("Exam 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static class Sort {
        private final SimpleLongProperty arraySize;
        private final SimpleLongProperty selecSort;
        private final SimpleLongProperty radSort;
        private final SimpleLongProperty bubSort;
        private final SimpleLongProperty mergeSort;
        private final SimpleLongProperty quickSort;
        private final SimpleLongProperty heapSort;
        
        private Sort(long arraySize, long selecSortTime, long radSortTime, long bubSortTime, long mergeSortTime, long quickSortTime, long heapSortTime){
            this.arraySize = new SimpleLongProperty(arraySize);
            this.selecSort = new SimpleLongProperty(selecSortTime);
            this.radSort = new SimpleLongProperty(radSortTime);
            this.bubSort = new SimpleLongProperty(bubSortTime);
            this.mergeSort = new SimpleLongProperty(mergeSortTime);
            this.quickSort = new SimpleLongProperty(quickSortTime);
            this.heapSort = new SimpleLongProperty(heapSortTime);
        }
        
        public Long getArraySize(){
            return arraySize.get();
        }
        
        public void setArraySize(Long aSize){
            arraySize.set(aSize);
        }
        
        public Long getSelecSort(){
            return selecSort.get();
        }
        
        public void setSelecSort(Long sSort){
            selecSort.set(sSort);
        }
        
        public Long getRadSort(){
            return radSort.get();
        }
        
        public void setRadSort(Long rSort){
            radSort.set(rSort);
        }
        
        public Long getBubSort(){
            return bubSort.get();
        }
        
        public void setBubSort(Long bSort){
            bubSort.set(bSort);
        }
        
        public Long getMergeSort(){
            return mergeSort.get();
        }
        
        public void setMergeSort(Long mSort){
            mergeSort.set(mSort);
        }
        
        public Long getQuickSort(){
            return quickSort.get();
        }
        
        public void setQuickSort(Long qSort){
            quickSort.set(qSort);
        }
        
        public Long getHeapSort(){
            return heapSort.get();
        }
        
        public void setHeapSort(Long hSort){
            heapSort.set(hSort);
        }
    }
    
}
