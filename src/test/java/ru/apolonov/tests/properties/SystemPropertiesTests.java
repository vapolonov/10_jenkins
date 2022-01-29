package ru.apolonov.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void someTest() {
        // System - некое внутреннее хранилище переменных (ключ - значение) в Java, можно туда складывать (set)
        // и забирать значения (get), используется чтобы прокинуть данные из вне
        String value = System.getProperty("value"); // забираем значение value
        System.out.println(value);  // null - сейчас ничего нет, поэтому null
    }

    @Test
    void someTest1() {
        String value = System.getProperty("value", "default_value"); // забираем значение value,
        // если value нет, тогда берется default_value
        System.out.println(value);  // default_value
    }

    @Test
    void someTest2() {
        System.setProperty("value", "another_value"); // положим значение value и значение по умолчанию another_value
        String value = System.getProperty("value"); // забираем значение value, где уже лежит значение по умолчанию
        System.out.println(value);  // another_value
    }

    @Test
    void someTest3() {
        System.setProperty("value", "another_value"); // положим значение value и значение по умолчанию another_value
        String value = System.getProperty("value", "default_value"); // забираем значение value,
        // где уже лежит значение по умолчанию another_value, default_value переменной уже не присвоится
        System.out.println(value);  // another_value
    }

    @Test
    @Tag("test4") // аннотация, которую указываем в task в build.gradle
    void someTest4() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);  // chrome
        // gradle clean properties_tests
        // chrome

        // gradle clean properties_tests -Dbrowser=opera
        // opera
    }

    @Test
    @Tag("test5")
    void someTest5() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "96");
        String browserSize = System.getProperty("browserSize", "1024x900");
        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
        // gradle clean properties_tests -Dbrowser=opera -Dversion=98
        // opera
        // 98
        // 1024x900
    }
}
