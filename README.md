# OrangeHRM Selenium Automation

A UI automation testing project built using **Java, Selenium WebDriver, JUnit 5, and Maven**.

This project automates the login functionality of the OrangeHRM demo application and validates both successful and unsuccessful login scenarios.

---

## 📌 Project Overview

The purpose of this project is to demonstrate web UI automation using Selenium WebDriver with Java and JUnit 5.

The automation tests the OrangeHRM login page and verifies:

- Successful login with valid credentials
- Login failure with invalid credentials
- Dashboard navigation after successful login
- Invalid credentials error message

---

## 🛠️ Technologies Used

| Technology | Version |
|---|---|
| Java | 21 |
| Selenium WebDriver | 4.35.0 |
| JUnit | 5.13.4 |
| Maven | 3.x |
| IntelliJ IDEA | 2026.2 |
| Google Chrome | 151 |

---

## 🌐 Application Under Test

OrangeHRM Demo:

https://opensource-demo.orangehrmlive.com/

---

## 📁 Project Structure

```text
OrangeHRM-Selenium
│
├── pom.xml
├── README.md
├── .gitignore
│
└── src
    ├── main
    │   └── java
    │
    └── test
        └── java
            └── org
                └── example
                    └── OrangeHRMTest.java
