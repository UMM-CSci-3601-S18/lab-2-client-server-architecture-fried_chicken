package umm3601.todo;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


/**
 * A fake "to-do" of to-do info
 *
 * Since we don't want to complicate this lab with a real database,
 * we're going to instead just read a bunch of to-do data from a
 * specified JSON file, and then provide various database-like
 * methods that allow the `TodoController` to "query" the "database".
 */
public class Database {

  private Todo[] allTodos;

  public Database(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  /**
   * Get the single to-do specified by the given ID. Return
   * `null` if there is no to-do with that ID.
   *
   * @param id the ID of the desired to-do
   * @return the to-do with the given ID, or null if there is no to-do
   * with that ID
   */
  public Todo getTodo(String id) {
    System.out.println(id + "here2");
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  /**
   * Get the single to-do specified by the given ID. Return
   * `null` if there is no to-do with that ID.
   *
   * @param  queryParams for various inputs in html form fields
   * @return the disired array of to-dos

   */

  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;



    if(queryParams.containsKey("status")) {
      Boolean targetStatus = Boolean.valueOf(queryParams.get("status")[0]);
      filteredTodos = filterTodosByStatus(filteredTodos, targetStatus);
    }

    if(queryParams.containsKey("body")) {
      String targetString = queryParams.get("body")[0].toLowerCase();
      filteredTodos = filterTodosByBody(filteredTodos, targetString);
    }

    if(queryParams.containsKey("category")) {
      String targetString = queryParams.get("category")[0].toLowerCase();
      filteredTodos = filterTodosByCategory(filteredTodos, targetString);
    }

    if(queryParams.containsKey("owner")) {
      String targetOwner = queryParams.get("owner")[0].toLowerCase();
      filteredTodos = filterTodosByOwner(filteredTodos, targetOwner);
    }

    if(queryParams.containsKey("limit")) {
      String targetLimit = queryParams.get("limit")[0];
      if(targetLimit.compareTo("") != 0) {
        filteredTodos = filterTodosByLimit(filteredTodos, targetLimit);
      }

    }
    if(queryParams.containsKey("orderBy")) {
      String fieldToOrder = queryParams.get("orderBy")[0];
      filteredTodos=orderTodosByField(filteredTodos, fieldToOrder);

    }


    return filteredTodos;
  }

  /**
   * Get an array of all the todos having the target status.
   *
   * @param todos the list of to-dos to filter by status
   * @param targetStatus the target status to look for
   * @return an array of all the to-dos from the given list that have
   * the target to-dos
   */
  public Todo[] filterTodosByStatus(Todo[] todos, Boolean targetStatus) {
    return Arrays.stream(todos).filter(x -> x.status == targetStatus).toArray(Todo[]::new);
  }

  /**
   * Get an array of all the to-dos having the target body.
   *
   * @param todos the list of todos to filter by age
   * @param targetString the target body to look for
   * @return an array of all the to-dos from the given list that have
   * the target to-dos
   */
  public Todo[] filterTodosByBody(Todo[] todos, String targetString) {
    return Arrays.stream(todos).filter(x -> x.body.toLowerCase().contains(targetString.toLowerCase())).toArray(Todo[]::new);
  }

  /**
   * Get an array of all to-dos the  having the target limit.
   *
   * @param todos the list of to-dos to filter by limit
   * @param targetLimit the target limit to look for
   * @return an array of all the todos from the given list that have
   * the limit of to-dos
   */
  public Todo[] filterTodosByLimit(Todo[] todos, String targetLimit) {
    Todo[] limitTodos1 = new Todo[Integer.parseInt(targetLimit)];
    for(int i = 0; i < Integer.parseInt(targetLimit); i++){
      limitTodos1[i] = todos[i];

    }
    return limitTodos1;
  }

  /**
   * Get an array of all the to-dos having the target category.
   *
   * @param todos list of todos to filter by category
   * @param targetString the target category to filter by
   * @return an array of all the to-dos from the given list that have been filtered
   *
   */
  public Todo[] filterTodosByCategory(Todo[] todos, String targetString) {
    return Arrays.stream(todos).filter(x -> x.category.toLowerCase().contains(targetString.toLowerCase())).toArray(Todo[]::new);
  }

  /**
   * Get an array of all the todos having the target age.
   *
   * @param todos the list of todos to filter by age
   * @param targetOwner the target age to look for
   * @return an array of all the todos from the given list that have
   * the target age
   */
  public Todo[] filterTodosByOwner(Todo[] todos, String targetOwner) {
    return Arrays.stream(todos).filter(x -> x.owner.toLowerCase().contains(targetOwner.toLowerCase())).toArray(Todo[]::new);
  }

  /**
   * Get an array of all the todos having the target age.
   *
   * @param todos the list of todos to filter by age
   * @param fieldToOrder the target age to look for
   * @return an array of all the todos from the given list that have
   * the target age
   */
  public Todo[] orderTodosByField(Todo[] todos, String fieldToOrder) {
    Todo[] filteredTodo;
    if(fieldToOrder.compareTo("owner") == 0){
     Arrays.sort(todos, new TodoOwnerComparator());

    }

    if(fieldToOrder.compareTo("category") == 0){
      Arrays.sort(todos, new TodoCategoryComparator());

    }

    if(fieldToOrder.compareTo("status") == 0){
      Arrays.sort(todos, new TodoStatusComparator());

    }

    if(fieldToOrder.compareTo("body") == 0){
      Arrays.sort(todos, new TodoBodyComparator());

    }

    return todos;
  }


}
