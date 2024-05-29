public class Task {
    private String name;
    private long deadline;
    private long duration;

    public Task(String name, long deadline, long duration) {
        this.name = name;
        this.deadline = deadline;
        this.duration = duration;
    }

    public String getName() { return name; }
    public long getDeadline() { return deadline; }
    public long getDuration() { return duration; }
    public void setDuration(long duration) { this.duration = duration; }
}
