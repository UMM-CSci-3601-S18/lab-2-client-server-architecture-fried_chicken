package umm3601.todo;

import java.util.Comparator;

public class TodoBodyComparator implements Comparator<Todo> {

  @Override
  public int compare(Todo todo1, Todo todo2){

    return todo1.body.compareTo(todo2.body);
  }
}
