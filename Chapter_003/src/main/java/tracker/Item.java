package tracker;

import java.util.Comparator;

public class Item implements Comparable<Item> {
    private String id;
    private String name;
    private String desk;
    private long created;
    private String[] comments;

    public Item(String name, String desk, long created) {
        this.name = name;
        this.desk = desk;
        this.created = created;
    }

    public Item(String name, String desk) {
        this.name = name;
        this.desk = desk;
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

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "Item{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", desk='" + desk + '\''
                + '}';
    }

    @Override
    public int compareTo(Item another) {
       return name.compareTo(another.name);
    }
}
