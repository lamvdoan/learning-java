package dynamic_proxy_pattern.objectville.person;

public interface PersonBean {
    String getName();
    String getGender();
    String getInterest();
    int getAge();
    int getRating();

    void setName(String name);
    void setGender(String gender);
    void setInterest(String interest);
    void setAge(int age);
    void setRating(int rating);
}
