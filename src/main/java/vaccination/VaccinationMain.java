package vaccination;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class VaccinationMain {

    Scanner scanner = new Scanner(System.in);
    CitizenDao citizenDao = new CitizenDao(DatabaseConfig.getConfig());

    public static void main(String[] args) {
        VaccinationMain vm = new VaccinationMain();
        vm.runMenu();

    }
        public void menuToConsole() {
            System.out.println("1. Registration\n" +
                    "2. Tömeges regisztráció\n" +
                    "3. Generálás\n" +
                    "4. Oltás\n" +
                    "5. Oltás meghiúsulás\n" +
                    "6. Riport\n" +
                    "7. Kilépés\n");
        }


    private void executeMenu(int menuNumber) {
        switch (menuNumber) {
            case 1: {
                System.out.println("Register citizen for vaccination");
                registerCitizen();
                return;
            }
            case 2: {
                System.out.println("Mass registration from file");
                massRegistration();
                return;
            }
            case 3: {
                System.out.println("Generate list");
                return;
            }
            case 4: {
                System.out.println("Vaccinate citizen");
                return;
            }
            case 5: {
                System.out.println("Vaccination failed");
                return;
            }
            case 6: {
                System.out.println("Print report");
                return;
            }
            case 7: {
                return;
            }

            default: {
                System.out.println("No such option");
            }
        }
    }

    private void massRegistration() {

        System.out.println("Enter fileName");
        try {
            citizenDao.insertCitizensFromList(citizenDao.createCitizenListFromFile(scanner.nextLine()));
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
        }
    }

    private void registerCitizen() {
        Citizen citizen = new Citizen(getName(), getZip(), getAge(), getEmail(), getTaj());
        try {
            citizenDao.insertCitizenToDb(citizen);
            System.out.println("registered");
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
        }
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int menuNumber = 0;
        while (menuNumber != 7) {
            menuToConsole();
            System.out.println("Choose an option: ");
            try {
                menuNumber = Integer.parseInt(scanner.nextLine());
                executeMenu(menuNumber);
            } catch (NumberFormatException nfe) {
                System.out.println("Enter a number between 1-7!");
            } catch (IllegalArgumentException | ArithmeticException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
    private String getName() {
        System.out.println("Enter name");
        try {
            return Validator.validateName(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getName();
        }
    }

    private String getZip() {
        System.out.println("Kérem adja meg a paciens irányítószámát!");
        try {
            return Validator.validateZip(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getZip();
        }
    }

    private int getAge() {
        System.out.println("Enter age");
        try {
            return Validator.validateAge(Integer.parseInt(scanner.nextLine()));
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getAge();
        }
    }

    private String getEmail() {
        System.out.println("Enter e-mail address!");
        try {
            String email = Validator.validateEmail(scanner.nextLine());
            return reCheckEmail(email);

        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getEmail();
        }
    }

    private String reCheckEmail(String email) {
        System.out.println("Again,enter e-mail address!");
        String check = scanner.nextLine();
        if (email.equals(check)) {
            return email;
        } else {
            System.out.println("Email doesn't match, enter again");
            return getEmail();
        }
    }

    private String getTaj() {
        System.out.println("Enter TAJ number");
        try {
            return Validator.checkCdvIsValid(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            throwIAE(iae);
            return getTaj();
        }
    }
    private void throwIAE(IllegalArgumentException iae) {
        System.out.println("Please try again, " + iae.getMessage());
    }



}
