package umm3601.todo;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todos.Database getUser functionality
 */
public class GetTodoByIDFromDB {

  @Test
  public void getBlanche() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985a22c04e761776d54");
    assertEquals("Incorrect name", "Blanche", todo.owner);
  }

  @Test
  public void getFry() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985c1849992336c219b");
    assertEquals("Incorrect name", "Fry", todo.owner);
  }
}
