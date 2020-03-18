package com.company;

import sep.pack.Address;
import sep.pack.House;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// создаем массив домов
        int n = 10;
        House[] base = new House[n];

        Address address = new Address("Независимости", 10);
        base[0] = new House(1990, 5, address);
        Address address1 = new Address("Независимости", 5, 1);
        base[1] = new House(1995, 20, address1);
        Address address2 = new Address("Независимости", 6, 1);
        base[2] = new House(2000, 17, address2);
        Address address3 = new Address("Независимости", 7);
        base[3] = new House(2005, 9, address3);

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int userChoice = 0;
        boolean cycle = true;

        while (cycle) {
            System.out.print(" * Выберите действие:\n" +
                    "1. Просмотреть информацию по всем домам \n" +
                    "2. Просмотреть информацию по одному дому №  \n" +
                    "3. Редактировать инфомацию по дому \n" +
                    "4. Ввести новый дом \n" +
                    "5. Выход\n" +
                    "Ваш выбор: ");
            userChoice = scannerInt(scanner);

            switch (userChoice) {
// вывод инфы по всем домам
                case (1): {
                    for (int i = 0; i < n; i++) {
                        if (base[i] != null) System.out.println((i + 1) + ". " + base[i].getFullInfo());
                    }
                    System.out.println("\n * Выберите действие: 1. Возрат в меню, 5. Выход ");
                    userChoice = scannerInt(scanner);
                    if (userChoice == 5) cycle = false;
                    break;
                }
// вывод инфы по конкретному дому
                case (2): {
                    System.out.print("Выберете номер дома ");
                    userChoice = scannerInt(scanner);
                    if ((userChoice <= n) && (base[userChoice - 1] != null)) {
                        System.out.println(userChoice + ". " + base[userChoice - 1].getFullInfo());
                    } else {
                        System.out.println("\nНет такого номера в базе.\nВыберите действие: 1. Возрат в меню, 5. Выход ");
                        userChoice = scannerInt(scanner);
                        if (userChoice == 5) cycle = false;
                        break;
                    }
                    break;
                }
// редактирование инфы по дому
                case (3): {
                    System.out.print("Выберете номер дома: ");
                    int changeObjNumber = scannerInt(scanner);
                    boolean cycleObjChange = false;
                    if ((changeObjNumber < n) && base[changeObjNumber] != null) {
                        cycleObjChange = true;
                    } else {
                        System.out.println("\nНет такого номера в базе.\nВыберите действие: 1. Возрат в меню, 5. Выход ");
                        userChoice = scannerInt(scanner);
                        if (userChoice == 5) cycle = false;
                    }
                    while (cycleObjChange) {
                        System.out.println("\n" + changeObjNumber + ". " + base[changeObjNumber - 1].getFullInfo());

                        System.out.println("\nКакой параметр требуется изменить: " +
                                "\n1.Год постройки " +
                                "\n2.Этажность " +
                                "\n3.Улица " +
                                "\n4.номер дома " +
                                "\n5.корпус " +
                                "\n6.Выход");
                        int changeParameter = scannerInt(scanner);
                        switch (changeParameter) {
                            case (1): {
                                System.out.print("Введите год постройки: ");
                                int year = scanner.nextInt();
                                base[changeObjNumber - 1].setYear(year);
                                break;
                            }
                            case (2): {
                                System.out.print("Введите этажность: ");
                                int flore = scanner.nextInt();
                                base[changeObjNumber - 1].setFlore(flore);
                                break;
                            }
                            case (3): {
                                System.out.println("Введите улицу: ");

                                String street = scanner1.nextLine();
                                // почему не получается с одним сканером                ???
                                // String street = scanner.nextLine()
                                base[changeObjNumber - 1].setStreet(street);
                                break;
                            }
                            case (4): {
                                System.out.print("Введите номер дома: ");
                                int houseNumber = scanner.nextInt();
                                base[changeObjNumber - 1].setHouseNumber(houseNumber);
                                break;
                            }

                            case (5): {
                                System.out.print("Введите корпус: ");
                                int housing = scanner.nextInt();
                                base[changeObjNumber - 1].setHousing(housing);
                                break;
                            }
                            case (6):
                                cycleObjChange = false;

                        }
                    }
                    break;

                }
                // Добавление нового дома в базу
                case (4): {
                    int i = House.getCount();
                    base[i] = new House();

                    System.out.print(" * Введите данные по дому: Год постройки ");
                    int year = scannerInt(scanner);
                    base[i].setYear(year);

                    System.out.print(" * Введите данные по дому: Этажность ");
                    int flore = scannerInt(scanner);
                    base[i].setFlore(flore);

                    System.out.print(" * Введите данные по дому: Улица ");
                    String street = scanner1.nextLine();
                    base[i].setStreet(street);

                    System.out.print(" * Введите данные по дому: Номер дома ");
                    int homeNumber = scannerInt(scanner);
                    base[i].setHouseNumber(homeNumber);

                    System.out.print(" * Введите данные по дому(Enter пропустить): Корпус ");
                    String housingString = scanner1.nextLine();
                    boolean bool = housingString.isEmpty();
                    if (!bool) {
                        int housing = Integer.parseInt(housingString);
                        base[i].setHousing(housing);
                    }

                    System.out.println("Данные сохранены. " + (i + 1) + ". " + base[i].getFullInfo());

                    System.out.println("\n Выберите действие: 1. Возрат в меню, 5. Выход ");
                    userChoice = scannerInt(scanner);
                    if (userChoice == 5) cycle = false;
                    break;

                }
                case (5): {
                    cycle = false;
                }
            }
        }

    }

    public static int scannerInt(Scanner scanner) {

        int i = scanner.nextInt();
        while (i < 0) {
            System.out.println("Введите положительное число");
            i = scanner.nextInt();
        }

        return i;

    }

}
