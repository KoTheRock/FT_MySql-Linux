package Pet_Registry;

public  abstract class Animal {
    private  String name;
    private  String birthDate;

    public Animal(String name, String birthdate){
        this.name = name;
        this.birthDate = birthdate;
    }
    public String getName(){
        return name;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public abstract void getCommands();
    }

    class  Dog extends  Animal {
        private String[] commands;

        public Dog(String name, String birthDate, String[] commands) {
            super(name, birthDate);
            this.commands = commands;
        }

        @Override
        public void getCommands() {
            System.out.println("Комманды для собаки " + getName() + ": ");
            for (String command : commands) {
                System.out.println(command);
            }
        }
    }
    class Cat extends  Animal {
    private String[] commands;

    public Cat(String name, String birthDate, String[] commands) {
        super(name, birthDate);
        this.commands = commands;
    }

    @Override
    public void getCommands() {
        System.out.println("Комманды для кошки " + getName() + ": ");
        for (String command : commands) {
            System.out.println(command);
        }
    }
}

class Hamster extends  Animal {
    private String[] commands;

    public Hamster(String name, String birthDate, String[] commands) {
        super(name, birthDate);
        this.commands = commands;
    }

    @Override
    public void getCommands() {
        System.out.println("Комманды для хомячка " + getName() + ": ");
        for (String command : commands) {
            System.out.println(command);
        }
    }
}
class Horses_and_Donkeys extends  Animal {
    private String[] commands;

    public Horses_and_Donkeys(String name, String birthDate, String[] commands) {
        super(name, birthDate);
        this.commands = commands;
    }

    @Override
    public void getCommands() {
        System.out.println("Комманды для верблюда и лошади " + getName() + ": ");
        for (String command : commands) {
            System.out.println(command);
        }
    }
}