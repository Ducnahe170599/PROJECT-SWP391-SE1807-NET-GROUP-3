package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Subject {

    /**
     * @param args the command line arguments
     */
//    [SubjectID] [int] IDENTITY(0,1) NOT NULL,
//	[Subject_Name] [nvarchar](200) NULL,
//	[Description] [nvarchar](500) NULL,
//	[Image] [nvarchar] (200) NULL,
//	[LessonId] [int] NULL,
//	[PackageId] [int] NULL,
//	[CategoryId] [int] NULL,
//	[UserId] [int] NOT NULL,
//	[RatingID] [int] NULL,
//	[Created_at] [date] NULL
    private int id;
    private String name;
    private String description;
    private String image;
    private int lessonId;
    private int packageId;
    private int categoryId;
    private int UserId;
    private int RatingId;
    private String packageName;
    private String categoryName;
    private String userName;
    private int rating;
    private Date date;
    private String lessonName;
    private int numberOfLessons;

    public Subject() {
    }

    public Subject(String name, String description, String image, int packageId, int categoryId, int UserId, int RatingId, Date date) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.packageId = packageId;
        this.categoryId = categoryId;
        this.UserId = UserId;
        this.RatingId = RatingId;
        this.date = date;
    }

    public Subject(int id, String name, String description, String image, int packageId, int categoryId, int UserId, int RatingId, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.packageId = packageId;
        this.categoryId = categoryId;
        this.UserId = UserId;
        this.RatingId = RatingId;
        this.date = date;
    }

    public Subject(int id, String name, String description, String image, String packageName, String categoryName, String userName, int rating, Date date, int numberOfLessons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.packageName = packageName;
        this.categoryName = categoryName;
        this.userName = userName;
        this.rating = rating;
        this.date = date;
        this.numberOfLessons = numberOfLessons;
    }

    public Subject(int id, String name, String description, String image, String packageName, String categoryName, String userName, int rating, Date date, String lessonName, int numberOfLessons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.packageName = packageName;
        this.categoryName = categoryName;
        this.userName = userName;
        this.rating = rating;
        this.date = date;
        this.lessonName = lessonName;
        this.numberOfLessons = numberOfLessons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }

    public void setNumberOfLessons(int numberOfLessons) {
        this.numberOfLessons = numberOfLessons;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getRatingId() {
        return RatingId;
    }

    public void setRatingId(int RatingId) {
        this.RatingId = RatingId;
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", packageName=" + packageName + ", categoryName=" + categoryName + ", userName=" + userName + ", rating=" + rating + ", date=" + date + ", lessonName=" + lessonName + ", numberOfLessons=" + numberOfLessons + '}';
    }
}
