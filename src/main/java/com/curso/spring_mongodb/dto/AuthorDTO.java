package com.curso.spring_mongodb.dto;

import com.curso.spring_mongodb.domain.User;

import java.io.Serializable;
import java.util.Objects;

public class AuthorDTO implements Serializable {
    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User obj) {
        this.name = obj.getName();
        this.id = obj.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorDTO authorDTO)) return false;

        if (!Objects.equals(id, authorDTO.id)) return false;
        return Objects.equals(name, authorDTO.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
