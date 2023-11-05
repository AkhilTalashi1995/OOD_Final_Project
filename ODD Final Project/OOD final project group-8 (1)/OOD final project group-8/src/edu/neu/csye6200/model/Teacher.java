package edu.neu.csye6200.model;


import edu.neu.csye6200.util.DateUtil;
import java.util.Date;


public class Teacher extends Person{
    private int credits;
    private Date reviewDate;
    private int teacherId;
    private String review;
    
    public Teacher( String firstName, String lastName, int age, int credits, Date reviewDate, String review) {
        super(firstName,lastName, age);
        this.credits = credits;
        this.reviewDate = reviewDate;
        this.review = review;

    }

    public Teacher( String data) {
        super(data);
        String[] parsedTeacherData = data.split(",");
        setCredits(Integer.parseInt(parsedTeacherData[3]));
        setReviewDate(DateUtil.parseStringToDate(parsedTeacherData[4], "MM/dd/yyyy"));
        setReview((parsedTeacherData[5]));


    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
    
    public Date getReviewDate() {
        return reviewDate;
    }
    
    public String setReview(String review) {
        this.review = review;
        return review;
    }
    
    public String getReview() {
        return review;
    }
    public void setTeacherId() {
        this.teacherId = teacherId + 100;
    }
    public int getTeacherId() {
        return teacherId;
    }

    private String String(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
