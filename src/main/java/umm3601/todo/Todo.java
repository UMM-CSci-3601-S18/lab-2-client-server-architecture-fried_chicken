package umm3601.todo;

public class Todo{
  String _id;
  String owner;
  Boolean status;
  String body;
  String category;

  public Todo(String _id, String owner, Boolean status, String body, String category){
    this._id = _id;
    this.owner =owner;
    this.status = status;
    this.body = body;
    this.category = category;
  }

  public String toString() {
    return String.format(_id + " " + owner + " " + status + " " + body + " " + category);
  }

}
