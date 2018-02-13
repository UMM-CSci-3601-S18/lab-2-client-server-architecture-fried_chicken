package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import static junit.framework.TestCase.assertEquals;

public class SortTodosAlphabeticallyByCategoryFromDB {

  @Test
  public void filterTodosByCategory() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] arr1 = new Todo[3];
    arr1[0] = new Todo("9119111911", "KyleFoss",false,"slim with glasses", "student");
    arr1[1] = new Todo("9119111912", "RochSexy",true,"in shape", "Chef");
    arr1[2] = new Todo("9119111913", "AndyLau",false,"not slim with glasses", "lazyner");

    Todo[] arr2 = new Todo[3];
    arr2[2] = new Todo("9119111911", "KyleFoss",false,"slim with glasses", "student");
    arr2[0] = new Todo("9119111912", "RochSexy",true,"in shape", "Chef");
    arr2[1] = new Todo("9119111913", "AndyLau",false,"not slim with glasses", "lazyner");

    Todo[] Todos = db.orderTodosByField(arr1, "category");

    for(int i = 0; i < 3; i++){
      assertEquals("Not sorted", 0, arr1[i].category.compareTo(arr2[i].category));
    }
  }

  @Test
  public void listTodosWithByCategorySorted() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("orderBy", new String[] {"category"});
    Todo[] todos1 = db.listTodos(queryParams);
    Todo[] todos2 = db.orderTodosByField(todos1, "category");
    System.out.println();
    for(int i =0; i < todos1.length-1; i++) {
      assertEquals("Not sorted", true, todos2[i].category.compareTo(todos2[i+1].category) <= 0);
    }

  }

}
