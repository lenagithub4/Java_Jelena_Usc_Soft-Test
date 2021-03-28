package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupForm {
    private  int id = Integer.MAX_VALUE;
    private String name;
    private  String header;
    private String footer;





  // constructor is deleted lekcija 5.4

  //  public GroupForm(int id, String name, String header, String footer) {
  //      this.id = id;
   //     this.name = name;
   //     this.header = header;
   //     this.footer = footer;
  //  }
  //  public GroupForm(String name, String header, String footer) {
   //     this.id = Integer.MAX_VALUE;
   //     this.name = name;
   //     this.header = header;
    //    this.footer = footer;
   // }

    public int getId() {
        return id;
    }

    public GroupForm withId(int id) {
        this.id = id;
        return this;
    }

    public GroupForm withName(String name) {
        this.name = name;
        return this;
    }

    public GroupForm withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupForm withFooter(String footer) {
        this.footer = footer;
        return this;
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
