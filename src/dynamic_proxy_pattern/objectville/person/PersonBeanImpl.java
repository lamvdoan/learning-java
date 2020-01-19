package dynamic_proxy_pattern.objectville.person;

public class PersonBeanImpl implements PersonBean {
    private String name;
    private String gender;
    private int age;
    private String interest;
    private int rating;
    private int ratingCount = 0;

    public PersonBeanImpl(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterest() {
        return interest;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getRating() {
        if (ratingCount == 0) {
            return 0;
        }
        return (rating / ratingCount);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterest(String interest) {
        this.interest = interest;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }

}
