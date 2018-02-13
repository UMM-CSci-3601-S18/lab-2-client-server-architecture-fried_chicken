package umm3601.todo;

import java.util.Comparator;

public class TodoStatusComparator implements Comparator<Todo> {

  @Override
  public int compare(Todo todo1, Todo todo2){

    return String.valueOf(todo1.status).compareTo(String.valueOf(todo2.status));
  }
}
