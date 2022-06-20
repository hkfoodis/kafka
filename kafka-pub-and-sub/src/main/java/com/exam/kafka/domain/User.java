package com.exam.kafka.domain;

public class User {

    private Long userNo;
    private String userName;
    private Long userAge;
    private Integer ko;
    private Integer math;
    private Integer eng;
    private Double averageScore;

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

    public Integer getKo() {
        return ko;
    }

    public void setKo(Integer ko) {
        this.ko = ko;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEng() {
        return eng;
    }

    public void setEng(Integer eng) {
        this.eng = eng;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", ko=" + ko +
                ", math=" + math +
                ", eng=" + eng +
                '}';
    }
}
