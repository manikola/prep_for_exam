package exam03retake02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo){
        todos.add(todo);
    }

    public int getNumberOfItemsLeft(){
        int counter =0;
        for(Todo item : todos){
            if(item.getState().equals(State.NON_COMPLETED)){
                counter++;
            }
        }return counter;
    }

    public List<String> getMostImportantTodosText(){
        List<String>  maxImportant = new ArrayList<>();
        todos.sort(Comparator.comparing(Todo::getPriority));
        int min = todos.get(0).getPriority();
        for(Todo item : todos){
            if(item.getPriority() == min){
                maxImportant.add(item.getText());
            }
        }
        return maxImportant;

    }

    public void deleteCompleted(){
        for(Iterator<Todo> i = todos.iterator(); i.hasNext();){
            Todo todo = i.next();
            if(todo.getState() == State.COMPLETED) {
                i.remove();
            }

        }
    }



}
