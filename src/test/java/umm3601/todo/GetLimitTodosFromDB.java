package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class GetLimitTodosFromDB {
  @Test
  public void filterTodosByLimit() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] Todos = db.filterTodosByLimit(allTodos, "15");
    assertEquals("Incorrect number of todos", 15, Todos.length);

    Todo[] Todos2 = db.filterTodosByLimit(allTodos, "5");
    assertEquals("Incorrect number of todos", 5, Todos2.length);
  }


  @Test
  public void listTodosWithLimitFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("limit", new String[] {"15"});
    Todo[] todos1 = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos", 15, todos1.length);

    queryParams.put("limit", new String[] {"5"});
    Todo[] todos2 = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos", 5, todos2.length);
  }
}
