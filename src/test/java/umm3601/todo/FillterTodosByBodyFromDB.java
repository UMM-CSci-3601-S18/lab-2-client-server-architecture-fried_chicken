package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FillterTodosByBodyFromDB {
  @Test
  public void filterTodosByBody() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] Todos = db.filterTodosByBody(allTodos, "Proident sit reprehenderit adipisicing consequat dolore aliquip ullamco in elit duis. Duis proident ad consectetur excepteur commodo pariatur amet occaecat irure irure dolore irure sit do.");
    assertEquals("Incorrect number of todos with enim", 1, Todos.length);

    Todo[] Todos2 = db.filterTodosByBody(allTodos, "Roch");
    assertEquals("Incorrect number of todos with banana", 0, Todos2.length);
  }


  @Test
  public void listTodosWithBodyFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("body", new String[] {"Proident sit reprehenderit adipisicing consequat dolore aliquip ullamco in elit duis. Duis proident ad consectetur excepteur commodo pariatur amet occaecat irure irure dolore irure sit do."});
    Todo[] todos1 = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with enim", 1, todos1.length);

    queryParams.put("body", new String[] {"Roch "});
    Todo[] todos2 = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with bananas", 0, todos2.length);
  }
}
