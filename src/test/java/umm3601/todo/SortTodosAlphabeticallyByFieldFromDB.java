package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class SortTodosAlphabeticallyByFieldFromDB {
  ArrayList <Todo> todos = new ArrayList<>();

  @Test
  public void filterTodosByBody() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] Todos = db.orderTodosByField(allTodos, "owner");
    for(int i = 0; i < 300; i++){
      System.out.println(Todos[i].owner);
    }
    assertEquals("Incorrect number of todos with enim", 1, Todos.length);

    Todo[] Todos2 = db.filterTodosByBody(allTodos, "Roch");
    assertEquals("Incorrect number of todos with banana", 0, Todos2.length);
  }

}
