package devandroid.micaela.moldylemons_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "couples")
public class Couple {

    @Id
    @SequenceGenerator(
            name = "couple_sequence",
            sequenceName = "couple_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "couple_sequence"
    )
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(nullable = true, length = 100)
    private String partnerOne;

    @Column(nullable = true, length = 100)
    private String partnerTwo;

    private LocalDateTime anniversaryDate;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    public Couple() {}

    public Couple(String partnerOne, String partnerTwo,
                  LocalDateTime anniversaryDate,
                  String email, String password) {
        this.partnerOne = partnerOne;
        this.partnerTwo = partnerTwo;
        this.anniversaryDate = anniversaryDate;
        this.email = email;
        this.password = password;
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }

    public LocalDateTime getCreationDate() { return creationDate; }

    public String getPartnerOne() { return partnerOne; }
    public void setPartnerOne(String partnerOne) { this.partnerOne = partnerOne; }

    public String getPartnerTwo() { return partnerTwo; }
    public void setPartnerTwo(String partnerTwo) { this.partnerTwo = partnerTwo; }

    public LocalDateTime getAnniversaryDate() { return anniversaryDate; }
    public void setAnniversaryDate(LocalDateTime anniversaryDate) { this.anniversaryDate = anniversaryDate; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}