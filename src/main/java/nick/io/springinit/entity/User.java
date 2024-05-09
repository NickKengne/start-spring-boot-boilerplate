package nick.io.springinit.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
}

