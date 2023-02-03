package licensegen.v2.licensev2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "datasourcedb", uniqueConstraints = {@UniqueConstraint(columnNames={"id"})})
public class dataSourceDB{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @Column(name = "jdbcdriver")
        private String jdbcdriver;

        @Column(name = "host")
        private String host;

        @Column(name = "port")
        private int port;

        @Column(name = "databasenm")
        private String databasenm;

        @Column(name = "username")
        private String username;

        @Column(name = "password")
        private String password;

        @Column(name = "datasourcenm")
        private String datasourcenm;


}
