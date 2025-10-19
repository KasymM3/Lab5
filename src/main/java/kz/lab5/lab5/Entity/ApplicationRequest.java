package kz.lab5.lab5.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "commentary")
    private String commentary;
    @Column(name = "phone")
    private String phone;
    @Column(name = "handled")
    private boolean handled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Courses course;

    @ManyToMany
    @JoinTable(
            name = "application_request_operators",
            joinColumns = @JoinColumn(name = "application_request_id"),
            inverseJoinColumns = @JoinColumn(name = "operator_id")
    )
    private List<Operators> operators = new ArrayList<>();

}
