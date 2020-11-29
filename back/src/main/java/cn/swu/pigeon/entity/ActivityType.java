package cn.swu.pigeon.entity;

public enum ActivityType {
    CHECKIN(0), COLLECT_TABLE(1);
    private int id;
    ActivityType(int id) {
      this.id = id;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}