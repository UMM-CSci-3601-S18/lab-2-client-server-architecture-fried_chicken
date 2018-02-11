package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.user.Database filterUsersByAge
 * and listUsers with _age_ query parameters
 */
public class FilterTodosByStatusFromDB {

  @Test
  public void filterTodosByStatus() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] falseTodos = db.filterTodosByStatus(allTodos, false);
    assertEquals("Incorrect number of todos with false", 157, falseTodos.length);

    Todo[] trueTodos = db.filterTodosByStatus(allTodos, true);
    assertEquals("Incorrect number of todos with true", 143, trueTodos.length);
  }

  @Test
  public void listTodosWithStatusFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("status", new String[] {"false"});
    Todo[] falseTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with false", 157, falseTodos.length);

    queryParams.put("status", new String[] {"true"});
    Todo[] trueTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with true", 143, trueTodos.length);
  }
}
