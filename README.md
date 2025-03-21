## JavaAppiumSelenium
Overview
This repository contains a Page Object Model (POM) based test automation framework built using Java, Appium, and Selenium. It is designed for automating mobile and web.

## Features
Supports Mobile & Web Testing (Android and browsers)
Page Object Model (POM) Design Pattern for better maintainability
TestNG for Test Execution & Reporting
Maven for Dependency Management
Appium for Mobile Automation
Selenium WebDriver for Web Testing

## Technologies Used
Language: Java
Build Tool: Maven
Test Framework: TestNG
Mobile Automation: Appium
Web Automation: Selenium WebDriver
Reporting: Extent Reports

## Project Structure

📂 JavaAppiumSeleniumPOMFramework

│-- 📂 src
│   ├── 📂 main
│   │   ├── 📂 java
│   │   │   ├── 📂 pages  # Page Object Classes
│   │   │   ├── 📂 utils  # Utility Classes
│   │   │   ├── 📂 config  # Configurations & Constants
│   ├── 📂 test
│   │   ├── 📂 java
│   │   │   ├── 📂 testcases  # Test Classes
│-- 📂 resources
│-- 📂 reports
│-- pom.xml  # Maven Dependencies
│-- testng.xml  # TestNG Configuration
│-- README.md  # Project Documentation

## Prerequisites
Install Java (JDK 11 or later)
Install Maven
Install Appium Server
Install Android SDK (for Android testing)
Install Browser Drivers (ChromeDriver, GeckoDriver, etc.)
Installation

## Clone the repository:
git clone https://github.com/vikashnarayan01/JavaAppiumSeleniumPOMFramework.git

cd JavaAppiumSeleniumPOMFramework

Install dependencies:

mvn clean install

Start the Appium server before running mobile tests.

## Run All the tests
mvn test
## Run specific TestNG suite
mvn test -DsuiteXmlFile=testng.xml
