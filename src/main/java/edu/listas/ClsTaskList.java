package edu.listas;

public class ClsTaskList {
    private String taskName;
    private String taskDescription;
    private boolean isDone;

    // Constructor de la clase
    public ClsTaskList(String taskName, String taskDescription, boolean isDone) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isDone = isDone;
    }

    // Método para obtener el nombre de la tarea
    public String getTaskName() {
        return taskName;
    }

    // Método para establecer el nombre de la tarea
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    // Método para obtener la descripción de la tarea
    public String getTaskDescription() {
        return taskDescription;
    }

    // Método para establecer la descripción de la tarea
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    // Método para verificar si la tarea está completa
    public boolean isDone() {
        return isDone;
    }

    // Método para marcar la tarea como completada o no completada
    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "ClsTaskList{" +
                "taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
