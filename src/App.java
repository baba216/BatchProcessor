import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main(String[] args) {
    BatchProcessor<Integer> batchProcessor = new BatchProcessor<>(10);
    List<Integer> integers = new ArrayList<>(100);
    for (int i = 0; i < 100; i++) {
      integers.add(i);
    }
    batchProcessor.batchProcess(integers, integer -> {
      System.out.println(integer.size());
    });
  }
}
