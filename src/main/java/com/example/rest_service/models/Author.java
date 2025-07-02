package com.example.rest_service.models;

import java.util.Objects;

public class Author {
    private Long _id;
    public void setId(Long i) { _id = i; }
    public Long getId() { return _id; }

    private String _name;
    public void setName(String test) { _name = test; }
    public String getName() { return _name; }

    public Author(){

    }

    public Author(long id, String name) {
        setId(id);
        setName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author comparedAuthor = (Author) o;
        return Objects.equals(_id, comparedAuthor.getId())
                && Objects.equals(_name, comparedAuthor.getName());
    }

}
