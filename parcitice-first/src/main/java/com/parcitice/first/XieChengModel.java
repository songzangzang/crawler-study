package com.parcitice.first;

/**
 * 评论实体
 *
 * @author songxibo
 * @date 2018/10/321:38
 */
public class XieChengModel {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 评分
     */
    private String score;

    /**
     * 评论内容
     */
    private String comment;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "XieChengModel{" +
                "userId='" + userId + '\'' +
                ", userType='" + userType + '\'' +
                ", score='" + score + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

}
