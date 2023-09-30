//В данном коде:
//
//Создан класс Robot, который моделирует робота-пылесоса с базовыми функциями, такими как "начать уборку" и "остановить уборку". Робот также имеет механизм отслеживания своих действий через AccessRepo.
//
//AccessRepo регистрирует команды, выполняемые роботом, поэтому его можно использовать для отслеживания того, какие действия были выполнены.
//
//Затем создается класс Command, который содержит методы для тестирования функций робота. Command также выводит историю команд после каждого теста, чтобы можно было увидеть, какие команды были отмечены как выполненные.
//
//Код осуществляет моделирование робота-пылесоса и проверку основных функций, и соответствует задаче проведения UAT тестирования.


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Robot {
        private int battery;
        private boolean cleaning;
        private AccessRepo accessRepo;

        public Robot() {
            this.battery = 100;
            this.cleaning = false;
            this.accessRepo = new AccessRepo(this);
        }

        public boolean isCleaning() {
            return cleaning;
        }

        public void startCleaning() {
            if (battery > 20) {
                battery -= 20;
                cleaning = true;
                this.accessRepo.addCommand("Запуск уборки");
            } else {
                System.out.println("Недостаточный уровень заряда для начала уборки!");
            }
        }

        public void stopCleaning() {
            cleaning = false;
            this.accessRepo.addCommand("Остановка уборки");
        }

        public AccessRepo getAccessRepo() {
            return accessRepo;
        }
    }

    public static class AccessRepo {
        private Robot robot;
        private List<String> commandHistory;

        public AccessRepo(Robot robot) {
            this.robot = robot;
            this.commandHistory = new ArrayList<>();
        }

        public void addCommand(String command) {
            commandHistory.add(command);
        }

        public List<String> getCommandHistory() {
            return commandHistory;
        }
    }

    public static class Command {
        public void runUATTests() {
            testStartCleaning();
            testStopCleaning();
        }

        public void testStartCleaning() {
            Robot robot = new Robot();
            robot.startCleaning();
            if (robot.isCleaning()) {
                System.out.println("Тест 'запуска уборки' пройден!");
            } else {
                System.out.println("Тест 'запуска уборки' провален!");
            }
            System.out.println("История команд: " + robot.getAccessRepo().getCommandHistory());
        }

        public void testStopCleaning() {
            Robot robot = new Robot();
            robot.startCleaning(); // Robot needs to start cleaning before it can stop
            robot.stopCleaning();
            if (!robot.isCleaning()) {
                System.out.println("Тест 'остановки уборки' пройден!");
            } else {
                System.out.println("Тест 'остановки уборки' провален!");
            }
            System.out.println("История команд: " + robot.getAccessRepo().getCommandHistory());
        }
    }

    public static void main(String[] args) {
        Command command = new Command();
        command.runUATTests();
    }
}