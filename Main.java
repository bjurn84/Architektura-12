package UnitTest;

public class Main {
    public static void main(String[] args) {
        AccessRepoTest test = new AccessRepoTest();
        test.getUser();
        test.setUser();
        test.getGroup();
        test.setGroup();
    }
}

class AccessRepo {
    User user;
    Group group;

    public AccessRepo(User user, Group group) {
        this.user = user;
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User findUser() {
        return null;
    }
}

class AccessRepoTest {

    void getUser() {
        User testUser = new User("NAME1");
        AccessRepo accessRepoTest = new AccessRepo(testUser, new Group("Architektura"));
        assertEquals(testUser, accessRepoTest.getUser());
    }

    void setUser() {
        AccessRepo accessRepoTest = new AccessRepo(new User("NAME1"), new Group("Architektura"));
        User testUser2 = new User("NAME2");
        accessRepoTest.setUser(testUser2);
        assertEquals(testUser2, accessRepoTest.getUser());
    }

    void getGroup() {
        Group groupTest = new Group("Architektura");
        AccessRepo accessRepoTest = new AccessRepo(new User("NAME1"), groupTest);
        assertEquals(groupTest, accessRepoTest.getGroup());
    }

    void setGroup() {
        AccessRepo accessRepoTest = new AccessRepo(new User("NAME1"), new Group("Architektura"));
        Group testGroup = new Group("Архитерктура");
        accessRepoTest.setGroup(testGroup);
        assertEquals(testGroup, accessRepoTest.getGroup());
    }

    private void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Expected: " + expected + ", but got: " + actual);
        }
    }
}

class Group {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group(String name) {
        this.name = name;
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}