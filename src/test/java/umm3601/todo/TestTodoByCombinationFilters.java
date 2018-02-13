package umm3601.todo;

import org.junit.Test;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import static junit.framework.TestCase.assertEquals;

public class TestTodoByCombinationFilters {

  @Test
  public void filterTodosByBody() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());


    Todo[] todos = db.filterTodosByOwner(allTodos, "Blanche");
    todos = db.filterTodosByStatus(todos, true);
    todos = db.filterTodosByLimit(todos, "3");

    for (int i=0; i < todos.length; i++) {
      assertEquals("Incorrect number of todos with category owner", "Blanche", todos[i].owner);
      assertEquals("Incorrect number of todos with category owner", 0, todos[i].status.compareTo(todos[i].status));

    }

  }

  @Test
  public void listTodosWithByBodySorted() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();
    queryParams.put("owner", new String[]{"Blanche"});
    queryParams.put("status", new String[]{"true"});
    queryParams.put("limit", new String[]{"3"});
    Todo[] todos1 = db.listTodos(queryParams);

    for (int i = 0; i < todos1.length; i++) {

      assertEquals("Wrong string returned", "Blanche", todos1[i].owner);
      assertEquals("Wrong string returned", 0, todos1[i].status.compareTo(true));
    }
    assertEquals("Wrong size returned", 2, todos1.length);

  }
}
