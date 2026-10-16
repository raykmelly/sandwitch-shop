# Sandwich Shop

A command-line ordering program written in Java. The user chooses a sandwich size, decides whether to upgrade to a loaded sandwich, enters their age, and the program calculates the final price with an age-based discount. It was built as a practice exercise from Workbook 1C (pp. 104-105) to reinforce reading user input with `Scanner` and making decisions with `if / else if / else`.

## Features

- Choose a **Regular** ($5.45) or **Large** ($8.95) sandwich
- Optional **loaded** upgrade: +$1.00 (regular) or +$1.75 (large)
- Age-based discount: **10% off** for ages 17 and under, **20% off** for ages 65 and over
- Case-insensitive Y/N prompt (`y` and `Y` both work)
- Final total formatted as currency to two decimal places

## Tech Stack

- **Language:** Java 17
- **Build tool:** Maven (`pom.xml`)
- **Input:** `java.util.Scanner`
- **IDE:** IntelliJ IDEA

## Getting Started

### Prerequisites

- JDK 17 or newer
- Maven (optional if you run it from an IDE)

### Run it

```bash
git clone https://github.com/raykmelly/sandwitch-shop.git
cd sandwitch-shop
mvn compile
java -cp target/classes com.pluralsight.SandwichShop
```

Or open the project in IntelliJ, then right-click `SandwichShop` and choose **Run**.

## Pricing

| Item                | Price  |
|---------------------|--------|
| Regular sandwich    | $5.45  |
| Large sandwich      | $8.95  |
| Loaded upgrade (regular) | +$1.00 |
| Loaded upgrade (large)   | +$1.75 |

| Customer age | Discount |
|--------------|----------|
| 17 and under | 10%      |
| 18 to 64     | None     |
| 65 and over  | 20%      |

The discount is applied after the upgrade is added to the sandwich price.

## Example Session

```
[1] Regular sandwich: $5.45:
[2] Large sandwich: $8.95:
2
Would you like your sandwich loaded? (Y/N):
Y
[1] Regular: $1.00:
[2] Large: $1.75:
2
Type in your age:
70
[Total cost]: $8.56
```

Calculation: $8.95 + $1.75 = $10.70, minus 20% = **$8.56**.

## What I Learned

### Reading input with `Scanner`

- **Setting up a Scanner:** `Scanner scanner = new Scanner(System.in);` connects the program to keyboard input.
- **Matching the method to the data:** `nextInt()` reads whole numbers (menu choices, age) and `nextLine()` reads a full line of text (the Y/N answer).
- **The leftover newline problem:** `nextInt()` does not consume the Enter key press, so a following `nextLine()` would immediately return an empty string and skip the real input. Calling `scanner.nextLine()` once after `nextInt()` clears the buffer before reading the Y/N reply.

### Control flow with `if / else if / else`

- Used `if / else if / else` chains to handle the loaded-upgrade question, the age discount tiers, the sandwich size, and the upgrade type.
- Only the first matching branch in a chain runs, so the order of conditions matters.
- Used a final `else` as a catch-all for unexpected input.

### Comparing strings correctly

- Compared the Y/N reply with `.equalsIgnoreCase()` instead of `==`. The `==` operator checks whether two variables point to the same object, not whether the text matches, and `equalsIgnoreCase()` lets the program accept upper or lower case.

### Working with numbers and formatting

- Stored prices and discounts as `double` and calculated the discount as a percentage of the running total.
- Used `System.out.printf("%.2f%n", ...)` to display money rounded to two decimal places.

### Project workflow

- Built the program in stages and committed after each feature (starting the project, adding the discount, adding the loaded upgrade, formatting the total) using Git and GitHub.

## Known Limitations and Future Improvements

- Re-prompt when the Y/N answer is invalid instead of continuing the order
- Validate menu choices so an invalid size does not produce a $0.00 total
- Handle non-numeric input with `InputMismatchException`
- Use constants for prices and discount rates instead of hard-coded values
- Use `BigDecimal` for currency to avoid floating-point rounding issues
- Add unit tests with JUnit

## Project Structure

```
sandwitch-shop/
├── pom.xml
├── .gitignore
└── src/main/java/com/pluralsight/
    └── SandwichShop.java
```

## Author

**Raymond** ([@raykmelly](https://github.com/raykmelly))

Built while learning Java in Year Up's Application Development program.
