package disi2022.entities;


import disi2022.enums.UserRole;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.MERGE)
    private List<Wishlist> wishlist;

    @OneToMany(mappedBy = "user",orphanRemoval = true,cascade = CascadeType.MERGE)
    private List<Review> reviewList;





}
