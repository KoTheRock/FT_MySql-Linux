package Pet_Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Pet_Registry.Dog;
import Pet_Registry.Cat;
import Pet_Registry.Hamster;
import Pet_Registry.Horses_and_Donkeys;
import Pet_Registry.Animal;
import Pet_Registry.Counter;



public class Main {
    private static List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Привет! Выберите действие:\n" +
                    "Напишете '1' -- Завести новое животное\n" +
                    "Напишете '2' -- Чтобы увидеть список команд, которое выполняет животное \n" +
                    "Напишете '3' -- Чтобы обучить животное новым командам\n " +
                    "Напишете '0' -- Выйти");

            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    System.out.println("Вы выбрали завести новое животное.");
                    addAnimal(scanner);
                    break;
                case 2:
                    System.out.println("Вы выбрали показать список команд.");
                    showCommands(scanner);
                    break;
                case 3:
                    System.out.println("Вы выбрали обучить животное новым командам.");
                    addCommands(scanner);
                    break;
                case 0:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
                    break;
            }
        }
    }

    public static void addAnimal(Scanner scanner) {
        System.out.println("Введите тип животного: Кошка, Собака, Хомяк, Лошадь, Осел");
        String animalType = scanner.nextLine();

        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();

        System.out.println("Введите дату рождения:");
        String birthDate = scanner.nextLine();

        String[] commands = {"Сидеть", "Лежать"};

        try (Counter counter = new Counter()) {
            counter.add();

            Animal animal = null;

            switch (animalType.toLowerCase()) {
                case "собака":
                    animal = new Dog(name, birthDate, commands);
                    break;
                case "кошка":
                    animal = new Cat(name, birthDate, commands);
                    break;
                case "хомяк":
                    animal = new Hamster(name, birthDate, commands);
                    break;
                case "лошадь":
                case "осел":
                    animal = new Horses_and_Donkeys(name, birthDate, commands);
                    break;
                default:
                    System.out.println("Неверный тип животного.");
                    return;
            }
            animals.add(animal);
            System.out.println("Животное добавлено: " + animal.getName());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void showCommands(Scanner scanner) {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();

        Animal animal = findAnimalByName(name);
        if (animal != null) {
            animal.getCommands();
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    public static void addCommands(Scanner scanner) {
        System.out.println("Введите имя животного, которого хотите обучить новым командам:");
        String animalName = scanner.nextLine();

        Animal animal = findAnimalByName(animalName);
        if (animal == null) {
            System.out.println("Животное не найдено.");
            return;
        }

        System.out.println("Введите новую команду для животного:");
        String newCommand = scanner.nextLine();

        System.out.println("Животное " + animalName + " обучено новой команде: " + newCommand);
    }

    private static Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}