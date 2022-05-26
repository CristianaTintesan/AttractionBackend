package disi2022.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "attractions")
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String location;
    private double price;
    private boolean isWish;

    @OneToMany(mappedBy = "attraction",orphanRemoval = true,cascade = CascadeType.MERGE)
    private List<VisitedAttraction> visitedAttractionList;

    @OneToMany(mappedBy = "attraction",orphanRemoval = true,cascade = CascadeType.MERGE)
    private List<AttractionPackage> attractionPackageList;

    private String photoUrl;
    @OneToMany(mappedBy = "attraction", orphanRemoval = true, cascade = CascadeType.MERGE)
    private List<Wishlist> wishlist;
    @OneToMany(mappedBy = "attraction",orphanRemoval = true,cascade = CascadeType.MERGE)
    private List<Review> reviewList;

    public boolean getIsWish() {
        return isWish;
    }
}
