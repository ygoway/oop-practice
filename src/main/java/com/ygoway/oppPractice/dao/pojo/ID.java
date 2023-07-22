package com.ygoway.oppPractice.dao.pojo;

public final class ID {

    private int id;
    private static int counter = 1;

    public ID() {
        this.id = counter++;
    }

    public int getIntId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ID otherId = (ID) obj;
        return id == otherId.id;
    }

    @Override
    public String toString() {
        return "ID{" +
                "id=" + id +
                '}';
    }
}
