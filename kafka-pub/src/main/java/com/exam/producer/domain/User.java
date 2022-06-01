package com.exam.producer.domain;

public class User {

    private Long userNo;
    private String userName;
    private Long userAge;

    public User(Long userNo, String userName, Long userAge) {
        this.userNo = userNo;
        this.userName = userName;
        this.userAge = userAge;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserAge() {
        return userAge;
    }

    public void setUserAge(Long userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNo='" + userNo + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                '}';
    }
}
