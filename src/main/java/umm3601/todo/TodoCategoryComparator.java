package umm3601.todo;

import java.util.Comparator;

public class TodoCategoryComparator implements Comparator<Todo> {

  @Override
  public int compare(Todo todo1, Todo todo2){

    return todo1.category.compareTo(todo2.category);
  }
}
