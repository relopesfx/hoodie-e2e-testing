package data.enums;

public enum RoleType {
    ADMIN("Admin"), USER("User");

    private String type;

    RoleType(String type) {
        this.type = type;
    }

    public String get() {
        return type;
    }
}
