package licensegen.v2.licensev2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "licensegendb", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class licenseGenDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

}
