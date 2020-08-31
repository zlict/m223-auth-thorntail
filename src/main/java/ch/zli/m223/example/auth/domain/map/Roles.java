package ch.zli.m223.example.auth.domain.map;

/**
 * Maps the database roles and make them available to the backend.
 */
public enum Roles {
    ADMINISTRATOR(Names.ADMINISTRATOR),
    USER(Names.USER);

    public static class Names {
        public static final String ADMINISTRATOR = "administrator";
        public static final String USER = "user";
    }

    private String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
