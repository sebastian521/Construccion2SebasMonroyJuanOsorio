package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Partner")
public class Partner{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column(name = "type")
    private String Type;
    @Column(name = "creationdate")
    private Timestamp DateCreated;
    @Column(name = "amount")
    private double money;
    @OneToOne
    @JoinColumn(name = "userid")
    private User userID;
    
    
    

   
    }

    

    
    
    
    
    