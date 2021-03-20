package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupForm {
    private  int id;
    private final String name;
    private final String header;
    private final String footer;

    public GroupForm(int id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }


    public GroupForm(String name, String header, String footer) {
        this.id = 0;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupForm groupForm = (GroupForm) o;
        return id == groupForm.id && Objects.equals(name, groupForm.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
