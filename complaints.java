package Java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDateTime;
import java.util.Objects;

public class complaints {
    private String status = "Pending";
    private String complaint;
    private LocalDateTime dateTime;

    public complaints(String complaint){
        this.complaint = complaint;
        this.dateTime = LocalDateTime.now();
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
