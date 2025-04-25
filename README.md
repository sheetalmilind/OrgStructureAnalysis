# OrgStructureAnalysis
Analysis of Organization structure

# Organizational Structure Analyzer

## 📋 Project Overview

This Java Maven project analyzes a company's organizational structure based on employee hierarchy and salary information provided in a CSV file. It ensures:

- Managers earn **20% to 50%** more than the average salary of their direct subordinates.
- Employees are not more than **4 levels** away from the CEO in the reporting hierarchy.

---

## 🛠 Features

- ✅ Reads employee data from a CSV file
- ✅ Calculates manager salary compliance
- ✅ Identifies deep reporting hierarchies
- ✅ Configurable file path via `application.properties`

---

## 📂 Project Structure


---

## ⚙️ Setup Instructions

### Prerequisites
- Java 8+
- Maven
- Eclipse or IntelliJ (optional)

### Steps
1. Clone the repository or copy the files into your Maven project.
2. Place your CSV file (`employees.csv`) in `src/main/resources`.
3. Set the file name in `application.properties`:
   ```properties
   employee.file.path=employees.csv


✅ Output
The program prints:

Managers earning less than 20% above average of their subordinates.

Managers earning more than 50% above average.

Employees more than 4 levels below the CEO.
