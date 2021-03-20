package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupForm {
    private final String id;
    private final String name;
    private final String header;
    private final String footer;

    public GroupForm(String id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }
    public GroupForm(String name, String header, String footer) {
        this.id = null;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public String getId() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupForm groupForm = (GroupForm) o;
        return Objects.equals(id, groupForm.id) && Objects.equals(name, groupForm.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "GroupForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
