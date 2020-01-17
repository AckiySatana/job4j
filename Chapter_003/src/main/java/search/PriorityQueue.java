package search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<Task>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
       if (tasks.size()>0) {
           for (Task tsk : tasks) {
               if (tsk.getPriority() > task.getPriority()) {
                   tasks.add(tasks.indexOf(tsk), task);
                   break;
               }
           }
           this.tasks.add(index, task);
       } else {
           tasks.add(task);
       }
    }

    public Task take() {
        return tasks.remove(0);
    }
}
