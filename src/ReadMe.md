
## Introduction

Welcome to the AutoPark application! This software simulates a vehicle dealership and provides an integrated shopping system. Below is what you can expect:

- **Browse Inventory**: You can look through a list of available vehicles and other items for sale.
- **Cart Functionality**: You have the option to add vehicles or items you like to a shopping cart and see how much everything will cost.
- **Sales and Profit Metrics**: You can see the number of items and vehicles sold, and how much profit has been made.
- **Vehicle Types**: The software supports different types of vehicles like family cars (sedans) and commercial vehicles.
- **Real-time Updates**: Any changes to the inventory, sales, or profits are updated as they happen.
- **GUI Interface**: The software uses a graphical interface, making it easy to navigate and use.

## Prerequisites

Before you can run the AutoPark software, you'll need to have certain programs installed on your computer:

1. **Java Development Kit (JDK)**: This is the software development environment for Java. [Click here to download JDK 11 or a higher version](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html). After downloading, run the installer to set it up.
  
2. **JavaFX Software Development Kit (SDK)**: This is needed for the graphical elements of the application. [Click here to download JavaFX SDK](https://www.gluonhq.com/products/javafx/). This will come as a compressed (zipped) folder. After downloading, unzip (extract) the folder and remember where you saved it. Make sure the version you download is the same or compatible with your JDK version.

For detailed installation instructions, visit the websites linked above.

## How to Run the Application

After downloading all the files for AutoPark, you have two options to run the application: the Command Prompt (or Terminal on Mac/Linux) or using Visual Studio Code (VS Code).

### Using Command Prompt or Terminal

1. **Open Command Prompt or Terminal**: Search for Command Prompt (or Terminal) in your computer's search bar and open it.
  
2. **Navigate to Project Folder**: Use the `cd` command followed by the path to the `src` folder inside your AutoPark project. For example, if your project is on the Desktop, type `cd Desktop/AutoPark/src`.

3. **Compile the Application**: Copy and paste the following command. Replace `/path/to/javafx-sdk-21.0.2/lib` with the location where you unzipped the JavaFX SDK.
    ```
    javac --module-path "/path/to/javafx-sdk-21.0.2/lib" --add-modules javafx.controls,javafx.fxml AutoParkApp.java
    ```
4. **Run the Application**: Copy and paste the following command, again replacing `/path/to/javafx-sdk-21.0.2/lib` with your JavaFX SDK location.
    ```
    java --module-path "/path/to/javafx-sdk-21.0.2/lib" --add-modules javafx.controls,javafx.fxml AutoParkApp
    ```

### Using Visual Studio Code (VS Code)

1. **Open VS Code**: If you don't have it, [download and install VS Code](https://code.visualstudio.com/).
  
2. **Open Project**: In VS Code, go to `File > Open Folder` and select the AutoPark folder.

3. **Install Java Extension**: If you haven't already, install the "Java Extension Pack" from the Extensions Marketplace in VS Code.

4. **Update Configuration Files**: The project comes with `.vscode` folder containing `launch.json` and `settings.json` files. Open these and replace the JavaFX SDK path with your own.

5. **Run**: Open the `AutoParkApp.java` file and click the `Run` button that appears at the top right corner of the editor.

## Enjoy!
