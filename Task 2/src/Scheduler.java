import java.io.*;
import java.util.*;

public class Scheduler {
    public static long currentTime = 0;
    private static PriorityQueue queue = new PriorityQueue();

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Scheduler <input_file>");
            return;
        }

        String inputFileName = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processLine(String line) {
        String[] parts = line.split(" ");
        if (parts[0].equals("schedule")) {
            String name = parts[1];
            long deadline = Long.parseLong(parts[2]);
            long duration = Long.parseLong(parts[3]);
            Task task = new Task(name, deadline, duration);
            queue.addTask(task);
        } else if (parts[0].equals("run")) {
            long runTime = Long.parseLong(parts[1]);
            runTasks(runTime);
        }
    }

    private static void runTasks(long runTime) {
        while (currentTime < runTime && !queue.isEmpty()) {
            Task task = queue.removeTask();
            if (task != null) {
                long taskStartTime = currentTime;
                currentTime += task.getDuration();
                if (currentTime <= runTime) {
                    System.out.println(taskStartTime + ": busy with " + task.getName() + " with deadline " + task.getDeadline() + " and duration " + task.getDuration());
                    if (currentTime > task.getDeadline()) {
                        System.out.println(currentTime + ": done with " + task.getName() + " (late)");
                    } else {
                        System.out.println(currentTime + ": done with " + task.getName());
                    }
                } else {
                    long executedTime = runTime - taskStartTime;
                    task.setDuration(task.getDuration() - executedTime);
                    queue.addTask(task);
                    currentTime = runTime;
                }
            }
        }
    }
}
