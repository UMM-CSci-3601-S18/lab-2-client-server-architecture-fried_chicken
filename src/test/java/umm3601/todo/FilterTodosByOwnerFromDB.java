package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByOwnerFromDB {
  @Test
  public void filterTodosByOwner() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] Todos = db.filterTodosByOwner(allTodos, "Fry");
    assertEquals("Incorrect number of todos with category owner", 61, Todos.length);

    Todo[] Todos2 = db.filterTodosByOwner(allTodos, "Blanche");
    assertEquals("Wrong string returned", "Blanche", Todos2[0].owner);
  }


  @Test
  public void listTodosWithBodyFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("owner", new String[] {"Fry"});
    Todo[] todos1 = db.listTodos(queryParams);
    assertEquals("Wrong string returned", "Fry", todos1[1].owner);

    queryParams.put("owner", new String[] {"Blanche"});
    Todo[] todos2 = db.listTodos(queryParams);
    assertEquals("Incorrect number of Todos with owner Blanche", 43, todos2.length);


  }
}
