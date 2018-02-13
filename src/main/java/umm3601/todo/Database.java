package umm3601.todo;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


/**
 * A fake "database" of user info
 *
 * Since we don't want to complicate this lab with a real database,
 * we're going to instead just read a bunch of user data from a
 * specified JSON file, and then provide various database-like
 * methods that allow the `UserController` to "query" the "database".
 */
public class Database {

  private Todo[] allTodos;

  public Database(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  /**
   * Get the single user specified by the given ID. Return
   * `null` if there is no user with that ID.
   *
   * @param id the ID of the desired user
   * @return the user with the given ID, or null if there is no user
   * with that ID
   */
  public Todo getTodo(String id) {
    System.out.println(id + "here2");
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

 /* *//**//**
   * Get an array of all the users satisfying the queries in the params.
   *
   * @param queryParams map of required key-value pairs for the query
   * @return an array of all the users matching the given criteria
   *//**//*
  public User[] listUsers(Map<String, String[]> queryParams) {
    User[] filteredUsers = allUsers;

    // Filter age if defined
    if(queryParams.containsKey("age")) {
      int targetAge = Integer.parseInt(queryParams.get("age")[0]);
      filteredUsers = filterUsersByAge(filteredUsers, targetAge);
    }
    // Process other query parameters here...

    return filteredUsers;
  }*//*




  */



  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;

    System.out.println("here");

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
   * Get an array of all the users having the target age.
   *
   * @param todos the list of users to filter by age
   * @param targetStatus the target age to look for
   * @return an array of all the users from the given list that have
   * the target age
   */
  public Todo[] filterTodosByStatus(Todo[] todos, Boolean targetStatus) {
    return Arrays.stream(todos).filter(x -> x.status == targetStatus).toArray(Todo[]::new);
  }

  /**
   * Get an array of all the users having the target age.
   *
   * @param todos the list of users to filter by age
   * @param targetString the target age to look for
   * @return an array of all the users from the given list that have
   * the target age
   */
  public Todo[] filterTodosByBody(Todo[] todos, String targetString) {
    return Arrays.stream(todos).filter(x -> x.body.toLowerCase().contains(targetString.toLowerCase())).toArray(Todo[]::new);
  }

  /**
   * Get an array of all the users having the target age.
   *
   * @param todos the list of users to filter by age
   * @param targetLimit the target age to look for
   * @return an array of all the users from the given list that have
   * the target age
   */
  public Todo[] filterTodosByLimit(Todo[] todos, String targetLimit) {
    Todo[] limitTodos1 = new Todo[Integer.parseInt(targetLimit)];
    for(int i = 0; i < Integer.parseInt(targetLimit); i++){
      limitTodos1[i] = todos[i];

    }
    return limitTodos1;
  }

  /**
   * Get an array of all the users having the target age.
   *
   * @param todos the list of users to filter by age
   * @param targetString the target age to look for
   * @return an array of all the users from the given list that have
   * the target age
   */
  public Todo[] filterTodosByCategory(Todo[] todos, String targetString) {
    return Arrays.stream(todos).filter(x -> x.category.toLowerCase().contains(targetString.toLowerCase())).toArray(Todo[]::new);
  }

  /**
   * Get an array of all the users having the target age.
   *
   * @param todos the list of users to filter by age
   * @param targetOwner the target age to look for
   * @return an array of all the users from the given list that have
   * the target age
   */
  public Todo[] filterTodosByOwner(Todo[] todos, String targetOwner) {
    return Arrays.stream(todos).filter(x -> x.owner.toLowerCase().contains(targetOwner.toLowerCase())).toArray(Todo[]::new);
  }

  /**
   * Get an array of all the users having the target age.
   *
   * @param todos the list of users to filter by age
   * @param fieldToOrder the target age to look for
   * @return an array of all the users from the given list that have
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
