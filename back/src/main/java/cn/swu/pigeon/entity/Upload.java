package cn.swu.pigeon.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Upload {

    private int id;
    private String userId;
    private String imgPath;
    private String companyId;


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

    /**
     * @return String return the username
     */
    public String getUsername() {
        return userId;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.userId = username;
    }

    /**
     * @return String return the imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

}
