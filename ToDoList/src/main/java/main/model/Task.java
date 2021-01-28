package main.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    int id;
    String description;
}
