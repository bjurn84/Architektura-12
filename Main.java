public class Main {

    public static void main(String[] args) {
        AccessRepoTest.runAllTests();
    }

    public static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) {
                return true;
            }
            if(!(obj instanceof User)) {
                return false;
            }
            User other = (User) obj;
            return (name != null && name.equals(other.name));
        }
    }

    public static class Group {
        private String name;

        public Group(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) {
                return true;
            }
            if(!(obj instanceof Group)) {
                return false;
            }
            Group other = (Group) obj;
            return (name != null && name.equals(other.name));
        }
    }

    public static class AccessRepo {
        private User user;
        private Group group;

        public AccessRepo(User user, Group group) {
            this.user = user;
            this.group = group;
        }

        public User findUser() {
            return user;
        }

        public Group getGroup() {
            return group;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public void setGroup(Group group) {
            this.group = group;
        }
    }

    public static class AccessRepoTest {
        public static void runAllTests() {
            testChangeUser();
            testChangeGroup();
        }

        public static void testChangeUser() {
            AccessRepo accessRepo = new AccessRepo(new User("Name1"), new Group("Group1"));
            User user2 = new User("Name2");
            accessRepo.setUser(user2);
            if(accessRepo.findUser().equals(user2)) {
                System.out.println("Тест замены пользователя пройден!");
            } else {
                System.out.println("Тест замены пользователя провален!");
            }
        }

        public static void testChangeGroup() {
            AccessRepo accessRepo = new AccessRepo(new User("Name1"), new Group("Архитектура ПО"));
            Group newGroup = new Group("Software Arch");
            accessRepo.setGroup(newGroup);
            if(accessRepo.getGroup().equals(newGroup)) {
                System.out.println("Тест замены группы пройден!");
            } else {
                System.out.println("Тест замены группы провален!");
            }
        }
    }
}