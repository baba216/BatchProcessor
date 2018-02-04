import java.util.List;
import java.util.function.Consumer;

public class BatchProcessor<T> {

  private int batchSize;

  public BatchProcessor(int batchSize) {
    this.batchSize = batchSize;
  }

  public void batchProcess(List<T> listToProcess, Consumer<List<T>> consumer) {
    int size = listToProcess.size();

    int batchProcessCount = listToProcess.size() / batchSize;
    System.out.println("Batch Process Count:" + batchProcessCount);
    for (int batchIndex = 1; batchIndex <= batchProcessCount; batchIndex++) {
      int start = batchSize * (batchIndex - 1);
      int end = batchSize * batchIndex;
      List<T> subList = listToProcess.subList(start, end);
      consumer.accept(subList);
    }
    if (batchProcessCount * batchSize < size) {
      System.out.println("Going to Process Remaning Items");
      int start = batchProcessCount * batchSize;
      List<T> subList = listToProcess.subList(start, size);
      consumer.accept(subList);
    }
  }
}
