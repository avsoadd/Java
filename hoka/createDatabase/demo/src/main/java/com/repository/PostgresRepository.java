import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("customers")
public class Customer {
    @Id
    @Column("customer_id")
    private Long id;
    private String name;
    private String email;
    private String password;
    @Column("created_at")
    private LocalDateTime createdAt;
    @Column("updated_at")
    private LocalDateTime updatedAt;

    // getters and setters
}

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostgresRepository extends CrudRepository<Customer, Long> {
    //@Query("SELECT * FROM customers WHERE email = :email")
    //Customer findByEmail(String email);
}
