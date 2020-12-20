package spring.project.closetoU.domain;

public enum Gender {
    MALE("남자"),
    FEMALE("여자");

    String value;

    Gender(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
