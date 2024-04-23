package jar.us.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

@Entity
public class Product implements Persistable<Long> {

    @Setter
    @Id
    private Long id;

    @Transient
    private boolean isNew = true;

    @Setter
    @Getter
    private String productName;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }
}
