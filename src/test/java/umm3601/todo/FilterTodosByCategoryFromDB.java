package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByCategoryFromDB {
  @Test
  public void filterTodosByCategory() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] Todos = db.filterTodosByCategory(allTodos, "groceries");
    assertEquals("Incorrect number of todos with category groceries", 76, Todos.length);

    Todo[] Todos2 = db.filterTodosByCategory(allTodos, "groceries");
    assertEquals("Wrong string returned", "groceries", Todos2[0].category);
  }


  @Test
  public void listTodosWithBodyFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("category", new String[] {"video games"});
    Todo[] todos1 = db.listTodos(queryParams);
    assertEquals("Wrong string returned", "video games", todos1[1].category);

    queryParams.put("category", new String[] {"Video games"});
    Todo[] todos2 = db.listTodos(queryParams);
    assertEquals("Incorrect number of Todos with category video games", 71, todos2.length);


  }
}
