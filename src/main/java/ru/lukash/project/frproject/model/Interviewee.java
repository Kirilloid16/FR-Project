package ru.lukash.project.frproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "interviewee",schema = "public")
public class Interviewee {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "interviewee_name")
    private Users user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "interviewee_id")
    private List<Variant_of_answer_from_interviewee> variant_of_answer_from_interviewees;

    public Interviewee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Variant_of_answer_from_interviewee> getVariant_of_answer_from_interviewees() {
        return variant_of_answer_from_interviewees;
    }

    public void setVariant_of_answer_from_interviewees(List<Variant_of_answer_from_interviewee> variant_of_answer_from_interviewees) {
        this.variant_of_answer_from_interviewees = variant_of_answer_from_interviewees;
    }

    @Override
    public String toString() {
        return "Interviewee{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
