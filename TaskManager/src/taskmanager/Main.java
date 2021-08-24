package taskmanager;

import java.text.*;
import java.util.*;

public class Main {
    
    static GetInput g = new GetInput();
    
    static void addTask(ArrayList<Task> list, int id) throws ParseException{
        System.out.println("-----------Add Task-----------");
        System.out.print("Requirement Name: ");
        String name = g.getString();
        System.out.print("Task Type: ");
        int taskType = g.getTypeID();
        System.out.print("Date: ");
        String date = g.getInputDate();
        System.out.print("From: ");
        double from = g.getFrom();
        System.out.print("To: ");
        double to = g.getTo(from);
        System.out.print("Assignee: ");
        String assignee = g.getString();
        System.out.print("Reviewer: ");
        String reviewer = g.getString();
        //iterate over the task list
        for (Task task : list) {
            //same date
            if(date.equals(task.getDate())){
                //same assignee
                if(assignee.equalsIgnoreCase(task.getAssignee())){
                    //assignee is doing another task in time
                    if((from >= task.getFrom() && from <= task.getTo()) || 
                       (to >= task.getFrom() && to <= task.getTo()) ||
                       (from <= task.getFrom() && to >= task.getTo())){
                        System.out.printf("%s is having another task from %.1f to %.1f\n", 
                                task.getAssignee(),task.getFrom(), task.getTo());
                        System.out.println("");
                        return;
                    }
                }
            }
        }
        list.add(new Task(id, taskType, name, date, from, to, assignee, reviewer));
        System.out.println("Add sucessfully.");
        System.out.println("");
    }
    
    static int findTaskByID(ArrayList<Task> list){
        System.out.print("ID: ");
        int id = g.getInt(list.size());
        //iterate over the task list
        for (int i = 0; i < list.size(); i++) {
            //found id
            if(list.get(i).getID() == id) return i;
        }
        return -1;
    }
    
    static void deleteTask(ArrayList<Task> list, int id){
        System.out.println("---------Del Task---------");
        //empty list
        if(list.isEmpty()){
            System.out.println("Empty list.");
            System.out.println("");
            return;
        } 
        int findID = findTaskByID(list);
        //task is found
        list.remove(findID);
        System.out.println("Delete sucessfully");         
        System.out.println("");
    }
    
    static void getDataTasks(ArrayList<Task> list){
        //empty list
        if(list.isEmpty()){
            System.out.println("Empty list.");
            System.out.println("");
            return;
        }
        System.out.println("----------------------------------------- Task -----------------------------------------");
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n","ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        //iterate over the task list and print task data
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    list.get(i).getID(),
                    list.get(i).getName(),
                    list.get(i).taskName(),
                    list.get(i).getDate(),
                    list.get(i).getTo() - list.get(i).getFrom(),
                    list.get(i).getAssignee(),
                    list.get(i).getReviewer()
            );
        }
        System.out.println("");
    }
    
    static void menu(){
        System.out.println("========= Task program =========");
        System.out.println("1. Add task");
        System.out.println("2. Delete task");
        System.out.println("3. Display task");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }

    static void display() throws ParseException{
        ArrayList<Task> list = new ArrayList<>();
//        list.add(new Task(1, 1, "Dev Program", "27-07-2015", 12.0, 15.0, "Dev", "Lead"));
//        list.add(new Task(2, 2, "Test", "22-02-2015", 12.0, 15.0, "Test", "Lead"));
//        list.add(new Task(3, 3, "Design", "29-09-2015", 12.0, 15.0, "Design", "Lead"));
        int choice;
        int id = 1;
        while (true) {            
            menu();
            choice = g.getChoice(1, 4);
            switch(choice){
                case 1:
                    addTask(list, id);
                    id++;
                    break;
                case 2: 
                    deleteTask(list, id);
                    break;
                case 3: 
                    getDataTasks(list);
                    break;
                case 4:
                    return;
            }
        }
    }
    
    public static void main(String[] args) throws ParseException {
        display();
    }
    
}
