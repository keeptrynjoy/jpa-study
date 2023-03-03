package hellojpa;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
@Embeddable
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Period() {
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

}
